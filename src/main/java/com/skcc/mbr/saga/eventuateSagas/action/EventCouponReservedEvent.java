package com.skcc.mbr.saga.eventuateSagas.action;

import com.skcc.mbr.saga.eventuateSagas.common.AbstractMasterEntryEvent;

public class EventCouponReservedEvent extends AbstractMasterEntryEvent{
	public EventCouponReservedEvent() {
	}
	public EventCouponReservedEvent(Long eventId, Long entryId, Long couponId) {
		super(eventId,entryId,couponId);
	}
	
}
