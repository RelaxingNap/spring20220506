package org.zerock.service.ex01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.mapper.ex01.Ex01Mapper;

@Service
public class Ex03Service {
	
	// DB와 연결하는 객체
	@Autowired
	private Ex01Mapper mapper;
		
	public int getNumber() {
		int number = mapper.selectNumber();
		
		return number;
	}
}
