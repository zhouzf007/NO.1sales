package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MerchantSearchVo implements Serializable {

	private static final long serialVersionUID = 2224788326722614400L;

	private String title;
	private Long cityId;
	private BigDecimal longitude;
	private BigDecimal latitude;
	private String display;
	private Double precision;
	private Long groupId;// 分类id
	private String preferentialField; // 优惠活动字段
	private String preferentialValue;// 优惠活动值
	private Integer fid;
	private boolean defaultGroupBy;
	private Integer merchantSource; // 商家类型
	private Integer couponMerchant; // 是否只显示有优惠券信息的商家 -1=显示

	public Integer getMerchantSource() {
		return merchantSource;
	}

	public void setMerchantSource(Integer merchantSource) {
		this.merchantSource = merchantSource;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public Double getPrecision() {
		return precision;
	}

	public void setPrecision(Double precision) {
		this.precision = precision;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public String getPreferentialField() {
		return preferentialField;
	}

	public void setPreferentialField(String preferentialField) {
		this.preferentialField = preferentialField;
	}

	public String getPreferentialValue() {
		return preferentialValue;
	}

	public void setPreferentialValue(String preferentialValue) {
		this.preferentialValue = preferentialValue;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Integer getCouponMerchant() {
		return couponMerchant;
	}

	public void setCouponMerchant(Integer couponMerchant) {
		this.couponMerchant = couponMerchant;
	}

	public boolean getDefaultGroupBy() {
		return defaultGroupBy;
	}

	public void setDefaultGroupBy(boolean defaultGroupBy) {
		this.defaultGroupBy =defaultGroupBy;
	}

}
