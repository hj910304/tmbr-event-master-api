package com.skcc.mbr.saga.domain.coupon;

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
@Table(name="EVENT_COUPON")
@Access(AccessType.FIELD)
@ToString
@Getter
public class Coupon {
	private static final long serialVersionUID = 1L;
	
	//이벤트 id 
	@Column(name="event_id")
	private Long eventId;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//쿠폰 일련번호 
	private Long coupon_seq;
	
	//1인 발급 제한 수 
	private int coupon_send_cnt; 
	
	//현재 쿠폰 수 
	private int total_cnt;
	
	//쿠폰 발급 제한 수 
	private int max_cnt;
	
	//등록 일자 
	private String reg_date; 
	
	//수정 일자 
	private String upd_date; 
	
	Coupon(){
		
	}
	
	@Builder
	Coupon(Long eventId, int sendCnt, int totalCnt, int maxCnt){
		this.eventId = eventId;
		this.coupon_send_cnt = sendCnt; 
		this.total_cnt = totalCnt; 
		this.max_cnt = maxCnt; 
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM--dd HH:mm:ss");
		String time = format.format(System.currentTimeMillis()); 
		this.reg_date = time; 
		this.upd_date = time;
	}
}
