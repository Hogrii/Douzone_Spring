package DI_06_Spring;

public class ArticleService {
	// ArticleService는 ArticleDao를 의존한다
	// ArticleService는 ArticleDao의 주소가 필요하다
	
	// 2가지(생성자, setter) 주입
	private ArticleDao articleDao;
	public ArticleService(ArticleDao articleDao) { // oracledao, mysqldao 다형성
		this.articleDao = articleDao;
		System.out.println("ArticleService 생성자 호출");
	}
	
	// 글쓰기 서비스
	public void write(Article article) {
		this.articleDao.insert(article);
	}
}
