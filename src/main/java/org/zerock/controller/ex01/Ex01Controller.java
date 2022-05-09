package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // component 어노테이션의 한 종류
public class Ex01Controller {
	
	@RequestMapping("/ex01/sub01") // Controller와 함께 쓰이는 어노테이션
	// 주소창에 /ex01/sub01을 적어서 실행하면 method가 실행됨
	public void method01() {
		System.out.println("메소드01 일함");
	} 
	
	@RequestMapping("/ex01/sub02")
	public void method02() {
		System.out.println("메소드02 일함");
	}
}
