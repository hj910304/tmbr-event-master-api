package com.skcc.mbr.saga.eventInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.mbr.saga.eventInfo.domain.coupon.Coupon;
import com.skcc.mbr.saga.eventInfo.domain.event.EventInfo;
import com.skcc.mbr.saga.eventInfo.service.EventMasterService;

import io.swagger.annotations.Api;

@EnableAutoConfiguration
@Api(value="main")
@RestController
@RequestMapping("/EventMaster")
@CrossOrigin(origins="*")
public class EventMasterController {
	@Autowired
	EventMasterService eventMasterService;
	
	@RequestMapping(value="getAllEventInfo" , method=RequestMethod.GET)
	public List<EventInfo> getAllEventInfo(){
		return eventMasterService.getAllEventInfo();
	}
	
	@RequestMapping(value="getOneEventInfo", method=RequestMethod.GET)
	public EventInfo getOneEventInfo(Long eventId) {
		return eventMasterService.getOneEventInfo(eventId);
	}
	
	@RequestMapping(value="getAllCoupon", method=RequestMethod.GET)
	public List<Coupon> getAllCoupon(){
		return eventMasterService.getAllCoupon(); 
	}
	
	@RequestMapping(value="getFindCoupon", method=RequestMethod.GET)
	public Coupon getFindCoupon(Long couponSeq){
		return eventMasterService.getOndeCoupon(couponSeq);
	}
}