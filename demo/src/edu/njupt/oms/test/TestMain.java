package edu.njupt.oms.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.njupt.oms.entity.Order;
import edu.njupt.oms.entity.User;

public class TestMain {

	public static void main(String[] args) {
		
		User user = new User(1, "张三", "zhangsan", "123", new Date(), true, 1);
		
		Order order1 = new Order(1, new Date(),	10002.5, 1);
		Order order2 = new Order(2, new Date(),	6002.5, 1);
		Order order3 = new Order(3, new Date(),	8002.5, 1);
		
		//建立Java关联
		order1.setUser(user);
		order2.setUser(user);
		order3.setUser(user);
		List<Order> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);
		user.setOrderList(orderList);
		
		//System.out.println(user);
		//System.out.println(order1);
		
		//查看用户user的所有订单
//		for(Order order:user.getOrderList()) {
//			System.out.println(order);
//		}
		
		System.out.println(order1.getUser().getName());
	}

}
