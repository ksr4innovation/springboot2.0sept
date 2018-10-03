package com.snkit.springbootdemo.custorder;

import java.util.ArrayList;
import java.util.List;

import com.snkit.springbootdemo.OrderVO;

public class CustomerOrderReq {

	private String email;
	
	private String name;
	private String addhar;
	
	
	public CustomerOrderReq() {
		orderList = new ArrayList<OrderVO>();
	}
	private List<OrderVO>  orderList;


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddhar() {
		return addhar;
	}


	public void setAddhar(String addhar) {
		this.addhar = addhar;
	}


	public List<OrderVO> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<OrderVO> orderList) {
		this.orderList = orderList;
	}
	
	
	
	
	
}
