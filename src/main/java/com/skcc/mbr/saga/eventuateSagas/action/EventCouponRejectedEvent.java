package com.skcc.mbr.saga.eventuateSagas.action;

import com.skcc.mbr.saga.eventuateSagas.common.AbstractMasterEntryEvent;

public class EventCouponRejectedEvent extends AbstractMasterEntryEvent{
	public EventCouponRejectedEvent() {
	}
	
	public EventCouponRejectedEvent(Long eventId, Long entryId) {
		super(eventId,entryId);
	}
}
