package AOP_Basic_02_java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

// 보조 업무(공통 관심)를 구현하는 클래스
// 보조 업무에서 실제 함수를 호출할 수 있어야 한다
// 보조 업무에서 실제 함수를 대리할 수 있어야 한다(대리함수) : invoke
// invoke 함수는 여러개의 실제 함수를 대리한다
public class LogPrintHandler implements InvocationHandler { // InvocationHandler로부터 invoke를 재정의
	// 실 객체의 주소값
	private Object target;
	public LogPrintHandler(Object target) {
		System.out.println("LogPrintHandler 생성자 호출 : " + target);
		this.target = target;
	}

	// inboke 함수가 (ADD, MUL, SUB) 함수를 대리한다
	// 마치 진짜 처럼 ..
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// Object[] args는 내가 사용할(Calc로부터 받아오는) 메소드들..
		
		System.out.println("invoke 함수 호출");
		System.out.println("Method method " + method);
		System.out.println("Method parameter " + Arrays.toString(args));
		
		// 보조 업무
		// 시간처리 로직(시작시간)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("[타이머 시작]");

		// 주업무(실제 함수 호출) : 주객체가 가지는 주함수 호출(ADD, MUL, SUB)
		// invoke의 return값은 무조건 Object -> 모든 값을 대리하기 때문
		int result = (int)method.invoke(this.target, args);

		// 보조 업무
		// 시간처리 로직(끝시간)
		sw.stop();
		log.info("[타이머 종료]");
		log.info("[Time log Method] : " + method.getName());
		log.info("[Time log Method] : " + sw.getTotalTimeMillis());

		// 보조함수 해제
		return result;
	}

}
