package kr.or.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IntroController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IntroController 요청 실행");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "kosauser");
		mav.setViewName("Intro");
		
		return mav;
	}
}
