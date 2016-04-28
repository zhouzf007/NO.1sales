package com.dianba.userdomain.discount.entity;

import java.io.Serializable;

public class CouponsPublish implements Serializable{
	private  static final long serialVersionUID = -4059729149033517519L;
	private Integer id;
	private Integer userId;
	private String couponsType;
	private String couponsSerial;
	private Integer createTime;
	private Integer endTime;
	private Integer couponsNum;
	private String status;

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
	public String getCouponsType() {
		return couponsType;
	}
	public void setCouponsType(String couponsType) {
		this.couponsType = couponsType;
	}
	public String getCouponsSerial() {
		return couponsSerial;
	}
	public void setCouponsSerial(String couponsSerial) {
		this.couponsSerial = couponsSerial;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public Integer getCouponsNum() {
		return couponsNum;
	}
	public void setCouponsNum(Integer couponsNum) {
		this.couponsNum = couponsNum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}