package com.dianba.userdomain.order.mapper;

import java.util.List;

import com.dianba.userdomain.order.entity.Flow;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonFlowMapper {

	public List<Flow> getFlowList();

	public PageList<Flow> getFlowList( PageBounds pageBounds );
	
	public List<Flow> getFlowPageList( Flow flow );
	
	public PageList<Flow> getFlowPageList(Flow flow, PageBounds pageBounds );
	
	public Flow getFlowByPrimaryKey(Long id);
	
	public void createFlow(Flow flow);
	
	public void updateFlow(Flow flow);
	
	public void updateFlowSelective(Flow flow);
	
	public void deleteFlow(Long id);
	
	public PageList<Flow> getFlowPageListByUserId(Long userId, PageBounds pageBounds);
}