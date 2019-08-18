package com.skcc.mbr.saga.eventInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.mbr.saga.eventInfo.service.EventMasterService;

import io.swagger.annotations.Api;

@EnableAutoConfiguration
@Api(value="main", description="Entry test controller")
@RestController
@RequestMapping("/insert")
public class dataInsertController {
	
		@Autowired
		EventMasterService eventMasterService; 
		
		@RequestMapping(value="insertEventInfo", method=RequestMethod.GET)
		public Object insertEventInfo(String eventName, String eventContent, String grade) {
			return eventMasterService.insertEventInfo(eventName, eventContent, grade);
		}
		
		@RequestMapping(value="insertCoupon", method=RequestMethod.GET)
		public Object insertCoupon(Long eventId, int sendCnt, int totalCnt, int maxCnt) {
			return eventMasterService.insertCouponInfo(eventId, sendCnt, totalCnt, maxCnt);
		}
} 
