package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;

public class MerchantStartTimeVo implements Serializable{

	private static final long serialVersionUID = 4282921853347631608L;
	
	private Integer startHour;
	private Integer startMin;
	
	public Integer getStartHour() {
		return startHour;
	}

	public void setStartHour(Integer startHour) {
		this.startHour = startHour;
	}

	public Integer getStartMin() {
		return startMin;
	}

	public void setStartMin(Integer startMin) {
		this.startMin = startMin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
