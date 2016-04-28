package com.dianba.userdomain.statistics.entity;

import java.io.Serializable;

public class TumUserStatistics implements Serializable{
	private  static final long serialVersionUID = 1401007661412651711L;
	private Long id;
	private Long userId;
	private Integer totalMoney;
	private Integer totalOrder;
	private Integer totalRecharge;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Integer getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Integer getTotalOrder() {
		return totalOrder;
	}
	public void setTotalOrder(Integer totalOrder) {
		this.totalOrder = totalOrder;
	}
	public Integer getTotalRecharge() {
		return totalRecharge;
	}
	public void setTotalRecharge(Integer totalRecharge) {
		this.totalRecharge = totalRecharge;
	}
	
	
}