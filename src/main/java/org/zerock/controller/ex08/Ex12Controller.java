package org.zerock.controller.ex08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Employee;
import org.zerock.service.Ex01Service;
import org.zerock.service.Ex02Service;

@Controller
@RequestMapping("ex12")
public class Ex12Controller {

	@Autowired
	private Ex01Service service;
	
	@Autowired
	private Ex02Service service2;
	
	@RequestMapping("sub01")
	public void method01() {
		// 1. request parameter 수집 / 가공
		// 2. business 로직 실행
		service.getCustomer(1);
		// controller는 service에 의존하기 때문에 의존성주입을 해야함
		// 의존성주입은 spring이 알아서 해주기 때문에
		// service객체에 어떤 방식으로 의존성 주입을 할지 정해서 해주면 됨.
		
		// 3. model에 attribute 추가
		// 4. forward / redirect
		
	}
	
	@RequestMapping("sub02")
	public void method02(Employee e) {
		service2.insertEmployee(e);
		
		System.out.println("입력 성공");
	}
}
