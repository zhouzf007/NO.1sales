package com.dianba.userdomain.controller.bean;

import java.math.BigDecimal;

import com.dianba.userdomain.discount.entity.Coupon;
import com.dianba.userdomain.util.DateUtils;


/**
 * 优惠券礼包
 * @author folo
 */
public class CouponPackage extends Coupon {
	private static final long serialVersionUID = -7450691155372156065L;

	/** 礼包名称 */
	private String name;
	
	/** 礼包总价值 单位：分 */
	private int totalMoney;
	
	/** 展示总金额 单位：元 */
	@SuppressWarnings("unused")
    private String showTotalMoney;
	
	/** 礼包优惠券张数 */
	private int count;
	
	/** 用户优惠券id,多个优惠券id用逗号","隔开 */
	private String userCouponIds;
	
	/** 用户优惠券编码,多个用逗号","隔开 */
	private String couponSns;
	
	/** 有效时间开始:yyyyMMdd */
	private String effectiveBeginUsedTime;
	
	/** 有效时间结束:yyyyMMdd */
	private String effectiveEndUsedTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUserCouponIds() {
		return userCouponIds;
	}

	public void setUserCouponIds(String userCouponIds) {
		this.userCouponIds = userCouponIds;
	}

	public String getCouponSns() {
		return couponSns;
	}

	public void setCouponSns(String couponSns) {
		this.couponSns = couponSns;
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
	
	public void setShowTotalMoney(String showTotalMoney) {
        this.showTotalMoney = showTotalMoney;
    }
	
	public String getShowTotalMoney(){
		return getShowTotalMoney(totalMoney);
	}
	
	public static String getShowTotalMoney(Integer totalMoney){
        return new BigDecimal(totalMoney).divide(new BigDecimal(100)).stripTrailingZeros().toPlainString();
    }
}
