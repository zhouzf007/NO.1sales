package com.dianba.userdomain.discount.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.discount.entity.TomPlatformAduit;
import com.dianba.userdomain.discount.mapper.CommonTomPlatformAduitMapper;
import com.dianba.userdomain.discount.service.TomPlatformAduitService;
import com.dianba.userdomain.util.ListUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonTomPlatformAduitServiceImpl implements TomPlatformAduitService { 

    @Autowired
	private CommonTomPlatformAduitMapper tomPlatformAduitMapper;
	
	public List<TomPlatformAduit> getTomPlatformAduitList(){
		return tomPlatformAduitMapper.getTomPlatformAduitList();
	}
	
	public PageList<TomPlatformAduit> getTomPlatformAduitList(PageBounds pageBounds){
		return tomPlatformAduitMapper.getTomPlatformAduitList(pageBounds);
	}
	
	public List<TomPlatformAduit> getTomPlatformAduitPageList(TomPlatformAduit tomPlatformAduit){
		return tomPlatformAduitMapper.getTomPlatformAduitPageList(tomPlatformAduit);
	}
	
	public PageList<TomPlatformAduit> getTomPlatformAduitPageList(TomPlatformAduit tomPlatformAduit, PageBounds pageBounds){
		return tomPlatformAduitMapper.getTomPlatformAduitPageList(tomPlatformAduit,pageBounds);
	}
	
	public TomPlatformAduit getTomPlatformAduitByPrimaryKey(Integer id){
		return tomPlatformAduitMapper.getTomPlatformAduitByPrimaryKey(id);
	}
	
	public void createTomPlatformAduit(TomPlatformAduit tomPlatformAduit){
		tomPlatformAduitMapper.createTomPlatformAduit(tomPlatformAduit);
	}
	
	public void createTomPlatformAduitBitch(List<TomPlatformAduit> tomPlatformAduitList){
		for( TomPlatformAduit tomPlatformAduit : tomPlatformAduitList ) {
			tomPlatformAduitMapper.createTomPlatformAduit(tomPlatformAduit);
		}
	}
	
	public void updateTomPlatformAduit(TomPlatformAduit tomPlatformAduit){
		tomPlatformAduitMapper.updateTomPlatformAduit(tomPlatformAduit);
	}
	
	public void updateTomPlatformAduitBitch(List<TomPlatformAduit> tomPlatformAduitList){
	    for( TomPlatformAduit tomPlatformAduit : tomPlatformAduitList ) {
		    tomPlatformAduitMapper.updateTomPlatformAduit(tomPlatformAduit);
		}
	}
	
	public void updateTomPlatformAduitSelective(TomPlatformAduit tomPlatformAduit){
	    tomPlatformAduitMapper.updateTomPlatformAduitSelective(tomPlatformAduit);
	}
	
	public void updateTomPlatformAduitSelectiveBitch(List<TomPlatformAduit> tomPlatformAduitList){
	    for( TomPlatformAduit tomPlatformAduit : tomPlatformAduitList ) {
		    tomPlatformAduitMapper.updateTomPlatformAduitSelective(tomPlatformAduit);
		}
	}
	
	public void deleteTomPlatformAduit(Integer id){
		tomPlatformAduitMapper.deleteTomPlatformAduit(id);
	}
	
	public void deleteTomPlatformAduitBitch(List<Integer> idList){
		for( Integer id : idList ) {
			tomPlatformAduitMapper.deleteTomPlatformAduit(id);
		}
	}

	@Override
	public int isMerchantAduit(Long merchantId) {
		TomPlatformAduit tomPlatformAduit = new TomPlatformAduit();
		tomPlatformAduit.setMerchantId(merchantId.intValue());
		List<TomPlatformAduit> tpfaList = tomPlatformAduitMapper.getTomPlatformAduitPageList(tomPlatformAduit);
		if(ListUtil.isNotNullOrEmpty(tpfaList)){
			tomPlatformAduit = tpfaList.get(0);
			if(tomPlatformAduit.getIsPass().equals("1")){
				return 1;
			}
		}
		return 0;
	}

}