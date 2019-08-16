package com.skcc.mbr.saga.eventuateSagas.common;

public class MasterApproveReservedEntry extends AbstractMasterEntryEvent{
	
	public MasterApproveReservedEntry() {
		
	}
	
	public MasterApproveReservedEntry(Long entryId) {
		super(entryId);
	}
}
