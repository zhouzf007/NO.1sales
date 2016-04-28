package com.dianba.userdomain.order.mapper;

import java.util.List;

import com.dianba.userdomain.order.entity.Recharge;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonRechargeMapper {

	public List<Recharge> getRechargeList();

	public PageList<Recharge> getRechargeList( PageBounds pageBounds );
	
	public List<Recharge> getRechargePageList( Recharge recharge );
	
	public PageList<Recharge> getRechargePageList(Recharge recharge, PageBounds pageBounds );
	
	public Recharge getRechargeByPrimaryKey(Long id);
	
	public void createRecharge(Recharge recharge);
	
	public void updateRecharge(Recharge recharge);
	
	public void updateRechargeSelective(Recharge recharge);
	
	public void deleteRecharge(Long id);
	
	public Long createNewRecharge(Recharge recharge);
}