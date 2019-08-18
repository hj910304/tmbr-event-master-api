package com.skcc.mbr.saga.eventuateSagas.common;
import com.skcc.mbr.saga.eventuateSagas.common.MasterEvent;
/**
 * 
 * message table의 payload에 들어가게 될 내용 
 * @author hyejin
 * get~형태의 리턴 메소드 생성시, 자동으로 message payLoad에 적재 
 */
public abstract class AbstractMasterEntryEvent implements MasterEvent{
	protected  Long entryId; 
	protected Long eventId;
	protected Long couponId; 
	
	protected AbstractMasterEntryEvent(Long couponId) {
		this.couponId = couponId; 
	}
	protected AbstractMasterEntryEvent(Long eventId, Long entryId) {
		this.entryId = entryId; 
		this.eventId = eventId;
	}
	
	protected AbstractMasterEntryEvent(Long eventId, Long entryId, Long couponId) {
		this.eventId = eventId; 
		this.entryId = entryId;
		this.couponId = couponId; 
	}
	
	protected AbstractMasterEntryEvent() {
		
	}
	
	public Long getEntryId() {
		return entryId; 
	}
	
	public Long getEventId() {
		return eventId; 
	}
	
	public Long getCouponId() {
		return couponId; 
	}
	public void setEntryID(Long eventId,Long entryId) {
		this.entryId = entryId;
		this.eventId = eventId;
	}
}
