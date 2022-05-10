package org.zerock.controller.ex05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.controller.ex03.Customer;
import org.zerock.controller.ex03.Employee;

@Controller
@RequestMapping("ex08")
public class Ex08Controller {
	
	@RequestMapping("sub01")
	public String method01(HttpServletRequest req) {
		
		req.setAttribute("address", "new york");
		// prefix : /WEB-INF/views/
		// suffix : .jsp
		// full view name : /WEB-INF/views/ex08/sub01.jsp
		
		return "ex08/sub01";
	}
	
	@RequestMapping("sub02")
	public String method02(Model model) {
		// Model인터페이스 객체를 사용하여 화면에 전달
		model.addAttribute("address", "london");
		
		return "ex08/sub01";
	}
	
	@RequestMapping("sub03")
	public String method03(Model model) {
		model.addAttribute("myName", "abc");
		model.addAttribute("myAge", 21);
		
		return "ex08/sub03";
	}
	// prefix : /WEB-INF/views/
	// suffix : .jsp
	// 요청경로 : ex08/sub04
	// full view name : /WEB-INF/views/ex08/sub04.jsp
	
	@RequestMapping("sub04")
	public void method04(Model model) {
		model.addAttribute("foods", new String[] {"apple", "milk", "coffee"});
	}
	
	@RequestMapping("sub05")
	public void method05(Model model) {
		List<String> list = new ArrayList<>();
		list.add("ironman");
		list.add("ironman2");
		list.add("ironman3");
		
		model.addAttribute("heroList", list);
		// model객체를 통해 list 전달 가능
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		Map<String,String> map = new HashMap<>();
		
		map.put("name", "jin");
		map.put("song", "butter");
		map.put("group", "bts");
		
		model.addAttribute("desc",map);
		// model객체를 통해 map도 전달가능
	}
	
	@RequestMapping("sub07")
	public void method07(Model model) {
		Customer cus = new Customer();
		cus.setAddress("seoul");
		cus.setAge(30);
		cus.setName("donald");
		
		model.addAttribute("customer", cus);
		// model객체를 통해 javabean객체도 전달가능
		
	}
	
	@RequestMapping("sub08")
	public void method08(Model model) {
		Employee emp = new Employee();
		
		emp.setEmail("2@a.com");
		emp.setName("sss");
		emp.setSalary(5000);
		
		model.addAttribute("employee", emp);
	}
	
	@RequestMapping("sub09")
	public String method09(Model model) {
		Employee emp = new Employee();
		emp.setEmail("korea@daum.net");
		emp.setName("sunja");
		emp.setSalary(70000);
		
		// model.addAttribute("employee", emp);
		model.addAttribute(emp); 
		// addAttribute메소드 사용시 String으로 명칭을 붙이지 않으면
		// attribute이름이 클래스의 이름으로 결정(단, lowerCamelCase형식)
		// 안적는경우는 잘 없음		
		return "ex08/sub08";
	}
	
	@RequestMapping("sub10")
	public String method10(Model model) {
		// model.addAttribute(Object)를 사용해서
		// sub07.jsp에서 고객의 정보가 출력되도록 코드를 완성
		Customer cus = new Customer();
		cus.setAddress("busan");
		cus.setAge(34);
		cus.setName("aaa");
		
		model.addAttribute(cus);
		
		return "ex08/sub07";
	}
	
	@RequestMapping("sub11")
	public void method11(Model model) {
		List<String> l = new ArrayList<>();
		// attribute이름이 클래스의 이름으로 결정(단, lowerCamelCase형식) 
		// 제대로 실행되지 않음 이유는 모름(알아봐야함)
						
		l.add("wanda");
		l.add("doctor");
		l.add("wong");
		
		model.addAttribute(l);
	}
	
	@RequestMapping("sub12")
	public void method12(Model model) {
		// 1. request 파라미터 수집/ 가공
		// 2. business 로직처리
		// 3. add attribute
		// 4. forward / redirect
	}
	
}
