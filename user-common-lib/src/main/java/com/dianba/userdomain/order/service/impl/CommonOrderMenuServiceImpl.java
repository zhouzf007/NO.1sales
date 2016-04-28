package com.dianba.userdomain.order.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.order.entity.OrderMenu;
import com.dianba.userdomain.order.mapper.CommonOrderMenuMapper;
import com.dianba.userdomain.order.service.OrderMenuService;
import com.dianba.userdomain.order.vo.OrderMenuVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonOrderMenuServiceImpl implements OrderMenuService {

	@Autowired
	private CommonOrderMenuMapper orderMenuMapper;

	public List<OrderMenu> getOrderMenuList() {
		return orderMenuMapper.getOrderMenuList();
	}

	public PageList<OrderMenu> getOrderMenuList(PageBounds pageBounds) {
		return orderMenuMapper.getOrderMenuList(pageBounds);
	}

	public List<OrderMenu> getOrderMenuPageList(OrderMenu orderMenu) {
		return orderMenuMapper.getOrderMenuPageList(orderMenu);
	}

	public PageList<OrderMenu> getOrderMenuPageList(OrderMenu orderMenu, PageBounds pageBounds) {
		return orderMenuMapper.getOrderMenuPageList(orderMenu, pageBounds);
	}

	public OrderMenu getOrderMenuByPrimaryKey(Long id) {
		return orderMenuMapper.getOrderMenuByPrimaryKey(id);
	}

	public void createOrderMenu(OrderMenu orderMenu) {
		orderMenuMapper.createOrderMenu(orderMenu);
	}

	public void createOrderMenuBitch(List<OrderMenu> orderMenuList) {
		for (OrderMenu orderMenu : orderMenuList) {
			orderMenuMapper.createOrderMenu(orderMenu);
		}
	}

	public void updateOrderMenu(OrderMenu orderMenu) {
		orderMenuMapper.updateOrderMenu(orderMenu);
	}

	public void updateOrderMenuBitch(List<OrderMenu> orderMenuList) {
		for (OrderMenu orderMenu : orderMenuList) {
			orderMenuMapper.updateOrderMenu(orderMenu);
		}
	}

	public void updateOrderMenuSelective(OrderMenu orderMenu) {
		orderMenuMapper.updateOrderMenuSelective(orderMenu);
	}

	public void updateOrderMenuSelectiveBitch(List<OrderMenu> orderMenuList) {
		for (OrderMenu orderMenu : orderMenuList) {
			orderMenuMapper.updateOrderMenuSelective(orderMenu);
		}
	}

	public void deleteOrderMenu(Long id) {
		orderMenuMapper.deleteOrderMenu(id);
	}

	public void deleteOrderMenuBitch(List<Long> idList) {
		for (Long id : idList) {
			orderMenuMapper.deleteOrderMenu(id);
		}
	}

	public void createNewOrderMenu(OrderMenu orderMenu) {
		orderMenuMapper.createNewOrderMenu(orderMenu);

	}

	public List<OrderMenu> getOrderMenuListByOrderId(Long id) {
		return orderMenuMapper.getOrderMenuListByOrderId(id);
	}

	@Override
	public List<Map<String, Object>> readyToPrint(Long id) {
		return orderMenuMapper.readyToPrint(id);
	}

	@Override
	public List<Map<String, Object>> getDineinOrderMenu(Long orderId) {
		return orderMenuMapper.getDineinOrderMenu(orderId);
	}

	@Override
	public Integer getOrderMenuCount(Long orderId) {
		return orderMenuMapper.getOrderMenuCount(orderId);
	}

	@Override
	public List<OrderMenuVo> getOrderMenuListByOrderIdAndRealTimePrice(Long id) {
		return orderMenuMapper.getOrderMenuListByOrderIdAndRealTimePrice(id);
	}

}