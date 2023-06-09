package Spring_DI4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Program {
	public static void main(String[] args) {
		/*
			// NewRecordView view = new NewRecordView(100, 50, 40);		
			// view.print();
			
			NewRecordView view = new NewRecordView();
			// 놀다가
			// 나는 NewRecord 객체 주소가 필요해
			NewRecord record = new NewRecord(100, 100, 100);
			view.setRecord(record); // 의존객체의 주소를 주입 받는다(DI)
			view.print();
		 */
		/*
		 * 스프링은 자신만의 메모리 공간을 갖는다
		 * 1. SpringFrameWork 컨테이너를 제공(메모리 생성 : 컨테이너(IOC 컨테이너))
		 *    ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		 * 	  ApplicationContext 메모리 공간을 만들고, DIConfig.xml 파일을 컴파일하고 읽고 설정한다
		 * 2. 컨테이너를 만들고 그 메모리에 필요한 [객체를 생성]한 뒤 객체들을 조립(주입:DI) 한다.. 나중에 자동 소멸
		 * 	  >> 컨테이너가 생성되고 DIConfig.xml를 read ..
		 * 	  >> DIConfig.xml 안에 객체 생성과 조립에 관련된 내용들이 들어 있다
		 * 	  >> 생성된 객체를 bean이라고 한다
		 */
		
		// 1. ApplicationContext -> 스프링 메모리 공간을 만들어주는 객체
		// Spring이 필요한 메모리 공간을 생성하고 생성된 메모리에 DIConfig.xml을 read한 뒤 객체를 생성하고 주입
		ApplicationContext context = new ClassPathXmlApplicationContext("DIConfig.xml");
		
		// 컨테이너 안에 필요한 객체가 있다면 가지고 온다 >> DIConfig.xml의 id값을 이용하면 된다
		RecordView view = (RecordView)context.getBean("view"); // getBean의 return -> Object
		view.input();
		view.print();
		// 실행시 에러
		// Caused by: java.lang.ClassNotFoundException: org.apache.commons.logging.LogFactory
		
	}
}
