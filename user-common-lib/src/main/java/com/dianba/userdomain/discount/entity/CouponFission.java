package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

import com.dianba.userdomain.order.entity.Order;

/**
 * 列表订单记录表
 * @author folo
 */
public class CouponFission implements Serializable {
    private static final long serialVersionUID = 8177145038746603557L;

    /** 唯一6位短链,主键 */
    private String id;

    /** 订单id */
    private Long orderId;

    /** 用户id */
    private Long userId;

    /** 发放金额 单位:分 */
    private Integer amount;

    /** 优惠券发放规则id */
    private Integer couponGrantId;

    /** 开始时间 */
    private Date beginTime;

    /** 结束时间 */
    private Date endTime;

    /** 创建时间 */
    private Date createdTime;
    
    public CouponFission() {
    }
    
    public CouponFission(Order order, CouponGrant couponGrant) {
        this.orderId = order.getId();
        this.userId = new Long(order.getUserId());
        
        this.couponGrantId = couponGrant.getId();
        this.beginTime = couponGrant.getBeginGrantTime();
        this.endTime = couponGrant.getEndGrantTime();
    }
    
    public CouponFission(Order order) {
        this.orderId = order.getId();
        this.userId = new Long(order.getUserId());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getCouponGrantId() {
        return couponGrantId;
    }

    public void setCouponGrantId(Integer couponGrantId) {
        this.couponGrantId = couponGrantId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
