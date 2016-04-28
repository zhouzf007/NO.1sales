package com.dianba.userdomain.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderMenusVo implements Serializable{

	private static final long serialVersionUID = 4461233004274592434L;
	
	private Long menuId;
	private String menuName;
	private BigDecimal price;
	private Integer count;
	private BigDecimal promotionMoney;
	private String promotion;
	private Long promotionId;
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public BigDecimal getPromotionMoney() {
		return promotionMoney;
	}
	public void setPromotionMoney(BigDecimal promotionMoney) {
		this.promotionMoney = promotionMoney;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public Long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}
	

}
