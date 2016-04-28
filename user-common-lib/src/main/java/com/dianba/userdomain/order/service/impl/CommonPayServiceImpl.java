package com.dianba.userdomain.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.order.entity.Pay;
import com.dianba.userdomain.order.mapper.CommonPayMapper;
import com.dianba.userdomain.order.service.PayService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonPayServiceImpl implements PayService { 

    @Autowired
	private CommonPayMapper payMapper;
	
	public List<Pay> getPayList(){
		return payMapper.getPayList();
	}
	
	public PageList<Pay> getPayList(PageBounds pageBounds){
		return payMapper.getPayList(pageBounds);
	}
	
	public List<Pay> getPayPageList(Pay pay){
		return payMapper.getPayPageList(pay);
	}
	
	public PageList<Pay> getPayPageList(Pay pay, PageBounds pageBounds){
		return payMapper.getPayPageList(pay,pageBounds);
	}
	
	public Pay getPayByPrimaryKey(String id){
		return payMapper.getPayByPrimaryKey(id);
	}
	
	public void createPay(Pay pay){
		payMapper.createPay(pay);
	}
	
	public void createPayBitch(List<Pay> payList){
		for( Pay pay : payList ) {
			payMapper.createPay(pay);
		}
	}
	
	public void updatePay(Pay pay){
		payMapper.updatePay(pay);
	}
	
	public void updatePayBitch(List<Pay> payList){
	    for( Pay pay : payList ) {
		    payMapper.updatePay(pay);
		}
	}
	
	public void updatePaySelective(Pay pay){
	    payMapper.updatePaySelective(pay);
	}
	
	public void updatePaySelectiveBitch(List<Pay> payList){
	    for( Pay pay : payList ) {
		    payMapper.updatePaySelective(pay);
		}
	}
	
	public void deletePay(String id){
		payMapper.deletePay(id);
	}
	
	public void deletePayBitch(List<String> idList){
		for( String id : idList ) {
			payMapper.deletePay(id);
		}
	}

	@Override
	public void createNewPay(Pay pay) {	
		payMapper.createNewPay(pay);
	}

}