package com.dianba.userdomain.merchant.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.dianba.userdomain.merchant.entity.MerchantInfo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface MerchantInfoService {

	public List<MerchantInfo> getMerchantInfoList();

	public PageList<MerchantInfo> getMerchantInfoList( PageBounds pageBounds );
	
	public List<MerchantInfo> getMerchantInfoPageList( MerchantInfo merchantInfo );
	
	public PageList<MerchantInfo> getMerchantInfoPageList(MerchantInfo merchantInfo, PageBounds pageBounds );

	public MerchantInfo getMerchantInfoByPrimaryKey(Integer id);
	
	public void createMerchantInfo(MerchantInfo merchantInfo);
	
	public void updateMerchantInfo(MerchantInfo merchantInfo);
	
	public void updateMerchantInfoSelective(MerchantInfo merchantInfo);
	
	public void deleteMerchantInfo(Integer id);
	
	public MerchantInfo getMerchantInfoByMerchantId(Integer merchantId);
	
	public Double getCostLunchBox(Integer id);
	
	public List<MerchantInfo> MerchantInfoList(Integer id);
	
	public Integer getMerchantSource(Integer id);

	public Integer getDineInDiscount (Integer merchantId);
	
	public Map<String,Object> getDineInDiscountMoney (Integer merchantId,BigDecimal money);

	public Integer findRechargeMerchantId();
}