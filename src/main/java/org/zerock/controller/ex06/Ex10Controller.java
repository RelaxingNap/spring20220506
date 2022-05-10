package org.zerock.controller.ex06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.ex03.Customer;

@Controller
@RequestMapping("ex10")
public class Ex10Controller {

	@RequestMapping("sub01")
	public String method01(RedirectAttributes rttr) {
		System.out.println("ex10/sub01 경로에서 일함.....");
		// redirect시 model객체는 request의 범위와 같아서 전달이 되지 않는다. 
		// (요청이 2번오므로 요청객체도 2개가 생성됨)
		// 2번째 request시 정보를 담아 보낼곳이 없어서 querystring으로 정보를 전달함.
		// 그래서 redirect시 RedirectAttributes객체를 이용하여 data를 전달한다.
		
		return "redirect:/ex10/sub02";
	}
	
	@RequestMapping("sub02")
	public void method02() {
		System.out.println("ex10/sub02 경로에서 일함");
	}
	
	@RequestMapping("sub03")
	public String method03(RedirectAttributes rttr) {
		rttr.addAttribute("name", "sunja");
		rttr.addAttribute("age", 99);
		rttr.addAttribute("address", "seoul");
		// 2번째 request시 정보를 담아 보낼곳이 없어서 querystring으로 정보를 전달함.
		// 그래서 session영역을 이용하여 정보를 전달하도록 해야함.
		
		return "redirect:/ex10/sub04";
	}
	
	// redirect시 http://localhost:8080/controller/ex10/sub04?name=sunja&age=99&address=seoul 
	// 이렇게 querystring에 정보를 전달해서 감.
	@RequestMapping("sub04")
	public void method04() {
				
	}
	
	@RequestMapping("sub05")
	public String method05(RedirectAttributes rttr) {
		Customer c = new Customer();
		c.setAge(58);
		c.setAddress("ny");
		c.setName("captain");
		
		rttr.addFlashAttribute("customer", c);
		// RedirectAttributes객체는 session영역을 이용하여 data를 전달. redirect후 session영역에서 data는 삭제됨.
		// addFlashAttribute메소드를 사용함으로인해 data를 querystring으로 유출시키지 않고 전달할 수 있게 됨.  
		return "redirect:/ex10/sub06";
	}
	
	@RequestMapping("sub06")
	public void method06(Model model) {
		System.out.println(model.asMap().get("customer"));		
		// session영역에서 data를 잘 넘겨받은것을 2번째 model객체를 통해서 보여줌.
	}
}
