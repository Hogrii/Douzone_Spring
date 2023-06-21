package kr.or.kosa.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	 
	@GetMapping("/login/*")
	public String LoginComplete(HttpSession session, Model model) {
		logger.info("LoginComplete 진입");
		return "/login/LoginComplete";
	}

}
