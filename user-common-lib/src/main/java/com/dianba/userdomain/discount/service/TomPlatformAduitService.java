package com.dianba.userdomain.discount.service;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomPlatformAduit;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TomPlatformAduitService {

	public List<TomPlatformAduit> getTomPlatformAduitList();
	
	public PageList<TomPlatformAduit> getTomPlatformAduitList(PageBounds pageBounds);
	
	public List<TomPlatformAduit> getTomPlatformAduitPageList(TomPlatformAduit tomPlatformAduit);
	
	public PageList<TomPlatformAduit> getTomPlatformAduitPageList(TomPlatformAduit tomPlatformAduit, PageBounds pageBounds);
	
	public TomPlatformAduit getTomPlatformAduitByPrimaryKey(Integer id);
	
	public void createTomPlatformAduit(TomPlatformAduit tomPlatformAduit);
	
	public void createTomPlatformAduitBitch(List<TomPlatformAduit> tomPlatformAduitList);
	
	public void updateTomPlatformAduit(TomPlatformAduit tomPlatformAduit);
	
	public void updateTomPlatformAduitBitch(List<TomPlatformAduit> tomPlatformAduitList);
	
	public void updateTomPlatformAduitSelective(TomPlatformAduit tomPlatformAduit);
	
	public void updateTomPlatformAduitSelectiveBitch(List<TomPlatformAduit> tomPlatformAduitList);
	
	public void deleteTomPlatformAduit(Integer id);
	
	public void deleteTomPlatformAduitBitch(List<Integer> idList);
	
	public int isMerchantAduit(Long merchantId);

}