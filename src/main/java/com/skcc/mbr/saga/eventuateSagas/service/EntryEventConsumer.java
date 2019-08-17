package com.skcc.mbr.saga.eventuateSagas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.skcc.mbr.saga.eventInfo.domain.EventInfo;
import com.skcc.mbr.saga.eventInfo.domain.EventInfoRepository;
import com.skcc.mbr.saga.eventInfo.service.EventMasterService;
import com.skcc.mbr.saga.eventuateSagas.common.EntryCreatedEvent;

import io.eventuate.tram.events.publisher.DomainEventPublisher;
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
	private EventInfoRepository eventRepository;
	
	@Autowired
	private DomainEventPublisher domainEventPublisher;
	
	@Autowired
	private EventMasterService eventMasterService;
	
	/*
	 * 이벤트 수신 후, 처리로직 
	 * 1) 
	 */
	
	public DomainEventHandlers domainEventHandlers() {
		DomainEventHandlers domainEvent = DomainEventHandlersBuilder.forAggregateType("com.skcc.mbr.saga.entry.domain.Entry")
				.onEvent(EntryCreatedEvent.class, this::handlerEntryCreatedEventHandler)
				.build();
		return domainEvent;
		
	}
	
	public void handlerEntryCreatedEventHandler(DomainEventEnvelope<EntryCreatedEvent> domainEventEnvelop) {
		log.info("event수신 ");
		EntryCreatedEvent entryCreatedEvent = domainEventEnvelop.getEvent();
		log.info("entryId:"+entryCreatedEvent.getEntry().getEntry_id());
		log.info("eventId: "+entryCreatedEvent.getEntry().getEvent_id());
		//eventId 가지고 가능 여부 조회 
		EventInfo eventInfo = EventInfo.builder().eventContent("test").eventName("ttt").grade("GOLD").build();
		log.info("handler entry created eventhanelrd");
		return;
	}
}
