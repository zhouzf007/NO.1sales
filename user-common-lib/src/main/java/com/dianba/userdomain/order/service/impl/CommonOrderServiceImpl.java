package com.dianba.userdomain.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dianba.userdomain.commons.vo.Proportion;
import com.dianba.userdomain.commons.vo.Result.State;
import com.dianba.userdomain.constant.OrderStateEnum;
import com.dianba.userdomain.constant.PayType;
import com.dianba.userdomain.constant.SVCException;
import com.dianba.userdomain.constant.SaleType;
import com.dianba.userdomain.core.MongoService;
import com.dianba.userdomain.discount.mapper.CommonTomMerchantMemberInfoMapper;
import com.dianba.userdomain.merchant.mapper.CommonMenuMapper;
import com.dianba.userdomain.merchant.service.MerchantInfoService;
import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.mongo.entity.QrOrderLog;
import com.dianba.userdomain.mongo.entity.ScanDiscountLog;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.order.entity.OrderMenu;
import com.dianba.userdomain.order.entity.OrderState;
import com.dianba.userdomain.order.entity.TpmScanpaySet;
import com.dianba.userdomain.order.entity.TpmScanpaySetRatio;
import com.dianba.userdomain.order.mapper.CommonOrderMapper;
import com.dianba.userdomain.order.mapper.CommonTpmScanpaySetMapper;
import com.dianba.userdomain.order.mapper.CommonTpmScanpaySetRatioMapper;
import com.dianba.userdomain.order.service.OrderMenuService;
import com.dianba.userdomain.order.service.OrderService;
import com.dianba.userdomain.order.service.OrderStateService;
import com.dianba.userdomain.order.vo.OrderDetailVo;
import com.dianba.userdomain.order.vo.OrderListVo;
import com.dianba.userdomain.order.vo.OrderMenusVo;
import com.dianba.userdomain.sysdictionary.mapper.CommonSystemConfigMapper;
import com.dianba.userdomain.user.entity.User;
import com.dianba.userdomain.user.mapper.CommonUserMapper;
import com.dianba.userdomain.user.service.UserService;
import com.dianba.userdomain.util.ConverDataUtil;
import com.dianba.userdomain.util.DateUtils;
import com.dianba.userdomain.util.DeliveryType;
import com.dianba.userdomain.util.OrderType;
import com.dianba.userdomain.util.OrderUtil;
import com.dianba.userdomain.util.ValidUtil;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
@Transactional
public class CommonOrderServiceImpl implements OrderService {
	private static final Logger logger = LoggerFactory.getLogger(CommonOrderServiceImpl.class);
	@Autowired
	private CommonOrderMapper orderMapper;
	@Autowired
	private CommonUserMapper userMapper;
	@Autowired
	private CommonMenuMapper menuMapper;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private CommonSystemConfigMapper systemConfigMapper;
	@Autowired
	private UserService userSerivce;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired 
	private OrderMenuService orderMenuService;
	@Autowired
	private OrderStateService orderStateService;
	@Autowired
	private CommonTomMerchantMemberInfoMapper tomMerchantMemberInfoMapper;
	@Autowired private MongoService mongoService;
	@Autowired private CommonTpmScanpaySetMapper tpmScanpaySetMapper;
	@Autowired private CommonTpmScanpaySetRatioMapper tpmScanpaySetRatioMapper;
	// 打印联数
	private static final int printTimes = 3;

	public List<Order> getOrderList() {
		return orderMapper.getOrderList();
	}

	public PageList<Order> getOrderList(PageBounds pageBounds) {
		return orderMapper.getOrderList(pageBounds);
	}

	public List<Order> getOrderPageList(Order order) {
		return orderMapper.getOrderPageList(order);
	}

	public PageList<Order> getOrderPageList(Order order, PageBounds pageBounds) {
		return orderMapper.getOrderPageList(order, pageBounds);
	}

