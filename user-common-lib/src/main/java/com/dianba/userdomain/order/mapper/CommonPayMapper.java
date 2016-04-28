package com.dianba.userdomain.order.mapper;

import java.util.List;

import com.dianba.userdomain.order.entity.Pay;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonPayMapper {

	public List<Pay> getPayList();

	public PageList<Pay> getPayList( PageBounds pageBounds );
	
	public List<Pay> getPayPageList( Pay pay );
	
	public PageList<Pay> getPayPageList(Pay pay, PageBounds pageBounds );
	
	public Pay getPayByPrimaryKey(String id);
	
	public void createPay(Pay pay);
	
	public void updatePay(Pay pay);
	
	public void updatePaySelective(Pay pay);
	
	public void deletePay(String id);
	
	public void createNewPay(Pay pay);
}