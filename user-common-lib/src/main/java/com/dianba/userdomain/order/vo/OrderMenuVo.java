package com.dianba.userdomain.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderMenuVo implements Serializable{

	private static final long serialVersionUID = 1700128358442598191L;
	private Long menuId;
	private String menuName;
	private BigDecimal price;
	private Integer count;
	private Integer repertory;
	private String salesPromotion;
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
	public Integer getRepertory() {
		return repertory;
	}
	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}
	public String getSalesPromotion() {
		return salesPromotion;
	}
	public void setSalesPromotion(String salesPromotion) {
		this.salesPromotion = salesPromotion;
	}
	

}
