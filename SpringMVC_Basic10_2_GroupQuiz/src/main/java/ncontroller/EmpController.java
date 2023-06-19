package ncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.EmpService;
import vo.Emp;

@Controller
@RequestMapping("/emp/")
public class EmpController {
	private EmpService empService;
	
	@Autowired
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	@GetMapping("enroll.htm")
	public String empEnrollPage() {
		System.out.println("들렸다가~");
		List<Emp> list = empService.select();
		
		return "emp/empEnroll";
	}
	
	@PostMapping("enroll.htm")
	public String empEnroll(Emp emp) {
		System.out.println("등록하러 왔어~");
		empService.insert(emp);
		
		return "redirect:/index.htm";
	}
	
	@GetMapping("update.htm")
	public String empUpdatePage(String empno, Model model) {
		System.out.println("update empno : " + empno);
		Emp emp = empService.selectOne(empno);
		model.addAttribute("emp", emp);
		return "emp/empEdit";
	}
	
	@PostMapping("update.htm")
	public String empUdate(Emp emp) {
		System.out.println("업데이트 : " + emp.getEmpno());
		empService.update(emp);
		return "redirect:/index.htm";
	}
	
	@GetMapping("delete.htm")
	public String empDelete(String empno) {
		System.out.println("delete empno : " + empno);
		empService.delete(empno);
		return "redirect:/index.htm";
	}
}
