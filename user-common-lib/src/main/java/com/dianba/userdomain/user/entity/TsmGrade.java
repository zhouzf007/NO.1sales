package com.dianba.userdomain.user.entity;

import java.io.Serializable;

public class TsmGrade implements Serializable{
	private  static final long serialVersionUID = -6899016789071282037L;
	private Long id;
	private String grade;
	private String gradeName;
	private Integer minRecharge;
	private Integer totalRecharge;
	private String discount;
	private Integer maxDiscount;
	private String icon;
	private String vipIcon;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGradeName() {
		return gradeName;
	}
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	public Integer getMinRecharge() {
		return minRecharge;
	}
	public void setMinRecharge(Integer minRecharge) {
		this.minRecharge = minRecharge;
	}
	public Integer getTotalRecharge() {
		return totalRecharge;
	}
	public void setTotalRecharge(Integer totalRecharge) {
		this.totalRecharge = totalRecharge;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Integer getMaxDiscount() {
		return maxDiscount;
	}
	public void setMaxDiscount(Integer maxDiscount) {
		this.maxDiscount = maxDiscount;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getVipIcon() {
		return vipIcon;
	}
	public void setVipIcon(String vipIcon) {
		this.vipIcon = vipIcon;
	}
	
}