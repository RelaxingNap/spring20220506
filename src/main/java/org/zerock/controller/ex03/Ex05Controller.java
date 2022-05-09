package org.zerock.controller.ex03;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ex05")
public class Ex05Controller {
	
	// http://localhost:8080/controller/ex05/sub01?name=jin&age=11&address=seoul
	@RequestMapping("sub01")
	public void method01(HttpServletRequest request) {
		// 1. request 파라미터 수집 / 가공
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		
		Customer cus = new Customer();
		cus.setName(name);
		cus.setAge(age);
		cus.setAddress(address);
		// 파라미터들을 하나의 객체로 묶어서 사용 가능
		System.out.println(cus);
		
	}
	
	// http://localhost:8080/controller/ex05/sub02?name=jin&age=11&address=seoul
	@RequestMapping("sub02")
	public void method02(Customer cus) {
		// @ModelAttribute 생략가능
		System.out.println(cus);
		
	}
	
	// http://localhost:8080/controller/ex05/sub03?name=jin&age=11&address=seoul
	@RequestMapping("sub03")
	public void method03(@ModelAttribute Customer cus) {
		// @ModelAttribute 생략가능
		// Customer의 field명들과 requestParameter의 이름들이 똑같다면
		// @ModelAttribute를 생략해도 
		// Customer의 field에 requestParameter의 값들이 자동으로 매칭되어 들어가짐
		System.out.println(cus);
	}
	
	// http://localhost:8080/controller/ex05/sub04?cpu=intel&hdd=1024&model=apple
	@RequestMapping("sub04")
	public void method04(Computer com) {
		System.out.println(com);
	}
	
	// http://localhost:8080/controller/ex05/sub05?name=donald&salary=1000&email=emp@gmail.com
	@RequestMapping("sub05")
	public void method05(Employee emp) {
		System.out.println(emp);
	}
	
}
