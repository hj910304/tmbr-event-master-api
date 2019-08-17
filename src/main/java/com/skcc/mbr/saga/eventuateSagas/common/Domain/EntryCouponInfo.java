//package com.skcc.mbr.saga.eventuateSagas.common.Domain;
//
//import java.util.Collections;
//import static java.util.Collections.singletonList;
//import com.skcc.mbr.saga.eventuateSagas.action.EventCouponReservedEvent;
//
//import io.eventuate.tram.events.publisher.ResultWithEvents;
//
//public class EntryCouponInfo {
//	private Long eventId; 
//	private Long entryId; 
//	private Long couponSeq; 
//	
//	private EntryCouponInfo() {
//		
//	}
//	
//	public EntryCouponInfo getResult() {
//		return this; 
//	}
//	
//	public Long getCouponSeq() {
//		return couponSeq; 
//	}
//	public EntryCouponInfo(Long evenId,Long entryId,Long couponSeq) {
//		this.eventId = eventId; 
//		this.entryId = entryId; 
//		this.couponSeq = couponSeq; 
//	}
//	
//	public static ResultWithEvents<EntryCouponInfo> createEntryCouponInfo(Long eventId, Long entryId, Long couponSeq){
//		EntryCouponInfo entryCouponInfo = new EntryCouponInfo(eventId,entryId,couponSeq);
//		EventCouponReservedEvent eventCouponReservedEvent = new EventCouponReservedEvent(entryCouponInfo);
//		return new ResultWithEvents<>(entryCouponInfo, singletonList(eventCouponReservedEvent));
//	}
//}
