package org.zerock.controller.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex09")
public class Ex09Controller {
	
	@RequestMapping("sub01")
	public void method01(String name, Model model) {
		// 1. request 파라미터 수집 / 가공
		
		// 3. model에 attribute 추가
		model.addAttribute("name", name); 
		// model객체를 통한 전달방식을 어노테이션으로 생략가능
		// 4. view forward : ex09/sub01.jsp
	}
	
	@RequestMapping("sub02")
	public String method02(@ModelAttribute("name") String name) {
		// @ModelAttribute를 사용하여 model객체에 addAttribute메소드를 사용한 것과 같은 효과를 내줌.
		return "ex09/sub01";
	}
	
	// http://localhost:8080/controller/ex09/sub03?address=seoul&email=seoul@gmail.com
	@RequestMapping("sub03")
	public void method03(@ModelAttribute("address") String address,
						 @ModelAttribute("email") String email) {
		// 코드가 없지만 어노테이션으로 인해서 알아서 일을 함
	}
	
	// http://localhost:8080/controller/ex09/sub04?name=trump&age=40&address=newyork
	@RequestMapping("sub04")
	public void method04(@ModelAttribute("customer") Customer cus) {
		// javabean객체를 넣을 경우 bean객체의 field가 모두 세팅 되므로 주소창에 주소적을 시 field이름과 값을 다 적어야 함
		// 그리고 그값을 model객체에 넣어서 전달 가능
	}
	
	@RequestMapping("sub05")
	public String method05(@ModelAttribute Customer cus) {
		// @ModelAttribute에 명칭 생략가능
		// 명칭 생략시 javabean클래스명으로 lowerCamelCase형식으로 model객체에 넣어서 전달함
		
		return "ex09/sub04";
	}
	
	@RequestMapping("sub06")
	public String method06(Customer cus) {
		// @ModelAttribute도 생략가능
		// 정해진 이유 찾아서 적어야함.
		return "ex09/sub04";
	}
	
	// 요청경로 : /ex09/sub07
	// 쿼리스트링 : ?name=sunja&salary=50000&email=sunja@gmail.com
	
	// method07 작성
	// org.zerock.controller.ex03.Employee 객체가
	// 쿼리스트링으로 넘어온 파라미터 값들을 세팅해서
	// model에 "employee"라는 이름의 attribute로 추가되고
	// /ex09/sub07 뷰로 포워드 되도록(jsp도 작성하세요)
	
	/*
	@RequestMapping("sub07")
	public void method07(HttpServletRequest request) {
		String name = request.getParameter("name");
		String salaryStr = request.getParameter("salary");
		String email = request.getParameter("email");
		
		int salary = Integer.parseInt(salaryStr);
		
		Employee emp = new Employee();
		emp.setEmail(email);
		emp.setName(name);
		emp.setSalary(salary);
		
		request.setAttribute("employee", emp);
		
		request.getRequestDispatcher("/WEB-INF/views/ex09/sub07.jsp");
		
	} 원래 하는 방법
	*/
	
	// 많이 생략되어서 이해하기 힘들겠지만 손쉽게 처리함
	@RequestMapping("sub07")
	public void method07(Employee emp) {
		
	}
	
	
	
}
