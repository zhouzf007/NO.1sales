package com.dianba.userdomain.sysdictionary.mapper;

import java.util.List;

import com.dianba.userdomain.sysdictionary.entity.CusttypeRule;
import com.dianba.web.repository.MyBatisRepository;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@MyBatisRepository
public interface CommonCusttypeRuleMapper {

	public List<CusttypeRule> getCusttypeRuleList();

	public PageList<CusttypeRule> getCusttypeRuleList( PageBounds pageBounds );
	
	public List<CusttypeRule> getCusttypeRulePageList( CusttypeRule custtypeRule );
	
	public PageList<CusttypeRule> getCusttypeRulePageList(CusttypeRule custtypeRule, PageBounds pageBounds );
	
	public CusttypeRule getCusttypeRuleByPrimaryKey(Integer id);
	
	public void createCusttypeRule(CusttypeRule custtypeRule);
	
	public void updateCusttypeRule(CusttypeRule custtypeRule);
	
	public void updateCusttypeRuleSelective(CusttypeRule custtypeRule);
	
	public void deleteCusttypeRule(Integer id);
	
	public List<CusttypeRule> getAllCusttypeRule();
}