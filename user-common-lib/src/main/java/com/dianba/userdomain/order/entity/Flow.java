package com.dianba.userdomain.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Flow implements Serializable{
	private  static final long serialVersionUID = 4646847567288427273L;
	private Long id;
	private Long merchantId;
	private Long userId;
	private Long detailId;
	private String detail;
	private BigDecimal money;
	private String action;
	private Integer createTime;
	private String type;
	private BigDecimal preMoney;
	private BigDecimal postMoney;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getPreMoney() {
		return preMoney;
	}
	public void setPreMoney(BigDecimal preMoney) {
		this.preMoney = preMoney;
	}
	public BigDecimal getPostMoney() {
		return postMoney;
	}
	public void setPostMoney(BigDecimal postMoney) {
		this.postMoney = postMoney;
	}
}