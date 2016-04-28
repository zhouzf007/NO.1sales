package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

import com.dianba.userdomain.constant.CouponType;

/**
 * 优惠券裂变用户表
 * @author folo
 */
public class CouponFissionUser implements Serializable {
    private static final long serialVersionUID = 5638260718723905201L;

    private Integer id;

    /** 唯一6位短链 */
    private String url;

    /** 用户id */
    private Long userId;
    
    /** 优惠券类型100平台200商家 */
    private Integer source;

    /** 领取金额 单位:分 */
    private Integer amount;

    /** 创建时间 */
    private Date createdTime;

    public CouponFissionUser() {
    }

    public CouponFissionUser(CouponFission couponFission, CouponType couponType) {
        this.url = couponFission.getId();
        this.amount = couponFission.getAmount();
        this.source = couponType.getCode();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Integer getSource() {
        return source;
    }
    
    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
