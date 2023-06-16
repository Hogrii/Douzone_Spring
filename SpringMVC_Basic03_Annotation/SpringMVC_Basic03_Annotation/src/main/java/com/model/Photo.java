package com.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * DB에 테이블(게시판 자료실)
 * create table photo(
 *   name
 *   age
 *   image >> 업로드한 파일의 이름 1. jpg, 2. jpg
 *   기타 : 파일의 용량, 생성일, 수정일
 * )
 * 
 * 실제 파일은 I/O 작업을 서버의 특정 폴더에 업로드 >> AWS >> S3 서버 >> 파일 서버
 * 
 * 클라이언트가 서버에 전송 ->> public String form(Photo photo)
 * (이름, 나이, 파일)
 */

public class Photo {
	private String name;
	private int age;
	private String image;
	
	// 파일을 담을 수 있는 객체 제공
	// POINT
	private CommonsMultipartFile file; 
	// multipart/form-data 형식으로 업로드한 파일을 담는다
	// client로부터 넘어온 이름이 file이기 때문에 변수명을 file로 만든다 
	// <input type="file" name="file"><br> -> image.jsp에 있음
	// <form method="post" enctype="multipart/form-data"> -> multipart 안쓰면 파일 안넘어옴..

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public CommonsMultipartFile getFile() {
		return file;
	}

	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Photo [name=" + name + ", age=" + age + ", image=" + image + ", file=" + file + "]";
	}
}
