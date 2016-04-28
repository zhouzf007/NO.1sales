package com.dianba.userdomain.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 扫码订单折扣记录
 * @author folo
 */
@Document(collection = "scan_discount_log")
public class ScanDiscountLog {
    @Id public String id;
    
    @Indexed public Long order_id;
    
    @Indexed public Integer scan_id;
    
    @Indexed public Integer discount;
    
    public Integer discountMoney;
    
    @Indexed  public Integer mcid;
    
    @Indexed  public Long uid;
    
    @Indexed public String created_time;
    
    /** -1=未支付 1=已支付 */
    @Indexed public Integer status;
    
    public Integer count;
}
