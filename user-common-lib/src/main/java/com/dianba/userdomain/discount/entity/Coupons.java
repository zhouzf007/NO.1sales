package com.dianba.userdomain.discount.entity;

import java.io.Serializable;

public class Coupons implements Serializable{
	private  static final long serialVersionUID = 5617416656992916608L;
	private Integer id;
	private String couponsType;
	private Integer couponsMoney;
	private Integer couponsLimitMoney;
	private Integer createTime;
	private String status;
	private String couponsUrl;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCouponsType() {
		return couponsType;
	}
	public void setCouponsType(String couponsType) {
		this.couponsType = couponsType;
	}
	public Integer getCouponsMoney() {
		return couponsMoney;
	}
	public void setCouponsMoney(Integer couponsMoney) {
		this.couponsMoney = couponsMoney;
	}
	public Integer getCouponsLimitMoney() {
		return couponsLimitMoney;
	}
	public void setCouponsLimitMoney(Integer couponsLimitMoney) {
		this.couponsLimitMoney = couponsLimitMoney;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCouponsUrl() {
		return couponsUrl;
	}
	public void setCouponsUrl(String couponsUrl) {
		this.couponsUrl = couponsUrl;
	}
}