package com.skcc.mbr.saga.eventInfo.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name="EVENT_INFO")
@Access(AccessType.FIELD)
@ToString
@Getter
public class EventInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//이벤트 id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private Long eventId; 
	
	//이벤트명 
	private String event_name; 
	
	//이벤트 내용 
	private String event_content;
	
	//이벤트 응모 등급 기준 (공통코드로 관리?) 
	private String max_grade;
	
	//등록 일자 
	private String reg_date; 
	
	//수정 일자 
	private String upd_date; 
	
	EventInfo(){
		
	}

	
	@Builder
	EventInfo(String eventName, String eventContent, String grade){
		this.event_name = eventName; 
		this.event_content = eventContent;
		this.max_grade = grade; 
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
		String time = format.format(System.currentTimeMillis()); 
		
		this.reg_date = time; 
		this.upd_date = time;
	}
}
