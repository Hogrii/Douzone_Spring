package DI_Annotation_04_javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // xml파일을 대체할 설정파일이 된다!! -> DIConfig.xml 같은 역할
			   // -> Bean객체 생성과 조립을 순수 자바 파일로 할 수 있다
public class ConfigContext {
	
	// xml : <bean id="user" class="DI_Annotation_04_javaconfig.User">
	// 자바 코드에서는 함수를 통해서 객체를 생성하고 리턴하게 만든다
	@Bean
	public User user() {
		return new User();
	}
	
	// xml : <bean id="user2" class="DI_Annotation_04_javaconfig.User2">
	@Bean
	public User2 user2() {
		return new User2();
	}

}
