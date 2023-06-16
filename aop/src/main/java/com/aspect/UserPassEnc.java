package com.aspect;

import java.security.MessageDigest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.dto.User;

@Component
@Aspect
public class UserPassEnc {
	@Before("execution(* com.service.UserService.*(..))")
	public void passwordEnc(JoinPoint jp) throws Exception {
		Object[] args = jp.getArgs();
		User user = (User) args[0];// Member의 주소가 들어감
		String password = user.getPassword();
		System.out.println("암호화 전 PW:" + password);
		String encPw = encData(password);
		System.out.println("암호화 된 PW:" + encPw);
		user.setPassword(encPw);
	}

	public String encData(String data) throws Exception {// 패스워드 값을 매개변수로 받음

		System.out.println("SHA256Util 입장");
		// MessageDigest 클래스를 이용한 암호화
		MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
		// password 값을 바이트 배열로 바꿔서 mDigest에 넣어줌
		mDigest.update(data.getBytes());
		// SHA-256으로 변환된 데이터를 byte배열로 꺼냄
		byte[] msgStr = mDigest.digest();
		// 1byte 0~255까지 사용가능하지만
		// 정수는 음수까지 포함해서 -128~127 까지의 범위를 표현 가능
		// 16진수로 변경 00~FF 범위로 변경할 예정
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < msgStr.length; i++) {
			byte tmpStrByte = msgStr[i];
			String tmpTxt = Integer.toString((tmpStrByte & 0xff) + 0x100, 16).substring(1);
			sb.append(tmpTxt);
		}
		return sb.toString();
	}

//	@Around("execution(* com.service.CalcService.*(..))")
//	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
//		
//		//공통 기능이 적용되는 메서드가 어떤 메서드인지 출력하기 위해 메서드명을 얻어옴
//		String signatureStr = joinpoint.getSignature().toShortString();
//		System.out.println(signatureStr + "시작"); //메서드 실행
//		
//		//공통기능
//		System.out.println("핵심 기능 전에 실행 할 공통 기능입니다. "+System.currentTimeMillis());
//		
//		try {
//			Object obj = joinpoint.proceed(); //핵심 기능 실행
//			return obj;
//		} finally {
//			//공통기능
//			System.out.println("핵심 기능 후에 실행 할 공통 기능입니다. "+System.currentTimeMillis());
//			
//			System.out.println(signatureStr + "끝");
//		}
//	}

//	@Pointcut("execution(* com.service..*.*(..))")
//	public void print() {System.out.println("안녕하세요");}
//	
//
//	
//	@After("execution(* com.service..*.*(..))")
//	public void print2() { System.out.println("안녕하세요2");}

}