	public Order getOrderByPrimaryKey(Long id) {
		return orderMapper.getOrderByPrimaryKey(id);
	}

	public Long createOrder(Order order) {
		return orderMapper.createOrder(order);
	}

	public void createOrderBitch(List<Order> orderList) {
		for (Order order : orderList) {
			orderMapper.createOrder(order);
		}
	}

	public void updateOrder(Order order) {
		orderMapper.updateOrder(order);
	}

	public void updateOrderBitch(List<Order> orderList) {
		for (Order order : orderList) {
			orderMapper.updateOrder(order);
		}
	}

	/**
	 * 更新order状态
	 */
	public void updateOrderSelective(Order order) {
		try {
			orderMapper.updateOrderSelective(order);
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}

	}

	public void updateOrderSelectiveBitch(List<Order> orderList) {
		for (Order order : orderList) {
			orderMapper.updateOrderSelective(order);
		}
	}

	public void deleteOrder(Long id) {
		orderMapper.deleteOrder(id);
	}

	public void deleteOrderBitch(List<Long> idList) {
		for (Long id : idList) {
			orderMapper.deleteOrder(id);
		}
	}

	public Long createNewOrder(Order order) {
		try {
			orderMapper.createNewOrder(order);
			return order.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Long createThirdOrder(Order order) {
		// try{
		// order.setCreateTime(ConverDataUtil.toInt(System.currentTimeMillis()/1000));
		// order.setOrderNum(HttpClientUtil.get(orderNumUrl));
		// orderMapper.createNewOrder(order);
		// return order.getId();
		// }catch(Exception e){
		// e.printStackTrace();
		// }
		return null;
	}

	public Long getOrderCreateTime(Long id) {
		return orderMapper.getOrderCreateTime(id);
	}

	public boolean validOrderByOrderId(Long orderId) {
		Long createTime = getOrderCreateTime(orderId);
		boolean flag = (System.currentTimeMillis() / 1000 - createTime) / 60.0 > 20;
		if (flag) {
			updateOrderState(orderId);
			return !flag;
		} else {
			return true;
		}
	}

	public void updateOrderState(Long id) {
		orderMapper.updateOrderState(id);
	}

	public void updateOrderScoreAndScoreMoney(Long id) {
		orderMapper.updateOrderScoreAndScoreMoney(id);
	}

	public Order getOrderByPayId(Long id) {
		return orderMapper.getOrderByPayId(id);
	}

	public List<Order> getOrders(Long id) {
		return orderMapper.getOrders(id);
	}

	public Long createNewEatInOrder(Order order) {
		orderMapper.createNewEatInOrder(order);
		return order.getId();
	}

	public Order judgeHaveAskrefund(Map<String, Object> map) {
		return orderMapper.judgeHaveAskrefund(map);
	}
	
	@Override
	public Long createOrderAsSaleTypeOne(String payId, User user, String merchantId, Double checkCost,
			String addressMobile, String addressAddress, String addressName, String remarks, String saleType,
			String timeRemark, String userAddressId, Integer score, BigDecimal scoreMoney, Double costDelivery,
			String payType, Double costLunchBox, String invoice, List<OrderMenusVo> list,
			BigDecimal userGradeDiscountMoney, BigDecimal couponMoney, String couponSn,
			BigDecimal userMechantMemberMoney, BigDecimal takeOutCostLunchBox, BigDecimal dineIndiscountMoney) {
		Order order = new Order();
		order.setPayId(payId);
		order.setUserId(user.getId());
		order.setCityId(0L);
		order.setMerchantId(Integer.valueOf(merchantId));
		order.setState("unpay");
		order.setOrigin(new BigDecimal(checkCost).setScale(2, BigDecimal.ROUND_HALF_UP));
		order.setMobile(addressMobile);
		order.setAddress(addressAddress);
		order.setRealname(addressName);
		order.setRemark(remarks);
		order.setOrderType("normal");
		order.setSaleType(Integer.valueOf(saleType));
		order.setTimeRemark(timeRemark);
		order.setUserAddressId(Integer.valueOf(userAddressId));
		order.setScore(score);
		order.setScoreMoney(scoreMoney);
		order.setDeliveryFee(new BigDecimal(costDelivery).setScale(2, BigDecimal.ROUND_HALF_UP));
		order.setPayType(payType);
		order.setInvoice(invoice);
		order.setIfcourier("Y");
		order.setCardId(couponSn);
		order.setCard(couponMoney);
		order.setMemberDiscountMoney(userGradeDiscountMoney);
		order.setMerchantMemberDiscountMoney(userMechantMemberMoney);
		order.setCostLunchBox(takeOutCostLunchBox);
		order.setDineInDiscountMoney(dineIndiscountMoney);
		Long orderId = createNewOrder(order);

		// OrderState orderState =new OrderState();
		// orderState.setDealTime(DateUtils.getSeconds());
		// orderState.setOrderId(orderId);
		// orderState.setDetail("提交了一个订单");
		// orderState.setState("未支付");
		orderStateService.createOrderState(orderId);
		// 循环购物车插入order_menu表
		for (OrderMenusVo o : list) {
			OrderMenu orderMenu = new OrderMenu();
			orderMenu.setOrderId(orderId.intValue());
			orderMenu.setMenuId(o.getMenuId());
			orderMenu.setQuantity(o.getCount());
			orderMenu.setPrice(o.getPrice());
			orderMenu.setTotalPrice(
					o.getPrice().multiply(new BigDecimal(o.getCount()).setScale(2, BigDecimal.ROUND_HALF_UP)));
			orderMenu.setPromotionMoney(o.getPromotionMoney());
			orderMenu.setSalesPromotion(o.getPromotion());
			if(o.getPromotionId() != null){
				orderMenu.setMenuPromotionId(o.getPromotionId().intValue());
			}
			orderMenuService.createNewOrderMenu(orderMenu);
		}
		return orderId;
	}

	@Override
	public Long createOrderAsSaleTypeTwo(String payId, User user, String merchantId, Double checkCost, String remarks,
			String saleType, String timeRemark, Integer score, BigDecimal scoreMoney, Double costDelivery,
			String payType, Double costLunchBox, String invoice, List<OrderMenusVo> list,
			BigDecimal userGradeDiscountMoney, BigDecimal couponMoney, String couponSn,
			BigDecimal userMechantMemberMoney, BigDecimal dineIndiscountMoney) {
		Order order = new Order();
		order.setPayId(payId);
		order.setUserId(user.getId());
		order.setCityId(0L);
		order.setMerchantId(Integer.valueOf(merchantId));
		order.setState("unpay");
		order.setOrigin(new BigDecimal(checkCost).setScale(2, BigDecimal.ROUND_HALF_UP));
		order.setRemark(remarks);
		order.setOrderType("normal");
		order.setSaleType(Integer.valueOf(saleType));
		order.setTimeRemark(timeRemark);
		order.setScore(score);
		order.setScoreMoney(scoreMoney);
		// 堂食没有配送费
		order.setDeliveryFee(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));
		order.setPayType(payType);
		// 堂食没有餐盒费
		order.setCostLunchBox(new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP));
		order.setInvoice(invoice);
		order.setIfcourier("N");
		order.setCardId(couponSn);
		order.setCard(couponMoney);
		order.setMemberDiscountMoney(userGradeDiscountMoney);
		order.setMerchantMemberDiscountMoney(userMechantMemberMoney);
		order.setDineInDiscountMoney(dineIndiscountMoney);
		Long orderId = createNewEatInOrder(order);

		// OrderState orderState =new OrderState();
		// orderState.setDealTime(DateUtils.getSeconds());
		// orderState.setOrderId(orderId);
		// if(user.getNickname() != null && user.getNickname() != ""){
		// orderState.setDetail(user.getNickname()+"提交了一个订单");
		// }else{
		// orderState.setDetail(user.getUsername()+"提交了一个订单");
		// }
		// orderState.setState("未支付");
		orderStateService.createOrderState(orderId);
		// 循环购物车插入order_menu表
		for (OrderMenusVo o : list) {
			OrderMenu orderMenu = new OrderMenu();
			orderMenu.setOrderId(orderId.intValue());
			orderMenu.setMenuId(o.getMenuId());
			orderMenu.setQuantity(o.getCount());
			orderMenu.setPrice(o.getPrice());
			orderMenu.setTotalPrice(
					o.getPrice().multiply(new BigDecimal(o.getCount()).setScale(2, BigDecimal.ROUND_HALF_UP)));
			orderMenu.setPromotionMoney(o.getPromotionMoney());
			orderMenu.setSalesPromotion(o.getPromotion());
			if(o.getPromotionId() != null){
				orderMenu.setMenuPromotionId(o.getPromotionId().intValue());
			}
			orderMenuService.createNewOrderMenu(orderMenu);

		}
		return orderId;
	}





