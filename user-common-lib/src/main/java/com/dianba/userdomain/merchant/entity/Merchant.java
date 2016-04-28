package com.dianba.userdomain.merchant.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.dianba.userdomain.controller.open_api.util.Check;

@Check
public class Merchant implements Serializable{
	private  static final long serialVersionUID = -7681107497661946099L;
	private Integer id;
	private Long userId;
	@Check(group="open")
	private String title;
	private Long groupId;
	private Long cityId;
	private String bankName;
	private String bankNo;
	private String bankUser;
	@Check(group="open")
	private String address;
	private String contact;
	private String phone;
	private String location;
	@Check(group="open")
	private String mobile;
	private Integer createTime;
	@Check(group="open")
	private BigDecimal longitude;
	@Check(group="open")
	private BigDecimal latitude;
	private String display;
	private String notice;
	private Integer startTime;
	private Integer endTime;
	private Integer deliveryTime;
	private String businessLicense;
	private String operatingPermit;
	private String printCode;
	private BigDecimal cardMoney;
	private String cardActivity;
	private BigDecimal biddingMoney;
	private String logoUrl;
	private String promotion;
	private BigDecimal costDelivery;
	private String type;
	private BigDecimal deliveryBegin;
	private BigDecimal deduction;
	private Integer orderNum;
	private Integer incomeDate;
	private String dineOrderPrint;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getBankUser() {
		return bankUser;
	}
	public void setBankUser(String bankUser) {
		this.bankUser = bankUser;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
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
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
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
	public String getPrintCode() {
		return printCode;
	}
	public void setPrintCode(String printCode) {
		this.printCode = printCode;
	}
	public BigDecimal getCardMoney() {
		return cardMoney;
	}
	public void setCardMoney(BigDecimal cardMoney) {
		this.cardMoney = cardMoney;
	}
	public String getCardActivity() {
		return cardActivity;
	}
	public void setCardActivity(String cardActivity) {
		this.cardActivity = cardActivity;
	}
	public BigDecimal getBiddingMoney() {
		return biddingMoney;
	}
	public void setBiddingMoney(BigDecimal biddingMoney) {
		this.biddingMoney = biddingMoney;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public BigDecimal getCostDelivery() {
		return costDelivery;
	}
	public void setCostDelivery(BigDecimal costDelivery) {
		this.costDelivery = costDelivery;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public BigDecimal getDeliveryBegin() {
		return deliveryBegin;
	}
	public void setDeliveryBegin(BigDecimal deliveryBegin) {
		this.deliveryBegin = deliveryBegin;
	}
	public BigDecimal getDeduction() {
		return deduction;
	}
	public void setDeduction(BigDecimal deduction) {
		this.deduction = deduction;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getIncomeDate() {
		return incomeDate;
	}
	public void setIncomeDate(Integer incomeDate) {
		this.incomeDate = incomeDate;
	}
	public String getDineOrderPrint() {
		return dineOrderPrint;
	}
	public void setDineOrderPrint(String dineOrderPrint) {
		this.dineOrderPrint = dineOrderPrint;
	}
}