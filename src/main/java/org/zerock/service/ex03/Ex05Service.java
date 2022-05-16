package org.zerock.service.ex03;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ex02.BoardDto;
import org.zerock.mapper.ex03.Ex03Mapper;
import org.zerock.mapper.ex03.Ex04Mapper;

@Service
public class Ex05Service {

	@Autowired
	private Ex03Mapper mapper;
	
	@Autowired
	private Ex04Mapper replyMapper;
	
	public String getCustomerNameById(int id) {
		
		return mapper.selectCustomerNameById(id);
	}

	public String getEmployeeFirstNameById(int id) {
		
		return mapper.getEmployeeFirstNameById(id);
	}

	public List<BoardDto> listBoard() {
		
		return mapper.selectBoard();
	}

	public BoardDto getBoard(int id) {
		return mapper.selectBoardById(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		return cnt == 1;
	}

	@Transactional
	public boolean removeBoardById(int id) {
		// 댓글 지우기
		replyMapper.deleteReplyByBoard(id);
		
		// 중간에 exception 발생시 위의 메소드만 일을해서 댓글만 지워짐.
		// 그렇게 되지 않기 위해서 2가지의 메소드를 하나의 일처럼 transaction으로 묶어서 처리
		
		// 게시물 지우기
		int cnt = mapper.deleteBoard(id);
		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now()); // 글 적은 시간은 값이 정해져있어서 미리 서비스에서 세팅함.
		
		int cnt = mapper.insertBoard(board);
		return cnt == 1;
	}

}
