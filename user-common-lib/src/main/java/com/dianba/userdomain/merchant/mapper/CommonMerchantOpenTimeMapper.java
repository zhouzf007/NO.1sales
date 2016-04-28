package com.dianba.userdomain.merchant.mapper;

import java.util.List;

import com.dianba.userdomain.merchant.entity.MerchantOpenTime;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonMerchantOpenTimeMapper {

	public List<MerchantOpenTime> getMerchantOpenTimeList();

	public PageList<MerchantOpenTime> getMerchantOpenTimeList( PageBounds pageBounds );
	
	public List<MerchantOpenTime> getMerchantOpenTimePageList( MerchantOpenTime merchantOpenTime );
	
	public PageList<MerchantOpenTime> getMerchantOpenTimePageList(MerchantOpenTime merchantOpenTime, PageBounds pageBounds );
	
	public MerchantOpenTime getMerchantOpenTimeByPrimaryKey(Integer id);
	
	public void createMerchantOpenTime(MerchantOpenTime merchantOpenTime);
	
	public void updateMerchantOpenTime(MerchantOpenTime merchantOpenTime);
	
	public void updateMerchantOpenTimeSelective(MerchantOpenTime merchantOpenTime);
	
	public void deleteMerchantOpenTime(Integer id);
}