package com.dianba.userdomain.util;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dianba.userdomain.constant.SaleType;
import com.dianba.userdomain.controller.open_api.OpenSign;
import com.dianba.userdomain.order.entity.Order;


/**
 * 订单处理工具类
 * @author folo
 */
public class OrderUtil {
    private static Logger logger = LoggerFactory.getLogger(OrderUtil.class);

    /**
     * 根据订单信息获取实际支付金额
     * @param order
     * @return
     */
    public static BigDecimal getRealPayMoney(Order order) {
        return order.getOrigin().add(order.getCostLunchBox())//加上餐盒费
                        .add(order.getDeliveryFee())//加上配送费
                        .subtract(order.getScoreMoney())//减去积分抵扣金额
                        .subtract(order.getCard())//减去优惠券抵扣金额
                        .subtract(order.getMemberDiscountMoney());//减去会员折扣金额
    }
    
    /**
     * 通过payid获取订单固定的信息
     * 2位标识订单来源 OrderSource
       2位标识订单类型 OrderType
       1位标识获取商品方式 SaleType
       1位标识订单配送类型 DeliveryType
       1位标识预收入状态 PreIncomStatus
     * @param payId
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getTypeByPayId(String payId, Class<?> c){
        try {
            if(c == OrderSource.class){
                return (T) OrderSource.get(ConverDataUtil.toInt(payId.substring(0, 2)));
            }else if(c == OrderType.class){
                return (T) OrderType.get(ConverDataUtil.toInt(payId.substring(2, 4)));
            } else if(c == SaleType.class){
                return (T) SaleType.get(ConverDataUtil.toInt(payId.substring(4, 5)));
            } else if(c == DeliveryType.class){
                return (T) DeliveryType.get(ConverDataUtil.toInt(payId.substring(5, 6)));
            } else if(c == PreIncomStatus.class){
                return (T) PreIncomStatus.get(ConverDataUtil.toInt(payId.substring(6, 7)));
            }else logger.error("通过payId{}获取订单{}失败,没有该类型", payId, c.getName());
        }
        catch (Exception e) {
            logger.warn("通过payId{}获取订单{}失败,异常", payId, c.getName(), e);
        }
        return null;
    }
    
    /**
     * 生成扫码订单payId
     * @return
     */
    public static String getSanOrderPayId(OrderType orderType) {
        return getPayId(OrderSource.WECHAT, orderType, SaleType.EATIN, DeliveryType.COURIER, PreIncomStatus.N);
    }
    
    /**
     * 生成pay_id 唯一
     *  2位标识订单来源
        2位标识订单类型
        1位标识获取商品方式
        1位标识订单配送类型
        1位标识预收入状态
        6位保留标识
        12位uuidHash(亿级重复在10以内)
     * @param uid
     * @return
     */
    public static String getPayId(OrderSource source, OrderType type, SaleType way, DeliveryType dtype, PreIncomStatus pStatus) {
        return new StringBuilder()
                        .append(source.getCode())
                        .append(type.getCode())
                        .append(way.getCode())
                        .append(dtype.getCode())
                        .append(pStatus.getCode())
                        .append("000000")
                        .append(OpenSign.hash(12)).toString();
    }
    
    /**
     * 订单金额元转分
     * @param yuan
     * @return
     */
    public static Integer yuanConverToPoint(BigDecimal yuan) {
        return (int) new BigDecimal(yuan.doubleValue()).multiply(new BigDecimal(100)).doubleValue();
    }

    /**
     * 订单金额分转元
     * @param point
     * @return
     */
    public static Double pointConverToYuan(Integer point) {
        return new BigDecimal(point).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    /**
     * double转换位保留places位的BigDecimal格式
     * @param d 需要处理的double数据
     * @param places 保留的小数位
     * @return
     */
    public static BigDecimal dp(double d, int places){
        return new BigDecimal(d).setScale(places, BigDecimal.ROUND_HALF_UP);
    }
}
