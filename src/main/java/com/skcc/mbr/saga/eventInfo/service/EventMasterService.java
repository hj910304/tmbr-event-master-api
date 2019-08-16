package com.skcc.mbr.saga.eventInfo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.mbr.saga.eventInfo.domain.EventInfo;
import com.skcc.mbr.saga.eventInfo.domain.EventInfoRepository;


@Service
public class EventMasterService {
		/*
		 * 데이터 조회 영역 
		 */
		@Autowired
		EventInfoRepository eventInfoRepository; 
		
//		@Autowired
//		CouponRepository couponRepository; 
//		
//		//전체 쿠폰 조회 
//		public List<Coupon> getAllCoupon(){
//			return couponRepository.findAll();
//		}
//		
//		//event id로 조회조건 추가 
//		public List<Coupon> getOneCoupon(Long eventId) {
//			return couponRepository.findAllByEventId(eventId);
//		}
		
		//전체 이벤트 조회 
		public List<EventInfo> getAllEventInfo(){
			return eventInfoRepository.findAll();
		}
		
		//event_id로 이벤트 단건 조회 
		public EventInfo getOneEventInfo(Long eventId) {
			return eventInfoRepository.findAllByEventId(eventId);
		}
		
		/*
		 * 데이터 insert영역 
		 */
		//event info 테이블 insert 
		public Object insertEventInfo(String eventName, String eventContent, String grade) {
			EventInfo eventInfo = EventInfo.builder().eventName(eventName).eventContent(eventContent).grade(grade).build();
			return eventInfoRepository.save(eventInfo);
		}
//		
//		//coupon 테이블 insert 
//		public Object insertCouponInfo(Long eventId, int sendCnt, int totalCnt, int maxCnt) {
//			Coupon coupon = Coupon.builder().eventId(eventId).sendCnt(sendCnt).totalCnt(totalCnt).maxCnt(maxCnt).build();
//			return couponRepository.save(coupon);
//		}
}
