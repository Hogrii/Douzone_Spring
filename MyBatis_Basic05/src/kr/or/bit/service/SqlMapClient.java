package kr.or.bit.service;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
// 나쁜 냄새가 나는 코드  
public class SqlMapClient {
	private static SqlSession session;	
	static {
		String resource = "SqlMapConfig.xml";
		try {
			  Reader reader =  Resources.getResourceAsReader(resource);
			  SqlSessionFactory factory=  new  SqlSessionFactoryBuilder().build(reader);
			  session = factory.openSession();
		}catch (Exception e) {
			
		}
	}
	
	public static SqlSession getSqlSession() {
		return session;
	}	
}
 */

public class SqlMapClient {
	// SessionFactory는 전역으로 남아있어야 한다 -> 한번 만들고 재사용
	private static SqlSessionFactory sqlsessionfactory;	
	static {
		String resource = "SqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			// build가 reader를 읽고 실행시킨다 -> 한번만 실행!
			sqlsessionfactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			
		}
	}

	public static SqlSessionFactory getSqlSession() {
		return sqlsessionfactory;
	}
}