	@Override
	public List<Map<String, Object>> countByStatus(Map<String, Object> map) {
		return orderMapper.countByStatus(map);
	}

	@Override
	public List<Map<String, Object>> countByStatusWhenConfirm(Map<String, Object> map) {
		return orderMapper.countByStatusWhenConfirm(map);
	}




	/**
	 * 查询用户此订单实际支付金额
	 */
	public String getOrderRealMoney(Order order) {
		String totalMoney = "0.00";
		totalMoney = order.getOrigin() // 菜品金额
				.add(order.getCostLunchBox()) // 餐盒费
				.add(order.getDeliveryFee()) // 配送费
				.subtract(order.getMemberDiscountMoney()) // 平台会员折扣
				.subtract(order.getMerchantMemberDiscountMoney()) // 商家会员折扣
				.subtract(order.getDineInDiscountMoney()) // 堂食折扣
				.subtract(order.getScoreMoney()) // 积分抵扣
				.subtract(order.getCard()).setScale(2, BigDecimal.ROUND_HALF_UP).toString(); // 优惠券抵扣
		return totalMoney;
	}

	

	@Override
	public void userConfirmOrder(Order oldOrder) {
		/*updateOrderSelective(oldOrder);
		Order order = getOrderByPrimaryKey(oldOrder.getId());
		orderIncomeService.createOrderIncome(order);
		sendMessage(order, "done");
		logger.info("发送模板成功");
		orderStateService.doneOrderState(order.getId());
		Order payOrder = getOrderByPrimaryKey(order.getId());
		List<Map<String, Object>> doneList = confirmOrderList(payOrder);
		if (doneList != null && doneList.size() > 0 && order.getCourierId() != 0) {
			Map<String, Object> doneMap = doneList.get(0);
			Map<String, String> pushMap = new HashMap<String, String>();
			pushMap.put("orderId", payOrder.getId().toString());
			pushMap.put("delivery_done", doneMap.get("c").toString());
			// JPush.push(new String[]{order.getCourierId().toString()},
			// "订单已确认", "已确认", "", pushMap);
			String title = "您有一条新的已确认订单";
			String content = title;
			String voiceFile = "new_order.mp3";
			String result = JPush.push(new String[] { order.getCourierId().toString() }, title, content, voiceFile,
					pushMap);
			// JpushLog jpushLog = new JPushLogEntity(title, content, voiceFile,
			// order.getCourierId().toString(), pushMap.toString());
			JpushLog jpushLog = new JpushLog();
			jpushLog.setTitle(title);
			jpushLog.setContent(content);
			jpushLog.setVoiceFile(voiceFile);
			jpushLog.setTargets(order.getCourierId().toString());
			jpushLog.setExtras(pushMap.toString());
			jpushLog.setResultTime(DateUtils.getSeconds());
			jpushLog.setResult(result);
			jpushLogMapper.createJpushLog(jpushLog);
		}*/
	}



