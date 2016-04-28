package com.dianba.userdomain.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderDetailVo implements Serializable{

	private static final long serialVersionUID = -7996304774059176844L;
	private Long id;
	private String payId;
	private String payType;
	private Integer userId;
	private Long courierId;
	private Long cityId;
	private String cardId;
	private String status;
	private String state;
	private String rstate;
	private String rereason;
	private Integer retime;
	private String realname;
	private String mobile;
	private String address;
	private BigDecimal onlineMoney;
	private BigDecimal origin;
	private BigDecimal credit;
	private BigDecimal card;
	private String remark;
	private Integer createTime;
	private Integer payTime;
	private String commentContent;
	private String commentDisplay;
	private BigDecimal commentTaste;
	private BigDecimal commentSpeed;
	private BigDecimal commentService;
	private BigDecimal commentCourier;
	private Integer commentTime;
	private Integer merchantId;
	private BigDecimal scoreMoney;
	private Integer score;
	private String orderType;
	private Integer accessTime;
	private Integer deliveryTime;
	private Integer completeTime;
	private Integer urgentTime;
	private String title;
	private String ifcourier;
	private Integer deliveryDoneTime;
	private String payState;
	private Integer saleType;
	private String orderNum;
	private String outTraceId;
	private String timeRemark;
	private Integer cookDoneTime;
	private String cookDoneCode;
	private Integer startTime;
	private String commentCourierContent;
	private Integer startSendTime;
	private Integer endSendTime;
	private Integer userAddressId;
	private String invoice;
	private String fromType;
	private BigDecimal deliveryFee;
	private BigDecimal costLunchBox;
	private String merchantMobile;
	private boolean isComment;
	private String realCreateTime;
	private String merchantPic;
	private String orderState;
	private String merchantTitle;
	private String courierMobile;
	private Integer merchantSource;
	private String merchantAddress;
	private BigDecimal memberDiscountMoney;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPayId() {
		return payId;
	}
	public void setPayId(String payId) {
		this.payId = payId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Long getCourierId() {
		return courierId;
	}
	public void setCourierId(Long courierId) {
		this.courierId = courierId;
	}
	public Long getCityId() {
		return cityId;
	}
	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRstate() {
		return rstate;
	}
	public void setRstate(String rstate) {
		this.rstate = rstate;
	}
	public String getRereason() {
		return rereason;
	}
	public void setRereason(String rereason) {
		this.rereason = rereason;
	}
	public Integer getRetime() {
		return retime;
	}
	public void setRetime(Integer retime) {
		this.retime = retime;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getOnlineMoney() {
		return onlineMoney;
	}
	public void setOnlineMoney(BigDecimal onlineMoney) {
		this.onlineMoney = onlineMoney;
	}
	public BigDecimal getOrigin() {
		return origin;
	}
	public void setOrigin(BigDecimal origin) {
		this.origin = origin;
	}
	public BigDecimal getCredit() {
		return credit;
	}
	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}
	public BigDecimal getCard() {
		return card;
	}
	public void setCard(BigDecimal card) {
		this.card = card;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	public Integer getPayTime() {
		return payTime;
	}
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDisplay() {
		return commentDisplay;
	}
	public void setCommentDisplay(String commentDisplay) {
		this.commentDisplay = commentDisplay;
	}
	public BigDecimal getCommentTaste() {
		return commentTaste;
	}
	public void setCommentTaste(BigDecimal commentTaste) {
		this.commentTaste = commentTaste;
	}
	public BigDecimal getCommentSpeed() {
		return commentSpeed;
	}
	public void setCommentSpeed(BigDecimal commentSpeed) {
		this.commentSpeed = commentSpeed;
	}
	public BigDecimal getCommentService() {
		return commentService;
	}
	public void setCommentService(BigDecimal commentService) {
		this.commentService = commentService;
	}
	public BigDecimal getCommentCourier() {
		return commentCourier;
	}
	public void setCommentCourier(BigDecimal commentCourier) {
		this.commentCourier = commentCourier;
	}
	public Integer getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(Integer commentTime) {
		this.commentTime = commentTime;
	}
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public BigDecimal getScoreMoney() {
		return scoreMoney;
	}
	public void setScoreMoney(BigDecimal scoreMoney) {
		this.scoreMoney = scoreMoney;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Integer accessTime) {
		this.accessTime = accessTime;
	}
	public Integer getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Integer deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Integer getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Integer completeTime) {
		this.completeTime = completeTime;
	}
	public Integer getUrgentTime() {
		return urgentTime;
	}
	public void setUrgentTime(Integer urgentTime) {
		this.urgentTime = urgentTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIfcourier() {
		return ifcourier;
	}
	public void setIfcourier(String ifcourier) {
		this.ifcourier = ifcourier;
	}
	public Integer getDeliveryDoneTime() {
		return deliveryDoneTime;
	}
	public void setDeliveryDoneTime(Integer deliveryDoneTime) {
		this.deliveryDoneTime = deliveryDoneTime;
	}
	public String getPayState() {
		return payState;
	}
	public void setPayState(String payState) {
		this.payState = payState;
	}
	public Integer getSaleType() {
		return saleType;
	}
	public void setSaleType(Integer saleType) {
		this.saleType = saleType;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getOutTraceId() {
		return outTraceId;
	}
	public void setOutTraceId(String outTraceId) {
		this.outTraceId = outTraceId;
	}
	public String getTimeRemark() {
		return timeRemark;
	}
	public void setTimeRemark(String timeRemark) {
		this.timeRemark = timeRemark;
	}
	public Integer getCookDoneTime() {
		return cookDoneTime;
	}
	public void setCookDoneTime(Integer cookDoneTime) {
		this.cookDoneTime = cookDoneTime;
	}
	public String getCookDoneCode() {
		return cookDoneCode;
	}
	public void setCookDoneCode(String cookDoneCode) {
		this.cookDoneCode = cookDoneCode;
	}
	public Integer getStartTime() {
		return startTime;
	}
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	public String getCommentCourierContent() {
		return commentCourierContent;
	}
	public void setCommentCourierContent(String commentCourierContent) {
		this.commentCourierContent = commentCourierContent;
	}
	public Integer getStartSendTime() {
		return startSendTime;
	}
	public void setStartSendTime(Integer startSendTime) {
		this.startSendTime = startSendTime;
	}
	public Integer getEndSendTime() {
		return endSendTime;
	}
	public void setEndSendTime(Integer endSendTime) {
		this.endSendTime = endSendTime;
	}
	public Integer getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getFromType() {
		return fromType;
	}
	public void setFromType(String fromType) {
		this.fromType = fromType;
	}
	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}
	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	public BigDecimal getCostLunchBox() {
		return costLunchBox;
	}
	public void setCostLunchBox(BigDecimal costLunchBox) {
		this.costLunchBox = costLunchBox;
	}
	public String getMerchantMobile() {
		return merchantMobile;
	}
	public void setMerchantMobile(String merchantMobile) {
		this.merchantMobile = merchantMobile;
	}
	public boolean isComment() {
		return isComment;
	}
	public void setComment(boolean isComment) {
		this.isComment = isComment;
	}
	public String getRealCreateTime() {
		return realCreateTime;
	}
	public void setRealCreateTime(String realCreateTime) {
		this.realCreateTime = realCreateTime;
	}
	public String getMerchantPic() {
		return merchantPic;
	}
	public void setMerchantPic(String merchantPic) {
		this.merchantPic = merchantPic;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	public String getMerchantTitle() {
		return merchantTitle;
	}
	public void setMerchantTitle(String merchantTitle) {
		this.merchantTitle = merchantTitle;
	}
	public String getCourierMobile() {
		return courierMobile;
	}
	public void setCourierMobile(String courierMobile) {
		this.courierMobile = courierMobile;
	}
	public Integer getMerchantSource() {
		return merchantSource;
	}
	public void setMerchantSource(Integer merchantSource) {
		this.merchantSource = merchantSource;
	}
	public String getMerchantAddress() {
		return merchantAddress;
	}
	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}
	public BigDecimal getMemberDiscountMoney() {
		return memberDiscountMoney;
	}
	public void setMemberDiscountMoney(BigDecimal memberDiscountMoney) {
		this.memberDiscountMoney = memberDiscountMoney;
	}
	
	
}
