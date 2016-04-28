package com.dianba.userdomain.merchant.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.merchant.entity.MenuType;
import com.dianba.userdomain.merchant.mapper.CommonMenuTypeMapper;
import com.dianba.userdomain.merchant.service.MenuTypeService;
import com.dianba.userdomain.order.vo.OrderMenusVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonMenuTypeServiceImpl implements MenuTypeService {

	@Autowired
	private CommonMenuTypeMapper menuTypeMapper;

	public List<MenuType> getMenuTypeList() {
		return menuTypeMapper.getMenuTypeList();
	}

	public PageList<MenuType> getMenuTypeList(PageBounds pageBounds) {
		return menuTypeMapper.getMenuTypeList(pageBounds);
	}

	public List<MenuType> getMenuTypePageList(MenuType menuType) {
		return menuTypeMapper.getMenuTypePageList(menuType);
	}

	public PageList<MenuType> getMenuTypePageList(MenuType menuType, PageBounds pageBounds) {
		return menuTypeMapper.getMenuTypePageList(menuType, pageBounds);
	}

	public MenuType getMenuTypeByPrimaryKey(Long id) {
		return menuTypeMapper.getMenuTypeByPrimaryKey(id);
	}

	public void createMenuType(MenuType menuType) {
		menuTypeMapper.createMenuType(menuType);
	}

	public void createMenuTypeBitch(List<MenuType> menuTypeList) {
		for (MenuType menuType : menuTypeList) {
			menuTypeMapper.createMenuType(menuType);
		}
	}

	public void updateMenuType(MenuType menuType) {
		menuTypeMapper.updateMenuType(menuType);
	}

	public void updateMenuTypeBitch(List<MenuType> menuTypeList) {
		for (MenuType menuType : menuTypeList) {
			menuTypeMapper.updateMenuType(menuType);
		}
	}

	public void updateMenuTypeSelective(MenuType menuType) {
		menuTypeMapper.updateMenuTypeSelective(menuType);
	}

	public void updateMenuTypeSelectiveBitch(List<MenuType> menuTypeList) {
		for (MenuType menuType : menuTypeList) {
			menuTypeMapper.updateMenuTypeSelective(menuType);
		}
	}

	public void deleteMenuType(Long id) {
		menuTypeMapper.deleteMenuType(id);
	}

	public void deleteMenuTypeBitch(List<Long> idList) {
		for (Long id : idList) {
			menuTypeMapper.deleteMenuType(id);
		}
	}
	

	@Override
	public Double getCostLunchBOX(Map<String, Object> map) {
		return menuTypeMapper.getCostLunchBOX(map);
	}

	@Override
	public Double getPackingCharge(Map<String, Object> map) {
		return menuTypeMapper.getPackingCharge(map);
	}

	@Override
	public Double getPackingMoney(List<OrderMenusVo> list) {
		List<Long> menuIds = new ArrayList<Long>();
		Double money = 0.0;
		for (OrderMenusVo o : list) {
			// 把menuId加入外卖打包费list
			if (o.getCount() == 1) {
				menuIds.add(o.getMenuId());
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("count", o.getCount());
				map.put("menuId", o.getMenuId());
				Double packIngMoney = getPackingCharge(map);
				packIngMoney = packIngMoney == null ? 0.0 : packIngMoney;
				money += new BigDecimal(packIngMoney).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			}
		}
		if (!CollectionUtils.isEmpty(menuIds)) {
			Map<String, Object> clb = new HashMap<String, Object>();
			clb.put("menuIds", menuIds);
			Double takeOutCostLunchBox = getCostLunchBOX(clb);
			if (takeOutCostLunchBox != null) {
				money += new BigDecimal(takeOutCostLunchBox).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
			}
		}
		return money;
	}

}