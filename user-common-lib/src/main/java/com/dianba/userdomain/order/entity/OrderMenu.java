package com.dianba.userdomain.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderMenu implements Serializable{
	private  static final long serialVersionUID = -3439569504602803325L;
	private Long id;
	private Integer orderId;
	private Long menuId;
	private Integer quantity;
	private BigDecimal price;
	private BigDecimal totalPrice;
	private String state;
	private BigDecimal promotionMoney;
	private String salesPromotion;
	private Integer menuPromotionId;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public BigDecimal getPromotionMoney() {
		return promotionMoney;
	}
	public void setPromotionMoney(BigDecimal promotionMoney) {
		this.promotionMoney = promotionMoney;
	}
	public String getSalesPromotion() {
		return salesPromotion;
	}
	public void setSalesPromotion(String salesPromotion) {
		this.salesPromotion = salesPromotion;
	}
	public Integer getMenuPromotionId() {
		return menuPromotionId;
	}
	public void setMenuPromotionId(Integer menuPromotionId) {
		this.menuPromotionId = menuPromotionId;
	}
}