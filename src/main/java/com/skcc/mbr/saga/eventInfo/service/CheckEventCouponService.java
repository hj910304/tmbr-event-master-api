package com.skcc.mbr.saga.eventInfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcc.mbr.saga.eventInfo.domain.coupon.Coupon;
import com.skcc.mbr.saga.eventInfo.domain.coupon.CouponRepository;
import com.skcc.mbr.saga.eventInfo.domain.event.EventInfo;
import com.skcc.mbr.saga.eventInfo.domain.event.EventInfoRepository;

/**
 * 이벤트/쿠폰 체크서비스 
 * 1) 이벤트 유효성 체크 
 * 2) 쿠폰발급 제한 수체크 
 * 3) 쿠폰 사용개수 차감
 * 4) 쿠폰 사용개수 롤백 
 * @author hyejin
 * @Since 2019.08.16
 */
@Service
public class CheckEventCouponService {
		@Autowired
		private EventInfoRepository eventRepository;
		
		@Autowired
		private CouponRepository couponRepository;
		
		//이벤트 유무 체크 
		public boolean validateEventInfo(Long eventId) {
			Optional<EventInfo> possibleEventInfo = eventRepository.findById(eventId);
			return possibleEventInfo.isPresent();
		}
		
		//쿠폰 존재여부 체크 
		public boolean validateCouponInfo(Long eventId) {
			List<Coupon> coupon = couponRepository.findByEventId(eventId);
			if(coupon!=null) {
				return true;
			}else {
				return false; 
			}
		}
		
		//쿠폰 발급가능 여부 체크 
		public boolean valiateReserveEventCoupon(Long eventId) {
			List<Coupon> coupon = couponRepository.findByEventId(eventId);
			Coupon cou = coupon.get(0);
			if(cou.getMax_cnt()<=cou.getTotal_cnt()) {
				return false;
			}else {
				return true; 
			}
		}

		//쿠폰 1건 조회 
		public Coupon findEventCoupon(Long eventId) {
			List<Coupon> coupon = couponRepository.findByEventId(eventId);
			return coupon.get(0);
		}
		
		// 쿠폰 사용개수 차감
		public void minusEventCoupon(Long couponSeq) {
			Coupon coupon = couponRepository.getOne(couponSeq);
			coupon.setTotal_cnt(coupon.getTotal_cnt()+1);
			couponRepository.save(coupon);
		}
		
		// 쿠폰 사용개수 롤백 
		public void plusEventCoupon(Long couponSeq) {
			Coupon coupon = couponRepository.getOne(couponSeq);
			coupon.setTotal_cnt(coupon.getTotal_cnt()-1);
			couponRepository.save(coupon);
		}
}
