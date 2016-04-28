package com.dianba.userdomain.discount.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dianba.userdomain.commons.vo.JsonResp;
import com.dianba.userdomain.constant.CouponGrantRule;
import com.dianba.userdomain.constant.CouponType;
import com.dianba.userdomain.constant.ExceptionCode;
import com.dianba.userdomain.constant.PutConditionType;
import com.dianba.userdomain.constant.SaleType;
import com.dianba.userdomain.controller.bean.UserCouponDetail;
import com.dianba.userdomain.controller.open_api.util.ValidUtil;
import com.dianba.userdomain.discount.entity.Coupon;
import com.dianba.userdomain.discount.entity.CouponDiscount;
import com.dianba.userdomain.discount.entity.CouponFission;
import com.dianba.userdomain.discount.entity.CouponGrant;
import com.dianba.userdomain.discount.entity.CouponUser;
import com.dianba.userdomain.discount.entity.CouponUserStatics;
import com.dianba.userdomain.discount.mapper.CommonCouponMapper;
import com.dianba.userdomain.discount.service.CouponService;
import com.dianba.userdomain.merchant.entity.Category;
import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.sysdictionary.entity.SysText;
import com.dianba.userdomain.util.ListUtil;
import com.dianba.userdomain.util.OLog;
import com.dianba.userdomain.util.OrderUtil;
import com.dianba.userdomain.util.ServiceErrorException;
/**
 * 优惠券功能实现
 * 
 * @author folo
 */
@Service
public class CommonCouponServiceImpl implements CouponService {
	public static Logger LOG = LoggerFactory.getLogger(CommonCouponServiceImpl.class);

	@Autowired
	CommonCouponMapper couponMapper;

