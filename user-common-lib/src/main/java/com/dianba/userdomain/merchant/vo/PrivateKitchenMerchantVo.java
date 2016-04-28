package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class PrivateKitchenMerchantVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5748106458917037759L;
	
	private Long id;
	private BigDecimal deliveryBegin;
	private Integer startTime;
	private Integer endTime;
	private String display;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getDeliveryBegin() {
		return deliveryBegin;
	}
	public void setDeliveryBegin(BigDecimal deliveryBegin) {
		this.deliveryBegin = deliveryBegin;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	
	
}
