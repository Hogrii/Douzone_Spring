package service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.Member;

@Service
public class MemberService {
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Member getMember(String userid) {
		Member member = null;
		try {
			////////////////////////////////////////////////////////////
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
			////////////////////////////////////////////////////////////

			member = memberdao.getMember(userid);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
	
	public String insert(Member member) {
		 try {
			 member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
			 ////////////////////////////////////////////////////////////
			 MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
			 ////////////////////////////////////////////////////////////
			 memberdao.insert(member); // DB insert
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/index.htm";
	 }
	
	public void updateMember(Member member){
		try {
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);;
			int result = memberdao.update(member);
			
			if(result > 0){
				System.out.println("업데이트 성공");
			}else{
				System.out.println("업데이트 실패");
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
