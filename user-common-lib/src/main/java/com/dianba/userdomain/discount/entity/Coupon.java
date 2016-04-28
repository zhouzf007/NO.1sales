package com.dianba.userdomain.discount.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 优惠券表
 * @author folo
 *
 */
public class Coupon implements Serializable {
    private static final long serialVersionUID = -2963743281658727504L;

    /** 主键 自增 */
    private Integer id;

    /** 优惠券名称 */
    private String name;

    /** 200=商家 100=平台 sys_code表code=coupon_source */
    private Integer sourceType;

    /** 关联主键 */
    private Long sourceId;

    /** 关联分类 */
    private Integer sourceGroup;

    /** 分类名称 */
    private String groupName;

    /** 可用金额 单位:分 */
    private Integer amount;

    /** 发放条件（满xx元发）单位:分 */
    private Integer putCondition;

    /** 发放总量(-1=无限) */
    private Integer putTotalCount;

    /** 剩余数量 */
    private Integer surplusCount;

    /** 开始发放时间 */
    private Date beginGrantTime;

    /** 结束发放时间 */
    private Date endGrantTime;

    /** 使用条件 单位:分(满xx元可使用) */
    private Integer useCondition;

    /** 可用开始时间 */
    private Date beginUsedTime;

    /** 可用结束时间 */
    private Date endUsedTime;

    /** 优惠券编码=平台类型(100=平台券 200=商家券) + yyyyMMddhhmmss + 6位随机数字 */
    private String couponSn;

    /** 创建时间 */
    private Date createdTime;

    /** 创建者 */
    private Long createdBy;

    /** 发放条件类型 1=固定金额 2=商家扣点 */
    private Integer putConditionType;
    
    private Integer grant_id;
    
    public Coupon() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getSourceGroup() {
        return sourceGroup;
    }

    public void setSourceGroup(Integer sourceGroup) {
        this.sourceGroup = sourceGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPutCondition() {
        return putCondition;
    }

    public void setPutCondition(Integer putCondition) {
        this.putCondition = putCondition;
    }

    public Integer getPutTotalCount() {
        return putTotalCount;
    }

    public void setPutTotalCount(Integer putTotalCount) {
        this.putTotalCount = putTotalCount;
    }

    public Integer getSurplusCount() {
        return surplusCount;
    }

    public void setSurplusCount(Integer surplusCount) {
        this.surplusCount = surplusCount;
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

    public Integer getUseCondition() {
        return useCondition;
    }

    public void setUseCondition(Integer useCondition) {
        this.useCondition = useCondition;
    }

    public Date getBeginUsedTime() {
        return beginUsedTime;
    }

    public void setBeginUsedTime(Date beginUsedTime) {
        this.beginUsedTime = beginUsedTime;
    }

    public Date getEndUsedTime() {
        return endUsedTime;
    }

    public void setEndUsedTime(Date endUsedTime) {
        this.endUsedTime = endUsedTime;
    }

    public String getCouponSn() {
        return couponSn;
    }

    public void setCouponSn(String couponSn) {
        this.couponSn = couponSn;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getPutConditionType() {
        return putConditionType;
    }

    public void setPutConditionType(Integer putConditionType) {
        this.putConditionType = putConditionType;
    }

    public Integer getGrant_id() {
        return grant_id;
    }

    public void setGrant_id(Integer grant_id) {
        this.grant_id = grant_id;
    }
    
}
