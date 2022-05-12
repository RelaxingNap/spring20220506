package org.zerock.controller.ex09;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.domain.ex01.PageInfoDto;
import org.zerock.service.ex02.Ex04Service;


@Controller
@RequestMapping("ex14")
public class Ex14Controller {
	
	@Autowired
	private Ex04Service service;
			
	@RequestMapping("sub01")
	public void method01(int id, Model model) {
		// 1. request parameter 수집 / 가공
		
		// 2. business logic 처러
		String name = service.getNameById(id);
		// 3. model addAttribute
		
		model.addAttribute("name", name);
		// 4. forward / redirect
	}
	
	// /ex14/sub02?id=3
	// view에서 Employee의 firstName이 출력되도록
	
	// controller에서 method02완성
	// service에도 메소드 추가
	// mapper에도 메소드 추가
	// jsp작성
	@RequestMapping("sub02")
	public String method02(int id, Model model) {
		String firstName = service.getFirstNameById(id);
		
		model.addAttribute("firstName", firstName);
		
		return "ex14/sub01";
	}
	
	// /ex14/sub03?id=3
	@RequestMapping("sub03")
	public void method03(int id, Model model) {
		CustomerDto dto = service.getCustomerInfoById(id);
		
		model.addAttribute("customer", dto);
	}
	
	// /ex14/sub04?id=7
	// 직원의 FirstName, LastName이 모두 jsp출력되도록
	@RequestMapping("sub04")
	public void method04(int id, Model model) {
		EmployeeDto dto = service.getFullNameById(id);
		
		model.addAttribute("employee", dto);
	}
	
	// controller에 새 메소드 작성
	// service에 새 메소드 작성
	// mapper에 새 메소드 작성
	// 새 jsp 파일 작성
	// EmployeeDto 새로 작성
	
	@GetMapping("sub05")
	public void method05() {
		// form 있는 jsp로 forward
	}
	
	@PostMapping("sub05") 
	public String method06(CustomerDto customer, RedirectAttributes rttr) {
		
		boolean ok = service.addCustomer(customer);
		
		if(ok) {
			rttr.addFlashAttribute("message", "등록완료");
		} else {
			rttr.addFlashAttribute("message", "등록실패");
		}
		
		return "redirect:/ex14/sub05";
	}
	
	@GetMapping("sub06")
	public void method07() {
		
	}
	
	@PostMapping("sub06")
	public String method08(EmployeeDto employee, RedirectAttributes rttr) {
		boolean ok = service.addEmployee(employee);
		
		if(ok) {
			rttr.addFlashAttribute("message", "성공");
		} else {
			rttr.addFlashAttribute("message", "실패");
		}
		
		return "redirect:/ex14/sub06";
	}
	
	@GetMapping("sub07")
	public void method09(Model model) {
		List<EmployeeDto> list = service.listEmployee();
		
		model.addAttribute("employees", list);
	}
	
	// 고객 목록 조회 코드 작성
	@GetMapping("sub08")
	public void method10(Model model) {
		List<CustomerDto> list = service.listCustomer();
		
		model.addAttribute("customers", list);
	}
	
	@GetMapping("sub09")
	public void method11(@RequestParam(name = "page", defaultValue = "1")int page, Model model) {
		int rowPerPage = 5;
		List<CustomerDto> list = service.listCustomerPage(page, rowPerPage);
		int totalRecords = service.countCustomers();
		int end = (totalRecords - 1) / rowPerPage + 1;
		
		PageInfoDto pageInfo = new PageInfoDto();
		pageInfo.setCurrent(page);
		pageInfo.setEnd(end);
		
		model.addAttribute("customers", list);
		model.addAttribute("pageInfo", pageInfo);
		
	}
	
}
