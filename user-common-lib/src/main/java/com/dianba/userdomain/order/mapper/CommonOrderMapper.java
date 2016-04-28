package com.dianba.userdomain.order.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.vo.OrderDetailVo;
import com.dianba.userdomain.order.vo.OrderListVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonOrderMapper{

	public List<Order> getOrderList();

	public PageList<Order> getOrderList(PageBounds pageBounds);

	public List<Order> getOrderPageList(Order order);

	public PageList<Order> getOrderPageList(Order order, PageBounds pageBounds);

	public Order getOrderByPrimaryKey(Long id);

	public Long createOrder(Order order);

	public void updateOrder(Order order);

	public void updateOrderSelective(Order order);

	public void deleteOrder(Long id);

	public Long createNewOrder(Order order);

	public Long getOrderCreateTime(Long id);
	
	public PageList<OrderListVo> getUserOrderListPage(Long id, PageBounds pageBounds);

	public void updateOrderState(Long id);

	public void updateOrderScoreAndScoreMoney(Long id);

	public Order getOrderByPayId(Long id);

	public List<Order> getOrders(Long id);

	public Long createNewEatInOrder(Order order);

	public Order judgeHaveAskrefund(Map<String, Object> map);

	public List<Map<String, Object>> countByStatus(Map<String, Object> map);

	public List<Map<String, Object>> countByStatusWhenConfirm(Map<String, Object> map);

	public Long getCustType(Long id);

	public List<Map<String, Object>> getTotalOriginMoney(Long id);

	public Order judgeHaveCancel(Long id);

	public Long createCengRiceOrder(Order order);

	public Order getThirdOrder(@Param("pay_id") String pay_id, @Param("from_type") String from_type,
			@Param("order_type") String order_type);

	public Order judgeIsComfirm(Map<String, Object> map);

	public Long createQcCodeOrder(Order order);
	
	public Long createQcCodeOrderByAgent(Order order);

	public Order getOrderByUserId(Map<String, Object> map);

	public List<Map<String, Object>> confirmOrderList(Order order);

	public Map<String, Object> getOrderMerchantSource(Long orderId);

	public Integer judgeFristPrivateKitchenOrder(Long userId);

	public Order judgeIsAccept(Map<String, Object> map);

	public Map<String, Object> getPromotionLimit(Map<String, Object> map);

	public String getOrderPayType(Long id);

	public Long createRechargeOrder(Order order);
	
	public OrderDetailVo getUserOrderState(Long id);

}