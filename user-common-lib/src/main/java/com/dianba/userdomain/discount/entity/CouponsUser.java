package com.dianba.userdomain.discount.entity;

import java.io.Serializable;

public class CouponsUser implements Serializable{
	private  static final long serialVersionUID = 5722584167867680270L;
	private Integer id;
	private String userMobile;
	private Integer couponsNum;
	private Integer couponsMoney;
	private Integer couponsLimitMoney;
	private String couponsSerial;
	private String couponsType;
	private Integer endTime;
	private Integer createTime;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public Integer getCouponsNum() {
		return couponsNum;
	}
	public void setCouponsNum(Integer couponsNum) {
		this.couponsNum = couponsNum;
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
	public String getCouponsSerial() {
		return couponsSerial;
	}
	public void setCouponsSerial(String couponsSerial) {
		this.couponsSerial = couponsSerial;
	}
	public String getCouponsType() {
		return couponsType;
	}
	public void setCouponsType(String couponsType) {
		this.couponsType = couponsType;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
}