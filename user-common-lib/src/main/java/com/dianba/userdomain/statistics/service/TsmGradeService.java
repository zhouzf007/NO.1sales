package com.dianba.userdomain.statistics.service;

import java.math.BigDecimal;
import java.util.List;

import com.dianba.userdomain.user.entity.TsmGrade;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface TsmGradeService {

	public List<TsmGrade> getTsmGradeList();
	
	public PageList<TsmGrade> getTsmGradeList(PageBounds pageBounds);
	
	public List<TsmGrade> getTsmGradePageList(TsmGrade tsmGrade);
	
	public PageList<TsmGrade> getTsmGradePageList(TsmGrade tsmGrade, PageBounds pageBounds);
	
	public TsmGrade getTsmGradeByPrimaryKey(Long id);
	
	public void createTsmGrade(TsmGrade tsmGrade);
	
	public void createTsmGradeBitch(List<TsmGrade> tsmGradeList);
	
	public void updateTsmGrade(TsmGrade tsmGrade);
	
	public void updateTsmGradeBitch(List<TsmGrade> tsmGradeList);
	
	public void updateTsmGradeSelective(TsmGrade tsmGrade);
	
	public void updateTsmGradeSelectiveBitch(List<TsmGrade> tsmGradeList);
	
	public void deleteTsmGrade(Long id);
	
	public void deleteTsmGradeBitch(List<Long> idList);
	
	public TsmGrade getUserGrade(Long id);
	
	public BigDecimal getmemberSubtractMoney(Long userId, BigDecimal money);
	
	public TsmGrade getUserGradeBytotalRecharge(BigDecimal money);
	
	public BigDecimal getPlatformSubtractMoney(Long userId, Long merchantId ,BigDecimal money ,String saleType);
	
	public BigDecimal getPlatformDiscount(Long userId, Long merchantId ,String saleType);
	
	public TsmGrade getTsmGradeByGrade(Long grade);

	public BigDecimal getNextGradePlatformDiscount(Long grade, Long merchantId);
}