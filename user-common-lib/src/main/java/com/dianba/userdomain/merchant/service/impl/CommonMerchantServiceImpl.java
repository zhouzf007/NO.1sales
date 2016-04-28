package com.dianba.userdomain.merchant.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.commons.exception.core.AssertCore;
import com.dianba.commons.exception.lang.Assert;
import com.dianba.userdomain.constant.Const;
import com.dianba.userdomain.discount.entity.TomMerchantMemberDiscount;
import com.dianba.userdomain.discount.entity.TomMerchantMemberInfo;
import com.dianba.userdomain.discount.service.TomMerchantMemberDiscountService;
import com.dianba.userdomain.discount.service.TomMerchantMemberInfoService;
import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.merchant.entity.MerchantInfo;
import com.dianba.userdomain.merchant.mapper.CommonMerchantMapper;
import com.dianba.userdomain.merchant.service.MerchantInfoService;
import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.merchant.vo.MerchantClassificationVo;
import com.dianba.userdomain.user.service.UserService;
import com.dianba.userdomain.util.ListUtil;
import com.dianba.userdomain.util.StringUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonMerchantServiceImpl implements MerchantService {

	@Autowired
	private CommonMerchantMapper merchantMapper;
	
	@Autowired
	private TomMerchantMemberDiscountService tomMerchantMemberDiscountService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MerchantInfoService merchantInfoService;
	
	@Autowired
	private TomMerchantMemberInfoService tomMerchantMemberInfoService;

	public List<Merchant> getMerchantList() {
		return merchantMapper.getMerchantList();
	}

	public PageList<Merchant> getMerchantList(PageBounds pageBounds) {
		return merchantMapper.getMerchantList(pageBounds);
	}

	public List<Merchant> getMerchantPageList(Merchant merchant) {
		return merchantMapper.getMerchantPageList(merchant);
	}

	public PageList<Merchant> getMerchantPageList(Merchant merchant, PageBounds pageBounds) {
		return merchantMapper.getMerchantPageList(merchant, pageBounds);
	}

	public Merchant getMerchantByPrimaryKey(Long id) {
		return merchantMapper.getMerchantByPrimaryKey(id);
	}

	public void createMerchant(Merchant merchant) {
		merchantMapper.createMerchant(merchant);
	}

	public void createMerchantBitch(List<Merchant> merchantList) {
		for (Merchant merchant : merchantList) {
			merchantMapper.createMerchant(merchant);
		}
	}

	public void updateMerchant(Merchant merchant) {
		merchantMapper.updateMerchant(merchant);
	}

	public void updateMerchantBitch(List<Merchant> merchantList) {
		for (Merchant merchant : merchantList) {
			merchantMapper.updateMerchant(merchant);
		}
	}

	public void updateMerchantSelective(Merchant merchant) {
		merchantMapper.updateMerchantSelective(merchant);
	}

	public void updateMerchantSelectiveBitch(List<Merchant> merchantList) {
		for (Merchant merchant : merchantList) {
			merchantMapper.updateMerchantSelective(merchant);
		}
	}

	public void deleteMerchant(Long id) {
		merchantMapper.deleteMerchant(id);
	}

	public void deleteMerchantBitch(List<Long> idList) {
		for (Long id : idList) {
			merchantMapper.deleteMerchant(id);
		}
	}

	@Override
	public String getMerchantTitle(Long id) {
		return merchantMapper.getMerchantTitle(id);
	}

	public List<MerchantClassificationVo> getUserFavourite(Map<String, Object> map) {
		return merchantMapper.getUserFavourite(map);
	}

	/**
	 *
	 *
	 * @param merchantId
	 * @param latitude
	 * @param longitude
	 * @return 0 : 可以使用 , 1 : 超出配送范围 , 2 : 用户地址无效
	 * @author zhoucong
	 * @date 2016年4月20日 下午6:21:54
	 */
	public int deliverable(long merchantId, BigDecimal latitude, BigDecimal longitude) {
		int result = 0;
		if (latitude == null || longitude == null) {
			result = 2;// 用户地址无效
		} else if (doDeliverable(merchantId, longitude.doubleValue(), latitude.doubleValue())) {
			result = 0; // 可配送地址
		} else {
			result = 1;// 超出配送范围
		}
		return result;
	}

	private boolean doDeliverable(long merchantId, double longitude, double latitude) {
		Merchant merchant = getMerchantByPrimaryKey(merchantId);
		AssertCore.G9011.notNull(merchant);
		double long2 = new Double(merchant.getLongitude().toString());
		double lat2 = new Double(merchant.getLatitude().toString());
		if (getDistance(longitude, latitude, long2, lat2) <= Const.PRECISION *100*1000) {
			return true;
		}
		return false;
	}

	public double getDistance(double long1, double lat1, double long2, double lat2) {
		double a, b, R;
		R = 6378137; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
		return d;
	}

	@Override
	public Map<String, Object> getUserMerchantMember(String merchantId, String userId) {
			Map<String, Object> map = new HashMap<>();
			Merchant merchant =getMerchantByPrimaryKey(StringUtil.parseLong(merchantId));
			Assert.dataNotFound(merchant);
			int isOpenMerchantMember = 0;// 是否开设商家会员 0=不是 1=是
			TomMerchantMemberDiscount tomMerchantMemberDiscount = new TomMerchantMemberDiscount();
			tomMerchantMemberDiscount.setMerchantId(StringUtil.parseInt(merchantId));
			List<TomMerchantMemberDiscount> tmmdList = tomMerchantMemberDiscountService
					.getTomMerchantMemberDiscountPageList(tomMerchantMemberDiscount);
			BigDecimal merchantDiscount = new BigDecimal(0);
			if (ListUtil.isNotNullOrEmpty(tmmdList)) {
				tomMerchantMemberDiscount = tmmdList.get(0);
				if (tomMerchantMemberDiscount.getMerchantDiscount() != null
						&& tomMerchantMemberDiscount.getMerchantDiscount() != "") {
					merchantDiscount = new BigDecimal(tomMerchantMemberDiscount.getMerchantDiscount())
							.divide(new BigDecimal(10));
					isOpenMerchantMember = 1;
				}
			}
			// 提示语
			String msg = "";
			if (isOpenMerchantMember != 1) {
				msg = "该商家暂时没有招募会员噢";
			}
			// tom_merchant_member_info
			BigDecimal userMerchantMemberMoney = new BigDecimal(0);
			TomMerchantMemberInfo tomMerchantMemberInfo = new TomMerchantMemberInfo();
			tomMerchantMemberInfo.setMerchantId(StringUtil.parseInt(merchantId));
			tomMerchantMemberInfo.setUserId(StringUtil.parseInt(userId));
			List<TomMerchantMemberInfo> tmmiList = tomMerchantMemberInfoService
					.getTomMerchantMemberInfoPageList(tomMerchantMemberInfo);
			if (ListUtil.isNotNullOrEmpty(tmmiList)) {
				tomMerchantMemberInfo = tmmiList.get(0);
				userMerchantMemberMoney = new BigDecimal(tomMerchantMemberInfo.getMoney()).divide(new BigDecimal(100))
						.setScale(2, BigDecimal.ROUND_HALF_UP); // 转换为元
			}
			map.put("msg", msg);
			map.put("isOpenMerchantMember", isOpenMerchantMember);
			map.put("merchantDiscount", merchantDiscount);
			map.put("merchantLogoUrl", merchant.getLogoUrl());
			map.put("merchantTitle", merchant.getTitle());
			map.put("userMerchantMemberMoney", userMerchantMemberMoney);
			return map;
	}

	@Override
	public Map<String, Object> getMerchantMemberInfo(String merchantId, long userId) {
		Map<String, Object> map = new HashMap<>();
		// 用户信息
		map.putAll(userService.getUserInfo(userId));
		// 商家信息
		map.putAll(getUserMerchantMember(merchantId,String.valueOf(userId)));
		// 充值金额面额
		map.putAll(getRechargeDenomination());
		// 商家来源
		map.putAll(getMerchantSource(merchantId));
		return map;
	}
	
	private Map<String, Object> getMerchantSource(String merchantId) {
		Map<String, Object> map = new HashMap<>();
		List<MerchantInfo> list = merchantInfoService.MerchantInfoList(StringUtil.parseInt(merchantId));
		if (ListUtil.isNotNullOrEmpty(list)) {
			MerchantInfo merchantInfo = list.get(0);
			int merchantSource = Integer.parseInt(merchantInfo.getMerchantSource());
			map.put("merchantSource", merchantSource);
		}
		return map;
	}
	
	/**
	 * 充值金额面额
	 * 
	 * @return
	 * @author chenweihong
	 * @date 2016年3月22日 下午3:32:09
	 */
	private Map<String, Object> getRechargeDenomination() {
		Map<String, Object> map = new HashMap<>();
		String rechargeDenomination[] = { "100", "200", "500", "1000", "2000", "4000" };
		map.put("rechargeDenomination", rechargeDenomination);
		return map;
	}

	@Override
	public List<MerchantClassificationVo> getUserFavourite(Map<String, Object> map, PageBounds pageBounds) {
		return merchantMapper.getUserFavourite(map, pageBounds);
	}
	
}