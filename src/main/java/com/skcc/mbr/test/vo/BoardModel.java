package com.skcc.mbr.test.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardModel {
	private int id;
	private String title;
	private String content; 
	private Date reg_date;
}
