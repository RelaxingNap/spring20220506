package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex02") //앞의 경로가 같을경우 클래스레벨에서 설정가능
public class Ex02Controller {
	
	@RequestMapping("sub01")
	public void method01() {
		System.out.println("ex02/sub01 일함");
	}
	// 이때, RequestMapping어노테이션에 /를 빼고 값을 넣어도 잘 동작함.
	
	@RequestMapping("sub02") // value 생략 가능
	public void method02( ) {
		System.out.println("ex02/sub02 일함");
	}
	
	@RequestMapping(value = "sub03")
	public void method03() {
		System.out.println("/ex02/sub03 일함....");
	}
	
	@RequestMapping({"sub04", "sub05"}) // value 값은 String[] 이므로 여러개를 매핑할 수 있음
	public void method04() {
		System.out.println("/ex02/sub04 일함....");
	}
	
	@RequestMapping(value = {"sub06", "sub07"})
	public void method05() {
		System.out.println("/ex02/sub05 일함....");
	}
	
	@RequestMapping(path = "sub08") // path는 value와 같은 일을 함
	public void method08() {
		System.out.println("/ex02/sub08 일함.......");
	}
	
	@RequestMapping(path = {"sub09", "sub10"}) // path도 value와 같이 String[] 이므로 여러개 매핑 가능
	public void method09() {
		System.out.println("/ex02/sub09 일함....!..");
	}
	
}
