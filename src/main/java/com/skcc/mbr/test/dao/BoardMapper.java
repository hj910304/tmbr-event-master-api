package com.skcc.mbr.test.dao;

import java.util.List;

import com.skcc.mbr.test.vo.BoardModel;

public interface BoardMapper {
	List<BoardModel> getBoard() throws Exception; 
}
