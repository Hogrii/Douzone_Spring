package com.kr.kosa;

 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class ViewController {	
	private static final Logger logger = LoggerFactory.getLogger(ViewController.class);
	
	@GetMapping("/")
	public String Home() {		
		logger.info("viewController 진입");
		return "MainPage";
	}
	
	@GetMapping("/FirstBoard")
	public ModelAndView FirstBoard() {
		logger.info("FirstBoard  진입");
		return new ModelAndView("FirstBoard");
	}

	@GetMapping("/SecondBoard")
	public ModelAndView SecondBoard() {
		logger.info("SecondBoard  진입");
		return new ModelAndView("SecondBoard");
	}
}
