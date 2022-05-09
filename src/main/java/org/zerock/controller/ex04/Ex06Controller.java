package org.zerock.controller.ex04;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex06")
public class Ex06Controller {
	
	@RequestMapping("sub01")
	public String method01() {
		
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// 경로명은 servlet-context.xml에서 
		// viewresolver의 property 세팅을 변경하면 prefix와 suffix를 변경할 수 있음  
		// String 리턴시 앞뒤로 적절하게 붙여서 리턴하면 viewresolver가 포워딩해줌
		
		// full view name : /WEB-INF/views/myview01.jsp
		return "ex06/myview01";
	}
	
	@RequestMapping("sub02")
	public String method02() {
		return "ex06/myview02";
	}
	
	@RequestMapping("sub03")
	public String method03() {
		return "ex06/myview03";
	}
	
	@RequestMapping("sub04") 
	public String method04() {
		// 요청 경로와 view(jsp)의 경로가 같은경우
		// null로 리턴 가능
		
		// 요청경로 /ex06/sub04
		// view이름 : /WEB-INF/views/ex06/sub04.jsp
		
		return null;
	}
	
	@RequestMapping("sub05")
	public void method05() {
		// 요청경로와 view(jsp)의 경로가 같은 경우
		// void로 작성 가능
		
		// 요청경로 /ex06/sub05
		// view이름 : /WEB-INF/views/ex06/sub05.jsp
	}
	
}
