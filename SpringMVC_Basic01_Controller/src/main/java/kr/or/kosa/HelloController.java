package kr.or.kosa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
// import org.springframework.web.servlet.DispatcherServlet;
// spring이 제공하는 front servlet controller >> web.xml로 이사

public class HelloController implements Controller{ // java를 웹 전용 파일로 만든 것

	// doGet, doPost처럼 생각해보자
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController 요청 실행 : handleRequest 자동 실행~");
		
		// 업무수행
		// DB연결 .. 로직 ..
		// 데이터 담기, 뷰 지정하기
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "kosauser"); // reuqest.setAttribute()
		mav.setViewName("Hello"); // forward >> path >> Hello.jsp
		
		return mav;
	}	
}
