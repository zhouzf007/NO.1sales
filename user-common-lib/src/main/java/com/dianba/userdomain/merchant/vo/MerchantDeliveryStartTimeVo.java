package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;

public class MerchantDeliveryStartTimeVo implements Serializable{

	private static final long serialVersionUID = 9143680188541086373L;

	private Integer deliveryStartHour;
	private Integer deliveryStartMin;
	public Integer getDeliveryStartHour() {
		return deliveryStartHour;
	}
	public void setDeliveryStartHour(Integer deliveryStartHour) {
		this.deliveryStartHour = deliveryStartHour;
	}
	public Integer getDeliveryStartMin() {
		return deliveryStartMin;
	}
	public void setDeliveryStartMin(Integer deliveryStartMin) {
		this.deliveryStartMin = deliveryStartMin;
	}
	
	
}
