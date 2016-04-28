package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class PrivateKitchenMenuVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3870283764151489811L;
	
	private Long id;
	private String name;
	private BigDecimal price;
	private String image;
	private Integer todayRepertory;
	private Long buyCount;
	private String intro;
	private String isOpenMerchantMember;//是否参加商家会员活动
	private BigDecimal merchantMemberPrice;//商家会员价
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getTodayRepertory() {
		return todayRepertory;
	}
	public void setTodayRepertory(Integer todayRepertory) {
		this.todayRepertory = todayRepertory;
	}
	public Long getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Long buyCount) {
		this.buyCount = buyCount;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public BigDecimal getMerchantMemberPrice() {
		return merchantMemberPrice;
	}
	public void setMerchantMemberPrice(BigDecimal merchantMemberPrice) {
		this.merchantMemberPrice = merchantMemberPrice;
	}
	public String getIsOpenMerchantMember() {
		return isOpenMerchantMember;
	}
	public void setIsOpenMerchantMember(String isOpenMerchantMember) {
		this.isOpenMerchantMember = isOpenMerchantMember;
	}
	
}
