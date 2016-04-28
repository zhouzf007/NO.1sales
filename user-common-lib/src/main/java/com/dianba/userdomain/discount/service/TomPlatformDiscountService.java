package com.dianba.userdomain.discount.service;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomPlatformDiscount;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TomPlatformDiscountService {

	public List<TomPlatformDiscount> getTomPlatformDiscountList();
	
	public PageList<TomPlatformDiscount> getTomPlatformDiscountList(PageBounds pageBounds);
	
	public List<TomPlatformDiscount> getTomPlatformDiscountPageList(TomPlatformDiscount tomPlatformDiscount);
	
	public PageList<TomPlatformDiscount> getTomPlatformDiscountPageList(TomPlatformDiscount tomPlatformDiscount, PageBounds pageBounds);
	
	public TomPlatformDiscount getTomPlatformDiscountByPrimaryKey(Integer id);
	
	public void createTomPlatformDiscount(TomPlatformDiscount tomPlatformDiscount);
	
	public void createTomPlatformDiscountBitch(List<TomPlatformDiscount> tomPlatformDiscountList);
	
	public void updateTomPlatformDiscount(TomPlatformDiscount tomPlatformDiscount);
	
	public void updateTomPlatformDiscountBitch(List<TomPlatformDiscount> tomPlatformDiscountList);
	
	public void updateTomPlatformDiscountSelective(TomPlatformDiscount tomPlatformDiscount);
	
	public void updateTomPlatformDiscountSelectiveBitch(List<TomPlatformDiscount> tomPlatformDiscountList);
	
	public void deleteTomPlatformDiscount(Integer id);
	
	public void deleteTomPlatformDiscountBitch(List<Integer> idList);

}