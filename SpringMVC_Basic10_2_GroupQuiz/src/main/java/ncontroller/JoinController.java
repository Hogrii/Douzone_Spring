package ncontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import service.MemberService;
import vo.Member;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	private MemberService memberService;
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	//GET 요청
	//join.jsp 화면
	@GetMapping("join.htm")  //  /joinus/join.htm
	public String join() {
		return "joinus/join";
		//   /WEB-INF/views/  +  joinus/join   + .jsp
	}
	
	//POST 요청
	@PostMapping("join.htm")
	public String join(Member member) {
		System.out.println(member.getUserid());
		System.out.println(member.getPwd());
		System.out.println(member.getName());
		return memberService.join(member);
	}	
}
