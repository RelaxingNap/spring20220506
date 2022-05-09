package org.zerock.controller.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex03")
public class Ex03Controller {
	
	@RequestMapping("sub01")
	public void method01() {
		System.out.println("/ex03/sub01 일함");
	}
	
	@RequestMapping(value = "sub01", params = "name") 
	// params를 통해서 querystring에 값을 넣어서 넘어오는 경우를 처리할 수 있음
	// params의 상태(params의 유무와 params에 어떤 값이 들어오느냐)에 따라 각자 다른일을 할 수 있도록 구분가능
	public void method02() {
		System.out.println("ex03/sub01 경로, name파라미터 있음");
	}
	
	@RequestMapping(value = "sub01", params = {"name","age"})
	// querystring으로 넘어오는 여러개의 파라미터도 params에 여러개의 parameter를 넣어서 처리가능
	public void method03() {
		System.out.println("ex03/sub01 경로, name파라미터, age파라미터 있음");
	}
	
}
