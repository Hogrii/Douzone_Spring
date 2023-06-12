package DI_10_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		/*
			BookClient client = new BookClient();
			Properties prop = new Properties();
			prop.setProperty("server", "192.168.0.172");
			prop.setProperty("connectiontimeout", "20");	
			
			client.setConfig(prop);
			client.connect();
		 */
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_10_Spring/DI_10.xml");
		BookClient client = context.getBean("bookClient", BookClient.class);
		client.connect();
	}
}
