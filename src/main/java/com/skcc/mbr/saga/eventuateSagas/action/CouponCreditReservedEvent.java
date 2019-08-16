package com.skcc.mbr.saga.eventuateSagas.action;

import com.skcc.mbr.saga.eventuateSagas.common.AbstractMasterEntryEvent;

public class CouponCreditReservedEvent extends AbstractMasterEntryEvent{
	public CouponCreditReservedEvent() {
		
	}
	
	public CouponCreditReservedEvent(Long entryId) {
		super(entryId);
	}

}
