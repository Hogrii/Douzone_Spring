package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.config.AopConfig;
import com.dao.UserDAO;
import com.dto.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO dao;
	
	@Override
	public String inset(User user) {		
		System.out.println("inset함수 실행중");		
		String en_pass = user.getPassword();		
		try {
			int result = dao.inset(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
		return en_pass;
	}
}