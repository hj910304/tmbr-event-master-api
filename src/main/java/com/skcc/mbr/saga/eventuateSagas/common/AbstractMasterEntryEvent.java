package com.skcc.mbr.saga.eventuateSagas.common;
import com.skcc.mbr.saga.eventuateSagas.common.MasterEvent;
/**
 * 
 * message table의 payload에 들어가게 될 내용 
 * @author hyejin
 *
 */
public abstract class AbstractMasterEntryEvent implements MasterEvent{
	protected  Long entryId; 
	protected Long eventId;
	
	protected AbstractMasterEntryEvent(Long eventId, Long entryId) {
		this.entryId = entryId; 
		this.eventId = eventId;
	}
	
	protected AbstractMasterEntryEvent() {
		
	}
	public Long getEntryId() {
		return entryId; 
	}
	
	public void setEntryID(Long eventId,Long entryId) {
		this.entryId = entryId;
		this.eventId = eventId;
	}
}
