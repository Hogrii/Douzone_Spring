package com.model;

import lombok.Data;

// DB 테이블과 1:1로 매핑되는 클래스
// create Article ..

@Data
public class NewArticleCommand {
	private int parentId;
	private String title;
	private String content;
}
