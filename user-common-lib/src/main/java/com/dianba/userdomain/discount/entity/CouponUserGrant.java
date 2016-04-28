package com.dianba.userdomain.discount.entity;

import java.util.Date;

/**
 * 优惠券赠送记录表
 * @author folo
 *
 */
public class CouponUserGrant implements java.io.Serializable {
	private static final long serialVersionUID = 7046611461513145421L;
	/** 主键id */
	private Integer id;
	
	/** 订单表id */
	private Long orderId;
	
	/** 用户表id */
	private Long userId;
	
	/** 赠送的优惠券id，多个用逗号隔开 */
	private String couponIds;
	
	/** 赠送状态 -1 未赠送，1 已赠送 */
	private Integer status;
	
	/** 创建时间 */
	private Date createdTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}
