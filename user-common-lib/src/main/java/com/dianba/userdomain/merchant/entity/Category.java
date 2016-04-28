package com.dianba.userdomain.merchant.entity;

import java.io.Serializable;

public class Category implements Serializable{
	private  static final long serialVersionUID = -8171627737251587451L;
	private Long id;
	private String zone;
	private String czone;
	private String name;
	private String ename;
	private String letter;
	private Integer sortOrder;
	private String display;
	private Long relateData;
	private Integer fid;
	private String hot;
	private String areaCode;
	private String img;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getCzone() {
		return czone;
	}
	public void setCzone(String czone) {
		this.czone = czone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getLetter() {
		return letter;
	}
	public void setLetter(String letter) {
		this.letter = letter;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public Long getRelateData() {
		return relateData;
	}
	public void setRelateData(Long relateData) {
		this.relateData = relateData;
	}
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}