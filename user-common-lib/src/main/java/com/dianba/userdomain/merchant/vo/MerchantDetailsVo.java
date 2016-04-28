package com.dianba.userdomain.merchant.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class MerchantDetailsVo implements Serializable{

	private static final long serialVersionUID = -5118016351814824889L;
	private Integer id;
	private String title;
	private BigDecimal deliveryBegin;
	private String notice;
	private Integer startTime;
	private Integer endTime;
	private String address;
	private String businessLicense;
	private String operatingPermit;
	private String logoUrl;
	private Double merchantGrade;
	private String salesVolume;
	private String mobile;
	private String startTimeString;
	private String endTimeString;

    private String couponMsg;//商家优惠券折扣信息
	
	public String getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(String salesVolume) {
		this.salesVolume = salesVolume;
	}
	public Double getMerchantGrade() {
		return merchantGrade;
	}
	public void setMerchantGrade(Double merchantGrade) {
		this.merchantGrade = merchantGrade;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getDeliveryBegin() {
		return deliveryBegin;
	}
	public void setDeliveryBegin(BigDecimal deliveryBegin) {
		this.deliveryBegin = deliveryBegin;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public Integer getEndTime() {
		return endTime;
	}
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBusinessLicense() {
		return businessLicense;
	}
	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}
	public String getOperatingPermit() {
		return operatingPermit;
	}
	public void setOperatingPermit(String operatingPermit) {
		this.operatingPermit = operatingPermit;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStartTimeString() {
		return startTimeString;
	}
	public void setStartTimeString(String startTimeString) {
		this.startTimeString = startTimeString;
	}
	public String getEndTimeString() {
		return endTimeString;
	}
	public void setEndTimeString(String endTimeString) {
		this.endTimeString = endTimeString;
	}
    public String getCouponMsg() {
        return couponMsg;
    }

    public void setCouponMsg(String couponMsg) {
        this.couponMsg = couponMsg;
    }
}
