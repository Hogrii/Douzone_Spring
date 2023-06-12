package DI_02;

public class HelloApp {
	public static void main(String[] args) {
		// 영문 버전
		MessageBean_en en = new MessageBean_en();
		en.sayHello("jinho");
		
		// 한글 버전
		MessageBean_kr kr = new MessageBean_kr();
		kr.sayHello("진호");
		
		MessageBean messageBean = new MessageBean_kr();
		messageBean.sayHello("hong");
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
