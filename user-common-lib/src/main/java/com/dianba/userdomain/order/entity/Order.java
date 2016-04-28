package com.dianba.userdomain.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

public class Order implements Serializable {
    private static final long serialVersionUID = -5180117714110031960L;
    @Id
    private Long id;

    /**
     * 支付ID
     */
    private String payId;

    /**
     * 支付类型：tenpay 财付通，weixinpay 微信支付，unionpay银联支付，alipay支付宝支付 , merchantpay商家会员支付，wft_pay威付通
     */
    private String payType;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 快递员ID
     */
    private Long courierId;

    /**
     * 城市ID
     */
    private Long cityId;

    /**
     * 代金券id
     */
    private String cardId;

    /**
     * 预收入状态:'Y';'N'
     */
    private String status;

    /**
     * 订单状态：unpay未支付，pay支付成功，accept制作中，done待评价，confirm 已完成，refund 退款 delivery 配送中，delivery_done配送完成
     */
    private String state;

    /**
     * 默认为normal，normal 正常状态，askrefund 申请退款，berefund 退款, norefund 拒绝退款, askReturnProduct 申请退款退货，acceptRefundApply 同意退款申请
     */
    private String rstate;

    /**
     * 退款时间
     */
    private Integer retime;

    /**
     * 名字
     */
    private String realname;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 地址
     */
    private String address;

    /**
     * 在线支付金额
     */
    private BigDecimal onlineMoney;

    /**
     * 订单金额
     */
    private BigDecimal origin;

    /**
     * 余额支付金额
     */
    private BigDecimal credit;

    /**
     * 代金券金额
     */
    private BigDecimal card;

    /**
     * 创建时间
     */
    private Integer createTime;

    /**
     * 支付时间
     */
    private Integer payTime;

    /**
     * 是否显示
     */
    private String commentDisplay;

    /**
     * 评价-口味
     */
    private Float commentTaste;

    /**
     * 评价速度
     */
    private Float commentSpeed;

    /**
     * 评价-服务
     */
    private Float commentService;

    /**
     * 评价-快递员
     */
    private Float commentCourier;

    /**
     * 评价时间
     */
    private Integer commentTime;

    /**
     * 商家id
     */
    private Integer merchantId;

    /**
     * 使用积分抵用金额
     */
    private BigDecimal scoreMoney;

    /**
     * 抵用积分
     */
    private Integer score;

    /**
     * 是否电话订单
     */
    private String orderType;

    /**
     * 商家接收订单时间
     */
    private Integer accessTime;

    /**
     * 开始配送时间
     */
    private Integer deliveryTime;

    /**
     * 订单完成时间
     */
    private Integer completeTime;

    /**
     * 加急时间
     */
    private Integer urgentTime;

    /**
     * 订单描述
     */
    private String title;

    /**
     * 是否快递服务'Y'：'是'；'N'：'否'
     */
    private String ifcourier;

    /**
     * 配送完成时间
     */
    private Integer deliveryDoneTime;

    /**
     * 支付状态
     */
    private String payState;

    /**
     * 1.为外卖订单，2为堂食订单
     */
    private Integer saleType;

    /**
     * 排号（每天清）
     */
    private String orderNum;

    /**
     * 第三方交易订单流水号（支付宝，微信支付等）
     */
    private String outTraceId;

    /**
     * 送达时间备注
     */
    private String timeRemark;

    /**
     * 厨房制作完成时间
     */
    private Integer cookDoneTime;

    /**
     * 厨房制作状态
     */
    private String cookDoneCode;

    /**
     * 开始制作时间
     */
    private Integer startTime;

    private String commentCourierContent;

    /**
     * 最早送达时间
     */
    private Integer startSendTime;

    /**
     * 最早送达时间
     */
    private Integer endSendTime;

    /**
     * 用户收货地址
     */
    private Integer userAddressId;

    private String invoice;

    private String fromType;

    /**
     * 配送费
     */
    private BigDecimal deliveryFee;

    /**
     * 餐盒费
     */
    private BigDecimal costLunchBox;

    /**
     * 会员折扣减去金额
     */
    private BigDecimal memberDiscountMoney;

    /**
     * 商家会员折扣减去金额
     */
    private BigDecimal merchantMemberDiscountMoney;

    /**
     * 堂食折扣
     */
    private BigDecimal dineInDiscountMoney;

