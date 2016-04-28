package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;

public class MerchantEndTimeVo implements Serializable{

	private static final long serialVersionUID = -8128533131685792818L;
	
	private Integer endHour;
	private Integer endMin;
	public Integer getEndHour() {
		return endHour;
	}
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}
	public Integer getEndMin() {
		return endMin;
	}
	public void setEndMin(Integer endMin) {
		this.endMin = endMin;
	}

	

}
