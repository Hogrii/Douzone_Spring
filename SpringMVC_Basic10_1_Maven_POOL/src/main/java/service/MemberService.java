package service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public String join(Member member) {
		try {
			System.out.println("service :");
			System.out.println(member.getUserid());
			System.out.println(member.getPwd());
			System.out.println(member.getName());
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
			memberdao.insert(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/index.htm";
		
		//http://localhost:8090/SpringMvc/joinus/join.htm
		// "redirect:/index.htm";
		//http://localhost:8090/SpringMvc/index.htm
	}	
}
