package com.dianba.userdomain.discount.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianba.commons.exception.core.AssertCore;
import com.dianba.userdomain.discount.entity.TomMerchantMemberDiscount;
import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.dianba.userdomain.discount.service.DiscountService;
import com.dianba.userdomain.discount.service.TomMerchantMemberDiscountService;
import com.dianba.userdomain.discount.service.TomMerchantMemberInfoService;
import com.dianba.userdomain.statistics.service.TsmGradeService;
import com.dianba.userdomain.user.entity.TsmGrade;
import com.dianba.userdomain.user.entity.User;
import com.dianba.userdomain.user.service.UserService;
import com.dianba.userdomain.util.StringUtil;

@Service
public class CommonDiscountServiceImpl implements DiscountService{

	@Autowired
	private UserService userService ;
	@Autowired
	private TsmGradeService tsmGradeService ;
	@Autowired
	private TomMerchantMemberDiscountService tomMerchantMemberDiscountService ;
	
	@Autowired
	private TomMerchantMemberInfoService tomMerchantMemberInfoService ;
	
	@Override
	public Map<String, Object> getMemberSubtractMoney(long userId, String money, String merchantId, String saleType) {
		User user = userService.getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(user);
		Map<String, Object> map = new HashMap<String, Object>();
			BigDecimal platformDiscount = tsmGradeService.getPlatformDiscount(userId,
					StringUtil.parseLong(merchantId), saleType);
			BigDecimal platformSubtractMoney = tsmGradeService.getPlatformSubtractMoney(user.getId(),
					StringUtil.parseLong(merchantId), new BigDecimal(money), saleType);
			BigDecimal merchantSubtractMoney = tomMerchantMemberDiscountService
					.getMerchantSubtractMoney(StringUtil.parseLong(merchantId), new BigDecimal(money));
			TomMerchantMemberDiscount tomMerchantMemberDiscount = tomMerchantMemberDiscountService
					.isMerchantSetDiscount(StringUtil.parseLong(merchantId));
			TomMerchantMemberInfo tomMerchantMemberInfo = tomMerchantMemberInfoService
					.isMemberOfMerchant(userId, StringUtil.parseLong(merchantId));
			int isMerchantAduit = 1;
			TsmGrade tsmGrade = tsmGradeService.getUserGrade(userId);
			map.put("platformSubtractMoney", platformSubtractMoney);// 平台会员打折减去的金额
			map.put("platformDiscount", platformDiscount);// 平台会员折扣
			map.put("merchantSubtractMoney", merchantSubtractMoney);// 商家会员打折减去的金额
			map.put("isMerchantAduit", isMerchantAduit);// 商家设置平台会员是否通过（平台会员卡是否显示条件1）
			String userGrade = tsmGrade.getGrade();// 平台会员卡是否显示2 等级 =0不显示
			map.put("tomMerchantMemberDiscount", tomMerchantMemberDiscount);// 商家是否设置会员折扣
																			// （null=不是）(决定商家会员卡是否显示条件1)
			map.put("tomMerchantMemberInfo", tomMerchantMemberInfo);// 用户是否是该商家会员
																	// （null=不是）(在1条件=1的情况下决定商家会员卡是否显示条件2)
			map.put("userId", user.getId());
			return map;
	}

}
