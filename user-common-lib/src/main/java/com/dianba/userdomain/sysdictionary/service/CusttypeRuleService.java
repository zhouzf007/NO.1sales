package com.dianba.userdomain.sysdictionary.service;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.CusttypeRule;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface CusttypeRuleService {

	public List<CusttypeRule> getCusttypeRuleList();
	
	public PageList<CusttypeRule> getCusttypeRuleList(PageBounds pageBounds);
	
	public List<CusttypeRule> getCusttypeRulePageList(CusttypeRule custtypeRule);
	
	public PageList<CusttypeRule> getCusttypeRulePageList(CusttypeRule custtypeRule, PageBounds pageBounds);
	
	public CusttypeRule getCusttypeRuleByPrimaryKey(Integer id);
	
	public void createCusttypeRule(CusttypeRule custtypeRule);
	
	public void createCusttypeRuleBitch(List<CusttypeRule> custtypeRuleList);
	
	public void updateCusttypeRule(CusttypeRule custtypeRule);
	
	public void updateCusttypeRuleBitch(List<CusttypeRule> custtypeRuleList);
	
	public void updateCusttypeRuleSelective(CusttypeRule custtypeRule);
	
	public void updateCusttypeRuleSelectiveBitch(List<CusttypeRule> custtypeRuleList);
	
	public void deleteCusttypeRule(Integer id);
	
	public void deleteCusttypeRuleBitch(List<Integer> idList);

	public CusttypeRule getUserRule(Long id);

}