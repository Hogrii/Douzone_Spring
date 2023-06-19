package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EmpDao;
import vo.Emp;

@Service
public class EmpService {
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlSessoin(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	// 조회
	public List<Emp> select() {
		List<Emp> list = null;	
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			list = empDao.select();
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return list;
	}
	
	// 사원 조회
	public Emp selectOne(String empno) {
		Emp emp = new Emp();
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			emp = empDao.selectOne(Integer.parseInt(empno));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	// 등록
	public void insert(Emp emp) {
		System.out.println(emp.getEmpno());
		try {
			EmpDao empDao = sqlsession.getMapper(EmpDao.class);
			empDao.insert(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 수정
	public void update(Emp emp) {
		System.out.println(emp.getEmpno());
		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			empdao.update(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 삭제
	public void delete(String empno) {
		System.out.println("Del empno : " + empno);
		try { 
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			empdao.delete(Integer.parseInt(empno));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
