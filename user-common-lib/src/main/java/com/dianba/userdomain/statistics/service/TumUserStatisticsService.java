package com.dianba.userdomain.statistics.service;

import java.util.List;

import com.dianba.userdomain.statistics.entity.TumUserStatistics;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TumUserStatisticsService {

	public List<TumUserStatistics> getTumUserStatisticsList();
	
	public PageList<TumUserStatistics> getTumUserStatisticsList(PageBounds pageBounds);
	
	public List<TumUserStatistics> getTumUserStatisticsPageList(TumUserStatistics tumUserStatistics);
	
	public PageList<TumUserStatistics> getTumUserStatisticsPageList(TumUserStatistics tumUserStatistics, PageBounds pageBounds);
	
	public TumUserStatistics getTumUserStatisticsByPrimaryKey(Long id);
	
	public void createTumUserStatistics(TumUserStatistics tumUserStatistics);
	
	public void createTumUserStatisticsBitch(List<TumUserStatistics> tumUserStatisticsList);
	
	public void updateTumUserStatistics(TumUserStatistics tumUserStatistics);
	
	public void updateTumUserStatisticsBitch(List<TumUserStatistics> tumUserStatisticsList);
	
	public void updateTumUserStatisticsSelective(TumUserStatistics tumUserStatistics);
	
	public void updateTumUserStatisticsSelectiveBitch(List<TumUserStatistics> tumUserStatisticsList);
	
	public void deleteTumUserStatistics(Long id);
	
	public void deleteTumUserStatisticsBitch(List<Long> idList);
	
	public void createOrUpdate (Long userId,Integer money);
	
    /**
     * 根据userId查询信息
     * @param userId
     * @return
     */
    public TumUserStatistics getTumUserStatisticsByUserId(Long userId);


}