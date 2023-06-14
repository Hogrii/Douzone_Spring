package com.model;

import java.util.List;

/*
 * 주문서 클래스
 * 하나의 주문은 여러 개의 상품(OrderItem)을 가질 수 있다
 * 
 * board : reply
 * 하나의 게시글은 여러 개의 댓글을 가질 수 있다
 * 
 * 하나의 은행은 여러 개의 계좌를 가질 수 있다
 */

public class OrderCommand {
	// key point
	private List<OrderItem> orderItem;
	
	public List<OrderItem> getOrderItem() {
		return this.orderItem;
	}
	
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	
	/*
	 * 주문 발생, 2건의 주문
	 * 1. 10, 파손주의
	 * 2. 1 , 리모콘 별도 주문
	 * 
	 * List<OrderItem> orderItem = new ArrayList<OrderItem>();
	 * orderItem.add(new OrderItem(1, 10, "파손주의"));
	 * orderItem.add(new OrderItem(2, 1, "리모콘 별도 주문"));
	 * 
	 * OrderCommand command = new OrderCommand();
	 * command.setOrderItem(orderItem);
	 */
}
