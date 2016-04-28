package com.dianba.userdomain.order.service;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.order.entity.OrderMenu;
import com.dianba.userdomain.order.vo.OrderMenuVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface OrderMenuService {

	public List<OrderMenu> getOrderMenuList();
	
	public PageList<OrderMenu> getOrderMenuList(PageBounds pageBounds);
	
	public List<OrderMenu> getOrderMenuPageList(OrderMenu orderMenu);
	
	public PageList<OrderMenu> getOrderMenuPageList(OrderMenu orderMenu, PageBounds pageBounds);
	
	public OrderMenu getOrderMenuByPrimaryKey(Long id);
	
	public void createOrderMenu(OrderMenu orderMenu);
	
	public void createOrderMenuBitch(List<OrderMenu> orderMenuList);
	
	public void updateOrderMenu(OrderMenu orderMenu);
	
	public void updateOrderMenuBitch(List<OrderMenu> orderMenuList);
	
	public void updateOrderMenuSelective(OrderMenu orderMenu);
	
	public void updateOrderMenuSelectiveBitch(List<OrderMenu> orderMenuList);
	
	public void deleteOrderMenu(Long id);
	
	public void deleteOrderMenuBitch(List<Long> idList);
	
	public void createNewOrderMenu(OrderMenu orderMenu);
	
	public List<OrderMenu> getOrderMenuListByOrderId(Long id);
	
	public List<Map<String,Object>> readyToPrint(Long id);
	
	public List<Map<String,Object>> getDineinOrderMenu (Long orderId);
	
	public Integer getOrderMenuCount (Long orderId);

	public List<OrderMenuVo> getOrderMenuListByOrderIdAndRealTimePrice(Long id);
}