package com.skcc.mbr.saga.eventuateSagas.consumer;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.skcc.mbr.saga.coupon.domain.Coupon;
import com.skcc.mbr.saga.eventInfo.domain.EventInfo;
import com.skcc.mbr.saga.eventInfo.service.CheckEventCouponService;
import com.skcc.mbr.saga.eventuateSagas.action.EntryCreatedEvent;
import com.skcc.mbr.saga.eventuateSagas.action.EventCouponRejectedEvent;
import com.skcc.mbr.saga.eventuateSagas.action.EventCouponReservedEvent;
import com.skcc.mbr.saga.eventuateSagas.action.EventInfoValidationFailed;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.ResultWithEvents;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author hyejin
 * @Date 2019.08.13
 */
@Slf4j
public class EntryEventConsumer {
	
	@Autowired
	private DomainEventPublisher domainEventPublisher;
	
	@Autowired
	private CheckEventCouponService  chkecEventCouponService;
	
	/*
	 * 이벤트 수신 후, 처리로직 
	 * 1) 
	 */
	
	public DomainEventHandlers domainEventHandlers() {
		DomainEventHandlers domainEvent = DomainEventHandlersBuilder
				.forAggregateType("com.skcc.mbr.saga.entry.domain.Entry")
				.onEvent(EntryCreatedEvent.class, this::handlerEntryCreatedEventHandler)		//entry생성하기 위한 요청 이벤트 (송신 위치와 같아야함)
				.build();
		return domainEvent;
		
	}
	
	public void handlerEntryCreatedEventHandler(DomainEventEnvelope<EntryCreatedEvent> domainEventEnvelop) {

		EntryCreatedEvent entryCreatedEvent = domainEventEnvelop.getEvent();
		Long eventId = entryCreatedEvent.getEntry().getEvent_id();
		Long entryId = entryCreatedEvent.getEntry().getEntry_id();
		
		log.info("entryId:"+entryId);
		log.info("eventId: "+eventId);
		
		//이벤트 정보 유무 조회(이벤트가 있는지, 쿠폰이 있는지)
		if(!chkecEventCouponService.validateEventInfo(eventId) || !chkecEventCouponService.validateCouponInfo(eventId)) {
			log.info("데이터 오류 ");
			domainEventPublisher.publish(EventInfo.class, 
					eventId, 
					Collections.singletonList(new EventInfoValidationFailed(eventId,entryId)));
			return;
		}
		
		if(chkecEventCouponService.valiateReserveEventCoupon(eventId)) {
			//쿠폰 발급 가능 
			Optional<Coupon> coupon = chkecEventCouponService.consumeEventCoupon(eventId);
			log.info("master:가능");
			
			domainEventPublisher.publish(EventInfo.class, 
					entryId,
					Collections.singletonList(new EventCouponReservedEvent(eventId,entryId,coupon.get().getCoupon_seq())));
		}else {
			//쿠폰 발급 불가능 
			log.info("master:불가");
			domainEventPublisher.publish(EventInfo.class,
					eventId,
					Collections.singletonList(new EventCouponRejectedEvent(eventId,entryId)));
			return; 
		}
	}
}
