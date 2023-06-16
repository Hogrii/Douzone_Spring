package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.config.AopConfig;
import com.dto.User;
import com.service.UserService;

@Controller
public class SinginController {
	@Autowired
	private UserService calcService;

	@PostMapping("signin.do")
	public String signin(User user, Model model) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);

		UserService service = context.getBean("calcService", UserService.class);

		System.out.println(user.toString());
		System.out.println("확인");

		String en_pass = calcService.inset(user);

		model.addAttribute("en_pass", en_pass);

		return "index";
	}
}
