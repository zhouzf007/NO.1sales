package com.dianba.userdomain.discount.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.discount.entity.CouponsUserLog;
import com.dianba.userdomain.discount.mapper.CommonCouponsUserLogMapper;
import com.dianba.userdomain.discount.service.CouponsUserLogService;
import com.dianba.userdomain.discount.vo.CouponsUserLogVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional 
public class CommonCouponsUserLogServiceImpl implements CouponsUserLogService { 

    @Autowired
	private CommonCouponsUserLogMapper couponsUserLogMapper;
	
	public List<CouponsUserLog> getCouponsUserLogList(){
		return couponsUserLogMapper.getCouponsUserLogList();
	}
	
	public PageList<CouponsUserLog> getCouponsUserLogList(PageBounds pageBounds){
		return couponsUserLogMapper.getCouponsUserLogList(pageBounds);
	}
	
	public List<CouponsUserLog> getCouponsUserLogPageList(CouponsUserLog couponsUserLog){
		return couponsUserLogMapper.getCouponsUserLogPageList(couponsUserLog);
	}
	
	public PageList<CouponsUserLog> getCouponsUserLogPageList(CouponsUserLog couponsUserLog, PageBounds pageBounds){
		return couponsUserLogMapper.getCouponsUserLogPageList(couponsUserLog,pageBounds);
	}
	
	public CouponsUserLog getCouponsUserLogByPrimaryKey(Integer id){
		return couponsUserLogMapper.getCouponsUserLogByPrimaryKey(id);
	}
	
	public void createCouponsUserLog(CouponsUserLog couponsUserLog){
		couponsUserLogMapper.createCouponsUserLog(couponsUserLog);
	}
	
	public void createCouponsUserLogBitch(List<CouponsUserLog> couponsUserLogList){
		for( CouponsUserLog couponsUserLog : couponsUserLogList ) {
			couponsUserLogMapper.createCouponsUserLog(couponsUserLog);
		}
	}
	
	public void updateCouponsUserLog(CouponsUserLog couponsUserLog){
		couponsUserLogMapper.updateCouponsUserLog(couponsUserLog);
	}
	
	public void updateCouponsUserLogBitch(List<CouponsUserLog> couponsUserLogList){
	    for( CouponsUserLog couponsUserLog : couponsUserLogList ) {
		    couponsUserLogMapper.updateCouponsUserLog(couponsUserLog);
		}
	}
	
	public void updateCouponsUserLogSelective(CouponsUserLog couponsUserLog){
	    couponsUserLogMapper.updateCouponsUserLogSelective(couponsUserLog);
	}
	
	public void updateCouponsUserLogSelectiveBitch(List<CouponsUserLog> couponsUserLogList){
	    for( CouponsUserLog couponsUserLog : couponsUserLogList ) {
		    couponsUserLogMapper.updateCouponsUserLogSelective(couponsUserLog);
		}
	}
	
	public void deleteCouponsUserLog(Integer id){
		couponsUserLogMapper.deleteCouponsUserLog(id);
	}
	
	public void deleteCouponsUserLogBitch(List<Integer> idList){
		for( Integer id : idList ) {
			couponsUserLogMapper.deleteCouponsUserLog(id);
		}
	}

	@Override
	public List<CouponsUserLogVo> searchCouponsUserLogVos(CouponsUserLog couponsUserLog, PageBounds pageBounds) {
		return couponsUserLogMapper.searchCouponsUserLogVos(couponsUserLog, pageBounds);
	}

}