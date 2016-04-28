package com.dianba.userdomain.discount.service;

import java.util.List;

import com.dianba.userdomain.constant.CouponType;
import com.dianba.userdomain.constant.SaleType;
import com.dianba.userdomain.controller.bean.UserCouponDetail;
import com.dianba.userdomain.order.entity.Order;
import com.dianba.userdomain.sysdictionary.entity.SysText;
import com.dianba.userdomain.util.ServiceErrorException;

/**
 * 优惠券功能
 * 
 * @author folo
 *
 */
public interface CouponService {

	/**
	 * 获取当前下单可用优惠券分页
	 * 
	 * @param createOrderType
	 *            下单的类型 <font color='red'><必填></font>
	 * @param merchantId
	 *            商家id <font color='red'><必填></font>
	 * @param userId
	 *            用户id <font color='red'><必填></font>
	 * @param actualMoney
	 *            订单实际支付金额 单位:分 <font color='red'><必填></font>
	 * @param page
	 *            当前页数 <font color='orange'>默认=1</font>
	 * @param pageSize
	 *            每页条数 <font color='orange'>默认=10</font>
	 * @return 失败:<font color='red'>null</font>
	 */
	public List<UserCouponDetail> getNowCouponPageList(SaleType createOrderType, Integer merchantId, Long userId,
			Integer actualMoney, Integer page, Integer pageSize);

	/**
	 * 获取当前下单可用优惠券数
	 * 
	 * @param createOrderType
	 *            下单的类型 <font color='red'><必填></font>
	 * @param merchantId
	 *            商家id <font color='red'><必填></font>
	 * @param userId
	 *            用户id <font color='red'><必填></font>
	 * @param actualMoney
	 *            订单实际支付金额 单位:分 <font color='red'><必填></font>
	 * @return 失败:<font color='red'>0</font>
	 */
	public int getNowCouponCount(SaleType createOrderType, Integer merchantId, Long userId, Integer actualMoney);

	/**
	 * 获取优惠券详细
	 * 
	 * @param couponSns
	 *            用户优惠券编码，多个用逗号","隔开 <font color='red'><必填></font>
	 * @param userId
	 *            用户id <font color='red'><必填></font>
	 * @return 暂时只支持:List<UserCouponDetail>,UserCouponDetail 失败:
	 *         <font color='red'>null</font> 成功:
	 *         <font color='green'>按照需要返回的类型返回</font>
	 */
	public <T> T getCouponDetail(String couponSns, Long userId);

	/**
	 * 使用优惠券
	 * 
	 * @param merchantId
	 *            商家id <font color='red'><必填></font>
	 * @param userId
	 *            用户id <font color='red'><必填></font>
	 * @param actualMoney
	 *            订单实际支付金额 <font color='red'><必填></font>
	 * @param couponSns
	 *            需要使用的用户优惠券编码 <font color='red'><必填></font>
	 * @param createOrderType
	 *            下单的类型(外卖、堂食、自提)
	 * @return 成功:<font color='green'>true</font>, 失败:
	 *         <font color='red'>false</font>
	 */
	public boolean getUseCase(Integer merchantId, Long userId, Integer actualMoney, String couponSn,
			SaleType createOrderType) throws RuntimeException;

	/**
	 * 查看是否有可发优惠券
	 * 
	 * @param CouponType
	 *            平台类型，null 为两个之中只有一个通过则通过
	 * @param order
	 * @return
	 * @throws ServiceErrorException
	 */
	public boolean canCreateCouponFission(CouponType type, Order order) throws ServiceErrorException;

	/**
	 * 查看是否有可发优惠券
	 * 
	 * @param CouponType
	 *            平台类型，null 为两个之中只有一个通过则通过
	 * @param order
	 * @return
	 * @throws ServiceErrorException
	 */
	public boolean canCreateCouponFission(Order order) throws ServiceErrorException;


	 /**
    * 获取优惠券使用说明
    * @param type coupon_guide=优惠券使用说明
    * @return 失败:<font color='red'>null</font>
    */
   public List<SysText> getUserExplain(String type);
}
