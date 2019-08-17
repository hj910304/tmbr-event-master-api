package com.skcc.mbr.saga.eventuateSagas.action;

import java.util.HashMap;

import com.skcc.mbr.saga.eventuateSagas.common.MasterEvent;

public class EventCouponReservedEvent implements MasterEvent{
	
	private HashMap<String, Long> map; 
	
	public EventCouponReservedEvent() {
	}
	
	public  EventCouponReservedEvent(Long entryId, Long eventId, Long couponId) {
		map = new HashMap<String,Long>(); 
		map.put("entryId", entryId);
		map.put("eventId", eventId);
		map.put("couponId", couponId);
	}
	
	public HashMap<String,Long> getResult() {
		return this.map;
	}
	
}
