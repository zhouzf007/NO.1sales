package com.dianba.userdomain.mongo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.util.DateUtils;

/**
 * 扫码订单支付记录
 * @author folo
 */
@Document(collection = "qr_order_log")
public class QrOrderLog {
    @Id public String id;
    
    @Indexed public Long order_id;
    
    @Indexed public Long uid;
    
    @Indexed public Integer merchantId;
    
    @Indexed public Integer sale_type;
    
    @Indexed public String pay_type;
    
    @Indexed public Double order_money;
    
    @Indexed public String created_time;
    
    @Indexed public Long time;
    
    /** -1=未支付 1=已支付 */
    @Indexed public Integer status;

    public QrOrderLog() {
    }
    
    public QrOrderLog(Order order) {
        this.order_id = order.getId();
        this.uid = order.getUserId();
        this.merchantId = order.getMerchantId();
        this.sale_type = order.getSaleType();
        this.pay_type = order.getPayType();
        this.order_money = order.getOrigin().doubleValue();
        this.created_time = DateUtils.formatDate(new Date());
        this.time = System.currentTimeMillis();
        this.status = -1;
    }
}
