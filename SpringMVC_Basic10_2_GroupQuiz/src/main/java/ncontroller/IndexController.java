package ncontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.EmpService;
import vo.Emp;

@Controller
public class IndexController {
	private EmpService empService;
	
	@Autowired
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	@RequestMapping("/index.htm")
	public String index(Model model) {
		List<Emp> empList = empService.select();
		model.addAttribute("empList", empList);
		return "emp/empList";
		
		//   /WEB-INF/views/  +  index   + .jsp
	}
}
