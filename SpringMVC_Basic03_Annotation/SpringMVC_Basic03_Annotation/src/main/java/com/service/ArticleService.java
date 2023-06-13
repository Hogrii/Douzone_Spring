package com.service;

import com.model.NewArticleCommand;

/**
 * @Service >> 너는 bean 객체로 생성되어야 해
 * public class ArticleService
 * 
 * xml 파일에 (설정) spring-servlet.xml
 * <context:component-scan base-package="com.service">
 */

public class ArticleService {
	public ArticleService() {
		System.out.println("articleService 생성자 호출");
	}
	
	public void writeArticle(NewArticleCommand command) {
		// dao 동작한다 가정
		// insert 가정
		System.out.println("글쓰기 작업 완료 : " + command.toString());
	}
}
