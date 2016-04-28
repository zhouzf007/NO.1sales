package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

public class TomMerchantMemberInfo implements Serializable{
	private  static final long serialVersionUID = -5843951941599995841L;
	private Integer id;
	private Integer merchantId;
	private Integer userId;
	private Integer money;
	private Date createTime;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}