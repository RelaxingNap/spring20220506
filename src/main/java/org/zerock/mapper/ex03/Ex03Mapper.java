package org.zerock.mapper.ex03;

import java.util.List;

import org.zerock.domain.ex02.BoardDto;

public interface Ex03Mapper {

	String selectCustomerNameById(int id);

	String getEmployeeFirstNameById(int id);

	List<BoardDto> selectBoard();

	BoardDto selectBoardById(int id);

	int updateBoard(BoardDto board);

	int deleteBoard(int id);

	int insertBoard(BoardDto board);
	
}
