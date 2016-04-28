package com.dianba.userdomain.order.mapper;

import java.util.List;

import com.dianba.userdomain.order.entity.OrderState;
import com.dianba.userdomain.order.vo.OrderStateVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonOrderStateMapper {

	public List<OrderState> getOrderStateList();

	public PageList<OrderState> getOrderStateList( PageBounds pageBounds );
	
	public List<OrderState> getOrderStatePageList( OrderState orderState );
	
	public PageList<OrderState> getOrderStatePageList(OrderState orderState, PageBounds pageBounds );
	
	public OrderState getOrderStateByPrimaryKey(Long id);
	
	public void createOrderState(OrderState orderState);
	
	public void updateOrderState(OrderState orderState);
	
	public void updateOrderStateSelective(OrderState orderState);
	
	public void deleteOrderState(Long id);
	
	public List<OrderStateVo> getOrderStateByOrderId(Long id);
	
}