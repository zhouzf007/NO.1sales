package com.dianba.userdomain.merchant.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.merchant.entity.Menu;
import com.dianba.userdomain.merchant.mapper.CommonMenuMapper;
import com.dianba.userdomain.merchant.mapper.CommonMerchantMapper;
import com.dianba.userdomain.merchant.service.MenuService;
import com.dianba.userdomain.merchant.vo.CheckOrderPriceVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonMenuServiceImpl implements MenuService {

	@Autowired
	private CommonMenuMapper menuMapper;
	
	@Override
	public List<Menu> getMenuList() {
		return menuMapper.getMenuList();
	}
	@Override
	public PageList<Menu> getMenuList(PageBounds pageBounds) {
		return menuMapper.getMenuList(pageBounds);
	}
	@Override
	public List<Menu> getMenuPageList(Menu menu) {
		return menuMapper.getMenuPageList(menu);
	}
	@Override
	public PageList<Menu> getMenuPageList(Menu menu, PageBounds pageBounds) {
		return menuMapper.getMenuPageList(menu, pageBounds);
	}
	@Override
	public Menu getMenuByPrimaryKey(Long id) {
		return menuMapper.getMenuByPrimaryKey(id);
	}
	@Override
	public void createMenu(Menu menu) {
		menuMapper.createMenu(menu);
	}
	@Override
	public void updateMenu(Menu menu) {
		menuMapper.updateMenu(menu);
	}
	@Override
	public void updateMenuSelective(Menu menu) {
		menuMapper.updateMenuSelective(menu);
	}
	@Override
	public void deleteMenu(Long id) {
		menuMapper.deleteMenu(id);
	}
	@Override
	public List<CheckOrderPriceVo> checkOrderPrice(Map<String, Object> map) {
		return menuMapper.checkOrderPrice(map);
	}
	

	

}