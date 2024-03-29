package kr.or.kosa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	private EmpService empservice;

	@Autowired
	public void setEmpservice(EmpService empservice) {
		this.empservice = empservice;
	}
	
	// 전체 조회
	// http://localhost:8090/kosa/emp
	@GetMapping // /emp가 들어온다
	public ResponseEntity<List<Emp>> empList() { 
		List<Emp> list = new ArrayList<Emp>();
		try {
			System.out.println("정상실행");
			list = empservice.selectAllEmpList();
			return new ResponseEntity<List<Emp>>(list, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Emp>>(list, HttpStatus.BAD_REQUEST);
		}
	}
	
	// 조건 조회
	// http://localhost:8090/kosa/emp/7788
	// @RequestMapping(value="{empno}", method=RequestMethod.GET)
	// value="{empno}"를 사용하면 emp/empno에 값이 떨어진다
	@GetMapping("{empno}") // mapping에 {empno}를 정의하고
	public Emp empListByEmpno(@PathVariable("empno") int empno) { // PathVariable안에 mapping에 정의한 변수명을 적은 뒤 뒤에 파라미터를 받아주면 파라미터에 값이 떨어진다 
		return empservice.selectEmpByEmpno(empno);
	}
	
	// 데이터 삽입(POST)
	// 데이터 전달(empno=3000&ename=아무개&sal=100)
	// Client(JSON) 형태의 문자열
	// http://localhost:8090/kosa/emp and POST and data {JSON객체}
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Emp emp) {
		try {
			System.out.println("insert 실행");
			System.out.println(emp.toString());
			empservice.insert(emp);
			return new ResponseEntity<String>("insert sucess", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("insert fail", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Emp emp) {
		try {
			System.out.println("update 실행");
			System.out.println(emp.toString());
			empservice.insert(emp);
			return new ResponseEntity<String>("update sucess", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("update fail", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("{empno}")
	public ResponseEntity<String> delete(@PathVariable("empno") int empno) {		
		try {
			System.out.println("delete 실행");
			empservice.delete(empno);
			return new ResponseEntity<String>("delete sucess", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("delete fail", HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	
	//controller 는 service 의존합니다
	/*
	Restful 방식의 annotation 도 존재합니다 
	@GetMapping
	@PostMapping
	@DeleteMapping
	@PutMapping
	@PatchMapping
	*/
	
	/*
	가장 쉬운 방식 
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Emp> empList(){
		return empservice.selectAllEmpList();
	}
	*/

}
/*
@RestController
public class ResfulUserController {
	
	@Autowired
	private IUserDAO dao;
	
	
	// 삭제
	@DeleteMapping("/users/{id}") // path valueable
	public int deleteUser(@PathVariable int id) {
		return dao.deleteUser(id);
	}
	
	// 수정
	@PutMapping("/users")
	public int updateUser(@RequestBody UserVO user) { restcontroller = controller + responsebody.. requestbody가 아니기 때문에 필요하면 사용해야한다
		return dao.updateUser(user);
	}
	
	
	// 등록
	@PostMapping("/users")
	public int insertUser(@RequestBody UserVO user) {
		return dao.insertUser(user);
	}
	
	
	
	// 1명 조회
	@GetMapping("/users/{userid}")
	public UserVO user(@PathVariable String userid) {
		return dao.getUser(userid);
	}
	
	
	// 목록조회
	@GetMapping("/users")
	public List<UserVO> users(){
		return dao.getUsers();
	}
	
	

}
*/
/*



var data = {"name":"John Doe"}
$.ajax({
    dataType : "html", //서버에서 html타입을 반환받는다.
    contentType: "application/json; charset=utf-8",
    data : JSON.stringify(data),
    success : function(result) {
        jQuery("#someContainer").html(result); // 반환받은 html을 추가한다.
    },
});











<script>
$(function(){
	user_list();
});

function user_list(){
	$.ajax({
		url : 'users',
		method : 'GET',
		contentType:'application/json;charset=utf-8',
		dataType:'json',
		
		error:function(error,status,msg){
			alert("상태코드 " + status + "에러메시지" + msg );
		},
		success:user_list_result
	});
}

function user_list_result(xhr) {
	console.log(xhr);
	
}

</script>
*/