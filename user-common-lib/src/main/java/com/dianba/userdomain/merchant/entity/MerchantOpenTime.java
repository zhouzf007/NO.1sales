package com.dianba.userdomain.merchant.entity;

import java.io.Serializable;

public class MerchantOpenTime implements Serializable{
	private  static final long serialVersionUID = 1772271894875205455L;
	private Integer id;
	private Integer merchantId;
	private String startTime;
	private String endTime;

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
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}