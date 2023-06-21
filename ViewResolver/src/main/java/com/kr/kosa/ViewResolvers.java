package com.kr.kosa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class ViewResolvers {
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanName = new BeanNameViewResolver();
		beanName.setOrder(0);
		return beanName;
	}
	
	@Bean("MainPage")
	public JstlView mainPage() {
		JstlView mainPage = new JstlView();
		mainPage.setUrl("WEB-INF/views/board/MainPage.jsp");
		return mainPage;
	}
	
	@Bean("FirstBoard")
	public JstlView firstBoard() {
		JstlView firstBoard = new JstlView();
		firstBoard.setUrl("WEB-INF/views/board/FirstBoard.jsp");
		return firstBoard;
	}
	
	@Bean("SecondBoard")
	public JstlView secondBoard() {
		JstlView secondBoard = new JstlView();
		secondBoard.setUrl("WEB-INF/views/board/SecondBoard.jsp");
		return secondBoard;
	}

	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internal = new InternalResourceViewResolver();
		internal.setPrefix("/WEB-INF/views/board/");
		internal.setSuffix(".jsp");
		internal.setOrder(1);
		return internal;
	}
}
