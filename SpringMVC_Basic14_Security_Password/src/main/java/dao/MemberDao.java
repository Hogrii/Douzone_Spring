package dao;

import java.sql.SQLException;
import vo.Member;

public interface MemberDao {
	Member getMember(String uid) throws ClassNotFoundException, SQLException;

	int insert(Member member) throws ClassNotFoundException, SQLException;

	// 회원수정
	public int update(Member member) throws ClassNotFoundException, SQLException;
}
