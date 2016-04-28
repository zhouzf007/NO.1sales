package com.dianba.userdomain.discount.mapper;

import java.util.List;

import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonTomMerchantMemberInfoMapper {

	public List<TomMerchantMemberInfo> getTomMerchantMemberInfoList();

	public PageList<TomMerchantMemberInfo> getTomMerchantMemberInfoList( PageBounds pageBounds );
	
	public List<TomMerchantMemberInfo> getTomMerchantMemberInfoPageList( TomMerchantMemberInfo tomMerchantMemberInfo );
	
	public PageList<TomMerchantMemberInfo> getTomMerchantMemberInfoPageList(TomMerchantMemberInfo tomMerchantMemberInfo, PageBounds pageBounds );
	
	public TomMerchantMemberInfo getTomMerchantMemberInfoByPrimaryKey(Integer id);
	
	public void createTomMerchantMemberInfo(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public void updateTomMerchantMemberInfo(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public void updateTomMerchantMemberInfoSelective(TomMerchantMemberInfo tomMerchantMemberInfo);
	
	public void deleteTomMerchantMemberInfo(Integer id);
}