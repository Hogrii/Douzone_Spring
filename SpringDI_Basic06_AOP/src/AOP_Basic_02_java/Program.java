package AOP_Basic_02_java;

import java.lang.reflect.Proxy;

public class Program {
	public static void main(String[] args) {
		// 1. 실객체의 주소
		Calc calc = new NewCalc();
		
		// 2. 속임수(진짜 함수를 호출하는 것이 아니고 가짜를 만들어서 호출하게 한다 >> 보조 업무를 수행하기 위해서)
		// >> 가짜(Proxy)
		Calc cal = (Calc)Proxy.newProxyInstance(calc.getClass().getClassLoader(), // 1번 파라미터 : 실객체의 정보(내부정보) : 메타정보
							                    calc.getClass().getInterfaces(), // 2번 파라미터 : 행위정보(인터페이스)
							                    new LogPrintHandler(calc)); // 3번 파라미터 : 보조관심 실행(공통관심) 객체 정보
		// calc.getClass().getClassLoader() : 역컴파일로 클래스 정보를 확인하기 위해 들어간다(reflection)
		// calc.getClass().getInterfaces() : 인터페이스의 정보 -> calc 인터페이스 내의 메소드를 가져오는 것
		// new LogPrintHandler(calc) : 실제 주소 정보를 슬쩍 넘겨준다 >> 생성자에서 Object target으로 받음
		
		// 실제 사용자 시점
		// ADD 함수를 호출해서 사용 가능하다 >> Calc가 가지고 있는 ADD가 아니라 LogPrintHandler가 가지고 있는 가짜 ADD이다
		int result = cal.ADD(12, 13);
		System.out.println("result : " + result);
	}
}
