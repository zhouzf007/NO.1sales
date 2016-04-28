package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MerchantMenuSearchVo implements Serializable{

	private static final long serialVersionUID = 385025793442371277L;
	private Long id;
	private String name;
	private BigDecimal price;
	private Long typeId;
	private Integer merchantId;
	private Long buyCount;
	private String merchantName;
	private int isOpenMerchantMember;//是否参加商家会员
	private BigDecimal memberPrice;//商家会员价
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
	public Long getTypeId() {
		return typeId;
	}
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Long getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Long buyCount) {
		this.buyCount = buyCount;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public int getIsOpenMerchantMember() {
		return isOpenMerchantMember;
	}
	public void setIsOpenMerchantMember(int isOpenMerchantMember) {
		this.isOpenMerchantMember = isOpenMerchantMember;
	}
	public BigDecimal getMemberPrice() {
		return memberPrice;
	}
	public void setMemberPrice(BigDecimal memberPrice) {
		this.memberPrice = memberPrice;
	}
	
	
}
