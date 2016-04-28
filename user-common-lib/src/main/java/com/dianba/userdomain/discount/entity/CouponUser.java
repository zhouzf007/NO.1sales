package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户优惠券表
 * @author folo
 */
public class CouponUser implements Serializable{
	private static final long serialVersionUID = 6007753701017337657L;

	/** 主键 自增 */
	private Integer id;
	
	/** 优惠券编码 */
	private String sn;
	
	/** 用户表id */
	private Long userId;
	
	/** 优惠券id */
	private Integer couponId;
	
	/** 200=商家 100=平台 sys_code表code=coupon_source */
	private Integer sourceType;
	
	/** 关联主键 */
	private Integer sourceId;
	
	/** 关联分类 */
	private Integer sourceGroup;
	
	/** 来源:  ([10]微信[100]支付订单:10100) sys_code=coupon_user_source */
	private Integer source;
	
	/** 可用开始时间 */
	private Date beginUsedTime;
	
	/** 可用结束时间 */
	private Date endUsedTime;
	
	/** -1=未用 1=已用 */
	private Integer status;
	
	/** 使用时间 */
	private Date usedTime;
	
	/** 使用金额 */
	private Integer usedAmount;
	
	/** 创建时间 */
	private Date createdTime;
	
	/** 可用金额 单位:分 */
	private Integer amount;
	
	public CouponUser() {
    }
	
	public CouponUser(CouponGrant couponGrant) {
	    this.couponId = couponGrant.getCouponId();
	    this.sourceType = couponGrant.getUsedType();
	    this.beginUsedTime = couponGrant.coupon.getBeginUsedTime();
	    this.endUsedTime = couponGrant.coupon.getEndUsedTime();
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getSourceGroup() {
		return sourceGroup;
	}

	public void setSourceGroup(Integer sourceGroup) {
		this.sourceGroup = sourceGroup;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Date getBeginUsedTime() {
		return beginUsedTime;
	}

	public void setBeginUsedTime(Date beginUsedTime) {
		this.beginUsedTime = beginUsedTime;
	}

	public Date getEndUsedTime() {
		return endUsedTime;
	}

	public void setEndUsedTime(Date endUsedTime) {
		this.endUsedTime = endUsedTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUsedTime() {
		return usedTime;
	}

	public void setUsedTime(Date usedTime) {
		this.usedTime = usedTime;
	}

	public Integer getUsedAmount() {
		return usedAmount;
	}

	public void setUsedAmount(Integer usedAmount) {
		this.usedAmount = usedAmount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
