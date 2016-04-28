package com.dianba.userdomain.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.constant.OrderStateEnum;
import com.dianba.userdomain.merchant.entity.Merchant;
import com.dianba.userdomain.merchant.mapper.CommonMerchantMapper;
import com.dianba.userdomain.merchant.service.MerchantInfoService;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.entity.OrderState;
import com.dianba.userdomain.order.mapper.CommonOrderMapper;
import com.dianba.userdomain.order.mapper.CommonOrderStateMapper;
import com.dianba.userdomain.order.service.OrderStateService;
import com.dianba.userdomain.order.vo.OrderStateVo;
import com.dianba.userdomain.user.entity.User;
import com.dianba.userdomain.user.mapper.CommonUserMapper;
import com.dianba.userdomain.util.DateUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonOrderStateServiceImpl implements OrderStateService {

	@Autowired
	private CommonOrderStateMapper orderStateMapper;
	@Autowired
	private CommonOrderMapper orderMapper;
	@Autowired
	private CommonMerchantMapper merchantMapper;
	@Autowired
	private CommonUserMapper userMapper;

	@Autowired
	private MerchantInfoService merchantInfoService;

	public List<OrderState> getOrderStateList() {
		return orderStateMapper.getOrderStateList();
	}

	public PageList<OrderState> getOrderStateList(PageBounds pageBounds) {
		return orderStateMapper.getOrderStateList(pageBounds);
	}

	public List<OrderState> getOrderStatePageList(OrderState orderState) {
		return orderStateMapper.getOrderStatePageList(orderState);
	}

	public PageList<OrderState> getOrderStatePageList(OrderState orderState, PageBounds pageBounds) {
		return orderStateMapper.getOrderStatePageList(orderState, pageBounds);
	}

	public OrderState getOrderStateByPrimaryKey(Long id) {
		return orderStateMapper.getOrderStateByPrimaryKey(id);
	}

	public void createOrderState(OrderState orderState) {
		orderStateMapper.createOrderState(orderState);
	}

	public void createOrderStateBitch(List<OrderState> orderStateList) {
		for (OrderState orderState : orderStateList) {
			orderStateMapper.createOrderState(orderState);
		}
	}

	public void updateOrderState(OrderState orderState) {
		orderStateMapper.updateOrderState(orderState);
	}

	public void updateOrderStateBitch(List<OrderState> orderStateList) {
		for (OrderState orderState : orderStateList) {
			orderStateMapper.updateOrderState(orderState);
		}
	}

	public void updateOrderStateSelective(OrderState orderState) {
		orderStateMapper.updateOrderStateSelective(orderState);
	}

	public void updateOrderStateSelectiveBitch(List<OrderState> orderStateList) {
		for (OrderState orderState : orderStateList) {
			orderStateMapper.updateOrderStateSelective(orderState);
		}
	}

	public void deleteOrderState(Long id) {
		orderStateMapper.deleteOrderState(id);
	}

	public void deleteOrderStateBitch(List<Long> idList) {
		for (Long id : idList) {
			orderStateMapper.deleteOrderState(id);
		}
	}



	@Override
	public void createOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		OrderState orderState = new OrderState();
		orderState.setDealTime(order.getCreateTime());
		orderState.setOrderId(orderId);
		orderState.setState("未支付");
		orderState.setDetail("15分钟内未付款，订单自动取消");
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void payOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);

		// OrderState orderState =new OrderState();
		// orderState.setDealTime(order.getCreateTime());
		// orderState.setOrderId(orderId);
		// orderState.setState("已付款");
		// orderState.setDetail("付款成功，等待商家接单");
		// orderStateMapper.createOrderState(orderState);
		//
		payOrderState(order);

	}

	@Override
	public void payOrderState(Order order) {
		// MerchantInfo info =
		// merchantInfoService.getMerchantInfoByMerchantId(order.getMerchantId());
		OrderState orderState = new OrderState();
		orderState.setDealTime(order.getPayTime());
		orderState.setOrderId(order.getId());

		orderState.setState("已付款");
		orderState.setDetail("付款成功，等待商家接单");
		orderStateMapper.createOrderState(orderState);

	}

	@Override
	public void accessOrderStateChoice(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		// Merchant merchant =
		// merchantMapper.getMerchantByPrimaryKey(StringUtil.parseLong(order.getMerchantId()
		// + ""));
		// User user = userMapper.getUserByPrimaryKey(merchant.getUserId());
		OrderState orderState = new OrderState();
		orderState.setDealTime(order.getCreateTime());
		orderState.setOrderId(orderId);
		orderState.setState("接单中");
		// String nickName = user.getNickname();
		// if (nickName != null && nickName != "") {
		// orderState.setDetail("等待商家" + nickName + "是否接单");
		// } else {
		// orderState.setDetail("等待商家" + user.getUsername() + "是否接单");
		// }
		orderState.setDetail("商家在15分钟未处理，自动取消订单");
		orderStateMapper.createOrderState(orderState);

	}

	@Override
	public void accessOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		OrderState orderState = new OrderState();
		orderState.setDealTime(order.getAccessTime());
		orderState.setOrderId(orderId);
		orderState.setState("已接单");
		orderState.setDetail("商家已接单，正在制作中");
		orderStateMapper.createOrderState(orderState);
		// if (2 == order.getSaleType()) {
		// OrderState orderState2 =new OrderState();
		// orderState2.setDealTime(DateUtils.getSeconds());
		// orderState2.setOrderId(orderId);
		// orderState2.setState("已完成");
		// orderState2.setDetail("订单已完成");
		// orderStateMapper.createOrderState(orderState2);
		// }
	}

	@Override
	public void noAcceptOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		OrderState orderState = new OrderState();
		orderState.setDealTime(order.getAccessTime());
		orderState.setOrderId(orderId);
		orderState.setState("取消订单");
		orderState.setDetail("商家已拒绝接单");
		orderStateMapper.createOrderState(orderState);
	}



	@Override
	public void doneOrderState(Long orderId) {
		try {
			Order order = orderMapper.getOrderByPrimaryKey(orderId);
			// User user = userMapper.getUserByPrimaryKey(order.getCourierId());
			// OrderState orderState = new OrderState();
			// orderState.setDealTime(order.getCompleteTime());
			// orderState.setOrderId(orderId);
			// orderState.setState("已送达");
			// String nickName = user.getNickname();
			// if (nickName != null && nickName != "") {
			// orderState.setDetail("快递小哥" + nickName + "已把外卖安全送到客人手上~");
			// } else {
			// orderState.setDetail("快递小哥" + user.getUsername() +
			// "已把外卖安全送到客人手上~");
			// }
			// orderStateMapper.createOrderState(orderState);
			// 待评价状态
			OrderState commentState = new OrderState();
			commentState.setDealTime(DateUtils.getSeconds());
			commentState.setOrderId(orderId);
			if ("Y".endsWith(order.getIfcourier())) {
				commentState.setState("配送完成");
				commentState.setDetail("配送员已完成配送，去评价拿积分哦");
			}else{
				commentState.setState("待评价");
				commentState.setDetail("去商家门店吃完后，请评价吧");
			}
			orderStateMapper.createOrderState(commentState);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void evaluateOrderState(Long orderId) {
		// Order order = orderMapper.getOrderByPrimaryKey(orderId);
		// User user =
		// userMapper.getUserByPrimaryKey(StringUtil.parseLong(order.getUserId()+""));
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("已完成");
		// String nickName=user.getNickname();
		// if(nickName!=null&&nickName!=""){
		// orderState.setDetail(nickName+"评价订单");
		// }else{
		// orderState.setDetail(user.getUsername()+"评价订单");
		// }
		orderState.setDetail("已评价，再去下一单吧");
		orderStateMapper.createOrderState(orderState);
	}

	///

	@Override
	public void askedRefundOrderState(Long orderId) {
		// Order order = orderMapper.getOrderByPrimaryKey(orderId);
		// User user =
		// userMapper.getUserByPrimaryKey(StringUtil.parseLong(order.getUserId()+""));
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("退款中");
		// String nickName=user.getNickname();
		// if(nickName!=null&&nickName!=""){
		// orderState.setDetail(nickName+"申请退款");
		// }else{
		// orderState.setDetail(user.getUsername()+"申请退款");
		// }
		orderState.setDetail("退款申请已提交，等待商家审核");
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void refundSuccessOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		Merchant merchant = merchantMapper.getMerchantByPrimaryKey(order.getMerchantId().longValue());
		User user = userMapper.getUserByPrimaryKey(merchant.getUserId());
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("已退款");
		String nickName = user.getNickname();
		if (nickName != null && nickName != "") {
			orderState.setDetail("商家" + nickName + "同意退款");
		} else {
			orderState.setDetail("商家" + user.getUsername() + "同意退款");
		}
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void refundFailedOrderState(Long orderId) {
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("已接单");
		orderState.setDetail("商家不同意取消订单");
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void deliveryDoneOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		User user = userMapper.getUserByPrimaryKey(order.getCourierId());
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("完成配送");
		String nickName = user.getNickname();
		if (nickName != null && nickName != "") {
			orderState.setDetail("配送员" + nickName + "完成配送");
		} else {
			orderState.setDetail("配送员" + user.getUsername() + "完成配送");
		}
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void deliveryPayOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		User user = userMapper.getUserByPrimaryKey(order.getCourierId());
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("转账");
		String nickName = user.getNickname();
		if (nickName != null && nickName != "") {
			orderState.setDetail("配送员" + nickName + "向用户转账￥" + order.getOrigin());
		} else {
			orderState.setDetail("配送员" + user.getUsername() + "向用户转账￥" + order.getOrigin());
		}
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void deliveryPayOrderState(String courier, String user, Long orderId, Double money) {
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("代付订单");
		orderState.setDetail("配送员" + courier + ",代付用户:" + user + ",代付金额:￥" + money);
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void cookDoneOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		Merchant merchant = merchantMapper.getMerchantByPrimaryKey(order.getMerchantId().longValue());
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("制作完成");
		orderState.setDetail(merchant.getTitle() + "制作完成");
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void autoCompleteOrderState(Long orderId) {
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setState("自动完成");
		orderState.setDetail("系统自动完成订单");
		orderStateMapper.createOrderState(orderState);

	}

	@Override
	public void merchantUpdateOrder(Long orderId) {
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		orderState.setDetail("商家将订单改为电话订单");
		orderState.setState("已接单");
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void userCancelOrder(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		User user = userMapper.getUserByPrimaryKey(order.getUserId().longValue());
		OrderState orderState = new OrderState();
		orderState.setDealTime(DateUtils.getSeconds());
		orderState.setOrderId(orderId);
		String nickName = user.getNickname();
		if (nickName != null && nickName != "") {
			orderState.setDetail("用户" + nickName + "取消订单");
		} else {
			orderState.setDetail("用户" + user.getUsername() + "取消订单");
		}
		orderState.setState("已取消");
		orderStateMapper.createOrderState(orderState);
	}

	@Override
	public void createPhoneOrderState(Long orderId) {
		Order order = orderMapper.getOrderByPrimaryKey(orderId);
		User user = userMapper.getUserByPrimaryKey(order.getUserId().longValue());
		Merchant merchant = merchantMapper.getMerchantByPrimaryKey(order.getMerchantId().longValue());
		OrderState orderState = new OrderState();
		orderState.setDealTime(order.getCreateTime());
		orderState.setOrderId(orderId);
		if (OrderStateEnum.PAY.getOrderStateEn().equals(order.getPayState())) {
			orderState.setState("已支付");
		} else {
			orderState.setState("未支付");
		}
		String nickName = user.getNickname();
		if (nickName != null && nickName != "") {
			orderState.setDetail("商家" + merchant.getTitle() + "生成用户" + nickName + "一个电话订单");
		} else {
			orderState.setDetail("商家" + merchant.getTitle() + "生成用户" + user.getUsername() + "一个电话订单");
		}
		orderStateMapper.createOrderState(orderState);
	}
	
	public List<OrderStateVo> getOrderStateByOrderId(Long id) {
		return orderStateMapper.getOrderStateByOrderId(id);
	}

}