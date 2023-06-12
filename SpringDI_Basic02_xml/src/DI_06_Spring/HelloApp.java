package DI_06_Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		// java 코드
//		ArticleService oService = new ArticleService(new OracleDao());
//		ArticleService mService = new ArticleService(new MySqlDao());
//		Article article = new Article();
//		oService.write(article);
		
		
		ApplicationContext context = new GenericXmlApplicationContext("classpath:DI_06_Spring/DI_06.xml");
		ArticleService service = (ArticleService)context.getBean("service", ArticleService.class);
		Article article = (Article)context.getBean("article", Article.class);
		
		service.write(article);
	}

}
