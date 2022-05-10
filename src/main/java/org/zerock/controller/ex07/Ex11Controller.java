package org.zerock.controller.ex07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("ex11")
public class Ex11Controller {
	
	// method파라미터를 지정안할시 모든 방식에 대해서 처리함.
	// method를 지정해서 포워드시 get방식으로 요청시 처리하도록만들 수 있음
	// 너무 많이 사용해서 이런 방식을 처리해주는 어노테이션이 존재
	// @RequestMapping(value="login", method=RequestMethod.GET)
	// get방식에 대해서만 처리해주는 어노테이션
	@GetMapping("login")
	public void loginForm() {
		System.out.println("로그인 화면으로 포워드");
	}
	
	// method를 지정해서 포워드시 post방식으로 요청시 처리하도록만들 수 있음
	// 너무 많이 사용해서 이런 방식을 처리해주는 어노테이션이 존재
	// @RequestMapping(path="login", method=RequestMethod.POST)
	// post방식에 대해서만 처리해주는 어노테이션
	@PostMapping("login")
	public String loginProcess(String id, String password, RedirectAttributes rttr) {
		System.out.println("로그인 처리");
		
		boolean ok = false;
		if(id != null && id.equals(password)) {
			ok = true;
		}
		
		if(ok) {
			rttr.addFlashAttribute("message", "로그인 성공");
			
			return "redirect:/ex11/main";
		} else {
			rttr.addFlashAttribute("message", "아이디나 패스워드 불일치");
			
			return "redirect:/ex11/login";
		}
	}
	
	@GetMapping("main")
	public void main() {
		
	}
	
}
