package com.dianba.userdomain.discount.vo;

import java.io.Serializable;

import com.dianba.userdomain.discount.entity.CouponsUser;

public class CouponsUserLogVo implements Serializable {
	private static final long serialVersionUID = 3806345703035332219L;
	
	private Integer userId;
	private CouponsUser couponsUser;
	private String detail;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public CouponsUser getCouponsUser() {
		return couponsUser;
	}
	public void setCouponsUser(CouponsUser couponsUser) {
		this.couponsUser = couponsUser;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
