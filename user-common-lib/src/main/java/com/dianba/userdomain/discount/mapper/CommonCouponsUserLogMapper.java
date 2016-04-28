package com.dianba.userdomain.discount.mapper;

import java.util.List;

import com.dianba.userdomain.discount.entity.CouponsUserLog;
import com.dianba.userdomain.discount.vo.CouponsUserLogVo;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonCouponsUserLogMapper {

	public List<CouponsUserLog> getCouponsUserLogList();

	public PageList<CouponsUserLog> getCouponsUserLogList( PageBounds pageBounds );
	
	public List<CouponsUserLog> getCouponsUserLogPageList( CouponsUserLog couponsUserLog );
	
	public PageList<CouponsUserLog> getCouponsUserLogPageList(CouponsUserLog couponsUserLog, PageBounds pageBounds );
	
	public CouponsUserLog getCouponsUserLogByPrimaryKey(Integer id);
	
	public void createCouponsUserLog(CouponsUserLog couponsUserLog);
	
	public void updateCouponsUserLog(CouponsUserLog couponsUserLog);
	
	public void updateCouponsUserLogSelective(CouponsUserLog couponsUserLog);
	
	public void deleteCouponsUserLog(Integer id);

	/**
	 * 
	 * @param couponsUserLog
	 * @param pageBounds
	 * @return 我的优惠劵查询对象page
	 */
	public List<CouponsUserLogVo> searchCouponsUserLogVos(CouponsUserLog couponsUserLog, PageBounds pageBounds);
	
}