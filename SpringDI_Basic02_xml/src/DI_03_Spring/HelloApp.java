package DI_03_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {		
		// 위와 같이 쓰려면.. 처음부터 2개를 만들지..
		// 인터페이스 쓰려면 아래처럼(다형성 + 느슨함)
//		MessageBean messageBean = new MessageBean_kr();
//		messageBean.sayHello("hong");
		
		// spring을 통해서 컨테이너를 만들고 메모리 안에 객체를 생성하고 조립(주입)한다
		// GenericXmlApplicationContext -> 자동으로 형변환을 해준다
		// classpath : 약속된 표현(root -> src)
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_03_Spring/DI_03.xml");
		
		// 조립(주입)한 객체 꺼내기
		// 두번째 파라미터 >> MessageBean.class : MessageBean 클래스의 정보를 반환해준다
		MessageBean messageBean = (MessageBean)context.getBean("messageBean", MessageBean.class);
		messageBean.sayHello("진호");
	}
}
/*
	요구사항
	1. 한글버전 (hong) >> 안녕 hong
	2. 영문버전 (hong) >> hello hong
	
	MessageBean_kr 
	MessageBean_en
	
	interface 다형성 설계
 */
