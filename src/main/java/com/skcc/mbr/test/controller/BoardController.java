package com.skcc.mbr.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.mbr.test.dao.BoardMapper;
import com.skcc.mbr.test.vo.BoardModel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@EnableAutoConfiguration
@Api(value="main", description="test controller")
public class BoardController {
	@Autowired
	private BoardMapper mapper; 
	
	@ApiOperation(value="Test 페이지 ")
	@GetMapping(value="/getboard")
	public List<BoardModel> getBoard() throws Exception{
		
		List<BoardModel> list = mapper.getBoard(); 
		for(int i=0; i<list.size(); i++) {
			System.out.println("result:"+list);
		}
		return list; 
	}

	@GetMapping(value="/test")
	public String test() {
		return "hi"; 
	}
}
