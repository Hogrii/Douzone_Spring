package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.OrderCommand;

/*
 * 하나의 요청 주소로 2개의 업무를 처리
 * 주소 : /order/order.do
 * 업무
 * GET > 화면
 * POST > 처리
 */

@Controller
@RequestMapping("/order/order.do")
public class OrderController {
	
	@GetMapping
	public String form() {
		return "order/OrderForm";
	}
	
	@PostMapping
	public String submit(OrderCommand ordercommand) {
		return "order/OrderCommitted";
	}
	
	/*
	 * 1. 자동화된 코드..
	 * 1.1 OrderCommand ordercommand = new OrderCommand();
	 * 1.2 자동매핑 >> member field >> private List<OrderItem> orderItem; 자동주입
	 * 
	 * 2. List<OrderItem> itemlist = new ArrayList<OrderItem>();이 자동으로 만들어져야 한다
	 *    >> orderItem[0].itemid > 1
	 *    >> orderItem[0].number > 10
	 *    >> orderItem[0].remark > "파손주의"
	 *    >> itemlist.add(newOrderItem(1, 10, "파손주의"))
	 *    
	 *    >> orderItem[1].itemid > 2
	 *    >> orderItem[1].number > 1
	 *    >> orderItem[1].remark > "리모콘"
	 *    >> itemlist.add(newOrderItem(2, 1, "리모콘"))
	 *    ..
	 *    >> itemlist.add(newOrderItem(3, 10, "파손주의"))
	 *    
	 * 3. ordercommand.setOrderItem(itemlist);
	 * 4. orderItem은 itemlist 주소값을 주입 받는다
	 * 5. View에 전달
	 *    자동 key, value 생성 forward
	 *    public String submit(OrderCommand ordercommand)
	 *    key >> orderCommand
	 *    value >> OrderCommand의 주소값
	 *    
	 * 
	 * List<OrderItem> itemlist = new ArrayList<OrderItem>();
	 * orderItem.add(new OrderItem(1, 10, "파손주의"));
	 * orderItem.add(new OrderItem(2, 1, "리모콘 별도 주문"));
	 * 
	 * OrderCommand command = new OrderCommand();
	 * command.setOrderItem(itemlist);
	 */

}
