package com.dianba.userdomain.user.vo;

import java.io.Serializable;

public class AddressDetailVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5937208878644394138L;
	
	private String address;
	private String mobile;
	private String name;
	private String longitude;
	private String latitude;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	

}
