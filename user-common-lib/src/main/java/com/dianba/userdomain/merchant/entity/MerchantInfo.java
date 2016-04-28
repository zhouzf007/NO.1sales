package com.dianba.userdomain.merchant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MerchantInfo implements Serializable{
	private  static final long serialVersionUID = 3321712097926274731L;
	private Integer id;
	private BigDecimal courierMinDeductMoney;
	private String merchantDeductType;
	private BigDecimal deductPercent;
	private Integer merchantId;
	private Integer isTakeout;
	private Integer isHallFood;
	private String supportSaleType;
	private BigDecimal costLunchBox;
	private String preferentialInformation;
	private String merchantSource;
	private BigDecimal deliveryScope;
	private Date deliveryScopeTime;
	private BigDecimal scanDiscount;
	private String isScanDiscount;
	private Integer scanDiscountLimit;
	private Integer isDineInDiscount;
	private Integer dineInDiscount;
	private Integer merchantSharePercent;
	private Integer platformSharePercent;


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getCourierMinDeductMoney() {
		return courierMinDeductMoney;
	}
	public void setCourierMinDeductMoney(BigDecimal courierMinDeductMoney) {
		this.courierMinDeductMoney = courierMinDeductMoney;
	}
	public String getMerchantDeductType() {
		return merchantDeductType;
	}
	public void setMerchantDeductType(String merchantDeductType) {
		this.merchantDeductType = merchantDeductType;
	}
	public BigDecimal getDeductPercent() {
		return deductPercent;
	}
	public void setDeductPercent(BigDecimal deductPercent) {
		this.deductPercent = deductPercent;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getIsTakeout() {
		return isTakeout;
	}
	public void setIsTakeout(Integer isTakeout) {
		this.isTakeout = isTakeout;
	}
	public Integer getIsHallFood() {
		return isHallFood;
	}
	public void setIsHallFood(Integer isHallFood) {
		this.isHallFood = isHallFood;
	}
	public String getSupportSaleType() {
		return supportSaleType;
	}
	public void setSupportSaleType(String supportSaleType) {
		this.supportSaleType = supportSaleType;
	}
	public BigDecimal getCostLunchBox() {
		return costLunchBox;
	}
	public void setCostLunchBox(BigDecimal costLunchBox) {
		this.costLunchBox = costLunchBox;
	}
	public String getPreferentialInformation() {
		return preferentialInformation;
	}
	public void setPreferentialInformation(String preferentialInformation) {
		this.preferentialInformation = preferentialInformation;
	}
	public String getMerchantSource() {
		return merchantSource;
	}
	public void setMerchantSource(String merchantSource) {
		this.merchantSource = merchantSource;
	}
	public BigDecimal getDeliveryScope() {
		return deliveryScope;
	}
	public void setDeliveryScope(BigDecimal deliveryScope) {
		this.deliveryScope = deliveryScope;
	}
	public Date getDeliveryScopeTime() {
		return deliveryScopeTime;
	}
	public void setDeliveryScopeTime(Date deliveryScopeTime) {
		this.deliveryScopeTime = deliveryScopeTime;
	}
	public BigDecimal getScanDiscount() {
		return scanDiscount;
	}
	public void setScanDiscount(BigDecimal scanDiscount) {
		this.scanDiscount = scanDiscount;
	}
	public String getIsScanDiscount() {
		return isScanDiscount;
	}
	public void setIsScanDiscount(String isScanDiscount) {
		this.isScanDiscount = isScanDiscount;
	}
	public Integer getIsDineInDiscount() {
		return isDineInDiscount;
	}
	public void setIsDineInDiscount(Integer isDineInDiscount) {
		this.isDineInDiscount = isDineInDiscount;
	}
	public Integer getDineInDiscount() {
		return dineInDiscount;
	}
	public void setDineInDiscount(Integer dineInDiscount) {
		this.dineInDiscount = dineInDiscount;
	}
	public Integer getMerchantSharePercent() {
		return merchantSharePercent;
	}
	public void setMerchantSharePercent(Integer merchantSharePercent) {
		this.merchantSharePercent = merchantSharePercent;
	}
	public Integer getPlatformSharePercent() {
		return platformSharePercent;
	}
	public void setPlatformSharePercent(Integer platformSharePercent) {
		this.platformSharePercent = platformSharePercent;
	}
	@Override
	public String toString() {
		return "MerchantInfo [id=" + id + ", courierMinDeductMoney="
				+ courierMinDeductMoney + ", merchantDeductType="
				+ merchantDeductType + ", deductPercent=" + deductPercent
				+ ", merchantId=" + merchantId + ", isTakeout=" + isTakeout
				+ ", isHallFood=" + isHallFood + ", supportSaleType="
				+ supportSaleType + ", costLunchBox=" + costLunchBox
				+ ", preferentialInformation=" + preferentialInformation
				+ ", merchantSource=" + merchantSource + ", deliveryScope="
				+ deliveryScope + ", deliveryScopeTime=" + deliveryScopeTime
				+ ", scanDiscount=" + scanDiscount + ", isScanDiscount="
				+ isScanDiscount + "]";
	}
	public Integer getScanDiscountLimit() {
		return scanDiscountLimit;
	}
	public void setScanDiscountLimit(Integer scanDiscountLimit) {
		this.scanDiscountLimit = scanDiscountLimit;
	}
	
}