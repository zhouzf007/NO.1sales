package com.dianba.userdomain.order.service;

import java.util.List;

import com.dianba.userdomain.order.entity.Recharge;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface RechargeService {

	public List<Recharge> getRechargeList();
	
	public PageList<Recharge> getRechargeList(PageBounds pageBounds);
	
	public List<Recharge> getRechargePageList(Recharge recharge);
	
	public PageList<Recharge> getRechargePageList(Recharge recharge, PageBounds pageBounds);
	
	public Recharge getRechargeByPrimaryKey(Long id);
	
	public void createRecharge(Recharge recharge);
	
	public void createRechargeBitch(List<Recharge> rechargeList);
	
	public void updateRecharge(Recharge recharge);
	
	public void updateRechargeBitch(List<Recharge> rechargeList);
	
	public void updateRechargeSelective(Recharge recharge);
	
	public void updateRechargeSelectiveBitch(List<Recharge> rechargeList);
	
	public void deleteRecharge(Long id);
	
	public void deleteRechargeBitch(List<Long> idList);
	
	public Long createNewRecharge(Recharge recharge);

}