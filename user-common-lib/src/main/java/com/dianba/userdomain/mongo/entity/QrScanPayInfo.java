package com.dianba.userdomain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.alibaba.fastjson.JSONObject;

/**
 * 扫码订单支付信息
 * @author folo
 */
@Document(collection = "qr_scan_pay_info")
public class QrScanPayInfo {
    @Id public String id;
    
    @Indexed public Long order_id;
    
    public JSONObject payInfo;
}
