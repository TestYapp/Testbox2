package edu.njupt.oms.entity;

import java.util.Date;

public class Order {

	private Integer id;
	private Date createTime;
	private Double totalPrice;
	private Integer userId;
	//建立订单到用户的关联,n->1
	private User user;

	public Order() {
		super();
	}

	public Order(Integer id, Date createTime, Double totalPrice, Integer userId) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.totalPrice = totalPrice;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", createTime=" + createTime + ", totalPrice=" + totalPrice + ", userId=" + userId
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
