package com.dianba.userdomain.order.service;

import java.util.List;

import com.dianba.userdomain.order.entity.Pay;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface PayService {

	public List<Pay> getPayList();
	
	public PageList<Pay> getPayList(PageBounds pageBounds);
	
	public List<Pay> getPayPageList(Pay pay);
	
	public PageList<Pay> getPayPageList(Pay pay, PageBounds pageBounds);
	
	public Pay getPayByPrimaryKey(String id);
	
	public void createPay(Pay pay);
	
	public void createPayBitch(List<Pay> payList);
	
	public void updatePay(Pay pay);
	
	public void updatePayBitch(List<Pay> payList);
	
	public void updatePaySelective(Pay pay);
	
	public void updatePaySelectiveBitch(List<Pay> payList);
	
	public void deletePay(String id);
	
	public void deletePayBitch(List<String> idList);
	
	public void createNewPay(Pay pay);

}