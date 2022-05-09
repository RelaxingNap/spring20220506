package org.zerock.controller.ex02;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ex04")
public class Ex04Controller {
	
	@RequestMapping("sub01")
	public void method01(HttpServletRequest request){
		System.out.println("/ex04/sub01 요청");
		// 1. request parameter 수집 / 가공
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("age"));
		// 2. business logic 실행
		// 3. add attribute
		// 4. forward /redirect
	}
	// @RequestParam
	@RequestMapping("sub02")
	public void method02(@RequestParam("name") String n) {
		// @RequestParam을 통해서 request객체를 받아오지 않아도 파라미터를 받아올 수 있음
		// @RequestParam를 사용했을 시 웹상에서 parameter를 표기하지 않으면 에러가 발생하기 때문에 반드시 작성해야 함
		System.out.println(n);
	}
	
	@RequestMapping("sub03")
	public void method03(@RequestParam("name") String n, @RequestParam("age") String age) {
		// 여러개의 querystring 받아오는것 가능
		System.out.println(n);
		System.out.println(age);
	}
	
	@RequestMapping("sub04")
	public void method04(@RequestParam("age") int age) {
		// querystring으로 받아오는 requestgetPameter의 리턴값은 String이지만, 다른 자료형으로 매개변수를 받겠다고 선언하면 
		// DispatcherServlet이 자동으로 형변환을 해줌
		System.out.println(age);
	}
	
	@RequestMapping("sub05")
	public void method05(HttpServletRequest request) {
		// 1. request parameter 수집 / 가공
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub06")
	public void method06(@RequestParam("name") String name, @RequestParam("age") int age) {
		// 여러개의 querystring 받아오는것 가능
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub07")
	public void method07(String name, int age) {
		// @RequestParam 생략가능
		// 파라미터 이름과 매개변수명이 같아야 하는 조건
		System.out.println(name);
		System.out.println(age);
	}
	
	@RequestMapping("sub08")
	public void method08(String address, int number) {
		System.out.println(address); // seoul
		System.out.println(number); // 300
	}
	
	@RequestMapping("sub09")
	public void method09(@RequestParam("password") String pw, @RequestParam("number") int num) {
		System.out.println(pw);	// 1q2w3e
		System.out.println(num); // 10000
	}
	
	@RequestMapping("sub10")
	public void method10(@RequestParam(value = "name", required = false) String name) {
		// required option : 기본값은 true, false로 지정시 parameter가 없다면 null로 넘어옴
		// true일 경우 method자체가 실행이 안됨
		System.out.println(name);
	}
	
	// http://localhost:8080/controller/ex04/sub11?food=apple&food=banana&food=milk
	@RequestMapping("sub11")
	public void method11(HttpServletRequest request) {
		String[] foods = request.getParameterValues("food");
		// 여러 파라미터값을 받아올 경우
		System.out.println(Arrays.toString(foods));
	}
	
	// http://localhost:8080/controller/ex04/sub12?food=apple&food=banana&food=milk
	@RequestMapping("sub12")
	public void method12(@RequestParam("food") String[] foods) {
		System.out.println(Arrays.toString(foods));
	}
	
	// http://localhost:8080/controller/ex04/sub13?food=apple&food=banana&food=milk
	@RequestMapping("sub13")
	public void method13(String[] food) {
		// 매개변수명과 파라미터명이 같으면 @RequestParam 생략가능
		System.out.println(Arrays.toString(food));
	}
	
	// http://localhost:8080/controller/ex04/sub14?food=apple&food=banana&food=milk
	@RequestMapping("sub14")
	public void method14(@RequestParam("food") ArrayList<String> food) {
		// simple property일때만 @RequestParam생략가능
		// simple property는 api를 참조
		System.out.println(food);
	}
	
}