	@Override
	public Order judgeHaveCancel(Long id) {
		return orderMapper.judgeHaveCancel(id);
	}

	@Override
	public Long createCengRiceOrder(Order order) {
		try {
			orderMapper.createCengRiceOrder(order);
			return order.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	



	@Override
	public Order getThirdOrder(String pay_id, String from_type, String order_type) {
		return orderMapper.getThirdOrder(pay_id, from_type, order_type);
	}

	@Override
	public Order judgeIsComfirm(Map<String, Object> map) {
		return orderMapper.judgeIsComfirm(map);
	}

	@Override
	public Long createQcCodeOrder(String payId, User user, String merchantId, Double checkCost, String saleType,
			String payType) {
		Order order = new Order();
		order.setPayId(payId);
		order.setUserId(user.getId());
		order.setCityId(0L);
		order.setMerchantId(Integer.valueOf(merchantId));
		order.setState("unpay");
		order.setOrigin(new BigDecimal(checkCost).setScale(2, BigDecimal.ROUND_HALF_UP));
		order.setOrderType("scan_order");
		order.setSaleType(Integer.valueOf(saleType));
		// 堂食没有配送费
		order.setPayType(payType);
		order.setIsMerchantDelivery("courier"); // 是否商家配送：merchant商家配送		// 堂食没有餐盒费
		// order.setFromType("qcCode");
		Long orderId = createQcCodeOrder(order);

		// OrderState orderState =new OrderState();
		// orderState.setDealTime(DateUtils.getSeconds());
		// orderState.setOrderId(orderId);
		// if(user.getNickname() != null && user.getNickname() != ""){
		// orderState.setDetail(user.getNickname()+"提交了一个订单");
		// }else{
		// orderState.setDetail(user.getUsername()+"提交了一个订单");
		// }
		// orderState.setState("未支付");
		orderStateService.createOrderState(orderId);
		return orderId;
	}

	@Override
	public Long createQcCodeOrder(Order order) {
		try {
			orderMapper.createQcCodeOrder(order);
			return order.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Order getOrderByUserId(Map<String, Object> map) {
		return orderMapper.getOrderByUserId(map);
	}

	@Override
	public List<Map<String, Object>> confirmOrderList(Order order) {
		return orderMapper.confirmOrderList(order);
	}

	@Override
	public PageList<OrderListVo> getUserOrderListPage(Long id, PageBounds pageBounds) {
		return orderMapper.getUserOrderListPage(id, pageBounds);
	}
	
	@Override
	public Map<String, Object> getOrderMerchantSource(Long orderId) {
		return orderMapper.getOrderMerchantSource(orderId);
	}


	@Override
	public Order judgeIsAccept(Map<String, Object> map) {
		return orderMapper.judgeIsAccept(map);
	}

	@Override
	public String getOrderPayType(Long id) {
		return orderMapper.getOrderPayType(id);
	}

	@Override
	public Long createRechargeOrder(Order order) {
		try {
			orderMapper.createRechargeOrder(order);
			return order.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BigDecimal getRealPayMoney(Order order) {
		return order.getOrigin().add(order.getCostLunchBox())// 加上餐盒费
				.add(order.getDeliveryFee())// 加上配送费
				.subtract(order.getScoreMoney())// 减去积分抵扣金额
				.subtract(order.getCard())// 减去优惠券抵扣金额
				.subtract(order.getMemberDiscountMoney());// 减去会员折扣金额
	}

	// ############ 二维码订单 ############
	@Override
	public Order createQRCodeOrder(Long mcid, Long uid, Double money, OrderType orderType, SaleType saleType, PayType payType, DeliveryType deliveryType) throws SVCException {
	    return createQRCodeOrder(null, mcid, uid, money, orderType, saleType, payType, deliveryType);
	}
	
	@Override
	public Order createQRCodeOrderByAgent(Integer agentId, Long uid, Double money, OrderType orderType, SaleType saleType, PayType payType, DeliveryType deliveryType) throws SVCException {
        Integer merchantId = merchantInfoService.findRechargeMerchantId();
        logger.info("代理商充值商家id---------------" + merchantId);
        return createQRCodeOrder(agentId, (long) merchantId, uid, money, orderType, saleType, payType, deliveryType);
	}
	
	@Override
	public Integer findDiscountMoney(Order order) {
	    //打折
        Integer moneyMin = tpmScanpaySetMapper.getMerchantMoneyMin(order.getMerchantId());
        if (ValidUtil.anyEmpty(moneyMin)) {
            logger.info("商家{}未设置随机立减规则", order.getMerchantId());
            return 0;
        }

        Integer needPayMoney = (int) (order.getOrigin().doubleValue() * 100);
        //支付金额大于最低立减
        if (needPayMoney >= moneyMin) return prizeMoney(order.getId(), order.getMerchantId(), order.getUserId());
        else logger.info("用户在商家{}支付金额{}小于最低立减金额{},没有优惠原价支付", order.getMerchantId(), needPayMoney, moneyMin);
        return 0;
	}
	
	
	private Order createQRCodeOrder(Integer agentId, Long mcid, Long uid, Double money, OrderType orderType, SaleType saleType, PayType payType, DeliveryType deliveryType) throws SVCException{
        //参数校验
        if(ValidUtil.anyEmpty(mcid, money, orderType, payType, deliveryType)) throw SVCException.error(State.ParamError.ret());
        
        //有当天同商家 同金额 30分钟内 同用户的订单 直接使用原来的订单进行支付
        Long oldOrderId = findReCreatedOrderId(mcid, uid, money, saleType, payType);
        if(null != oldOrderId) return getOrderByPrimaryKey(oldOrderId);
        
        //创建订单
        Order cOrder = newQRCodeOrder(uid, mcid, money, orderType, saleType, payType, deliveryType);
        Long orderId = null;
        
        if(null != agentId){
            cOrder.setAgentId(agentId);
            cOrder.setFromType("qcCode");
            orderId = orderMapper.createQcCodeOrderByAgent(cOrder);
        }else{
            orderId = orderMapper.createQcCodeOrder(cOrder);
        }
        if(null == orderId) throw new SVCException(State.Error.ret("创建扫码订单失败!"));;
        
        //创建订单状态
        OrderState ostate = createState(orderId, OrderStateEnum.UNPAY);
        if(null == ostate) throw new SVCException(State.Error.ret("创建订单状态失败!"));
        return cOrder;
    }
	
	
	/**
	 * 创建扫码订单实体
	 * @param uid 用户id
	 * @param mcid 商家id
	 * @param money 金额
	 * @param saleType 销售类型
	 * @param payType 支付类型
	 * @param deliveryType 是否商家配送
	 * @return
	 */
	private Order newQRCodeOrder(Long uid, Long mcid, Double money, OrderType orderType, SaleType saleType, PayType payType, DeliveryType deliveryType){
	    Order order = new Order();
        order.setPayId(OrderUtil.getSanOrderPayId(orderType));
        order.setUserId(uid);
        order.setCityId(0L);
        order.setMerchantId(ConverDataUtil.toInt(mcid));
        order.setState(OrderStateEnum.UNPAY.getOrderStateEn());
        order.setOrigin(OrderUtil.dp(money, 2));
        order.setOrderType(orderType.getName());
        order.setSaleType(saleType.getCode());
        order.setIsMerchantDelivery(deliveryType.name());
        order.setPayType(payType.name());
        return order;
	}
	
	/**
	 * 找到缓存的订单id
	 * @param mcid 商家id
	 * @param uid 用户id
	 * @param money 金额
	 * @param saleType 销售类型
	 * @param payType 支付类型
	 * @return
	 */
	public Long findReCreatedOrderId(Long mcid, Long uid, Double money, SaleType saleType, PayType payType){
        QrOrderLog searchOrderLog = new QrOrderLog();
        searchOrderLog.uid = uid;
        searchOrderLog.merchantId = ConverDataUtil.toInt(mcid);
        searchOrderLog.order_money = money;
        searchOrderLog.sale_type = saleType.getCode();
        searchOrderLog.pay_type = payType.name();
        searchOrderLog.created_time = DateUtils.formatDate(new Date());
        searchOrderLog.status = -1;
        QrOrderLog orderLog = mongoService.findOne(searchOrderLog);
        if(null != orderLog && null != orderLog.order_id && null != orderLog.time){
            // 30分支内的订单才可重新支付
            Long thisTime = System.currentTimeMillis();
            Long fiveMinute = orderLog.time + (25 * DateUtils.MINUTE_IN_MILLIS);
            if(thisTime <= fiveMinute) return orderLog.order_id;
            else{
                //清除缓存的单
                QrOrderLog upOrderLog = new QrOrderLog();
                upOrderLog.status = 1;
                try {
                    orderLog.id = null;
                    mongoService.updateMulti(searchOrderLog, upOrderLog);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
        return null;
    }
	
	/**
	 * 保存订单状态记录
	 * @param orderId
	 * @param state
	 * @return
	 */
	private OrderState createState(Long orderId, OrderStateEnum state){
	    OrderState orderState = new OrderState();
        orderState.setDealTime(DateUtils.getSeconds());
        orderState.setOrderId(orderId);
        
        //订单状态记录
        switch (state) {
        case UNPAY:
            orderState.setState("未支付");
            orderState.setDetail("15分钟内未付款，订单自动取消");
            break;

        default:
            break;
        }
	    
        orderStateService.createOrderState(orderState);
        return orderState;
	}
	
	/**
     * 随机立减金额
     */
    private int prizeMoney(Long orderId, Integer mcid, Long uid) {
        //如果有历史优惠则使用历史优惠
        ScanDiscountLog scanDiscountLog = new ScanDiscountLog();
        scanDiscountLog.order_id = orderId;
        scanDiscountLog = mongoService.findOne(scanDiscountLog);
        if(null != scanDiscountLog){
            logger.info("找到历史扣减金额 订单:{} 扣减金额:{}", orderId, scanDiscountLog.discountMoney);
            return scanDiscountLog.discountMoney;
        }
        
        // 读取商家 中奖率和中奖金额
        List<TpmScanpaySetRatio> proportionList = findScanPaySetRatio(mcid);
        if (!CollectionUtils.isEmpty(proportionList)) {
            // 立减算法
            int totalRate = 0;
            List<Proportion> list = new ArrayList<Proportion>();
            for (int i = 0; i < proportionList.size(); i++) {
                totalRate += proportionList.get(i).getProportion();
                Proportion p = new Proportion();
                int begin = (0 == i) ? 1 : (list.get(i - 1).getEnd() + 1);
                p.setBegin(begin);
                int end = (0 == i) ? proportionList.get(i).getProportion()
                                : list.get(i - 1).getEnd() + proportionList.get(i).getProportion();
                p.setEnd(end);
                p.setMaxMoney(proportionList.get(i).getMoneyMax());
                p.setMinMoney(proportionList.get(i).getMoneyMin());
                p.scanPayId = proportionList.get(i).getScanpayId();
                p.discount = proportionList.get(i).getProportion();
                list.add(p);
            }

            //总几率
            Integer random = ThreadLocalRandom.current().nextInt(totalRate);
            for (int i = 0; i < list.size(); i++) {
                //匹配到其中一条规则
                if (random >= list.get(i).getBegin() && random <= list.get(i).getEnd()) {
                    // 中奖了,再random maxmoney 和minmoney 单位 分
                    Integer max = list.get(i).getMaxMoney();
                    Integer min = list.get(i).getMinMoney();
                    int runDom = (max - min > 0) ? max - min : 1;
                    Integer moneyRandom = ThreadLocalRandom.current().nextInt(runDom) + min;
                    Double wrate = new BigDecimal((list.get(i).getEnd() - list.get(i).getBegin())).divide(new BigDecimal(totalRate)).doubleValue();
                    logger.info("---end--商家:{}-随机数:{}-几率:{}-金额区间:[{}->{}]-扣减金额:{}(分)", mcid, random, wrate, min, max, moneyRandom);
                    saveScanDiscountLog(orderId, list.get(i).scanPayId, list.get(i).discount, mcid, uid, moneyRandom);
                    //保存优惠记录
                    return moneyRandom;
                }
                // 最后中奖率有问题处理
                if (i == (list.size() - 1)) {
                    logger.warn("商家{}中奖率设置有问题,总中奖率:{}", mcid, totalRate);
                    return 0;
                }
            }
        }

        logger.warn("没有找到商家{}设置的随机立减规则", mcid);
        return 0;
    }
    
    /**
     * 获得该商家支持的扫码优惠规则
     * @param mcid
     * @return
     */
    private List<TpmScanpaySetRatio> findScanPaySetRatio(Integer mcid){
        // 读取商家 中奖率和中奖金额
        List<TpmScanpaySetRatio> olrOroportionList = tpmScanpaySetRatioMapper.getMerchantProportion(mcid);
        
        List<TpmScanpaySetRatio> proportionList = new ArrayList<>();
        //取出掉已用完次数的优惠规则
        for (TpmScanpaySetRatio TpmScanpaySetRatio : olrOroportionList) {
            ScanDiscountLog scanDiscountLog = new ScanDiscountLog();
            scanDiscountLog.scan_id = TpmScanpaySetRatio.getScanpayId();
            scanDiscountLog.discount = TpmScanpaySetRatio.getProportion();
            scanDiscountLog.created_time = DateUtils.formatDate(new Date());
            scanDiscountLog.status = 1;
            int scanThisDayCount = mongoService.count(scanDiscountLog);
            if(scanThisDayCount > 1){
               //如果该规则已使用次数达到最大上限
               TpmScanpaySet tss = tpmScanpaySetMapper.getTpmScanpaySetByPrimaryKey(TpmScanpaySetRatio.getScanpayId());
               if(null == tss){
                   logger.error("有误优惠规则{}", TpmScanpaySetRatio.getScanpayId());
                   continue;
               }
               int totalCount = (int) (tss.getEverydayCount() * OrderUtil.pointConverToYuan(scanDiscountLog.discount));
               if(scanThisDayCount > totalCount){
                   logger.info("优惠规则:{}-当前第{}人,已达到最大使用人数:{}", TpmScanpaySetRatio.getScanpayId(), scanDiscountLog.count, totalCount);
                   continue;
               }
            }
            proportionList.add(TpmScanpaySetRatio);
        }
        return proportionList;
    }
    
    /**
     * 保存订单折扣记录
     * @param orderId
     * @param scanId
     * @param discount
     * @param mcid
     * @param uid
     * @param discountMoney
     */
    private void saveScanDiscountLog(Long orderId, Integer scanId, Integer discount, Integer mcid, Long uid, Integer discountMoney){
        ScanDiscountLog scanDiscountLog = new ScanDiscountLog();
        scanDiscountLog.order_id = orderId;
        scanDiscountLog.scan_id = scanId;
        scanDiscountLog.discount = discount;
        scanDiscountLog.created_time = DateUtils.formatDate(new Date());
        scanDiscountLog.status = -1;
        scanDiscountLog.mcid = mcid;
        scanDiscountLog.uid = uid;
        scanDiscountLog.discountMoney = discountMoney;
        mongoService.save(scanDiscountLog);
    }
    
	public OrderDetailVo getUserOrderState(Long id) {
		return orderMapper.getUserOrderState(id);
	}
}