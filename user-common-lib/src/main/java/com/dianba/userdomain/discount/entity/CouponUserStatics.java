package com.dianba.userdomain.discount.entity;

import java.io.Serializable;

/**
 * 优惠券用户使用统计表
 * @author folo
 *
 */
public class CouponUserStatics implements Serializable{
    private static final long serialVersionUID = -8868166525634300593L;

    /** 主键 自增 */
    private Integer id;

    /** 优惠券id */
    private Integer couponId;

    /** 可使用范围 200=商家 100=平台 sys_code表code=coupon_source */
    private Integer usedType;

    /** 关联主键 */
    private Integer usedId;

    /** 关联使用分类 */
    private Integer usedGroup;

    /** 关联下单分类 */
    private Integer fromGroup;

    /** 关联下单网点或地区 */
    private Integer fromArea;

    /** 发放总量(-1=无限) */
    private Integer putTotalCount;

    /** 已发放数量 */
    private Integer reciveiedCount;

    /** 已使用数量 */
    private Integer usedCount;
    
    public CouponUserStatics() {
    }

    public CouponUserStatics(CouponGrant couponGrant) {
        this.couponId = couponGrant.coupon.getId();
        this.usedType = couponGrant.getUsedType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getUsedType() {
        return usedType;
    }

    public void setUsedType(Integer usedType) {
        this.usedType = usedType;
    }

    public Integer getUsedId() {
        return usedId;
    }

    public void setUsedId(Integer usedId) {
        this.usedId = usedId;
    }

    public Integer getUsedGroup() {
        return usedGroup;
    }

    public void setUsedGroup(Integer usedGroup) {
        this.usedGroup = usedGroup;
    }

    public Integer getFromGroup() {
        return fromGroup;
    }

    public void setFromGroup(Integer fromGroup) {
        this.fromGroup = fromGroup;
    }

    public Integer getFromArea() {
        return fromArea;
    }

    public void setFromArea(Integer fromArea) {
        this.fromArea = fromArea;
    }

    public Integer getPutTotalCount() {
        return putTotalCount;
    }

    public void setPutTotalCount(Integer putTotalCount) {
        this.putTotalCount = putTotalCount;
    }

    public Integer getReciveiedCount() {
        return reciveiedCount;
    }

    public void setReciveiedCount(Integer reciveiedCount) {
        this.reciveiedCount = reciveiedCount;
    }

    public Integer getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }
}
