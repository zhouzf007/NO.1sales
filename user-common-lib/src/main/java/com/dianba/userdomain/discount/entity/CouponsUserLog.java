package com.dianba.userdomain.discount.entity;

import java.io.Serializable;

public class CouponsUserLog implements Serializable{
	private  static final long serialVersionUID = -3734996220123874764L;
	private Integer id;
	private Integer userId;
	private Integer orderId;
	private Integer couponsUserId;
	private Integer useTime;
	private String detail;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getCouponsUserId() {
		return couponsUserId;
	}
	public void setCouponsUserId(Integer couponsUserId) {
		this.couponsUserId = couponsUserId;
	}
	public Integer getUseTime() {
		return useTime;
	}
	public void setUseTime(Integer useTime) {
		this.useTime = useTime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}