
package com.dianba.userdomain.order.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dianba.userdomain.constant.PayType;
import com.dianba.userdomain.constant.SVCException;
import com.dianba.userdomain.constant.SaleType;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.vo.OrderDetailVo;
import com.dianba.userdomain.order.vo.OrderListVo;
import com.dianba.userdomain.order.vo.OrderMenusVo;
import com.dianba.userdomain.user.entity.User;
import com.dianba.userdomain.util.DeliveryType;
import com.dianba.userdomain.util.OrderType;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface OrderService {

	public List<Order> getOrderList();
	
	public PageList<Order> getOrderList(PageBounds pageBounds);
	
	public List<Order> getOrderPageList(Order order);
	
	public PageList<Order> getOrderPageList(Order order, PageBounds pageBounds);
	
	public PageList<OrderListVo> getUserOrderListPage(Long id ,PageBounds pageBounds);
	
	public Order getOrderByPrimaryKey(Long id);
	
	public Long createOrder(Order order);
	
	public void createOrderBitch(List<Order> orderList);
	
	public void updateOrder(Order order);
	
	public void updateOrderBitch(List<Order> orderList);
	/**
	 * 更新order状态
	 */
	public void updateOrderSelective(Order order);
	
	public void updateOrderSelectiveBitch(List<Order> orderList);
	
	public void deleteOrder(Long id);
	
	public void deleteOrderBitch(List<Long> idList);
	
	public Long createNewOrder(Order order);
	
	public Long createThirdOrder(Order order);
	
	public Long getOrderCreateTime(Long id);
	
	public boolean validOrderByOrderId(Long orderId);
	
	public void updateOrderState(Long id);
	
	public void updateOrderScoreAndScoreMoney(Long id);
	
	public Order getOrderByPayId(Long id);
	
//	public String getOrderNum();
	
	public List<Order> getOrders(Long id);
	
	public Long createNewEatInOrder(Order order);
	
	public Order judgeHaveAskrefund(Map<String,Object>map);
	
	public Long createOrderAsSaleTypeOne(String payId,User user,String merchantId,Double checkCost,String addressMobile,String addressAddress,String addressName
			,String remarks,String saleType,String timeRemark,String userAddressId,Integer score,BigDecimal scoreMoney,Double costDelivery,String payType
			,Double costLunchBox,String invoice,List<OrderMenusVo> list,BigDecimal userGradeDiscountMoney, BigDecimal couponMoney, String couponSn,BigDecimal userMechantMemberMoney,BigDecimal takeOutCostLunchBox, BigDecimal dineIndiscountMoney);
	
	public Long createOrderAsSaleTypeTwo(String payId,User user,String merchantId,Double checkCost
			,String remarks,String saleType,String timeRemark,Integer score,BigDecimal scoreMoney,Double costDelivery,String payType
			,Double costLunchBox,String invoice,List<OrderMenusVo> list,BigDecimal userGradeDiscountMoney, BigDecimal couponMoney, String couponSn,BigDecimal userMechantMemberMoney,BigDecimal dineIndiscountMoney);
	

	
	public List<Map<String,Object>> countByStatus(Map<String,Object>map);
	
	public List<Map<String,Object>> countByStatusWhenConfirm(Map<String,Object>map);
	



	public Order judgeHaveCancel(Long id);
	
	public Long createCengRiceOrder(Order order);
	
	public Order getThirdOrder(String pay_id, String from_type, String order_type);
	
	public Order judgeIsComfirm(Map<String,Object>map);
	
	public Long createQcCodeOrder(String payId,User user,String merchantId,Double checkCost,String saleType,String payType);
	
	public Long createQcCodeOrder(Order order);
	
	public Order getOrderByUserId(Map<String,Object> map);
	
	public List<Map<String,Object>> confirmOrderList(Order order);
	
	public Map<String,Object> getOrderMerchantSource (Long orderId);
	
	public Order judgeIsAccept(Map<String,Object>map);
	
	public String getOrderPayType (Long id);

	public Long createRechargeOrder(Order order);
	
	public void userConfirmOrder(Order order);
	/**
	 * 计算订单真实金额
	 * @param order
	 * @return
	 */
	public BigDecimal getRealPayMoney(Order order);
	
	
	// ############ 二维码订单 ############
	/**
	 * 创建二维码订单
	 * @throws SVCException
	 */
	public Order createQRCodeOrder(Long mcid, Long uid, Double money, OrderType orderType, SaleType saleType, PayType payType, DeliveryType deliveryType) throws SVCException;

	/**
	 * 创建代理商充值二维码订单
	 * @throws SVCException
	 */
	public Order createQRCodeOrderByAgent(Integer agentId, Long uid, Double money, OrderType orderType, SaleType saleType, PayType payType, DeliveryType deliveryType) throws SVCException;
	
	/**
	 * 计算扫码订单获得折扣需要扣减的金额
	 */
	public Integer findDiscountMoney(Order order);
	
	public OrderDetailVo getUserOrderState(Long id);

}