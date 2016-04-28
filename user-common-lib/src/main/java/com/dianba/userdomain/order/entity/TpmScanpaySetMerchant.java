package com.dianba.userdomain.order.entity;

import org.springframework.data.annotation.Id;

public class TpmScanpaySetMerchant {
    @Id
    private Integer id;

    private Integer scanpayId;

    /**
     * 鍟嗗id
     */
    private Integer merchantId;

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
     * 获取鍟嗗id
     *
     * @return merchant_id - 鍟嗗id
     */
    public Integer getMerchantId() {
        return merchantId;
    }

    /**
     * 设置鍟嗗id
     *
     * @param merchantId 鍟嗗id
     */
    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }
}