package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券发放信息
 * @author folo
 *
 */
public class CouponGrant implements Serializable {
    private static final long serialVersionUID = 305389721498102103L;

    /** 主键 自增 */
    private Integer id;

    /** 发放者 200=商家 100=平台 sys_code表code=coupon_source */
    private Integer fromType;

    /** 关联主键,多个用逗号隔开 */
    private String fromId;

    /** 发放分类id,多个用逗号隔开 */
    private String fromGroup;

    /** 发放规则, 1=全体 2=互发 3=指定 */
    private Integer fromRule;

    /** 发放区域id,多个用逗号隔开 */
    private String fromArea;

    /** 可使用范围 200=商家 100=平台 sys_code表code=coupon_source */
    private Integer usedType;

    /** 关联主键,多个用逗号隔开 */
    private String usedId;

    /** 关联分类,多个用逗号隔开 */
    private String usedGroup;

    /** 优惠券id */
    private Integer couponId;

    /** 商家展示金额 单位:元,多个逗号隔开 例如:10,20,50 */
    private String merchantDiscount;

    /** 开始发放时间 */
    private Date beginGrantTime;

    /** 结束发放时间 */
    private Date endGrantTime;

    /** 创建者 */
    private Long createdBy;

    /** 创建时间 */
    private Date createdTime;
    
    public Coupon coupon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromType() {
        return fromType;
    }

    public void setFromType(Integer fromType) {
        this.fromType = fromType;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getFromGroup() {
        return fromGroup;
    }

    public void setFromGroup(String fromGroup) {
        this.fromGroup = fromGroup;
    }

    public Integer getFromRule() {
        return fromRule;
    }

    public void setFromRule(Integer fromRule) {
        this.fromRule = fromRule;
    }

    public String getFromArea() {
        return fromArea;
    }

    public void setFromArea(String fromArea) {
        this.fromArea = fromArea;
    }

    public Integer getUsedType() {
        return usedType;
    }

    public void setUsedType(Integer usedType) {
        this.usedType = usedType;
    }

    public String getUsedId() {
        return usedId;
    }

    public void setUsedId(String usedId) {
        this.usedId = usedId;
    }

    public String getUsedGroup() {
        return usedGroup;
    }

    public void setUsedGroup(String usedGroup) {
        this.usedGroup = usedGroup;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getMerchantDiscount() {
        return merchantDiscount;
    }

    public void setMerchantDiscount(String merchantDiscount) {
        this.merchantDiscount = merchantDiscount;
    }

    public Date getBeginGrantTime() {
        return beginGrantTime;
    }

    public void setBeginGrantTime(Date beginGrantTime) {
        this.beginGrantTime = beginGrantTime;
    }

    public Date getEndGrantTime() {
        return endGrantTime;
    }

    public void setEndGrantTime(Date endGrantTime) {
        this.endGrantTime = endGrantTime;
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
