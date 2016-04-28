package com.dianba.userdomain.order.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class TpmScanpaySet {
    @Id
    private Integer id;

    /**
     * 最低可享受立减金额 100=1元
     */
    private Integer moneyMin;

    /**
     * 每日活动次数
     */
    private Integer everydayCount;

    /**
     * 开始时间
     */
    private Date beginTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 每日同一用户可享受优惠次数
     */
    private Integer everydayUserCount;

    /**
     * 同一用户在活动期间内可享受优惠次数
     */
    private Integer userCount;

    /**
     * 活动范围 市
     */
    private Integer cityId;

    /**
     * 创建时间
     */
    private Date addTime;

    /**
     * 创建人
     */
    private Integer addId;

    /**
     * 最后一次修改时间
     */
    private Date modTime;

    /**
     * 最后一次修改人
     */
    private Integer modId;

    /**
     * 是否删除，默认0=不删除，1=删除
     */
    private String isDelete;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取最低可享受立减金额 100=1元
     *
     * @return money_min - 最低可享受立减金额 100=1元
     */
    public Integer getMoneyMin() {
        return moneyMin;
    }

    /**
     * 设置最低可享受立减金额 100=1元
     *
     * @param moneyMin 最低可享受立减金额 100=1元
     */
    public void setMoneyMin(Integer moneyMin) {
        this.moneyMin = moneyMin;
    }

    /**
     * 获取每日活动次数
     *
     * @return everyday_count - 每日活动次数
     */
    public Integer getEverydayCount() {
        return everydayCount;
    }

    /**
     * 设置每日活动次数
     *
     * @param everydayCount 每日活动次数
     */
    public void setEverydayCount(Integer everydayCount) {
        this.everydayCount = everydayCount;
    }

    /**
     * 获取开始时间
     *
     * @return begin_time - 开始时间
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * 设置开始时间
     *
     * @param beginTime 开始时间
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取每日同一用户可享受优惠次数
     *
     * @return everyday_user_count - 每日同一用户可享受优惠次数
     */
    public Integer getEverydayUserCount() {
        return everydayUserCount;
    }

    /**
     * 设置每日同一用户可享受优惠次数
     *
     * @param everydayUserCount 每日同一用户可享受优惠次数
     */
    public void setEverydayUserCount(Integer everydayUserCount) {
        this.everydayUserCount = everydayUserCount;
    }

    /**
     * 获取同一用户在活动期间内可享受优惠次数
     *
     * @return user_count - 同一用户在活动期间内可享受优惠次数
     */
    public Integer getUserCount() {
        return userCount;
    }

    /**
     * 设置同一用户在活动期间内可享受优惠次数
     *
     * @param userCount 同一用户在活动期间内可享受优惠次数
     */
    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    /**
     * 获取活动范围 市
     *
     * @return city_id - 活动范围 市
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 设置活动范围 市
     *
     * @param cityId 活动范围 市
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取创建时间
     *
     * @return add_time - 创建时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置创建时间
     *
     * @param addTime 创建时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取创建人
     *
     * @return add_id - 创建人
     */
    public Integer getAddId() {
        return addId;
    }

    /**
     * 设置创建人
     *
     * @param addId 创建人
     */
    public void setAddId(Integer addId) {
        this.addId = addId;
    }

    /**
     * 获取最后一次修改时间
     *
     * @return mod_time - 最后一次修改时间
     */
    public Date getModTime() {
        return modTime;
    }

    /**
     * 设置最后一次修改时间
     *
     * @param modTime 最后一次修改时间
     */
    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }

    /**
     * 获取最后一次修改人
     *
     * @return mod_id - 最后一次修改人
     */
    public Integer getModId() {
        return modId;
    }

    /**
     * 设置最后一次修改人
     *
     * @param modId 最后一次修改人
     */
    public void setModId(Integer modId) {
        this.modId = modId;
    }

    /**
     * 获取是否删除，默认0=不删除，1=删除
     *
     * @return is_delete - 是否删除，默认0=不删除，1=删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除，默认0=不删除，1=删除
     *
     * @param isDelete 是否删除，默认0=不删除，1=删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}