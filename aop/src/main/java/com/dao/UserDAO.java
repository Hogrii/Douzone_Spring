package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.dto.User;

@Component
public class UserDAO {
	public int inset(User user) throws ClassNotFoundException, SQLException {
		// 2. 데이터 베이스 연동을 위한 쿼리와 실행 코드 작성
		String sql = "insert into springuser values(?, ?)";
		// 0. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 1. 접속
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "springuser", "1004");
		// 2. 실행
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, user.getId());
		st.setString(2, user.getPassword());

		int af = st.executeUpdate();

		return af;
	}

}
