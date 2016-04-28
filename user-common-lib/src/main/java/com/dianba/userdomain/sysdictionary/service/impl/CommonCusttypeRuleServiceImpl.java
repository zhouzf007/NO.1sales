package com.dianba.userdomain.sysdictionary.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.statistics.entity.TumUserStatistics;
import com.dianba.userdomain.statistics.service.TumUserStatisticsService;
import com.dianba.userdomain.sysdictionary.entity.CusttypeRule;
import com.dianba.userdomain.sysdictionary.mapper.CommonCusttypeRuleMapper;
import com.dianba.userdomain.sysdictionary.service.CusttypeRuleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonCusttypeRuleServiceImpl implements CusttypeRuleService {

	@Autowired
	private CommonCusttypeRuleMapper custtypeRuleMapper;

	@Autowired
	private TumUserStatisticsService tumUserStatisticsService;

	public List<CusttypeRule> getCusttypeRuleList() {
		return custtypeRuleMapper.getCusttypeRuleList();
	}

	public PageList<CusttypeRule> getCusttypeRuleList(PageBounds pageBounds) {
		return custtypeRuleMapper.getCusttypeRuleList(pageBounds);
	}

	public List<CusttypeRule> getCusttypeRulePageList(CusttypeRule custtypeRule) {
		return custtypeRuleMapper.getCusttypeRulePageList(custtypeRule);
	}

	public PageList<CusttypeRule> getCusttypeRulePageList(CusttypeRule custtypeRule, PageBounds pageBounds) {
		return custtypeRuleMapper.getCusttypeRulePageList(custtypeRule, pageBounds);
	}

	public CusttypeRule getCusttypeRuleByPrimaryKey(Integer id) {
		return custtypeRuleMapper.getCusttypeRuleByPrimaryKey(id);
	}

	public void createCusttypeRule(CusttypeRule custtypeRule) {
		custtypeRuleMapper.createCusttypeRule(custtypeRule);
	}

	public void createCusttypeRuleBitch(List<CusttypeRule> custtypeRuleList) {
		for (CusttypeRule custtypeRule : custtypeRuleList) {
			custtypeRuleMapper.createCusttypeRule(custtypeRule);
		}
	}

	public void updateCusttypeRule(CusttypeRule custtypeRule) {
		custtypeRuleMapper.updateCusttypeRule(custtypeRule);
	}

	public void updateCusttypeRuleBitch(List<CusttypeRule> custtypeRuleList) {
		for (CusttypeRule custtypeRule : custtypeRuleList) {
			custtypeRuleMapper.updateCusttypeRule(custtypeRule);
		}
	}

	public void updateCusttypeRuleSelective(CusttypeRule custtypeRule) {
		custtypeRuleMapper.updateCusttypeRuleSelective(custtypeRule);
	}

	public void updateCusttypeRuleSelectiveBitch(List<CusttypeRule> custtypeRuleList) {
		for (CusttypeRule custtypeRule : custtypeRuleList) {
			custtypeRuleMapper.updateCusttypeRuleSelective(custtypeRule);
		}
	}

	public void deleteCusttypeRule(Integer id) {
		custtypeRuleMapper.deleteCusttypeRule(id);
	}

	public void deleteCusttypeRuleBitch(List<Integer> idList) {
		for (Integer id : idList) {
			custtypeRuleMapper.deleteCusttypeRule(id);
		}
	}

	@Override
	public CusttypeRule getUserRule(Long userId) {
		TumUserStatistics tum = tumUserStatisticsService.getTumUserStatisticsByUserId(userId);
		List<CusttypeRule> custtypeRules = this.custtypeRuleMapper.getAllCusttypeRule();
		Collections.sort(custtypeRules, new Comparator<CusttypeRule>() {

			@Override
			public int compare(CusttypeRule o1, CusttypeRule o2) {

				return o2.getAmount() - o1.getAmount();
			}

		});
		if (tum != null && tum.getTotalMoney() > 0) {
			for (CusttypeRule usergrade : custtypeRules) {
				if (usergrade.getAmount() <= tum.getTotalMoney()) {
					return usergrade;
				}
			}
		}
		return new CusttypeRule();
	}
}