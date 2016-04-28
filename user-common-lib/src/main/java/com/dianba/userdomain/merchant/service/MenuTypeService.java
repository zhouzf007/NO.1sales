package com.dianba.userdomain.merchant.service;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.merchant.entity.MenuType;
import com.dianba.userdomain.order.vo.OrderMenusVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface MenuTypeService {

	public List<MenuType> getMenuTypeList();

	public PageList<MenuType> getMenuTypeList( PageBounds pageBounds );
	
	public List<MenuType> getMenuTypePageList( MenuType menuType );
	
	public PageList<MenuType> getMenuTypePageList(MenuType menuType, PageBounds pageBounds );
	
	public MenuType getMenuTypeByPrimaryKey(Long id);
	
	public void createMenuType(MenuType menuType);
	
	public void updateMenuType(MenuType menuType);
	
	public void updateMenuTypeSelective(MenuType menuType);
	
	public void deleteMenuType(Long id);
	
	public Double getCostLunchBOX (Map<String,Object> map);
	
	public Double getPackingCharge (Map<String,Object> map);
	
	public Double getPackingMoney(List<OrderMenusVo> list);
}