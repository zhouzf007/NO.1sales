package com.dianba.userdomain.discount.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.dianba.userdomain.discount.mapper.CommonTomMerchantMemberInfoMapper;
import com.dianba.userdomain.discount.service.TomMerchantMemberInfoService;
import com.dianba.userdomain.util.ListUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonTomMerchantMemberInfoServiceImpl implements TomMerchantMemberInfoService { 

    @Autowired
	private CommonTomMerchantMemberInfoMapper tomMerchantMemberInfoMapper;
	
	public List<TomMerchantMemberInfo> getTomMerchantMemberInfoList(){
		return tomMerchantMemberInfoMapper.getTomMerchantMemberInfoList();
	}
	
	public PageList<TomMerchantMemberInfo> getTomMerchantMemberInfoList(PageBounds pageBounds){
		return tomMerchantMemberInfoMapper.getTomMerchantMemberInfoList(pageBounds);
	}
	
	public List<TomMerchantMemberInfo> getTomMerchantMemberInfoPageList(TomMerchantMemberInfo tomMerchantMemberInfo){
		return tomMerchantMemberInfoMapper.getTomMerchantMemberInfoPageList(tomMerchantMemberInfo);
	}
	
	public PageList<TomMerchantMemberInfo> getTomMerchantMemberInfoPageList(TomMerchantMemberInfo tomMerchantMemberInfo, PageBounds pageBounds){
		return tomMerchantMemberInfoMapper.getTomMerchantMemberInfoPageList(tomMerchantMemberInfo,pageBounds);
	}
	
	public TomMerchantMemberInfo getTomMerchantMemberInfoByPrimaryKey(Integer id){
		return tomMerchantMemberInfoMapper.getTomMerchantMemberInfoByPrimaryKey(id);
	}
	
	public void createTomMerchantMemberInfo(TomMerchantMemberInfo tomMerchantMemberInfo){
		tomMerchantMemberInfoMapper.createTomMerchantMemberInfo(tomMerchantMemberInfo);
	}
	
	public void createTomMerchantMemberInfoBitch(List<TomMerchantMemberInfo> tomMerchantMemberInfoList){
		for( TomMerchantMemberInfo tomMerchantMemberInfo : tomMerchantMemberInfoList ) {
			tomMerchantMemberInfoMapper.createTomMerchantMemberInfo(tomMerchantMemberInfo);
		}
	}
	
	public void updateTomMerchantMemberInfo(TomMerchantMemberInfo tomMerchantMemberInfo){
		tomMerchantMemberInfoMapper.updateTomMerchantMemberInfo(tomMerchantMemberInfo);
	}
	
	public void updateTomMerchantMemberInfoBitch(List<TomMerchantMemberInfo> tomMerchantMemberInfoList){
	    for( TomMerchantMemberInfo tomMerchantMemberInfo : tomMerchantMemberInfoList ) {
		    tomMerchantMemberInfoMapper.updateTomMerchantMemberInfo(tomMerchantMemberInfo);
		}
	}
	
	public void updateTomMerchantMemberInfoSelective(TomMerchantMemberInfo tomMerchantMemberInfo){
	    tomMerchantMemberInfoMapper.updateTomMerchantMemberInfoSelective(tomMerchantMemberInfo);
	}
	
	public void updateTomMerchantMemberInfoSelectiveBitch(List<TomMerchantMemberInfo> tomMerchantMemberInfoList){
	    for( TomMerchantMemberInfo tomMerchantMemberInfo : tomMerchantMemberInfoList ) {
		    tomMerchantMemberInfoMapper.updateTomMerchantMemberInfoSelective(tomMerchantMemberInfo);
		}
	}
	
	public void deleteTomMerchantMemberInfo(Integer id){
		tomMerchantMemberInfoMapper.deleteTomMerchantMemberInfo(id);
	}
	
	public void deleteTomMerchantMemberInfoBitch(List<Integer> idList){
		for( Integer id : idList ) {
			tomMerchantMemberInfoMapper.deleteTomMerchantMemberInfo(id);
		}
	}
	/**
	 * 用户是否是商家会员  null=不是  
	 */
	@Override
	public TomMerchantMemberInfo isMemberOfMerchant(Long userId, Long merchantId) {
		TomMerchantMemberInfo tomMerchantMemberInfo = new TomMerchantMemberInfo();
		tomMerchantMemberInfo.setMerchantId(merchantId.intValue());
		tomMerchantMemberInfo.setUserId(userId.intValue());
		List<TomMerchantMemberInfo> tmmiList = tomMerchantMemberInfoMapper.getTomMerchantMemberInfoPageList(tomMerchantMemberInfo);
		if(ListUtil.isNotNullOrEmpty(tmmiList)){
			tomMerchantMemberInfo = tmmiList.get(0);
			return tomMerchantMemberInfo;
		
		}
		return null;
	}

}