    /**
     * 充值来源 0-正常充值 1-快递员推荐充值
     */
    private Integer rechargeSrc;

    /**
     * 邀请人ID
     */
    private Long inviteId;

    /**
     * 代理商ID
     */
    private Integer agentId;

    /**
     * 是否商家配送：merchant商家配送  courier快递员配送
     */
    private String isMerchantDelivery;

    /**
     * 乐玩咖ID
     */
    private String lwkId;

    /**
     * 乐玩咖渠道标识
     */
    private String lwkMark;

    /**
     * 乐玩咖是否推送
     */
    private String lwkFlag;

    /**
     * flash_order 的ID
     */
    private Long flashOrderId;

    /**
     * 退款理由
     */
    private String rereason;

    /**
     * 备注
     */
    private String remark;

    /**
     * 评价内容
     */
    private String commentContent;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取支付ID
     *
     * @return pay_id - 支付ID
     */
    public String getPayId() {
        return payId;
    }

    /**
     * 设置支付ID
     *
     * @param payId 支付ID
     */
    public void setPayId(String payId) {
        this.payId = payId;
    }

    /**
     * 获取支付类型：tenpay 财付通，weixinpay 微信支付，unionpay银联支付，alipay支付宝支付 , merchantpay商家会员支付，wft_pay威付通
     *
     * @return pay_type - 支付类型：tenpay 财付通，weixinpay 微信支付，unionpay银联支付，alipay支付宝支付 , merchantpay商家会员支付，wft_pay威付通
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置支付类型：tenpay 财付通，weixinpay 微信支付，unionpay银联支付，alipay支付宝支付 , merchantpay商家会员支付，wft_pay威付通
     *
     * @param payType 支付类型：tenpay 财付通，weixinpay 微信支付，unionpay银联支付，alipay支付宝支付 , merchantpay商家会员支付，wft_pay威付通
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取快递员ID
     *
     * @return courier_id - 快递员ID
     */
    public Long getCourierId() {
        return courierId;
    }

    /**
     * 设置快递员ID
     *
     * @param courierId 快递员ID
     */
    public void setCourierId(Long courierId) {
        this.courierId = courierId;
    }

    /**
     * 获取城市ID
     *
     * @return city_id - 城市ID
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 设置城市ID
     *
     * @param cityId 城市ID
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取代金券id
     *
     * @return card_id - 代金券id
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 设置代金券id
     *
     * @param cardId 代金券id
     */
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    /**
     * 获取预收入状态:'Y';'N'
     *
     * @return status - 预收入状态:'Y';'N'
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置预收入状态:'Y';'N'
     *
     * @param status 预收入状态:'Y';'N'
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取订单状态：unpay未支付，pay支付成功，accept制作中，done待评价，confirm 已完成，refund 退款 delivery 配送中，delivery_done配送完成
     *
     * @return state - 订单状态：unpay未支付，pay支付成功，accept制作中，done待评价，confirm 已完成，refund 退款 delivery 配送中，delivery_done配送完成
     */
    public String getState() {
        return state;
    }

    /**
     * 设置订单状态：unpay未支付，pay支付成功，accept制作中，done待评价，confirm 已完成，refund 退款 delivery 配送中，delivery_done配送完成
     *
     * @param state 订单状态：unpay未支付，pay支付成功，accept制作中，done待评价，confirm 已完成，refund 退款 delivery 配送中，delivery_done配送完成
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 获取默认为normal，normal 正常状态，askrefund 申请退款，berefund 退款, norefund 拒绝退款, askReturnProduct 申请退款退货，acceptRefundApply 同意退款申请
     *
     * @return rstate - 默认为normal，normal 正常状态，askrefund 申请退款，berefund 退款, norefund 拒绝退款, askReturnProduct 申请退款退货，acceptRefundApply 同意退款申请
     */
    public String getRstate() {
        return rstate;
    }

    /**
     * 设置默认为normal，normal 正常状态，askrefund 申请退款，berefund 退款, norefund 拒绝退款, askReturnProduct 申请退款退货，acceptRefundApply 同意退款申请
     *
     * @param rstate 默认为normal，normal 正常状态，askrefund 申请退款，berefund 退款, norefund 拒绝退款, askReturnProduct 申请退款退货，acceptRefundApply 同意退款申请
     */
    public void setRstate(String rstate) {
        this.rstate = rstate;
    }

    /**
     * 获取退款时间
     *
     * @return retime - 退款时间
     */
    public Integer getRetime() {
        return retime;
    }

