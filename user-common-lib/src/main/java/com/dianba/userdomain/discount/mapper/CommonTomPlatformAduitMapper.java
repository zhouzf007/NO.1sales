package com.dianba.userdomain.discount.mapper;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomPlatformAduit;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonTomPlatformAduitMapper {

	public List<TomPlatformAduit> getTomPlatformAduitList();

	public PageList<TomPlatformAduit> getTomPlatformAduitList( PageBounds pageBounds );
	
	public List<TomPlatformAduit> getTomPlatformAduitPageList( TomPlatformAduit tomPlatformAduit );
	
	public PageList<TomPlatformAduit> getTomPlatformAduitPageList(TomPlatformAduit tomPlatformAduit, PageBounds pageBounds );
	
	public TomPlatformAduit getTomPlatformAduitByPrimaryKey(Integer id);
	
	public void createTomPlatformAduit(TomPlatformAduit tomPlatformAduit);
	
	public void updateTomPlatformAduit(TomPlatformAduit tomPlatformAduit);
	
	public void updateTomPlatformAduitSelective(TomPlatformAduit tomPlatformAduit);
	
	public void deleteTomPlatformAduit(Integer id);
}