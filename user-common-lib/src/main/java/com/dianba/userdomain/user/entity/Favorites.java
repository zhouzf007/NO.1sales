package com.dianba.userdomain.user.entity;

import java.io.Serializable;

public class Favorites implements Serializable{
	private  static final long serialVersionUID = 2910293896988099481L;
	private Integer id;
	private String type;
	private Integer userid;
	private Integer itemId;
	private Integer fTime;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getFTime() {
		return fTime;
	}
	public void setFTime(Integer fTime) {
		this.fTime = fTime;
	}
}