    /**
     * 设置退款时间
     *
     * @param retime 退款时间
     */
    public void setRetime(Integer retime) {
        this.retime = retime;
    }

    /**
     * 获取名字
     *
     * @return realname - 名字
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置名字
     *
     * @param realname 名字
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取手机
     *
     * @return mobile - 手机
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机
     *
     * @param mobile 手机
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取在线支付金额
     *
     * @return online_money - 在线支付金额
     */
    public BigDecimal getOnlineMoney() {
        return onlineMoney;
    }

    /**
     * 设置在线支付金额
     *
     * @param onlineMoney 在线支付金额
     */
    public void setOnlineMoney(BigDecimal onlineMoney) {
        this.onlineMoney = onlineMoney;
    }

    /**
     * 获取订单金额
     *
     * @return origin - 订单金额
     */
    public BigDecimal getOrigin() {
        return origin;
    }

    /**
     * 设置订单金额
     *
     * @param origin 订单金额
     */
    public void setOrigin(BigDecimal origin) {
        this.origin = origin;
    }

    /**
     * 获取余额支付金额
     *
     * @return credit - 余额支付金额
     */
    public BigDecimal getCredit() {
        return credit;
    }

    /**
     * 设置余额支付金额
     *
     * @param credit 余额支付金额
     */
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    /**
     * 获取代金券金额
     *
     * @return card - 代金券金额
     */
    public BigDecimal getCard() {
        return card;
    }

