package DI_04_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	public static void main(String[] args) {
		// java 코드
//		MessageBeanImple messageBean = new MessageBeanImple("jinho");
//		messageBean.setGreeting("hello");
//		messageBean.sayHello();

		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_04_Spring/DI_04.xml");
		MessageBean messageBean = (MessageBean)context.getBean("m1", MessageBean.class);
		messageBean.sayHello();
	}
}
