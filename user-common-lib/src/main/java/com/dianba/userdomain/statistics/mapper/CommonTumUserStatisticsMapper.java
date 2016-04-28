package com.dianba.userdomain.statistics.mapper;

import java.util.List;

import com.dianba.userdomain.statistics.entity.TumUserStatistics;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonTumUserStatisticsMapper {

	public List<TumUserStatistics> getTumUserStatisticsList();

	public PageList<TumUserStatistics> getTumUserStatisticsList( PageBounds pageBounds );
	
	public List<TumUserStatistics> getTumUserStatisticsPageList( TumUserStatistics tumUserStatistics );
	
	public PageList<TumUserStatistics> getTumUserStatisticsPageList(TumUserStatistics tumUserStatistics, PageBounds pageBounds );

    public TumUserStatistics getTumUserStatisticsByPrimaryKey(Long id);
	
	public void createTumUserStatistics(TumUserStatistics tumUserStatistics);
	
	public void updateTumUserStatistics(TumUserStatistics tumUserStatistics);
	
	public void updateTumUserStatisticsSelective(TumUserStatistics tumUserStatistics);
	
	public void deleteTumUserStatistics(Long id);

	
	public TumUserStatistics getTumUserStatisticsByUserId(Long userId);
	
	public void insertTumUserStatistics(TumUserStatistics tumUserStatistics);
	
	public void updateTumUserStatisticsSelectiveByUserId(TumUserStatistics tumUserStatistics);


}