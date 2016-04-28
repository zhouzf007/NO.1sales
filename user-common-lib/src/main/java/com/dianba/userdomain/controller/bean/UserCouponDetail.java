package com.dianba.userdomain.controller.bean;

import com.dianba.userdomain.discount.entity.Coupon;
import com.dianba.userdomain.util.DateUtils;

public class UserCouponDetail extends Coupon {
	private static final long serialVersionUID = 1198047662830536243L;
	/** 用户优惠券id */
	private int userCouponId;
	
	/** 展示优惠券金额 单位：元 */
	@SuppressWarnings("unused")
    private String showAmount;
	
	/** 优惠券编码 */
	private String sn;
	
	/** 分类名称 */
	private String categoryName;
	
	/** 店铺名称 */
	private String merchantName;
	
	/** 平台名称 */
	private String sourceTypeName;
	
	/** 有效时间开始:yyyyMMdd */
	private String effectiveBeginUsedTime;
	
	/** 有效时间结束:yyyyMMdd */
	private String effectiveEndUsedTime;
	
	public UserCouponDetail() {
		super();
	}

	public int getUserCouponId() {
		return userCouponId;
	}

	public void setUserCouponId(int userCouponId) {
		this.userCouponId = userCouponId;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getSourceTypeName() {
		return sourceTypeName;
	}

	public void setSourceTypeName(String sourceTypeName) {
		this.sourceTypeName = sourceTypeName;
	}
	
	public void setEffectiveBeginUsedTime(String effectiveBeginUsedTime) {
		this.effectiveBeginUsedTime = effectiveBeginUsedTime;
	}
	
	public String getEffectiveBeginUsedTime(){
		this.effectiveBeginUsedTime = DateUtils.formatDate(getBeginUsedTime(), "yyyy.MM.dd");
		return effectiveBeginUsedTime;
	}
	
	public void setEffectiveEndUsedTime(String effectiveEndUsedTime) {
		this.effectiveEndUsedTime = effectiveEndUsedTime;
	}
	
	public String getEffectiveEndUsedTime(){
		this.effectiveEndUsedTime = DateUtils.formatDate(getEndUsedTime(), "yyyy.MM.dd");
		return effectiveEndUsedTime;
	}
	
	public void setShowAmount(String showAmount) {
        this.showAmount = showAmount;
    }
	
	public String getShowAmount(){
	    return CouponPackage.getShowTotalMoney(getAmount());
	}
}
