package edu.njupt.oms.entity;

import java.util.Date;
import java.util.List;

public class User {

	private Integer id;
	private String name;
	private String account;
	private String password;
	private Date birthday;
	private Boolean gender;
	private Integer status;
	//关联订单集合对象,建立Java的1->n的关联
	private List<Order> orderList;

	public User() {
		super();
	}

	public User(Integer id, String name, String account, String password, Date birthday, Boolean gender,
			Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", password=" + password + ", birthday="
				+ birthday + ", gender=" + gender + ", status=" + status + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

}
