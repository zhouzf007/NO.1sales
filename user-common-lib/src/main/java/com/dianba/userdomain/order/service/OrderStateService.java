package com.dianba.userdomain.order.service;

import java.util.List;

import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.entity.OrderState;
import com.dianba.userdomain.order.vo.OrderStateVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface OrderStateService {

	public List<OrderState> getOrderStateList();
	
	public PageList<OrderState> getOrderStateList(PageBounds pageBounds);
	
	public List<OrderState> getOrderStatePageList(OrderState orderState);
	
	public PageList<OrderState> getOrderStatePageList(OrderState orderState, PageBounds pageBounds);
	
	public OrderState getOrderStateByPrimaryKey(Long id);
	
	public void createOrderState(OrderState orderState);
	
	public void createOrderStateBitch(List<OrderState> orderStateList);
	
	public void updateOrderState(OrderState orderState);
	
	public void updateOrderStateBitch(List<OrderState> orderStateList);
	
	public void updateOrderStateSelective(OrderState orderState);
	
	public void updateOrderStateSelectiveBitch(List<OrderState> orderStateList);
	
	public void deleteOrderState(Long id);
	
	public void deleteOrderStateBitch(List<Long> idList);
	
	public void createOrderState (Long orderId);
	
	public void createPhoneOrderState (Long orderId);
	
	public void payOrderState (Long orderId);
	
	public void payOrderState (Order order);
	
	public void accessOrderState (Long orderId);
	
	public void noAcceptOrderState (Long orderId);
	
	public void doneOrderState (Long orderId);
	
	public void evaluateOrderState (Long orderId);
	
	public void askedRefundOrderState (Long orderId);
	
	public void refundSuccessOrderState (Long orderId);
	
	public void refundFailedOrderState (Long orderId);
	
	public void deliveryDoneOrderState (Long orderId);
	
	public void deliveryPayOrderState (Long orderId);
	
	public void deliveryPayOrderState (String courier, String user, Long  orderId, Double money);
	
	public void cookDoneOrderState (Long orderId);
	
	public void autoCompleteOrderState (Long orderId);
	
	public void merchantUpdateOrder (Long orderId);
	
	public void userCancelOrder(Long orderId);
	
	public void accessOrderStateChoice(Long orderId);
	
	public List<OrderStateVo> getOrderStateByOrderId(Long id);

}