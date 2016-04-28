package com.dianba.userdomain.sysdictionary.service;

import java.math.BigDecimal;
import java.util.List;

import com.dianba.userdomain.order.entity.Flow;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface FlowService {

	public List<Flow> getFlowList();
	
	public PageList<Flow> getFlowList(PageBounds pageBounds);
	
	public List<Flow> getFlowPageList(Flow flow);
	
	public PageList<Flow> getFlowPageList(Flow flow, PageBounds pageBounds);
	
	public Flow getFlowByPrimaryKey(Long id);
	
	public void createFlow(Flow flow);
	
	public void createFlowBitch(List<Flow> flowList);
	
	public void updateFlow(Flow flow);
	
	public void updateFlowBitch(List<Flow> flowList);
	
	public void updateFlowSelective(Flow flow);
	
	public void updateFlowSelectiveBitch(List<Flow> flowList);
	
	public void deleteFlow(Long id);
	
	public void deleteFlowBitch(List<Long> idList);
	
	public void rechargeFlowCreate(Long userid, BigDecimal money, Long detailId);
	
	public void merchantOrderIncome (Long userId,BigDecimal money,Long detailId);
	
	public PageList<Flow> getFlowPageListByUserId(Long userId, PageBounds pageBounds);
	
	public void merchantRechargeFlowCreate(Long userid, Long merchantId ,BigDecimal money, Long detailId);
}