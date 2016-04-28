package com.dianba.userdomain.order.entity;

import java.io.Serializable;

public class OrderState implements Serializable{
	private  static final long serialVersionUID = 2246331529749951224L;
	private Long id;
	private Long orderId;
	private Integer dealTime;
	private String state;
	private String detail;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Integer getDealTime() {
		return dealTime;
	}
	public void setDealTime(Integer dealTime) {
		this.dealTime = dealTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}