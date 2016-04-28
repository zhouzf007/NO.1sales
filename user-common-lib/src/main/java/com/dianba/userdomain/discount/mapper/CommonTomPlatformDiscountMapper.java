package com.dianba.userdomain.discount.mapper;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomPlatformDiscount;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonTomPlatformDiscountMapper {

	public List<TomPlatformDiscount> getTomPlatformDiscountList();

	public PageList<TomPlatformDiscount> getTomPlatformDiscountList( PageBounds pageBounds );
	
	public List<TomPlatformDiscount> getTomPlatformDiscountPageList( TomPlatformDiscount tomPlatformDiscount );
	
	public PageList<TomPlatformDiscount> getTomPlatformDiscountPageList(TomPlatformDiscount tomPlatformDiscount, PageBounds pageBounds );
	
	public TomPlatformDiscount getTomPlatformDiscountByPrimaryKey(Integer id);
	
	public void createTomPlatformDiscount(TomPlatformDiscount tomPlatformDiscount);
	
	public void updateTomPlatformDiscount(TomPlatformDiscount tomPlatformDiscount);
	
	public void updateTomPlatformDiscountSelective(TomPlatformDiscount tomPlatformDiscount);
	
	public void deleteTomPlatformDiscount(Integer id);
}