package com.skcc.mbr.saga.eventuateSagas.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Entry {
	private Long entry_id;
	private Long event_id; 
	private String reg_date; 
	private String upd_date; 
}
