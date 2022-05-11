package org.zerock.controller.ex08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.service.Ex03Service;

@Controller
@RequestMapping("ex13")
public class Ex13Controller {
	
	@Autowired
	private Ex03Service service;
	
	@RequestMapping("sub01")
	public void method01() {
		int number = service.getNumber();
		System.out.println(number);
	}
}
