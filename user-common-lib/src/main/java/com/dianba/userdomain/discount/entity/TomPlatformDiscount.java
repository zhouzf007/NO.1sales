package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TomPlatformDiscount implements Serializable{
	private  static final long serialVersionUID = 2801508663975340562L;
	private Integer id;
	private Integer merchantId;
	private Integer tsmGradeId;
	private String discountType;
	private BigDecimal discountValue;
	private Date createTime;
	private Date updateTime;
	private Integer userId;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getTsmGradeId() {
		return tsmGradeId;
	}
	public void setTsmGradeId(Integer tsmGradeId) {
		this.tsmGradeId = tsmGradeId;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	public BigDecimal getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}