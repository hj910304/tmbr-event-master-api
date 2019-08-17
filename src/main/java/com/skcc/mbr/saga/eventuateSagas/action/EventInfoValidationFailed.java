package com.skcc.mbr.saga.eventuateSagas.action;

import com.skcc.mbr.saga.eventuateSagas.common.AbstractMasterEntryEvent;

public class EventInfoValidationFailed extends AbstractMasterEntryEvent{

	public EventInfoValidationFailed() {
		
	}
	
	public EventInfoValidationFailed(Long eventId,Long entryId) {
		super(eventId,entryId);
	}

}
 