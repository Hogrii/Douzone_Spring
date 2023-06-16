package ncontroller;

import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.NoticeDao;
import vo.Notice;

@Controller
@RequestMapping("/customer/")
public class CustomerController {
	
	private NoticeDao noticedao;
	
	@Autowired
	public void setNoticedao(NoticeDao noticedao) {
		this.noticedao = noticedao;
	}
	
	@RequestMapping("notice.htm") // /customer/notice.htm
	public String notices(String pg, String f, String q, Model model) {
		// HttpServletRequest request >> 생성된 request 객체의 주소가 할당
		// Model model >> 생성된 model 객체의 주소가 할당,, request와 똑같다 >> 데이터 저장에 사용
		
		int page = 1;
		String field="TITLE";
		String query = "%%";
		if(pg != null   && !pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(f != null   && ! f.equals("")) {
			field = f;
		}
		
		if(pg != null   && ! pg.equals("")) {
			page  = Integer.parseInt(pg);
		}
		
		if(q != null   && ! q.equals("")) {
			query = q;
		}
		
		//DAO 작업
		List<Notice> list = null;
		try {
			list = noticedao.getNotices(page, field, query);			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		// list View 전달 (저장 >> 전달)
		// 1. public ModelAndView ..
		//    mv.addObject("list", list);
		//    vm.setViewName("notice.jsp");
		//    return mv;

		model.addAttribute("list", list); // 자동으로 notice.jsp로 forward..
		
		return "notice.jsp";
	}
	
	@RequestMapping("noticeDetail.htm")
	public String noticesDetail(String seq, Model model) {
		//public Notice getNotice(String seq)
		
		Notice notice = null;
		System.out.println("seq : " + seq);
		
		try {
			notice = noticedao.getNotice(seq);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail.jsp"; 
	}
	
	// @GetMapping (화면) : select
	// @PostMapping(처리) : insert
	// <a class="btn-write button" href="noticeReg.htm">글쓰기</a>	
	@GetMapping(value="noticeReg.htm") // /customer/noticeReg.htm >> 전송 >> get
	public String noticeReg() {
		return "noticeReg.jsp";
	}
	
	// form method="post" action="" 현재 주소창에 있는 주소
	// customer/noticeReg.htm 전송 >> POST	
	@PostMapping(value="noticeReg.htm")
	public String noticeReg(Notice notice, HttpServletRequest request) {
		System.out.println(notice.toString());
		// 글쓰기 완료 >> 목록으로 이동 >> 리다이렉트 >> location.href="", response.sendRedirect
		// Spring -> redirect: notice.htm
		
		CommonsMultipartFile imagefile = notice.getFile();
		System.out.println("imageFile.getName() " + imagefile.getName());
		System.out.println("imagefile.getContentType() " + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename() " + imagefile.getOriginalFilename());
		System.out.println("imagefile.getBytes().length " + imagefile.getBytes().length);
		
		// upload
		// 자동화 : cos.jar(무료), 상용 업로드(DEXT Upload)
		
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("customer/upload"); // 배포된 서버의 경로
		String fpath = path + "\\" + filename; // c:\\temp\\a.jpg
		System.out.println("fpath : " + fpath); // 실경로 확인하기
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(fpath); // 파일 생성 >> 없으면 1.jpg 생성
			fos.write(imagefile.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		notice.setFileSrc(filename);
		
		try {
			noticedao.insert(notice);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return "redirect: notice.htm";
	}

	// 글 수정하기(화면이면서 동시에 데이터를 처리) GET
	// <a class="btn-edit button" href="noticeEdit.htm?seq=${notice.seq }">수정</a>
	@GetMapping(value="noticeEdit.htm") // /customer/noticeEdit.htm
	public String noticeEdit(String seq, Model model) {
		Notice notice = null;
		
		try {
			noticedao.getNotice(seq);			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		model.addAttribute("notice", notice);
		
		return "noticeEdit.jsp";
	}
	
	@PostMapping(value="noticeEdit.htm")
	public String noticeEdit(Notice notice, HttpServletRequest request) {
		// 추후 파일처리
		
		System.out.println(notice.toString());
		// 글쓰기 완료 >> 목록으로 이동 >> 리다이렉트 >> location.href="", response.sendRedirect
		// Spring -> redirect: notice.htm
		
		CommonsMultipartFile imagefile = notice.getFile();
		System.out.println("imageFile.getName() " + imagefile.getName());
		System.out.println("imagefile.getContentType() " + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename() " + imagefile.getOriginalFilename());
		System.out.println("imagefile.getBytes().length " + imagefile.getBytes().length);
		
		// upload
		// 자동화 : cos.jar(무료), 상용 업로드(DEXT Upload)
		
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("customer/upload"); // 배포된 서버의 경로
		String fpath = path + "\\" + filename; // c:\\temp\\a.jpg
		System.out.println("fpath : " + fpath); // 실경로 확인하기
		
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream(fpath); // 파일 생성 >> 없으면 1.jpg 생성
			fos.write(imagefile.getBytes());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
		// 파일명(DTO)
		notice.setFileSrc(filename);
		
		try {
			noticedao.update(notice);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return "redirect: noticeDetail.htm?seq=" + notice.getSeq();
		
	}
	
	// 글 삭제하기
	// <a class="btn-del button" href="noticeDel.htm?seq=${notice.seq }">삭제</a>

}
