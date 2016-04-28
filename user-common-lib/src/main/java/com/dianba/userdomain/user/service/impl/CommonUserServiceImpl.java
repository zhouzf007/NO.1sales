package com.dianba.userdomain.user.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.commons.exception.core.AssertCore;
import com.dianba.userdomain.constant.SmsValidType;
import com.dianba.userdomain.discount.entity.TomMerchantMemberDiscount;
import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.dianba.userdomain.discount.service.TomMerchantMemberDiscountService;
import com.dianba.userdomain.discount.service.TomMerchantMemberInfoService;
import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.order.entity.Flow;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.service.OrderService;
import com.dianba.userdomain.statistics.entity.TumUserStatistics;
import com.dianba.userdomain.statistics.service.TsmGradeService;
import com.dianba.userdomain.statistics.service.TumUserStatisticsService;
import com.dianba.userdomain.sysdictionary.entity.CusttypeRule;
import com.dianba.userdomain.sysdictionary.service.CusttypeRuleService;
import com.dianba.userdomain.sysdictionary.service.FlowService;
import com.dianba.userdomain.user.entity.TsmGrade;
import com.dianba.userdomain.user.entity.User;
import com.dianba.userdomain.user.mapper.CommonUserMapper;
import com.dianba.userdomain.user.service.UserService;
import com.dianba.userdomain.util.AliOcsMemcachedUtil;
import com.dianba.userdomain.util.ListUtil;
import com.dianba.userdomain.util.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonUserServiceImpl implements UserService {


	@Autowired
	private TsmGradeService tsmGradeService;
	
	@Autowired
	private MerchantService merchantService;
	
	@Autowired
	private TomMerchantMemberInfoService tomMerchantMemberInfoService;

	@Autowired
	private TomMerchantMemberDiscountService tomMerchantMemberDiscountService;

	@Autowired
	private CusttypeRuleService custtypeRuleService;
	
	@Autowired
	private FlowService flowService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TumUserStatisticsService tumUserStatisticsService;
	
    @Autowired 
    private CommonUserMapper userMapper;

	public void userPhotoUrlUpdate(long userId, String newPhotoUrl) {
		User o = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(o);
		o.setPhotourl(newPhotoUrl);
		updateUser(o);
	}

	@Override
	public void usernickNameUpdate(long userId, String nickName) {
		User o = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(o);
		o.setNickname(nickName);
		updateUser(o);
	}
	
	@Override
	public void userPasswordUpdate(long userId, String oldPassword, String newPassword) {
		User o = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(o);
		if (!StringUtil.empty(o.getPassword())) {
			AssertCore.G9012.isTrue(!StringUtil.isEmpty(oldPassword));
			AssertCore.G9013.isTrue(oldPassword.equals(o.getPassword()));//密码验证
		}
	    o.setPassword(newPassword);
		updateUserSelective(o);
	}
	
	@Override
	public void updateUserMobile(long userId, String mobile, String validCode) {
		User o = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(o);
		SmsValidType type = SmsValidType.getByName("bind");
		String validCodeCache = AliOcsMemcachedUtil.getCache(mobile + "_" + type.toString() + "_valid");
		AssertCore.G9015.isTrue(validCodeCache.equals(validCode));// 校验验证码
		AliOcsMemcachedUtil.deleteCache(mobile + "_" + type + "_valid");// 删除缓存
		o.setMobile(mobile);
		updateUserSelective(o);
	}
	
	@Override
	public Map<String, Object> getUserInfo(long userId) {
		User user = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(user);
		if (StringUtil.isNotEmpty(user.getPassword())) {
			user.setIsHavePassword("Y");
		} else {
			user.setIsHavePassword("N");
		}
		// 构建出参
		Map<String, Object> rtMap = new HashMap<String, Object>();
		rtMap.put("id", user.getId());
		rtMap.put("userName", user.getUsername());
		rtMap.put("nickName", user.getNickname());
		rtMap.put("isHavePassword", user.getIsHavePassword());
		rtMap.put("sex", user.getGender());
		rtMap.put("mobile", user.getMobile());
		rtMap.put("photoUrl", user.getPhotourl());
		rtMap.put("money", user.getMoney());
		rtMap.put("score", user.getScore());
		rtMap.put("openId", user.getOpenid());
		rtMap.put("unionId", user.getUnionid());
		return rtMap;
	}
	
	@Override
	public Map<String, Object> getUserBaseInfo(long userId) {
		User user = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(user);
		TsmGrade tsmGrade = tsmGradeService.getUserGrade(user.getId());
		CusttypeRule custtypeRule = custtypeRuleService.getUserRule(user.getId());
		String Grade = custtypeRule.getTypeName();
		String desc = custtypeRule.getTypeDesc();
		if (StringUtil.isNotEmpty(user.getPassword())) {
			user.setIsHavePassword("Y");
		} else {
			user.setIsHavePassword("N");
		}
		// 构建出参
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", user.getId());
		map.put("photoUrl", user.getPhotourl());
		map.put("nickName", user.getNickname());
		map.put("score", user.getScore());
		map.put("grade", Grade);// 要关联表
		map.put("gradeDesc", desc);
		map.put("money", user.getMoney());
		map.put("mobile", user.getMobile());
		map.put("rechargeGrade", tsmGrade.getGrade());// 会员充值等级
		map.put("icon", tsmGrade.getIcon());// 会员等级图标url(大图标)
		map.put("vipIcon", tsmGrade.getVipIcon());// 会员充值等级图标(小图标)
		map.put("rechargeGradeName", tsmGrade.getGradeName());// 会员等级名称
		map.put("isHavePassword", user.getIsHavePassword());
		return map;
	}
	
	@Override
	public Map<String, Object> getUserMoney(long userId) {
		User user = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(user);
		TsmGrade tsmGrade = tsmGradeService.getUserGrade(user.getId());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", user.getId());// 用户ID
		map.put("money", user.getMoney());// 用户余额
		map.put("rechargeGrade", tsmGrade.getGrade());// 会员等级
		map.put("rechargeGradeName", tsmGrade.getGradeName());// 会员称号
		map.put("minRecharge", tsmGrade.getMinRecharge());// 当前等级最低充值金额
		map.put("warnLine", "");// 黄条警告
		if (tsmGrade.getMinRecharge() != 0) {
			map.put("warnLine", String.format("首次充值满%s元，即可终生享受平台会员折扣价", tsmGrade.getMinRecharge().toString()));// 黄条警告
		}
		map.put("icon", tsmGrade.getIcon());// 会员大图标
		map.put("vipIcon", tsmGrade.getVipIcon());// 会员小图标
		return map;
	}
	
	@Override


    public List<User> getUserList() {
        return userMapper.getUserList();
    }
   
	public PageList<User> getUserList(PageBounds pageBounds) {
		return userMapper.getUserList(pageBounds);
	}

	public List<User> getUserPageList(User user) {
		return userMapper.getUserPageList(user);
	}

	public PageList<User> getUserPageList(User user, PageBounds pageBounds) {
		return userMapper.getUserPageList(user, pageBounds);
	}

	public User getUserByPrimaryKey(Long id) {
		try{
			return userMapper.getUserByPrimaryKey(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Integer hasUserById(Long id){
	    return userMapper.hasUserById(id);
	}

	public void createUser(User user) {
		userMapper.createUser(user);
	}

	public void createUserBitch(List<User> userList) {
		for (User user : userList) {
			userMapper.createUser(user);
		}
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public void updateUserBitch(List<User> userList) {
		for (User user : userList) {
			userMapper.updateUser(user);
		}
	}

    public int updateUserSelective(User user) {
        return userMapper.updateUserSelective(user);
    }

	public void updateUserSelectiveBitch(List<User> userList) {
		for (User user : userList) {
			userMapper.updateUserSelective(user);
		}
	}

	public void deleteUser(Long id) {
		userMapper.deleteUser(id);
	}

	public void deleteUserBitch(List<Long> idList) {
		for (Long id : idList) {
			userMapper.deleteUser(id);
		}
	}

	
	public void updateUserScore(Map<String, Object> map) {
		try{
			userMapper.updateUserScore(map);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Object> getUserMerchantMemberInfo(long userId) {
		User user = getUserByPrimaryKey(userId);
		Map<String, Object> rtmap = new HashMap<String, Object>();
		if (user != null) {
			TsmGrade tsmGrade = tsmGradeService.getUserGrade(userId);
			Map<String, Object> mmp = new HashMap<String, Object>();
			if (tsmGrade != null) {
				mmp.put("grade", tsmGrade.getGrade());// 会员等级
				mmp.put("balance", user.getMoney());
				mmp.put("icon", tsmGrade.getIcon());
				mmp.put("grdeName", tsmGrade.getGradeName());
				mmp.put("userId", user.getId());
			}
			TomMerchantMemberInfo tomMerchantMemberInfo = new TomMerchantMemberInfo();
			tomMerchantMemberInfo.setUserId((int)userId);
			List<TomMerchantMemberInfo> list = tomMerchantMemberInfoService
					.getTomMerchantMemberInfoPageList(tomMerchantMemberInfo);
			List<Map<String, Object>> merchantList = new ArrayList<Map<String, Object>>();
			if (ListUtil.isNotNullOrEmpty(list)) {
				for (TomMerchantMemberInfo tmmi : list) {
					Map<String, Object> map = new HashMap<String, Object>();
					tmmi.getMerchantId();
					TomMerchantMemberDiscount tomMerchantMemberDiscount = new TomMerchantMemberDiscount();
					tomMerchantMemberDiscount.setMerchantId(tmmi.getMerchantId());
					List<TomMerchantMemberDiscount> tmmdList = tomMerchantMemberDiscountService
							.getTomMerchantMemberDiscountPageList(tomMerchantMemberDiscount);
					if (ListUtil.isNotNullOrEmpty(tmmdList)) {
						tomMerchantMemberDiscount = tmmdList.get(0);
						map.put("merchantDiscount", tomMerchantMemberDiscount.getMerchantDiscount());
					}
					Merchant merchant = new Merchant();
					merchant.setId(tmmi.getMerchantId());
					List<Merchant> merchantList2 = merchantService.getMerchantPageList(merchant);
					if (ListUtil.isNotNullOrEmpty(merchantList2)) {
						merchant = merchantList2.get(0);
						map.put("merchantTitle", merchant.getTitle());
						map.put("merchantLogoUrl", merchant.getLogoUrl());
					}
					BigDecimal bdcm = new BigDecimal("100");
					BigDecimal userInMerchantMoney = new BigDecimal(tmmi.getMoney()).divide(bdcm).setScale(2,
							BigDecimal.ROUND_HALF_UP); // 转换为元
					map.put("money", userInMerchantMoney);
					map.put("merchantId", tmmi.getMerchantId());
					merchantList.add(map);
				}
			}
			rtmap.put("userMap", mmp);
			rtmap.put("merchantList", merchantList);
		}
		return rtmap;
	}

	@Override
	public Map<String, Object> getUserPlatfromMemberInfo(long userId, String merchantId) {
		Map<String, Object> map=new HashMap<>();
		User user = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(user);
		// 用户余额信息
		map.put("userMoney",user.getMoney());
		// 用户会员等级信息
		if (merchantId != "" && merchantId != null) {
			map.putAll(getUserPlatfromMemberInfoFromMerchant(userId, merchantId));
		} else {
			map.putAll(getUserPlatfromMemberInfoFromMy(userId));
		}
		// 充值金额面额
		map.putAll(getRechargeDenomination());
		return map;
	}
	
	private Map<String, Object> getRechargeDenomination() {
		Map<String, Object> map = new HashMap<>();
		String rechargeDenomination[] = { "100", "200", "500", "1000", "2000", "4000" };
		map.put("rechargeDenomination", rechargeDenomination);
		return map;
	}
	
	/**
	 * 用户平台会员信息(我的模块进入)
	 * 
	 * @param userId
	 * @return
	 * @author chenweihong
	 * @date 2016年3月22日 下午3:28:15
	 */
	private Map<String, Object> getUserPlatfromMemberInfoFromMy(long userId) {
		Map<String, Object> map = new HashMap<>();

		// 用户当前会员等级
		TsmGrade tsmGrade = tsmGradeService.getUserGrade(userId);
		Long userGrade = StringUtil.parseLong(tsmGrade.getGrade());

		// 提示语
		String reminder = "";// 提示语
		TsmGrade userNextGrade = tsmGradeService.getTsmGradeByGrade(userGrade + 1);
		if (userNextGrade != null) {
			TumUserStatistics tumUserStatistics = tumUserStatisticsService
					.getTumUserStatisticsByUserId(userId);
			BigDecimal nextTotalRecharge = new BigDecimal(userNextGrade.getTotalRecharge());
			BigDecimal totalRecharge = new BigDecimal(tumUserStatistics.getTotalRecharge()).divide(new BigDecimal(100));
			BigDecimal needRechargeMoney = nextTotalRecharge.subtract(totalRecharge).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			reminder = "再充值" + needRechargeMoney + "元升级至" + userNextGrade.getGradeName();
		}
		map.put("reminder", reminder);// 提示语
		map.put("icon", tsmGrade.getIcon());// 会员大图标
		return map;
	}
	
	/**
	 * 用户平台会员信息(店铺进入)
	 * 
	 * @param userId
	 * @param merchantId
	 * @return
	 * @author chenweihong
	 * @date 2016年3月22日 下午3:28:15
	 */
	private Map<String, Object> getUserPlatfromMemberInfoFromMerchant(long userId, String merchantId) {
		Map<String, Object> map = new HashMap<>();

		// 用户当前会员等级
		TsmGrade tsmGrade = tsmGradeService.getUserGrade(userId);
		Long userGrade = StringUtil.parseLong(tsmGrade.getGrade());

		// 用户平台会员外卖类折扣
		BigDecimal platformDiscount = tsmGradeService
				.getPlatformDiscount(userId, StringUtil.parseLong(merchantId), "0")
				.multiply(new BigDecimal(10));// 会员折扣

		// 提示语
		String reminder = "";// 提示语
		TsmGrade userNextGrade = tsmGradeService.getTsmGradeByGrade(userGrade + 1);
		if (userNextGrade != null) {
			TumUserStatistics tumUserStatistics = tumUserStatisticsService
					.getTumUserStatisticsByUserId(userId);
			BigDecimal nextTotalRecharge = new BigDecimal(userNextGrade.getTotalRecharge());
			BigDecimal totalRecharge = new BigDecimal(tumUserStatistics.getTotalRecharge()).divide(new BigDecimal(100));
			BigDecimal needRechargeMoney = nextTotalRecharge.subtract(totalRecharge).setScale(2,
					BigDecimal.ROUND_HALF_UP);
			BigDecimal nextPlatformDiscount = tsmGradeService.getNextGradePlatformDiscount(userGrade + 1,
					StringUtil.parseLong(merchantId));
			reminder = "再充值" + needRechargeMoney + "元升级" + userNextGrade.getGradeName() + "，尊享" + nextPlatformDiscount
					+ "折优惠";
		}
		if (!tsmGrade.getGrade().equals("0")) {
			if (platformDiscount.compareTo(new BigDecimal("0")) == 0
					|| platformDiscount.compareTo(new BigDecimal("10")) == 0) {
				reminder = "";
			}
		}
		map.put("reminder", reminder);// 提示语
		map.put("platformDiscount", platformDiscount);// 会员折扣
		map.put("icon", tsmGrade.getIcon());// 会员大图标
		return map;
	}

	@Override
	public List<Map<String, Object>> getUserMoneyDetail(long userId, PageBounds pageBounds) {
		List<Flow> list = flowService.getFlowPageListByUserId(userId, pageBounds);
		List<Map<String, Object>> userMoneyDetailList=new ArrayList<Map<String, Object>>();
		if (ListUtil.isNotNullOrEmpty(list)) {
			BigDecimal bg = new BigDecimal(0);
			for (Flow f : list) {
				if (f.getMoney().compareTo(bg) == 1) {
					Map<String, Object> map = new HashMap<String, Object>();
					Long time = f.getCreateTime() * 1000L;
					Date date = new Date(time);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String createTime = sdf.format(date);
					BigDecimal preMoney = new BigDecimal(0).setScale(2);
					BigDecimal postMoney = new BigDecimal(0).setScale(2);
					if (f.getPreMoney() != null) {
						preMoney = f.getPreMoney().setScale(2, BigDecimal.ROUND_HALF_UP);
					}
					if (f.getPostMoney() != null) {
						postMoney = f.getPostMoney().setScale(2, BigDecimal.ROUND_HALF_UP);
					}
					String action = f.getAction();
					Order order = orderService.getOrderByPrimaryKey(f.getDetailId());
					Merchant merchant = merchantService
							.getMerchantByPrimaryKey(StringUtil.parseLong(order.getMerchantId().toString()));
					String merchantTitle = merchant.getTitle();
					if (merchantTitle.length() > 7) {
						merchantTitle = merchantTitle.substring(0, 7) + "...";
					}
					if (f.getAction().equals("buy")) {
						action = "平台会员卡 消费";
					} else if (f.getAction().equals("income")) {
						action = "平台会员卡 收入";
					} else if (f.getAction().equals("recharge")) {
						action = "平台会员卡 充值";
					} else if (f.getAction().equals("orderIncome")) {
						action = "商家订单收入";
					} else if (f.getAction().equals("transfer")) {
						action = "转账";
					} else if (f.getAction().equals("refund")) {
						action = "平台会员卡 退款";
					} else if (f.getAction().equals("deduct")) {
						action = "快递员提成";
					} else if (f.getAction().equals("merchantRebate")) {
						action = "商家返点收入";
					} else if (f.getAction().equals("courierRebate")) {
						action = "快递员返点";
					} else if (f.getAction().equals("merchantRecharge")) {

						action = merchantTitle + " 充值";
					} else if (f.getAction().equals("merchantrefund")) {
						action = merchant.getTitle() + " 退款";
					} else if (f.getAction().equals("merchantBuy")) {
						action = merchant.getTitle() + " 消费";
					}
					map.put("detail", f.getDetail());// 说明
					map.put("money", f.getMoney());// 当前操作涉及金额
					map.put("action", action);// '类型：buy为购买，income为收入，recharge
												// 充值，orderIncome
												// 商家订单收入，transfer
												// 转账，refund退款，deduct快递员提成',
					map.put("createTime", createTime);// 创建时间
					map.put("type", f.getType());// 类型 '收入（income）或支出（pay）',
					map.put("preMoney", preMoney);// 操作前余额
					map.put("postMoney", postMoney);// 操作后金额
					map.put("id", f.getId());
					userMoneyDetailList.add(map);
				}
			}
		}
		return userMoneyDetailList;
	}

	@Override
	public Map<String, Object> getUserRechargeGradeInfo(long userId) {
		User user = getUserByPrimaryKey(userId);
		AssertCore.G7015.notNull(user);
		Map<String, Object> map = new HashMap<String, Object>();
		List<TsmGrade> tsmGradeList = new ArrayList<TsmGrade>();
		tsmGradeList = tsmGradeService.getTsmGradeList();
		map.put("tsmGradeList", tsmGradeList);
		TsmGrade tsmGrade = tsmGradeService.getUserGrade(userId);
		map.put("userId", userId);// 用户ID
		map.put("tsmGradeId", tsmGrade.getId());// 对应会员等级ID
		map.put("rechargeGrade", tsmGrade.getGrade());// 会员等级
		map.put("rechargeGradeName", tsmGrade.getGradeName());// 会员称号
		if ("0".equals(tsmGrade.getGrade())) {
			map.put("minRecharge", 100);// 当前等级最低充值金额
			map.put("warnLine", String.format("首次充值满%s元，即可终生享受平台会员折扣价", tsmGrade.getMinRecharge().toString()));// 黄条警告
		} else {
			map.put("warnLine", "");// 黄条警告
			map.put("minRecharge", 0);// 当前等级最低充值金额
		}
		map.put("totalRecharge", tsmGrade.getTotalRecharge());// 等级对应所需的累计充值金额
		map.put("discount", tsmGrade.getDiscount());// '折扣:0-100，对应单位:%'
		map.put("maxDiscount", tsmGrade.getMaxDiscount());// '最大打折金额，对应单位:元'
		map.put("icon", tsmGrade.getIcon());// 会员大图标
		map.put("vipIcon", tsmGrade.getVipIcon());// 会员小图标
		return map;
	}
}