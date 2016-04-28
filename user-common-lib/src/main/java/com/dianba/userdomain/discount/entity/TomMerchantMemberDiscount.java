package com.dianba.userdomain.discount.entity;

import java.io.Serializable;

public class TomMerchantMemberDiscount implements Serializable{
	private  static final long serialVersionUID = -4292757848886651367L;
	private Integer id;
	private Integer merchantId;
	private String merchantDiscount;
	private Integer minRecharge;

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
	public String getMerchantDiscount() {
		return merchantDiscount;
	}
	public void setMerchantDiscount(String merchantDiscount) {
		this.merchantDiscount = merchantDiscount;
	}
	public Integer getMinRecharge() {
		return minRecharge;
	}
	public void setMinRecharge(Integer minRecharge) {
		this.minRecharge = minRecharge;
	}
}