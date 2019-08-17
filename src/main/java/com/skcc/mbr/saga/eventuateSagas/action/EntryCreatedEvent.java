package com.skcc.mbr.saga.eventuateSagas.action;
import com.skcc.mbr.saga.eventuateSagas.common.Entry;
import com.skcc.mbr.saga.eventuateSagas.common.EntryEvent;

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
