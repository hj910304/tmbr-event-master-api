package com.skcc.mbr.saga.eventuateSagas.common;
import io.eventuate.tram.events.common.DomainEvent;

public class EntryCreatedEvent implements EntryEvent {
	
	private Entry entry; 
	
	public EntryCreatedEvent() {
		
	}
	
	public EntryCreatedEvent(Entry entry) {
		this.entry = entry; 
	}
	public Entry getEntry() {
		return entry; 
	}

}
