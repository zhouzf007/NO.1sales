package com.dianba.userdomain.merchant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.merchant.entity.MerchantOpenTime;
import com.dianba.userdomain.merchant.mapper.CommonMerchantOpenTimeMapper;
import com.dianba.userdomain.merchant.service.MerchantOpenTimeService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonMerchantOpenTimeServiceImpl implements MerchantOpenTimeService { 

    @Autowired
	private CommonMerchantOpenTimeMapper merchantOpenTimeMapper;
	
	public List<MerchantOpenTime> getMerchantOpenTimeList(){
		return merchantOpenTimeMapper.getMerchantOpenTimeList();
	}
	
	public PageList<MerchantOpenTime> getMerchantOpenTimeList(PageBounds pageBounds){
		return merchantOpenTimeMapper.getMerchantOpenTimeList(pageBounds);
	}
	
	public List<MerchantOpenTime> getMerchantOpenTimePageList(MerchantOpenTime merchantOpenTime){
		return merchantOpenTimeMapper.getMerchantOpenTimePageList(merchantOpenTime);
	}
	
	public PageList<MerchantOpenTime> getMerchantOpenTimePageList(MerchantOpenTime merchantOpenTime, PageBounds pageBounds){
		return merchantOpenTimeMapper.getMerchantOpenTimePageList(merchantOpenTime,pageBounds);
	}
	
	public MerchantOpenTime getMerchantOpenTimeByPrimaryKey(Integer id){
		return merchantOpenTimeMapper.getMerchantOpenTimeByPrimaryKey(id);
	}
	
	public void createMerchantOpenTime(MerchantOpenTime merchantOpenTime){
		merchantOpenTimeMapper.createMerchantOpenTime(merchantOpenTime);
	}
	
	public void createMerchantOpenTimeBitch(List<MerchantOpenTime> merchantOpenTimeList){
		for( MerchantOpenTime merchantOpenTime : merchantOpenTimeList ) {
			merchantOpenTimeMapper.createMerchantOpenTime(merchantOpenTime);
		}
	}
	
	public void updateMerchantOpenTime(MerchantOpenTime merchantOpenTime){
		merchantOpenTimeMapper.updateMerchantOpenTime(merchantOpenTime);
	}
	
	public void updateMerchantOpenTimeBitch(List<MerchantOpenTime> merchantOpenTimeList){
	    for( MerchantOpenTime merchantOpenTime : merchantOpenTimeList ) {
		    merchantOpenTimeMapper.updateMerchantOpenTime(merchantOpenTime);
		}
	}
	
	public void updateMerchantOpenTimeSelective(MerchantOpenTime merchantOpenTime){
	    merchantOpenTimeMapper.updateMerchantOpenTimeSelective(merchantOpenTime);
	}
	
	public void updateMerchantOpenTimeSelectiveBitch(List<MerchantOpenTime> merchantOpenTimeList){
	    for( MerchantOpenTime merchantOpenTime : merchantOpenTimeList ) {
		    merchantOpenTimeMapper.updateMerchantOpenTimeSelective(merchantOpenTime);
		}
	}
	
	public void deleteMerchantOpenTime(Integer id){
		merchantOpenTimeMapper.deleteMerchantOpenTime(id);
	}
	
	public void deleteMerchantOpenTimeBitch(List<Integer> idList){
		for( Integer id : idList ) {
			merchantOpenTimeMapper.deleteMerchantOpenTime(id);
		}
	}

}