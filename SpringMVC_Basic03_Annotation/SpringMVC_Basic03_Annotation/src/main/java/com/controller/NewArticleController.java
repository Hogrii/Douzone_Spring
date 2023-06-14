package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.NewArticleCommand;
import com.service.ArticleService;

/**
 * 클라이언트 요청
 * 1. 화면주세요(글쓰기, 로그인 화면) : write.do
 * 2. 처리해주세요(글쓰기 입력 처리, 로그인 완료 처리) : writeok.do
 * 
 * 요청 주소가 write.do -> 화면
 * 요청 주소가 writeok.do -> 처리
 * 
 * spring
 * 클라이언트 요청
 * 요청을 method 단위로 처리
 * 1개의 요청 주소로 화면, 처리 판단 >> 근거 : 전송방식에 따라 판단(GET, POST)
 * http:....../article/newArticle.do
 * 요청 방식
 * GET : 화면 > view 제공
 * POST : 서비스 처리 > insert, update > 화면 제공
 *         
 */

@Controller
@RequestMapping("/article/newArticle.do") // 전체 주소를 RequesteMapping이 잡고 있을 때
public class NewArticleController {
	
	// NewArticleContoller는 업무수행을 위해서 ArticleService가 필요하다
	// has-a 관점에서 보아야 한다 >> 연관 관계
	private ArticleService articleService;
	
	@Autowired
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	// @RequestMapping(method = RequestMethod.GET) // method가 GET 방식이면 form으로..
	@GetMapping // 5.x.x 버전부터 도입
	public String form() { // 화면
		System.out.println("GET 화면 주세요");
		// public String form() 함수의 return 타입이 String이라면
		// Spring은 View의 주소로 인지한다
		// 이전 : public ModelAndView form() >> return ..
		return "article/newArticleForm";
		// ViewResolver에서 조합된다
		// /WEB-INF/views/ + article/newArticleForm + .jsp
	}
	
	/*
	 * 2. Spring에서 parameter를 DTO 객체로 받기
	 * 2.1 자동화 >> 선행조건 >> input 태그의 name 값이 DTO 객체의 memberfield명과 동일해야 한다
	 */
	
	@PostMapping
	public String submit(@ModelAttribute("Articledata") NewArticleCommand article) { // 처리
		// @ModelAttribute("Articledata") >> NewArticleCommand의 key값이 Articledata가 된다
		// view에서 ${newArticleCommand.title} -> ${Articledata.title}로 바꿔주면 된다
		System.out.println("POST 처리해 주세요");
		
		/*
			1. 자동으로 DTO 객체 생성 : NewArticleCommand article = new NewArticleCommand();
			2. 넘어온 parameter가 setter 함수를 통해 자동 주입 => article.setParentId ..
			3. NewArticleCommand article 객체가 자동으로 IOC 컨테이너 안에 등록 : id=newArticleCommand
			   <bean id="newArticleCommand" class=".."></bean>
			4. ModelAndView mv = new ModelAndView();
			   mv.addObject("newArticleCommand", article); // request.getAttribute("newArticleCommand", mv);
			   위 코드가 생략..
			   view key : NewArticleCommand >> newArticleCommand
		 */
		
		// 글쓰기 작업
		this.articleService.writeArticle(article);
		
		return "article/newArticleSubmitted";
	}
	
	/*
	 * 너무 전통적인 방법.. 새로운 방법을 사용해야 한다
	// @RequestMapping(method = RequestMethod.POST) // method가 POST 방식이면 submit으로..
	@PostMapping
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) { // 처리
		System.out.println("POST 처리해 주세요");
		
		NewArticleCommand article = new NewArticleCommand();
		article.setParentId(Integer.parseInt(request.getParameter("parentId")));
		article.setTitle(request.getParameter("title"));
		article.setContent(request.getParameter("content"));
		
		this.articleService.writeArticle(article);
		ModelAndView mv = new ModelAndView();
		mv.addObject("newArticleCommand", article); // request.getAttribute("newArticleCommand", mv);
		mv.setViewName("article/newArticleSubmitted");
		
		return mv;
	}
	 */
}
