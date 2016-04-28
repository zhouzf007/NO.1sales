package com.dianba.userdomain.statistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.statistics.entity.TumUserStatistics;
import com.dianba.userdomain.statistics.mapper.CommonTumUserStatisticsMapper;
import com.dianba.userdomain.statistics.service.TumUserStatisticsService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonTumUserStatisticsServiceImpl implements TumUserStatisticsService { 

    @Autowired
	private CommonTumUserStatisticsMapper tumUserStatisticsMapper;
	
	public List<TumUserStatistics> getTumUserStatisticsList(){
		return tumUserStatisticsMapper.getTumUserStatisticsList();
	}
	
	public PageList<TumUserStatistics> getTumUserStatisticsList(PageBounds pageBounds){
		return tumUserStatisticsMapper.getTumUserStatisticsList(pageBounds);
	}
	
	public List<TumUserStatistics> getTumUserStatisticsPageList(TumUserStatistics tumUserStatistics){
		return tumUserStatisticsMapper.getTumUserStatisticsPageList(tumUserStatistics);
	}
	
	public PageList<TumUserStatistics> getTumUserStatisticsPageList(TumUserStatistics tumUserStatistics, PageBounds pageBounds){
		return tumUserStatisticsMapper.getTumUserStatisticsPageList(tumUserStatistics,pageBounds);
	}
	
	public TumUserStatistics getTumUserStatisticsByPrimaryKey(Long id){
		return tumUserStatisticsMapper.getTumUserStatisticsByPrimaryKey(id);
	}
	
	public void createTumUserStatistics(TumUserStatistics tumUserStatistics){
		tumUserStatisticsMapper.createTumUserStatistics(tumUserStatistics);
	}
	
	public void createTumUserStatisticsBitch(List<TumUserStatistics> tumUserStatisticsList){
		for( TumUserStatistics tumUserStatistics : tumUserStatisticsList ) {
			tumUserStatisticsMapper.createTumUserStatistics(tumUserStatistics);
		}
	}
	
	public void updateTumUserStatistics(TumUserStatistics tumUserStatistics){
		tumUserStatisticsMapper.updateTumUserStatistics(tumUserStatistics);
	}
	
	public void updateTumUserStatisticsBitch(List<TumUserStatistics> tumUserStatisticsList){
	    for( TumUserStatistics tumUserStatistics : tumUserStatisticsList ) {
		    tumUserStatisticsMapper.updateTumUserStatistics(tumUserStatistics);
		}
	}
	
	public void updateTumUserStatisticsSelective(TumUserStatistics tumUserStatistics){
	    tumUserStatisticsMapper.updateTumUserStatisticsSelective(tumUserStatistics);
	}
	
	public void updateTumUserStatisticsSelectiveBitch(List<TumUserStatistics> tumUserStatisticsList){
	    for( TumUserStatistics tumUserStatistics : tumUserStatisticsList ) {
		    tumUserStatisticsMapper.updateTumUserStatisticsSelective(tumUserStatistics);
		}
	}
	
	public void deleteTumUserStatistics(Long id){
		tumUserStatisticsMapper.deleteTumUserStatistics(id);
	}
	
	public void deleteTumUserStatisticsBitch(List<Long> idList){
		for( Long id : idList ) {
			tumUserStatisticsMapper.deleteTumUserStatistics(id);
		}
	}
	
	/**
	 * 根据userId查询信息
	 * @param userId
	 * @return
	 */
    public TumUserStatistics getTumUserStatisticsByUserId(Long userId){
        return tumUserStatisticsMapper.getTumUserStatisticsByUserId(userId);
    }

	@Override
	public void createOrUpdate(Long userId, Integer money) {
		try{
			TumUserStatistics user = tumUserStatisticsMapper.getTumUserStatisticsByUserId(userId);
			if(user == null){
				TumUserStatistics tumUserStatistics = new TumUserStatistics();
				tumUserStatistics.setUserId(userId);
				tumUserStatistics.setTotalMoney(money);
				tumUserStatisticsMapper.insertTumUserStatistics(tumUserStatistics);
			}else if(user != null){
				TumUserStatistics tumUserStatistics = new TumUserStatistics();
				tumUserStatistics.setUserId(userId);
				tumUserStatistics.setTotalMoney(money);
				tumUserStatisticsMapper.updateTumUserStatisticsSelectiveByUserId(tumUserStatistics);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}