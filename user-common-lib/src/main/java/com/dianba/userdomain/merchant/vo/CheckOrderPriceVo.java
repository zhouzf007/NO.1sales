package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CheckOrderPriceVo implements Serializable{

	private static final long serialVersionUID = -6357828755248073002L;
	
	private Long id;
	private BigDecimal price;
	private String promotion;
	private BigDecimal money;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
}
