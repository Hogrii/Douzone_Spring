package main;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.bit.dto.User;
import kr.or.bit.service.SqlMapClient;

public class program {
	public static void main(String[] args) {
		// method scope
		// sqlsessionfactory -> singleton
	    SqlSessionFactory sqlsession = SqlMapClient.getSqlSession();
	    
	    SqlSession session = sqlsession.openSession(); //연결 객체 생성
	    
	    //session.selectOne("Emp.getone", arg1)

	    // Mapper에 있는 <mapper namespace="Emp">
	    // Mapper에 있는 <select id="getone" parameterType="String" ~
	    // "namespace.id", data
	    User user = (User)session.selectOne("Emp.getone", "ALLEN");
	    System.out.println(user.getEmpno());
	    System.out.println(user.getEname());
	    session.close();
	}

}



