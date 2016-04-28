package com.dianba.userdomain.merchant.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class MenuType implements Serializable{
	private  static final long serialVersionUID = 8196994087093076273L;
	private Integer id;
	private String name;
	private Integer sortNum;
	private Long merchantId;
	private Integer createTime;
	private BigDecimal costLunchBox;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public BigDecimal getCostLunchBox() {
		return costLunchBox;
	}
	public void setCostLunchBox(BigDecimal costLunchBox) {
		this.costLunchBox = costLunchBox;
	}
	
}