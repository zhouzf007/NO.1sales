package com.dianba.userdomain.discount.service;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TomMerchantMemberInfoService {

	public List<TomMerchantMemberInfo> getTomMerchantMemberInfoList();
	
	public PageList<TomMerchantMemberInfo> getTomMerchantMemberInfoList(PageBounds pageBounds);
	
	public List<TomMerchantMemberInfo> getTomMerchantMemberInfoPageList(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public PageList<TomMerchantMemberInfo> getTomMerchantMemberInfoPageList(TomMerchantMemberInfo tomMerchantMemberInfo, PageBounds pageBounds);
	
	public TomMerchantMemberInfo getTomMerchantMemberInfoByPrimaryKey(Integer id);
	
	public void createTomMerchantMemberInfo(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public void createTomMerchantMemberInfoBitch(List<TomMerchantMemberInfo> tomMerchantMemberInfoList);
	
	public void updateTomMerchantMemberInfo(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public void updateTomMerchantMemberInfoBitch(List<TomMerchantMemberInfo> tomMerchantMemberInfoList);
	
	public void updateTomMerchantMemberInfoSelective(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public void updateTomMerchantMemberInfoSelectiveBitch(List<TomMerchantMemberInfo> tomMerchantMemberInfoList);
	
	public void deleteTomMerchantMemberInfo(Integer id);
	
	public void deleteTomMerchantMemberInfoBitch(List<Integer> idList);
	
	public TomMerchantMemberInfo isMemberOfMerchant(Long userId, Long merchantId);

}