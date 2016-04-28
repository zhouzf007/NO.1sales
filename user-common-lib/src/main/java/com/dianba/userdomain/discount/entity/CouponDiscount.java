package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 现金券折扣表
 * @author folo
 */
public class CouponDiscount implements Serializable{
    private static final long serialVersionUID = -8725735867775931543L;

    /** 商家id */
    private Long merchantId;

    /** 外卖扣点 1%~100% */
    private Integer takeout;

    /** 堂食扣点 1%~100% */
    private Integer dine;

    /** 自提扣点 1%~100% */
    private Integer mention;

    /** 创建者 */
    private Long createdBy;

    /** 创建时间 */
    private Date createdTime;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getTakeout() {
        return takeout;
    }

    public void setTakeout(Integer takeout) {
        this.takeout = takeout;
    }

    public Integer getDine() {
        return dine;
    }

    public void setDine(Integer dine) {
        this.dine = dine;
    }

    public Integer getMention() {
        return mention;
    }

    public void setMention(Integer mention) {
        this.mention = mention;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
