package com.skcc.mbr.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class testController {
	@RequestMapping(value="/pageTest")
	public String test() {
		return "vewtest"; 
	}
}
