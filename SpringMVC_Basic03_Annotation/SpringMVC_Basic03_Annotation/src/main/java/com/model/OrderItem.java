package com.model;

import lombok.Data;

// DB 상품 테이블
// 1:1 mapping

@Data
public class OrderItem {
	private int itemid;
	private int number;
	private String remark;
}
