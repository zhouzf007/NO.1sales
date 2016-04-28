package com.dianba.userdomain.merchant.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Menu implements Serializable{
	private  static final long serialVersionUID = 4487383987232077791L;
	private Long id;
	private String name;
	private BigDecimal price;
	private String image;
	private Long typeId;
	private Integer merchantId;
	private Integer createTime;
	private Long buyCount;
	private String intro;
	private Long printType;
	private String display;
	private Integer repertory;
	private Integer todayRepertory;
	private Integer beginTime;
	private Integer endTime;
	private Integer limitToday;
	private String isDelete;
	private Integer menuSort;
	private BigDecimal priceOnline;
	private String isonline;
	private String unit;
	
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
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
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
	public Long getPrintType() {
		return printType;
	}
	public void setPrintType(Long printType) {
		this.printType = printType;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public Integer getRepertory() {
		return repertory;
	}
	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}
	public Integer getTodayRepertory() {
		return todayRepertory;
	}
	public void setTodayRepertory(Integer todayRepertory) {
		this.todayRepertory = todayRepertory;
	}
	public Integer getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public Integer getLimitToday() {
		return limitToday;
	}
	public void setLimitToday(Integer limitToday) {
		this.limitToday = limitToday;
	}
	public String getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	public Integer getMenuSort() {
		return menuSort;
	}
	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}
	public BigDecimal getPriceOnline() {
		return priceOnline;
	}
	public void setPriceOnline(BigDecimal priceOnline) {
		this.priceOnline = priceOnline;
	}
	public String getIsonline() {
		return isonline;
	}
	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}