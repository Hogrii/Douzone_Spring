package dao;

import java.util.List;

import vo.Emp;

public interface EmpDao {
	// Emp CRUD
	// 사원 목록
	List<Emp> select();
	
	// 사원 조회
	Emp selectOne(int empno);
	
	// 사원 삭제
	int delete(int empno);
	
	// 사원 수정
	int update(Emp emp);
	
	// 사원 등록
	int insert(Emp emp);	
}