    /**
     * 设置代金券金额
     *
     * @param card 代金券金额
     */
    public void setCard(BigDecimal card) {
        this.card = card;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Integer getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取支付时间
     *
     * @return pay_time - 支付时间
     */
    public Integer getPayTime() {
        return payTime;
    }

    /**
     * 设置支付时间
     *
     * @param payTime 支付时间
     */
    public void setPayTime(Integer payTime) {
        this.payTime = payTime;
    }

    /**
     * 获取是否显示
     *
     * @return comment_display - 是否显示
     */
    public String getCommentDisplay() {
        return commentDisplay;
    }

    /**
     * 设置是否显示
     *
     * @param commentDisplay 是否显示
     */
    public void setCommentDisplay(String commentDisplay) {
        this.commentDisplay = commentDisplay;
    }

    /**
     * 获取评价-口味
     *
     * @return comment_taste - 评价-口味
     */
    public Float getCommentTaste() {
        return commentTaste;
    }

    /**
     * 设置评价-口味
     *
     * @param commentTaste 评价-口味
     */
    public void setCommentTaste(Float commentTaste) {
        this.commentTaste = commentTaste;
    }

    /**
     * 获取评价速度
     *
     * @return comment_speed - 评价速度
     */
    public Float getCommentSpeed() {
        return commentSpeed;
    }

    /**
     * 设置评价速度
     *
     * @param commentSpeed 评价速度
     */
    public void setCommentSpeed(Float commentSpeed) {
        this.commentSpeed = commentSpeed;
    }

    /**
     * 获取评价-服务
     *
     * @return comment_service - 评价-服务
     */
    public Float getCommentService() {
        return commentService;
    }

    /**
     * 设置评价-服务
     *
     * @param commentService 评价-服务
     */
    public void setCommentService(Float commentService) {
        this.commentService = commentService;
    }

    /**
     * 获取评价-快递员
     *
     * @return comment_courier - 评价-快递员
     */
    public Float getCommentCourier() {
        return commentCourier;
    }

    /**
     * 设置评价-快递员
     *
     * @param commentCourier 评价-快递员
     */
    public void setCommentCourier(Float commentCourier) {
        this.commentCourier = commentCourier;
    }

    /**
     * 获取评价时间
     *
     * @return comment_time - 评价时间
     */
    public Integer getCommentTime() {
        return commentTime;
    }

    /**
     * 设置评价时间
     *
     * @param commentTime 评价时间
     */
    public void setCommentTime(Integer commentTime) {
        this.commentTime = commentTime;
    }

    /**
     * 获取商家id
     *
     * @return merchant_id - 商家id
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * 设置商家id
     *
     * @param merchantId 商家id
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * 获取使用积分抵用金额
     *
     * @return score_money - 使用积分抵用金额
     */
    public BigDecimal getScoreMoney() {
        return scoreMoney;
    }

    /**
     * 设置使用积分抵用金额
     *
     * @param scoreMoney 使用积分抵用金额
     */
    public void setScoreMoney(BigDecimal scoreMoney) {
        this.scoreMoney = scoreMoney;
    }

    /**
     * 获取抵用积分
     *
     * @return score - 抵用积分
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置抵用积分
     *
     * @param score 抵用积分
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取是否电话订单
     *
     * @return order_type - 是否电话订单
     */
    public String getOrderType() {
        return orderType;
    }

    /**
     * 设置是否电话订单
     *
     * @param orderType 是否电话订单
     */
    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    /**
     * 获取商家接收订单时间
     *
     * @return access_time - 商家接收订单时间
     */
    public Integer getAccessTime() {
        return accessTime;
    }

    /**
     * 设置商家接收订单时间
     *
     * @param accessTime 商家接收订单时间
     */
    public void setAccessTime(Integer accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * 获取开始配送时间
     *
     * @return delivery_time - 开始配送时间
     */
    public Integer getDeliveryTime() {
        return deliveryTime;
    }

    /**
     * 设置开始配送时间
     *
     * @param deliveryTime 开始配送时间
     */
    public void setDeliveryTime(Integer deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    /**
     * 获取订单完成时间
     *
     * @return complete_time - 订单完成时间
     */
    public Integer getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置订单完成时间
     *
     * @param completeTime 订单完成时间
     */
    public void setCompleteTime(Integer completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取加急时间
     *
     * @return urgent_time - 加急时间
     */
    public Integer getUrgentTime() {
        return urgentTime;
    }

    /**
     * 设置加急时间
     *
     * @param urgentTime 加急时间
     */
    public void setUrgentTime(Integer urgentTime) {
        this.urgentTime = urgentTime;
    }

    /**
     * 获取订单描述
     *
     * @return title - 订单描述
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置订单描述
     *
     * @param title 订单描述
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取是否快递服务'Y'：'是'；'N'：'否'
     *
     * @return ifCourier - 是否快递服务'Y'：'是'；'N'：'否'
     */
    public String getIfcourier() {
        return ifcourier;
    }

    /**
     * 设置是否快递服务'Y'：'是'；'N'：'否'
     *
     * @param ifcourier 是否快递服务'Y'：'是'；'N'：'否'
     */
    public void setIfcourier(String ifcourier) {
        this.ifcourier = ifcourier;
    }

    /**
     * 获取配送完成时间
     *
     * @return delivery_done_time - 配送完成时间
     */
    public Integer getDeliveryDoneTime() {
        return deliveryDoneTime;
    }

    /**
     * 设置配送完成时间
     *
     * @param deliveryDoneTime 配送完成时间
     */
    public void setDeliveryDoneTime(Integer deliveryDoneTime) {
        this.deliveryDoneTime = deliveryDoneTime;
    }

    /**
     * 获取支付状态
     *
     * @return pay_state - 支付状态
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 设置支付状态
     *
     * @param payState 支付状态
     */
    public void setPayState(String payState) {
        this.payState = payState;
    }

    /**
     * 获取1.为外卖订单，2为堂食订单
     *
     * @return sale_type - 1.为外卖订单，2为堂食订单
     */
    public Integer getSaleType() {
        return saleType;
    }

    /**
     * 设置1.为外卖订单，2为堂食订单
     *
     * @param saleType 1.为外卖订单，2为堂食订单
     */
    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    /**
     * 获取排号（每天清）
     *
     * @return order_num - 排号（每天清）
     */
    public String getOrderNum() {
        return orderNum;
    }

    /**
     * 设置排号（每天清）
     *
     * @param orderNum 排号（每天清）
     */
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * 获取第三方交易订单流水号（支付宝，微信支付等）
     *
     * @return out_trace_id - 第三方交易订单流水号（支付宝，微信支付等）
     */
    public String getOutTraceId() {
        return outTraceId;
    }

    /**
     * 设置第三方交易订单流水号（支付宝，微信支付等）
     *
     * @param outTraceId 第三方交易订单流水号（支付宝，微信支付等）
     */
    public void setOutTraceId(String outTraceId) {
        this.outTraceId = outTraceId;
    }

    /**
     * 获取送达时间备注
     *
     * @return time_remark - 送达时间备注
     */
    public String getTimeRemark() {
        return timeRemark;
    }

    /**
     * 设置送达时间备注
     *
     * @param timeRemark 送达时间备注
     */
    public void setTimeRemark(String timeRemark) {
        this.timeRemark = timeRemark;
    }

    /**
     * 获取厨房制作完成时间
     *
     * @return cook_done_time - 厨房制作完成时间
     */
    public Integer getCookDoneTime() {
        return cookDoneTime;
    }

    /**
     * 设置厨房制作完成时间
     *
     * @param cookDoneTime 厨房制作完成时间
     */
    public void setCookDoneTime(Integer cookDoneTime) {
        this.cookDoneTime = cookDoneTime;
    }

    /**
     * 获取厨房制作状态
     *
     * @return cook_done_code - 厨房制作状态
     */
    public String getCookDoneCode() {
        return cookDoneCode;
    }

    /**
     * 设置厨房制作状态
     *
     * @param cookDoneCode 厨房制作状态
     */
    public void setCookDoneCode(String cookDoneCode) {
        this.cookDoneCode = cookDoneCode;
    }

    /**
     * 获取开始制作时间
     *
     * @return start_time - 开始制作时间
     */
    public Integer getStartTime() {
        return startTime;
    }

    /**
     * 设置开始制作时间
     *
     * @param startTime 开始制作时间
     */
    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    /**
     * @return comment_courier_content
     */
    public String getCommentCourierContent() {
        return commentCourierContent;
    }

    /**
     * @param commentCourierContent
     */
    public void setCommentCourierContent(String commentCourierContent) {
        this.commentCourierContent = commentCourierContent;
    }

    /**
     * 获取最早送达时间
     *
     * @return start_send_time - 最早送达时间
     */
    public Integer getStartSendTime() {
        return startSendTime;
    }

    /**
     * 设置最早送达时间
     *
     * @param startSendTime 最早送达时间
     */
    public void setStartSendTime(Integer startSendTime) {
        this.startSendTime = startSendTime;
    }

    /**
     * 获取最早送达时间
     *
     * @return end_send_time - 最早送达时间
     */
    public Integer getEndSendTime() {
        return endSendTime;
    }

    /**
     * 设置最早送达时间
     *
     * @param endSendTime 最早送达时间
     */
    public void setEndSendTime(Integer endSendTime) {
        this.endSendTime = endSendTime;
    }

    /**
     * 获取用户收货地址
     *
     * @return user_address_id - 用户收货地址
     */
    public Integer getUserAddressId() {
        return userAddressId;
    }

    /**
     * 设置用户收货地址
     *
     * @param userAddressId 用户收货地址
     */
    public void setUserAddressId(Integer userAddressId) {
        this.userAddressId = userAddressId;
    }

    /**
     * @return invoice
     */
    public String getInvoice() {
        return invoice;
    }

    /**
     * @param invoice
     */
    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    /**
     * @return from_type
     */
    public String getFromType() {
        return fromType;
    }

    /**
     * @param fromType
     */
    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    /**
     * 获取配送费
     *
     * @return delivery_fee - 配送费
     */
    public BigDecimal getDeliveryFee() {
        return deliveryFee;
    }

    /**
     * 设置配送费
     *
     * @param deliveryFee 配送费
     */
    public void setDeliveryFee(BigDecimal deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    /**
     * 获取餐盒费
     *
     * @return cost_lunch_box - 餐盒费
     */
    public BigDecimal getCostLunchBox() {
        return costLunchBox;
    }

    /**
     * 设置餐盒费
     *
     * @param costLunchBox 餐盒费
     */
    public void setCostLunchBox(BigDecimal costLunchBox) {
        this.costLunchBox = costLunchBox;
    }

    /**
     * 获取会员折扣减去金额
     *
     * @return member_discount_money - 会员折扣减去金额
     */
    public BigDecimal getMemberDiscountMoney() {
        return memberDiscountMoney;
    }

    /**
     * 设置会员折扣减去金额
     *
     * @param memberDiscountMoney 会员折扣减去金额
     */
    public void setMemberDiscountMoney(BigDecimal memberDiscountMoney) {
        this.memberDiscountMoney = memberDiscountMoney;
    }

    /**
     * 获取商家会员折扣减去金额
     *
     * @return merchant_member_discount_money - 商家会员折扣减去金额
     */
    public BigDecimal getMerchantMemberDiscountMoney() {
        return merchantMemberDiscountMoney;
    }

    /**
     * 设置商家会员折扣减去金额
     *
     * @param merchantMemberDiscountMoney 商家会员折扣减去金额
     */
    public void setMerchantMemberDiscountMoney(BigDecimal merchantMemberDiscountMoney) {
        this.merchantMemberDiscountMoney = merchantMemberDiscountMoney;
    }

    /**
     * 获取堂食折扣
     *
     * @return dine_in_discount_money - 堂食折扣
     */
    public BigDecimal getDineInDiscountMoney() {
        return dineInDiscountMoney;
    }

    /**
     * 设置堂食折扣
     *
     * @param dineInDiscountMoney 堂食折扣
     */
    public void setDineInDiscountMoney(BigDecimal dineInDiscountMoney) {
        this.dineInDiscountMoney = dineInDiscountMoney;
    }

    /**
     * 获取充值来源 0-正常充值 1-快递员推荐充值
     *
     * @return recharge_src - 充值来源 0-正常充值 1-快递员推荐充值
     */
    public Integer getRechargeSrc() {
        return rechargeSrc;
    }

    /**
     * 设置充值来源 0-正常充值 1-快递员推荐充值
     *
     * @param rechargeSrc 充值来源 0-正常充值 1-快递员推荐充值
     */
    public void setRechargeSrc(Integer rechargeSrc) {
        this.rechargeSrc = rechargeSrc;
    }

    /**
     * 获取邀请人ID
     *
     * @return invite_id - 邀请人ID
     */
    public Long getInviteId() {
        return inviteId;
    }

    /**
     * 设置邀请人ID
     *
     * @param inviteId 邀请人ID
     */
    public void setInviteId(Long inviteId) {
        this.inviteId = inviteId;
    }

    /**
     * 获取代理商ID
     *
     * @return agent_id - 代理商ID
     */
    public Integer getAgentId() {
        return agentId;
    }

    /**
     * 设置代理商ID
     *
     * @param agentId 代理商ID
     */
    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    /**
     * 获取是否商家配送：merchant商家配送  courier快递员配送
     *
     * @return is_merchant_delivery - 是否商家配送：merchant商家配送  courier快递员配送
     */
    public String getIsMerchantDelivery() {
        return isMerchantDelivery;
    }

    /**
     * 设置是否商家配送：merchant商家配送  courier快递员配送
     *
     * @param isMerchantDelivery 是否商家配送：merchant商家配送  courier快递员配送
     */
    public void setIsMerchantDelivery(String isMerchantDelivery) {
        this.isMerchantDelivery = isMerchantDelivery;
    }

    /**
     * 获取乐玩咖ID
     *
     * @return lwk_id - 乐玩咖ID
     */
    public String getLwkId() {
        return lwkId;
    }

    /**
     * 设置乐玩咖ID
     *
     * @param lwkId 乐玩咖ID
     */
    public void setLwkId(String lwkId) {
        this.lwkId = lwkId;
    }

    /**
     * 获取乐玩咖渠道标识
     *
     * @return lwk_mark - 乐玩咖渠道标识
     */
    public String getLwkMark() {
        return lwkMark;
    }

    /**
     * 设置乐玩咖渠道标识
     *
     * @param lwkMark 乐玩咖渠道标识
     */
    public void setLwkMark(String lwkMark) {
        this.lwkMark = lwkMark;
    }

    /**
     * 获取乐玩咖是否推送
     *
     * @return lwk_flag - 乐玩咖是否推送
     */
    public String getLwkFlag() {
        return lwkFlag;
    }

    /**
     * 设置乐玩咖是否推送
     *
     * @param lwkFlag 乐玩咖是否推送
     */
    public void setLwkFlag(String lwkFlag) {
        this.lwkFlag = lwkFlag;
    }

    /**
     * 获取flash_order 的ID
     *
     * @return flash_order_id - flash_order 的ID
     */
    public Long getFlashOrderId() {
        return flashOrderId;
    }

    /**
     * 设置flash_order 的ID
     *
     * @param flashOrderId flash_order 的ID
     */
    public void setFlashOrderId(Long flashOrderId) {
        this.flashOrderId = flashOrderId;
    }

    /**
     * 获取退款理由
     *
     * @return rereason - 退款理由
     */
    public String getRereason() {
        return rereason;
    }

    /**
     * 设置退款理由
     *
     * @param rereason 退款理由
     */
    public void setRereason(String rereason) {
        this.rereason = rereason;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取评价内容
     *
     * @return comment_content - 评价内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 设置评价内容
     *
     * @param commentContent 评价内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