	@Override
	public List<UserCouponDetail> getNowCouponPageList(SaleType createOrderType, Integer merchantId, Long userId,
			Integer actualMoney, Integer page, Integer pageSize) {
		try {
			// 找到该用户 未使用 使用时间有效 支持该商家的商家券 或者 支持该商家分类的平台券 按照使用金额倒序，时间升序排序
			// 优惠券需要满足满减额度
			// 返回用户券与券的详细信息
			// 检查是否可发优惠券
			Merchant merchant = couponMapper.findSupportCouponMerchant(merchantId);
			if (null == merchant)
				return null;

			// 没有给分类id 从商家里面获得
			return getCouponPageList(createOrderType, merchant, null, userId, actualMoney, page, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getNowCouponCount(SaleType createOrderType, Integer merchantId, Long userId,
			Integer actualMoney) {
		try {
			// 找到该用户 未使用 使用时间有效 支持该商家的商家券 或者 支持该商家分类的平台券
			// 优惠券需要满足满减额度
			// 返回总记录数
			// 检查是否可发优惠券
			Merchant merchant = couponMapper.findSupportCouponMerchant(merchantId);
			if (null == merchant)
				return 0;

			// 根据折扣规则 该商家可用最大优惠券金额
			int canUsedAmount = getCanUsedAmount(merchantId, createOrderType, actualMoney);
			List<CouponUser> couponUsers = couponMapper.findUserCoupons(couponTbNum(userId), userId, -1, new Date(),
					null, merchantId, merchant.getGroupId().intValue(), canUsedAmount, actualMoney, -1, -1);
			String couponStr = ListUtil.toStringsByField(couponUsers, "couponId");
			if (ValidUtil.anyEmpty(couponStr))
				return 0;
			List<Coupon> coupons = couponMapper.findCoupons(couponStr, actualMoney, "amount");
			if (ValidUtil.anyEmpty(coupons))
				return 0;
			Map<Integer, Coupon> hashCoupon = ListUtil.toHashMap(coupons, "id", Integer.class);
			if (ValidUtil.anyEmpty(hashCoupon))
				return 0;

			int canUsedCouponCount = 0;
			for (CouponUser couponUser : couponUsers) {
				Coupon coupon = hashCoupon.get(couponUser.getCouponId());
				if (null == coupon)
					continue;
				if (actualMoney >= coupon.getUseCondition())
					canUsedCouponCount++;
			}

			return canUsedCouponCount;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 计算该商家下单可使用优惠券最大金额
	 * 
	 * @param merchantId
	 *            商家id
	 * @param createOrderType
	 *            下单类型
	 * @param actualMoney
	 *            实际支付金额
	 * @return
	 */
	private int getCanUsedAmount(Integer merchantId, SaleType createOrderType, Integer actualMoney) {
		// 商家扣点信息
		int discount = getDiscount(merchantId, createOrderType);
		if (0 == discount)
			return 0;

		// 计算该商家可使用优惠券最大金额
		BigDecimal takeout = new BigDecimal(discount).divide(new BigDecimal(10000));
		return new BigDecimal(actualMoney).multiply(takeout).intValue() / 10 * 10;
	}

	/**
	 * 根据不同订单类型 获得商家的扣点
	 * 
	 * @param merchantId
	 *            商家id
	 * @param orderType
	 *            下单类型
	 * @return
	 */
	private int getDiscount(Integer merchantId, SaleType orderType) {
		CouponDiscount couponDiscount = couponMapper.findCouponDiscount(merchantId);
		if (null == couponDiscount)
			return 0;

		switch (orderType) {
		case TAKEOUT:
			return couponDiscount.getTakeout();
		case EATIN:
			return couponDiscount.getDine();
		case MENTION:
			return couponDiscount.getMention();
		default:
			break;
		}
		return 0;
	}

	private int couponTbNum(long userId) {
		return (int) (userId % 10);
	}

	/**
	 * 获取优惠券分页列表
	 * 
	 * @param createOrderType
	 *            下单的类型
	 * @param merchant
	 *            商家
	 * @param sourceType
	 * @param userId
	 *            用户id
	 * @param actualMoney
	 *            订单实际支付金额
	 * @param page
	 *            当前页数
	 * @param pageSize
	 *            每页条数
	 * @return
	 */
	private List<UserCouponDetail> getCouponPageList(SaleType createOrderType, Merchant merchant,
			Integer sourceType, Long userId, Integer actualMoney, Integer page, Integer pageSize) {
		try {
			page = (null == page || page < 0 ? 0 : page - 1);
			pageSize = (null == pageSize || pageSize < 0 ? 20 : pageSize);
			Integer merchantId = (null == merchant ? null : merchant.getId());
			Integer groupId = (null == merchant ? null : merchant.getGroupId().intValue());

			// 根据扣点 计算该订单最多可使用优惠券金额
			Integer amount = (null == createOrderType ? null
					: getCanUsedAmount(merchantId, createOrderType, actualMoney));

			// 找到该用户 未使用 使用时间有效 支持该商家的商家券 或者 支持该商家分类的平台券
			List<CouponUser> couponUsers = couponMapper.findUserCoupons(couponTbNum(userId), userId, -1, new Date(),
					sourceType, merchantId, groupId, amount, actualMoney, page * pageSize, pageSize);
			if (ValidUtil.anyEmpty(couponUsers))
				return null;
			String couponIds = "";
			String categoryIds = "";
			String merchantIds = "";
			for (CouponUser couponUser : couponUsers) {
				if (couponIds.indexOf("" + couponUser.getCouponId()) == -1)
					couponIds += "," + couponUser.getCouponId();
				if (categoryIds.indexOf("" + couponUser.getSourceGroup()) == -1)
					categoryIds += "," + couponUser.getSourceGroup();
				if (merchantIds.indexOf("" + couponUser.getSourceId()) == -1)
					merchantIds += "," + couponUser.getSourceId();
			}
			if (couponIds.length() > 1)
				couponIds = couponIds.substring(1);
			if (categoryIds.length() > 1)
				categoryIds = categoryIds.substring(1);
			if (merchantIds.length() > 1)
				merchantIds = merchantIds.substring(1);

			String couponStr = ListUtil.toStringsByField(couponUsers, "couponId");
			if (ValidUtil.anyEmpty(couponStr))
				return null;

			// 找到金额满足满减额度的所有优惠券详情
			List<Coupon> coupons = couponMapper.findCoupons(couponStr, actualMoney, "amount");
			Map<Integer, Coupon> hashCoupon = ListUtil.toHashMap(coupons, "id", Integer.class);

			// 找到所有的分类名字 并缓存
			List<Category> categoryNames = couponMapper.findCategoryNames(categoryIds);
			Map<Integer, Category> hashCouponCategory = ListUtil.toHashMap(categoryNames, "id", Integer.class);
			// 找到所有商家名字 并缓存
			List<Merchant> merchantNames = couponMapper.findMerchantNames(merchantIds);
			Map<Integer, Merchant> hashCouponMerchant = null;
			if (!ValidUtil.anyEmpty(merchantNames))
				hashCouponMerchant = ListUtil.toHashMap(merchantNames, "id", Integer.class);

			// 转换展示用数据格式
			List<UserCouponDetail> retusnCouPons = new ArrayList<>();
			for (int i = 0; i < couponUsers.size(); i++) {
				CouponUser couponUser = couponUsers.get(i);
				Coupon cacheCoupon = hashCoupon.get(couponUser.getCouponId());
				if (null == cacheCoupon)
					continue;

				UserCouponDetail userCouponDetail = new UserCouponDetail();
				userCouponDetail.setUserCouponId(couponUser.getId());
				userCouponDetail.setSn(couponUser.getSn());
				if (couponUser.getSourceType() == 100)
					userCouponDetail.setSourceTypeName("平台");
				else if (couponUser.getSourceType() == 200) {
					userCouponDetail.setSourceTypeName("商家");
					Merchant cmerchant = hashCouponMerchant.get(couponUser.getSourceId());
					userCouponDetail.setMerchantName(cmerchant.getTitle());
				}
				Category category = hashCouponCategory.get(couponUser.getSourceGroup());
				userCouponDetail.setCategoryName(category.getName());
				BeanUtils.copyProperties(cacheCoupon, userCouponDetail);

				userCouponDetail.setAmount(couponUser.getAmount());
				retusnCouPons.add(userCouponDetail);
			}
			// 从内存清除
			couponUsers = null;
			coupons = null;
			hashCoupon = null;
			categoryNames = null;
			hashCouponCategory = null;
			merchantNames = null;
			hashCouponMerchant = null;
			return retusnCouPons;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getCouponDetail(String couponSns, Long userId) {
		try {
			// 查找用户优惠券表
			List<CouponUser> couponUsers = couponMapper.findUserCouponsBySns(couponTbNum(userId), couponSns);
			String couponIds = ListUtil.toStringsByField(couponUsers, "couponId");

			// 查找优惠券详细
			List<Coupon> coupons = couponMapper.findCoupons(couponIds, null, "amount");
			if (null == coupons || coupons.isEmpty())
				return null;

			String categoryIds = ListUtil.toStringsByField(couponUsers, "sourceGroup");
			List<Category> categorys = couponMapper.findCategoryNames(categoryIds);
			Map<Long, Category> categoryMap = ListUtil.toHashMap(categorys, "id", Long.class);

			String merchantIds = ListUtil.toStringsByField(couponUsers, "sourceId");
			List<Merchant> merchants = couponMapper.findMerchantNames(merchantIds);
			Map<Long, Merchant> merchantMap = ListUtil.toHashMap(merchants, "id", Integer.class);

			// 如果是单个查询
			if (couponUsers.size() == 1) {
				UserCouponDetail userCouponDetail = new UserCouponDetail();
				CouponUser couponUser = couponUsers.get(0);
				userCouponDetail.setUserCouponId(couponUser.getId());
				userCouponDetail.setSn(couponUser.getSn());
				userCouponDetail.setCategoryName(categoryMap.get((long) couponUser.getSourceGroup()).getName());
				if (null != couponUser.getSourceId())
					userCouponDetail.setMerchantName(merchantMap.get(couponUser.getSourceId()).getTitle());
				BeanUtils.copyProperties(coupons.get(0), userCouponDetail);
				userCouponDetail.setAmount(couponUser.getAmount());
				// 从内存清除
				coupons = null;
				couponUsers = null;

				return (T) userCouponDetail;
			} else {
				List<UserCouponDetail> UserCouponDetails = new ArrayList<>();
				Map<Integer, Coupon> couponHash = ListUtil.toHashMap(coupons, "id", Integer.class);
				for (CouponUser couponUser : couponUsers) {
					UserCouponDetail userCouponDetail = new UserCouponDetail();
					userCouponDetail.setUserCouponId(couponUser.getId());
					userCouponDetail.setSn(couponUsers.get(0).getSn());
					userCouponDetail.setCategoryName(categoryMap.get((long) couponUser.getSourceGroup()).getName());
					if (null != couponUser.getSourceId())
						userCouponDetail.setMerchantName(merchantMap.get(couponUser.getSourceId()).getTitle());
					BeanUtils.copyProperties(couponHash.get(couponUser.getCouponId()), userCouponDetail);
					userCouponDetail.setAmount(couponUser.getAmount());
					UserCouponDetails.add(userCouponDetail);
				}
				// 从内存清除
				couponHash = null;
				coupons = null;
				couponUsers = null;

				return (T) UserCouponDetails;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * <pre>
	 * 
	 * A.只有默认商家 乡村基 和 合同店铺才可使用优惠券
	 * B.检查优惠券编号是否该用户未使用，使用时间有效的优惠券
	 * C.检查优惠券是否满足规则
	 *      a.商家优惠券
	 *          一、检查优惠券金额是否支持该商家,是否满足规则：订单实际支付金额 >= 优惠券使用条件
	 *      b.平台现金券
	 *          一、检查优惠券是否支持该分类,是否满足规则
	 *              a>、扣点模式
	 *                  1.检查商家是否有设置优惠券扣点
	 *                  2.检查优惠券金额是否满足规则：订单实际支付金额*扣点 <= 优惠券金额
	 *              b>、固定金额模式
	 *                  1.检查优惠券金额是否满足规则：订单实际支付金额 >= 优惠券使用条件
	 * D.更新优惠券使用状态,使用时间,具体抵扣金额
	 * E.更新用户优惠券表统计
	 * 
	 * </pre>
	 */
	@Override
	@Transactional
	public boolean getUseCase(Integer merchantId, Long userId, Integer actualMoney, String couponSn,
			SaleType createOrderType) throws ServiceErrorException {
		try {
			StackTraceElement stack = Thread.currentThread().getStackTrace()[1];

			// 只有默认商家 乡村基 和 合同店铺才可使用优惠券
			Merchant merchant = couponMapper.findSupportCouponMerchant(merchantId);
			if (null == merchant)
				return false;

			// 检查优惠券编号是否该用户未使用优惠券
			CouponUser couponUser = couponMapper.findCouponUser(couponTbNum(userId), couponSn, userId);
			if (null == couponUser || couponUser.getStatus() != -1)
				return false;

			// 检查优惠券是否失效
			Coupon coupon = couponMapper.findCoupons(couponUser.getCouponId() + "", null, "amount").get(0);
			Date usedTime = new Date();
			if (usedTime.getTime() < coupon.getBeginUsedTime().getTime()
					|| usedTime.getTime() > coupon.getEndUsedTime().getTime()) {
				return false;
			}

			// 平台券
			if (CouponType.PLATFORM.equals(couponUser.getSourceType())) {
				if (!couponUser.getSourceGroup().equals(merchant.getGroupId().intValue()))
					return false;
				// 扣点模式
				if (PutConditionType.DISCOUNT.equals(coupon.getPutConditionType())) {
					// 商家扣点信息
					int discount = getDiscount(merchantId, createOrderType);
					if (0 == discount) {
						OLog.warn(stack,
								"use coupon error, the merchant not found discount, merchant:{} couponSn:{} createOrderType:{}",
								merchant, couponSn, createOrderType);
						return false;
					}
					// 是否满足扣点金额
					if (coupon.getAmount() > (actualMoney * (discount / 10000)))
						return false;
				}
				// 固定金额模式
				else {
					// 是否满足使用条件 满减
					if (actualMoney < coupon.getUseCondition())
						return false;
				}
			}
			// 商家券
			else if (CouponType.MERCHANT.equals(couponUser.getSourceType())) {
				if (!couponUser.getSourceId().equals(merchantId))
					return false;
				// 是否满足使用条件 满减
				if (actualMoney < coupon.getUseCondition())
					return false;
			} else
				return false;

			// 更新用户优惠券表 使用状态与使用时间
			int count = couponMapper.useCoupon(couponTbNum(userId), usedTime, coupon.getAmount(), userId, couponSn);
			if (count != 1)
				return false;
			// 更新用户优惠券表统计（如果不存在则进行添加）
			CouponUserStatics couponUserStatics = new CouponUserStatics();
			couponUserStatics.setCouponId(coupon.getId());
			couponUserStatics.setUsedType(couponUser.getSourceType());
			couponUserStatics.setUsedId(couponUser.getSourceId());
			couponUserStatics.setUsedGroup(couponUser.getSourceGroup());
			couponUserStatics.setFromGroup(merchant.getGroupId().intValue());
			couponUserStatics.setFromArea(merchant.getCityId().intValue());
			saveCouponUserStatics(couponUserStatics, coupon.getPutTotalCount(), 0, 1);
			return true;
		} catch (ServiceErrorException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceErrorException();
		}
	}

	/**
	 * 保存用户优惠券统计
	 * 
	 * @param couponUserStatics
	 *            用户优惠券4个条件唯一键
	 * @param putTotalCount
	 *            总发放数
	 * @param reciveiedCount
	 *            已发放数
	 * @param usedCount
	 *            已使用数
	 */
	private void saveCouponUserStatics(CouponUserStatics couponUserStatics, int putTotalCount, int reciveiedCount,
			int usedCount) throws Exception {
		CouponUserStatics udpateCouponUserStatics = couponMapper.findCouponUserStatics(couponUserStatics);
		if (null == udpateCouponUserStatics) {
			couponUserStatics.setPutTotalCount(putTotalCount);
			couponUserStatics.setReciveiedCount(reciveiedCount);
			couponUserStatics.setUsedCount(usedCount);
			couponMapper.insertCouponUserStatics(couponUserStatics);
		} else {
			udpateCouponUserStatics.setReciveiedCount(udpateCouponUserStatics.getReciveiedCount() + reciveiedCount);
			udpateCouponUserStatics.setUsedCount(udpateCouponUserStatics.getUsedCount() + usedCount);
			couponMapper.updateCouponUserStatics(udpateCouponUserStatics);
		}
	}

	@Override
	public boolean canCreateCouponFission(Order order) throws ServiceErrorException {
		return canCreateCouponFission(order);
	}

	@Override
	public boolean canCreateCouponFission(CouponType type, Order order) throws ServiceErrorException {
		StackTraceElement stack = Thread.currentThread().getStackTrace()[1];
		try {
			JsonResp errorResp = ExceptionCode.FAIL.resp(null);
			// 校验订单状态

			// 检查是否可发优惠券
			Merchant merchant = couponMapper.findSupportCouponMerchant(order.getMerchantId());
			if (null == merchant)
				throw new ServiceErrorException(errorResp.msgDetail("该商家不支持发券"));

			if (null != type) {
				// 校验是否可发商家券
				if (CouponType.MERCHANT.equals(type))
					return null != getMerchantGrant(order);
				// 校验是否可发平台券
				if (CouponType.PLATFORM.equals(type))
					return null != getPlantGrant(order);
			}

			// 校验商家券 或 平台券是否有可发的
			if (null == type) {
				ServiceErrorException retMerchantException = null;
				boolean canGrantMerchant = false;
				try {
					canGrantMerchant = (null != getMerchantGrant(order));
				} catch (ServiceErrorException e) {
					retMerchantException = e;
				}
				if (canGrantMerchant)
					return true;

				ServiceErrorException retPlantException = null;
				boolean canGrantPlantform = false;
				try {
					canGrantPlantform = (null != getPlantGrant(order));
				} catch (ServiceErrorException e) {
					retPlantException = e;
				}
				if (canGrantPlantform)
					return true;

				throw (null == retMerchantException ? retPlantException : retMerchantException);
			}
			return true;
		} catch (ServiceErrorException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			OLog.warn(stack, "check can grant coupon exception, type:{} order:{}", type.getCode(),
					JSON.toJSONString(order));
			throw new ServiceErrorException();
		}
	}

	/**
	 * 获取商家券发放信息
	 * 
	 * @param order
	 * @return true=可以发，false=不可以
	 * @throws ServiceErrorException
	 */
	private CouponGrant getMerchantGrant(Order order) throws ServiceErrorException {
		JsonResp errorResp = ExceptionCode.FAIL.resp(null);
		Integer actualMoney = OrderUtil.getRealPayMoney(order).multiply(new BigDecimal(100)).intValue();
		// 找到支持下单金额的 正在发放的 支持下单金额的 某个商家的优惠券（获得金额最高，最先发放的1个））
		Date date = new Date();

		CouponGrant couponGrant = couponMapper.findMerchantCouponsBeingIssued(date, order.getMerchantId(),
				CouponType.MERCHANT.getCode(), actualMoney, 1);
		if (ValidUtil.anyEmpty(couponGrant))
			throw new ServiceErrorException(errorResp.msgDetail("该商家没有正在发的优惠券"));
		return couponGrant;
	}

	/**
	 * 获取平台优惠劵发放规则
	 * 
	 * @param order
	 * @param amountTotal
	 * @return
	 */
	private CouponGrant getPlantGrant(Order order) throws ServiceErrorException {
		JsonResp errorResp = ExceptionCode.FAIL.resp(null);
		Integer amountTotal = OrderUtil.getRealPayMoney(order).multiply(new BigDecimal(100)).intValue();

		// 已经创建裂变记录的订单 不做处理
		CouponFission findCouponFission = couponMapper.findCouponFissionByOrderId(order.getId());
		if (null != findCouponFission)
			throw new ServiceErrorException(errorResp.msgDetail("已获得过优惠券礼包!"));

		// A.只有默认商家 乡村基 和 合同店铺才可发放优惠券
		Merchant merchant = couponMapper.findSupportCouponMerchant(order.getMerchantId());
		if (null == merchant)
			throw new ServiceErrorException();

		// 根据订单对应实际支付金额可用的最优发放规则
		CouponGrant couponGrant = findPlantGrant(merchant, amountTotal);
		if (null == couponGrant)
			throw new ServiceErrorException(errorResp.msgDetail("不符合发放规则"));
		return couponGrant;
	}

	/**
	 * 根据订单对应实际支付金额可用的最优发放规则
	 * 
	 * @param order
	 *            订单id
	 * @param merchant
	 *            商家信息
	 * @param amountTotal
	 *            发放总金额
	 * @return
	 */
	private CouponGrant findPlantGrant(Merchant merchant, Integer amountTotal) {
		StackTraceElement stack = Thread.currentThread().getStackTrace()[1];
		try {
			// 查询正在发放的平台券规则中(可能有多条规则) 支持该商家所在的分类, 支持商家所在的地区
			Date nowDate = new Date();
			List<CouponGrant> couponGrants = couponMapper.findCouponsBeingIssued(nowDate, merchant.getGroupId(),
					merchant.getCityId(), 100);
			if (null == couponGrants || couponGrants.size() < 1)
				return null;

			// 查询hashmap格式支持规则的优惠券信息，按照发放金额限制倒序
			Map<Integer, Coupon> couponMaps = findHashCoupons(couponGrants, amountTotal);

			// 校验发放规则 如果符合规则 则进行发放
			for (CouponGrant couponGrant : couponGrants) {
				// 校验优惠券规则
				Coupon coupon = couponMaps.get(couponGrant.getCouponId());

				String realUsedGroupsStr = couponGrant.getUsedGroup();
				// 互发模式 排除掉当前商家所在分类
				if (CouponGrantRule.EACH.equals(couponGrant.getFromRule())) {
					realUsedGroupsStr = realUsedGroupsStr.replace(merchant.getGroupId() + ",", "");
				}
				String[] realUsedGroups = realUsedGroupsStr.split(",");

				// 优惠券剩余数量不够
				if (coupon.getPutTotalCount() > 0 && coupon.getSurplusCount() < realUsedGroups.length)
					return null;
				// 金额不满足发放条件
				if (coupon.getPutCondition() > 0 && amountTotal < coupon.getPutCondition())
					return null;

				// 清除占用内存
				couponGrants = null;
				couponMaps = null;
				couponGrant.coupon = coupon;
				return couponGrant;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			OLog.warn(stack, "grant coupon exception, amountTotal:{}", amountTotal);
			throw new ServiceErrorException();
		}
	}

	/**
	 * 查询hashmap格式支持规则的优惠券信息，按照发放金额限制倒序
	 * 
	 * @param couponGrants
	 *            优惠券规则
	 * @param actualMoney
	 *            下单金额
	 * @return
	 */
	private Map<Integer, Coupon> findHashCoupons(List<CouponGrant> couponGrants, Integer actualMoney) {
		StackTraceElement stack = Thread.currentThread().getStackTrace()[1];
		// 根据规则列表获得代金券的id，拼凑后用逗号隔开
		String couponIds = ListUtil.toStringsByField(couponGrants, "couponId");
		if (ValidUtil.anyEmpty(couponIds)) {
			OLog.warn(stack, "couponGrants get couponIds empty, couponGrants:{}", JSON.toJSONString(couponGrants));
			return null;
		}
		// 获得所有支持代金券的详情
		List<Coupon> coupons = couponMapper.findCoupons(couponIds, actualMoney, "put_condition");
		if (ValidUtil.anyEmpty(coupons)) {
			OLog.warn(stack, "find coupons empty by couponIds:{}", couponIds);
			return null;
		}
		// 转换代金券详情数据格式为msp
		Map<Integer, Coupon> couponMaps = ListUtil.toHashMap(coupons, "id", Integer.class);
		if (ValidUtil.anyEmpty(couponMaps)) {
			OLog.warn(stack, "conver to map empty by coupons:{}", JSON.toJSONString(couponMaps));
			return null;
		}
		return couponMaps;
	}
	 @Override
	    public List<SysText> getUserExplain(String type) {
	        return couponMapper.findSysTexts(type);
	    }
}
