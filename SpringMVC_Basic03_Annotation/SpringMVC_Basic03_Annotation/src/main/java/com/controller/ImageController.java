package com.controller;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Photo;

@Controller
@RequestMapping("/image/upload.do")
public class ImageController {
	
	@GetMapping
	public String form() {
		return "image/image"; // 경로만 제공
	}
	
	@PostMapping
	public String submit(Photo photo, HttpServletRequest request) { // Photo -> DTO 타입
		
		/*
		 * 1. photo DTO 타입으로 데이터 받기
		 * 1.1 자동화 : name 속상값이 Photo 타입클래스의 member field 명과 동일
		 * 2. public String submit(Photo photo) 내부적으로..
		 *    >> Photo photo = new Photo();
		 *    >> photo.setName("홍길동");
		 *    >> photo.setAge(20);
		 *    >> photo.setImage() >> 자동 주입이 안됨 >> 수동으로 해야.. >> 가공 CommonsMultipartFile 추출(이름)
		 *    >> photo.setFile(CommonsMultipartFile file) 파일 자동으로 들어와요
		 */
		
		System.out.println(photo.toString());
		CommonsMultipartFile imagefile = photo.getFile();
		System.out.println("imageFile.getName() " + imagefile.getName());
		System.out.println("imagefile.getContentType() " + imagefile.getContentType());
		System.out.println("imagefile.getOriginalFilename() " + imagefile.getOriginalFilename());
		System.out.println("imagefile.getBytes().length " + imagefile.getBytes().length);
		
		// Point 파일명 추출
		photo.setImage(imagefile.getOriginalFilename());
		
		// upload
		// 자동화 : cos.jar(무료), 상용 업로드(DEXT Upload)
		
		String filename = imagefile.getOriginalFilename();
		String path = request.getServletContext().getRealPath("/upload"); // 배포된 서버의 경로
		String fpath = path + "\\" + filename; // c:\\temp\\a.jpg
		System.out.println(fpath); // 실경로 확인하기
		
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
		
		// 여기까지의 작업이 서버 특정 폴더에 파일을 생성
		
		// Next DB 작업 ..
		// DAO >> 게시판에 insert 작업..		
		
		return "image/image";
	}

}
