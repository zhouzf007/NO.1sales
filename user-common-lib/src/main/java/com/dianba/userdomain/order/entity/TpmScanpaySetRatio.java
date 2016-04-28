package com.dianba.userdomain.order.entity;

import org.springframework.data.annotation.Id;

public class TpmScanpaySetRatio {
    @Id
    private Integer id;

    private Integer scanpayId;

    /**
     * 占比 99.95%=9995
     */
    private Integer proportion;

    /**
     * 最小金额 100=1元
     */
    private Integer moneyMin;

    /**
     * 最大金额 100=1元
     */
    private Integer moneyMax;

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
     * @return scanpay_id
     */
    public Integer getScanpayId() {
        return scanpayId;
    }

    /**
     * @param scanpayId
     */
    public void setScanpayId(Integer scanpayId) {
        this.scanpayId = scanpayId;
    }

    /**
     * 获取占比 99.95%=9995
     *
     * @return proportion - 占比 99.95%=9995
     */
    public Integer getProportion() {
        return proportion;
    }

    /**
     * 设置占比 99.95%=9995
     *
     * @param proportion 占比 99.95%=9995
     */
    public void setProportion(Integer proportion) {
        this.proportion = proportion;
    }

    /**
     * 获取最小金额 100=1元
     *
     * @return money_min - 最小金额 100=1元
     */
    public Integer getMoneyMin() {
        return moneyMin;
    }

    /**
     * 设置最小金额 100=1元
     *
     * @param moneyMin 最小金额 100=1元
     */
    public void setMoneyMin(Integer moneyMin) {
        this.moneyMin = moneyMin;
    }

    /**
     * 获取最大金额 100=1元
     *
     * @return money_max - 最大金额 100=1元
     */
    public Integer getMoneyMax() {
        return moneyMax;
    }

    /**
     * 设置最大金额 100=1元
     *
     * @param moneyMax 最大金额 100=1元
     */
    public void setMoneyMax(Integer moneyMax) {
        this.moneyMax = moneyMax;
    }
}