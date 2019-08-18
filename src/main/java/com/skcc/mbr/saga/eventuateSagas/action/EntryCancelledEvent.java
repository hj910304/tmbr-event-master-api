package com.skcc.mbr.saga.eventuateSagas.action;

import com.skcc.mbr.saga.eventuateSagas.common.AbstractMasterEntryEvent;

public class EntryCancelledEvent  extends AbstractMasterEntryEvent{
	
	public EntryCancelledEvent(){
		
	}
	
	public EntryCancelledEvent(Long couponId) {
		super(couponId);
	}
}
