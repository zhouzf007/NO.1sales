package com.dianba.userdomain.order.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.merchant.vo.MerchantCommentVo;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.entity.OrderComment;
import com.dianba.userdomain.order.mapper.CommonOrderCommentMapper;
import com.dianba.userdomain.order.mapper.CommonOrderMapper;
import com.dianba.userdomain.order.service.OrderCommentService;
import com.dianba.userdomain.order.service.OrderStateService;
import com.dianba.userdomain.user.mapper.CommonUserMapper;
import com.dianba.userdomain.user.service.UserService;
import com.dianba.userdomain.util.DateUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonOrderCommentServiceImpl implements OrderCommentService {

	@Autowired
	private CommonOrderCommentMapper orderCommentMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderStateService orderStateService;
	@Autowired
	private CommonOrderMapper orderMapper;
	@Autowired
	private CommonUserMapper userMapper;
	@Autowired
	private MerchantService merchantService;

	public List<OrderComment> getOrderCommentList() {
		return orderCommentMapper.getOrderCommentList();
	}

	public PageList<OrderComment> getOrderCommentList(PageBounds pageBounds) {
		return orderCommentMapper.getOrderCommentList(pageBounds);
	}

	public List<OrderComment> getOrderCommentPageList(OrderComment orderComment) {
		return orderCommentMapper.getOrderCommentPageList(orderComment);
	}

	public PageList<OrderComment> getOrderCommentPageList(OrderComment orderComment, PageBounds pageBounds) {
		return orderCommentMapper.getOrderCommentPageList(orderComment, pageBounds);
	}

	public OrderComment getOrderCommentByPrimaryKey(Long id) {
		return orderCommentMapper.getOrderCommentByPrimaryKey(id);
	}

	public void createOrderComment(OrderComment orderComment) {
		try {
			orderCommentMapper.createOrderComment(orderComment);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteCommentByOrderId(Long orderId, Long targetId) {
		try {
			orderCommentMapper.deleteCommentByOrderId(orderId, targetId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int getRewardScore(Order order) {
		int score = 0;
		if (order.getPayType().equals("balance")) {
			score = order.getCredit().intValue();
		} else {
			score = order.getOnlineMoney().intValue();
		}
		score = score >= 10 ? score : 0;
		return score;
	}

	public void createOrderCommentBitch(List<OrderComment> orderCommentList) {
		for (OrderComment orderComment : orderCommentList) {
			orderCommentMapper.createOrderComment(orderComment);
		}
	}

	public void updateOrderComment(OrderComment orderComment) {
		orderCommentMapper.updateOrderComment(orderComment);
	}

	public void updateOrderCommentBitch(List<OrderComment> orderCommentList) {
		for (OrderComment orderComment : orderCommentList) {
			orderCommentMapper.updateOrderComment(orderComment);
		}
	}

	public void updateOrderCommentSelective(OrderComment orderComment) {
		orderCommentMapper.updateOrderCommentSelective(orderComment);
	}

	public void updateOrderCommentSelectiveBitch(List<OrderComment> orderCommentList) {
		for (OrderComment orderComment : orderCommentList) {
			orderCommentMapper.updateOrderCommentSelective(orderComment);
		}
	}

	public void deleteOrderComment(Long id) {
		orderCommentMapper.deleteOrderComment(id);
	}

	public void deleteOrderCommentBitch(List<Long> idList) {
		for (Long id : idList) {
			orderCommentMapper.deleteOrderComment(id);
		}
	}

	public List<MerchantCommentVo> getOrderCommentListByMerchantId(Long id) {
		return orderCommentMapper.getOrderCommentListByMerchantId(id);
	}

	public String queryCommentScore(Long id) {
		return orderCommentMapper.queryCommentScore(id);
	}

	public List<OrderComment> getOrderCommentListByOrderId(Long id, PageBounds pageBounds) {
		return orderCommentMapper.getOrderCommentListByOrderId(id, pageBounds);

	}

	public Double getMerchantGrade(Long id) {
		return orderCommentMapper.getMerchantGrade(id);
	}

	public Double getMerchantServeGrade(Long id) {
		return orderCommentMapper.getMerchantServeGrade(id);

	}

	public List<MerchantCommentVo> getOrderCommentHaveContentListByMerchantId(Long id, PageBounds pageBounds) {
		return orderCommentMapper.getOrderCommentHaveContentListByMerchantId(id, pageBounds);
	}

	public Integer getMerchantCommentAmountAll(Long id) {
		return orderCommentMapper.getMerchantCommentAmountAll(id);
	}

	public Integer getMerchantCommentAmountHaveComment(Long id) {
		return orderCommentMapper.getMerchantCommentAmountHaveComment(id);
	}

	public List<OrderComment> judgeHaveComment(Map<String, Object> map) {
		return orderCommentMapper.judgeHaveComment(map);
	}

	@Override
	public void createOrderCommentForMerchant(String orderId, String merchantId, String merchantContent,
			String merchantEvaScore, String commentDisplay, String userId, String merchantTags) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("userId", userId);
		map.put("target", 1);
		map.put("targetId", merchantId);
		OrderComment orderComment = judgeHaveDefaultComment(map);
		if (orderComment != null) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("content", merchantContent);
			map2.put("grade", merchantEvaScore);
			map2.put("tags", merchantTags);
			map2.put("id", orderComment.getId());
			updateOrderCommentContent(map2);
		} else {
			OrderComment orderComment2 = new OrderComment();
			orderComment2.setOrderId(Long.parseLong(orderId));
			orderComment2.setCommentContent(merchantContent);
			orderComment2.setCommentDisplay(commentDisplay);
			orderComment2.setCommentTarget(Integer.parseInt("1"));
			orderComment2.setGrade(Integer.parseInt(merchantEvaScore));
			orderComment2.setInvalid(0);
			orderComment2.setTags(merchantTags);
			orderComment2.setCommentTargetId(Long.parseLong(merchantId));
			orderComment2.setUserId(Integer.parseInt(userId));
			createOrderComment(orderComment2);
		}
	}

	@Override
	public void createOrderCommentForCourier(String orderId, String courierId, String courierContent,
			String courierEvaScore, String commentDisplay, String userId, String courierTags) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("userId", userId);
		map.put("target", 0);
		map.put("targetId", courierId);
		OrderComment orderComment = judgeHaveDefaultComment(map);
		if (orderComment != null) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("content", courierContent);
			map2.put("grade", courierEvaScore);
			map2.put("tags", courierTags);

			map2.put("id", orderComment.getId());
			updateOrderCommentContent(map2);
		} else {
			OrderComment orderComment2 = new OrderComment();
			orderComment2.setOrderId(Long.parseLong(orderId));
			orderComment2.setCommentContent(courierContent);
			orderComment2.setCommentDisplay(commentDisplay);
			orderComment2.setCommentTarget(Integer.parseInt("0"));
			orderComment2.setGrade(Integer.parseInt(courierEvaScore));
			orderComment2.setInvalid(0);
			orderComment2.setTags(courierTags);
			orderComment2.setCommentTargetId(Long.parseLong(courierId));
			orderComment2.setUserId(Integer.parseInt(userId));
			createOrderComment(orderComment2);
		}

	}

	@Override
	public OrderComment judgeHaveDefaultComment(Map<String, Object> map) {
		return orderCommentMapper.judgeHaveDefaultComment(map);
	}

	@Override
	public void updateOrderCommentContent(Map<String, Object> map) {
		orderCommentMapper.updateOrderCommentContent(map);
	}

	@Override
	public void createOrderCommentForMerchantTase(String orderId, String merchantId, String merchantContent,
			String merchantEvaScore, String commentDisplay, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderId", orderId);
		map.put("userId", userId);
		map.put("target", 2);
		map.put("targetId", merchantId);
		OrderComment orderComment = judgeHaveDefaultComment(map);
		if (orderComment != null) {
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("content", merchantContent);
			map2.put("grade", merchantEvaScore);
			map2.put("id", orderComment.getId());
			updateOrderCommentContent(map2);
		} else {
			OrderComment orderComment2 = new OrderComment();
			orderComment2.setOrderId(Long.parseLong(orderId));
			orderComment2.setCommentContent(merchantContent);
			orderComment2.setCommentDisplay(commentDisplay);
			orderComment2.setCommentTarget(Integer.parseInt("2"));
			orderComment2.setGrade(Integer.parseInt(merchantEvaScore));
			orderComment2.setInvalid(0);
			orderComment2.setCommentTargetId(Long.parseLong(merchantId));
			orderComment2.setUserId(Integer.parseInt(userId));
			createOrderComment(orderComment2);
		}

	}

	public PageList<MerchantCommentVo> getOrderCommentListPageByMerchantId(Long id, PageBounds pageBounds) {
		return orderCommentMapper.getOrderCommentListPageByMerchantId(id, pageBounds);
	}

/*	@Override
	public void createOrderCommentForMerchantAndCourier(String orderId, String courierId, String merchantId,
			String merchantContent, String courierContent, String merchantTaseScore, String courierEvaScore,
			String commentDisplay, String userId, String merchantTags, String courierTags) {
		Integer merchantScore = (Integer.parseInt(courierEvaScore) + Integer.parseInt(merchantTaseScore)) / 2;
		createOrderCommentForMerchant(orderId, merchantId, merchantContent, merchantScore.toString(), commentDisplay,
				userId, merchantTags);
		createOrderCommentForCourier(orderId, courierId, courierContent, courierEvaScore, commentDisplay, userId,
				courierTags);
		createOrderCommentForMerchantTase(orderId, merchantId, merchantContent, merchantTaseScore, commentDisplay,
				userId);
		// tlm_statistics_realtime表快快递员评论操作
		Map<String, Object> TlmCommentMap = new HashMap<String, Object>();
		TlmCommentMap.put("courierId", courierId);
		TlmCommentMap.put("score", courierEvaScore);
		tlmStatisticsRealtimeService.updateTotalComment(TlmCommentMap);
		// tpm_statistics_realtime 商家统计表评论操作
		Map<String, Object> TpmCommentMap = new HashMap<String, Object>();
		TpmCommentMap.put("merchantId", merchantId);
		TpmCommentMap.put("score", merchantScore);
		tpmStatisticsRealtimeService.updateTotalComment(TpmCommentMap);

		// userService.updateUserScorePlusFromComment(StringUtil.parseLong(userId));
		Order order = orderMapper.getOrderByPrimaryKey(Long.parseLong(orderId));
		// 给用户加积分
		Map<String, Object> map = new HashMap<String, Object>();
		int score = 0;
		if (order.getPayType().equals("balance")) {
			score = order.getCredit().intValue();
			map.put("score", score);
			map.put("id", userId);
		} else {
			score = order.getOnlineMoney().intValue();
			map.put("score", score);
			map.put("id", userId);
		}
		if (score >= 10) {
			userMapper.updateUserScoreByOrderMoney(map);
			// 记录积分流水表
			String commentScoreCode = "comment_score";
			Credit credit = new Credit();
			credit.setAction(commentScoreCode);
			credit.setCreateTime(DateUtils.getSeconds());
			credit.setDetailId(Long.parseLong(orderId));
			credit.setDetail("主动评论送积分");
			credit.setScore(score);
			credit.setUserId(Long.parseLong(userId));
			creditService.createCredit(credit);
		}
		// 插入已完成订单状态
		// OrderState orderState = new OrderState();
		// orderState.setDealTime(DateUtils.getSeconds());
		// orderState.setOrderId(StringUtil.parseLong(orderId));
		// orderState.setState("已完成");
		// orderState.setDetail("感谢您的评价,谢谢您对1号外卖的支持!");

		orderStateService.evaluateOrderState(Long.parseLong(orderId));
		// 推送一条评价语音
		if (!"0".equals(courierId)) {
			merchantService.pushOrderComment(Long.parseLong(orderId));
		}
	}*/

	@Override
	public Double getMerchantAvgGrade(Long id) {
		return orderCommentMapper.getMerchantAvgGrade(id);
	}

	@Override
	public Map<String, Object> merchantScore(Long id) {
		return orderCommentMapper.merchantScore(id);
	}

	@Override
	public Integer getOrderCommentCountByMerchantId(Long merchantId) {
		return orderCommentMapper.getOrderCommentCountByMerchantId(merchantId);
	}

	@Override
	public MerchantCommentVo getOrderCommentFirstByMerchantId(Long merchantId) {
		return orderCommentMapper.getOrderCommentFirstByMerchantId(merchantId);
	}

	/*
	 * 
	 * <p>Title: getcommentTarget</p> <p>Description:根据id获取评价对象</p>
	 *
	 * 创建人：陈健文 创建时间： 2015年12月28日 下午4:32:20
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.dianba.web.service.OrderCommentService#getcommentTarget(java.lang.
	 * Long)
	 */
	@Override
	public Integer getcommentTarget(Long id) {
		return orderCommentMapper.getcommentTarget(id);
	}

	@Override
	public PageList<MerchantCommentVo> getPrivateKitchenOrderCommentListByMerchantId(Long merchantId,
			PageBounds pageBounds) {
		return orderCommentMapper.getPrivateKitchenOrderCommentListByMerchantId(merchantId, pageBounds);
	}

	/*
	 * 
	 * <p>Title: courierScore</p> <p>Description: 获取快递员的评分及评价内容</p>
	 *
	 * 创建人： 创建时间： 2016年1月4日 下午3:18:53
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see
	 * com.dianba.web.service.OrderCommentService#courierScore(java.lang.Long)
	 */
	@Override
	public List<OrderComment> courierScore(Long id) {
		return orderCommentMapper.courierScore(id);
	}

}