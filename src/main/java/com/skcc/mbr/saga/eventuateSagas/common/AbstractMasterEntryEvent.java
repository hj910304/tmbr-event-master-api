package com.skcc.mbr.saga.eventuateSagas.common;
import com.skcc.mbr.saga.eventuateSagas.MasterEvent;

public class AbstractMasterEntryEvent implements MasterEvent{
	protected  Long entryId; 
	
	protected AbstractMasterEntryEvent(Long entryId) {
		this.entryId = entryId; 
	}
	
	protected AbstractMasterEntryEvent() {
		
	}
	
	public Long getEntryId() {
		return entryId; 
	}
	
	public void setEntryID(Long entryId) {
		this.entryId = entryId;
	}

}
