package com.dianba.userdomain.merchant.mapper;

import java.util.List;
import java.util.Map;

import com.dianba.userdomain.merchant.entity.Menu;
import com.dianba.userdomain.merchant.vo.CheckOrderPriceVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;


@MyBatisRepository
public interface CommonMenuMapper {

	public List<Menu> getMenuList();

	public PageList<Menu> getMenuList(PageBounds pageBounds);

	public List<Menu> getMenuPageList(Menu menu);

	public PageList<Menu> getMenuPageList(Menu menu, PageBounds pageBounds);

	public Menu getMenuByPrimaryKey(Long id);

	public void createMenu(Menu menu);

	public void updateMenu(Menu menu);

	public void updateMenuSelective(Menu menu);

	public void deleteMenu(Long id);
	
	public List<CheckOrderPriceVo> checkOrderPrice(Map<String,Object>map);

}