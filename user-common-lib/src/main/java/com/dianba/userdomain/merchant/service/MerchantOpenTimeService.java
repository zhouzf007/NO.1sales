package com.dianba.userdomain.merchant.service;

import java.util.List;

import com.dianba.userdomain.merchant.entity.MerchantOpenTime;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface MerchantOpenTimeService {

	public List<MerchantOpenTime> getMerchantOpenTimeList();
	
	public PageList<MerchantOpenTime> getMerchantOpenTimeList(PageBounds pageBounds);
	
	public List<MerchantOpenTime> getMerchantOpenTimePageList(MerchantOpenTime merchantOpenTime);
	
	public PageList<MerchantOpenTime> getMerchantOpenTimePageList(MerchantOpenTime merchantOpenTime, PageBounds pageBounds);
	
	public MerchantOpenTime getMerchantOpenTimeByPrimaryKey(Integer id);
	
	public void createMerchantOpenTime(MerchantOpenTime merchantOpenTime);
	
	public void createMerchantOpenTimeBitch(List<MerchantOpenTime> merchantOpenTimeList);
	
	public void updateMerchantOpenTime(MerchantOpenTime merchantOpenTime);
	
	public void updateMerchantOpenTimeBitch(List<MerchantOpenTime> merchantOpenTimeList);
	
	public void updateMerchantOpenTimeSelective(MerchantOpenTime merchantOpenTime);
	
	public void updateMerchantOpenTimeSelectiveBitch(List<MerchantOpenTime> merchantOpenTimeList);
	
	public void deleteMerchantOpenTime(Integer id);
	
	public void deleteMerchantOpenTimeBitch(List<Integer> idList);

}