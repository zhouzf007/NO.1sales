package com.dianba.userdomain.order.mapper;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.order.entity.OrderMenu;
import com.dianba.userdomain.order.vo.OrderMenuVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonOrderMenuMapper {

	public List<OrderMenu> getOrderMenuList();

	public PageList<OrderMenu> getOrderMenuList( PageBounds pageBounds );
	
	public List<OrderMenu> getOrderMenuPageList( OrderMenu orderMenu );
	
	public PageList<OrderMenu> getOrderMenuPageList(OrderMenu orderMenu, PageBounds pageBounds );
	
	public OrderMenu getOrderMenuByPrimaryKey(Long id);
	
	public void createOrderMenu(OrderMenu orderMenu);
	
	public void updateOrderMenu(OrderMenu orderMenu);
	
	public void updateOrderMenuSelective(OrderMenu orderMenu);
	
	public void deleteOrderMenu(Long id);
	
	public void createNewOrderMenu(OrderMenu orderMenu);
	
	public List<OrderMenu> getOrderMenuListByOrderId(Long id);
	
	public List<Map<String,Object>> readyToPrint(Long id);
	
	public List<Map<String,Object>> getDineinOrderMenu (Long orderId);
	
	public Integer getOrderMenuCount (Long orderId);
	
	public List<OrderMenuVo> getOrderMenuListByOrderIdAndRealTimePrice(Long id);
}