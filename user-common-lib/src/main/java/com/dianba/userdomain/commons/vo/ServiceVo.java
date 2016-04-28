package com.dianba.userdomain.commons.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dianba.userdomain.discount.service.CouponService;
import com.dianba.userdomain.discount.service.TomMerchantMemberDiscountService;
import com.dianba.userdomain.discount.service.TomMerchantMemberInfoService;
import com.dianba.userdomain.discount.service.TomPlatformAduitService;
import com.dianba.userdomain.merchant.service.MenuService;
import com.dianba.userdomain.merchant.service.MenuTypeService;
import com.dianba.userdomain.merchant.service.MerchantInfoService;
import com.dianba.userdomain.merchant.service.MerchantOpenTimeService;
import com.dianba.userdomain.merchant.service.MerchantService;
import com.dianba.userdomain.order.service.OrderCommentService;
import com.dianba.userdomain.order.service.OrderMenuService;
import com.dianba.userdomain.order.service.OrderService;
import com.dianba.userdomain.order.service.OrderStateService;
import com.dianba.userdomain.order.service.PayService;
import com.dianba.userdomain.order.service.RechargeService;
import com.dianba.userdomain.statistics.service.TsmGradeService;
import com.dianba.userdomain.statistics.service.TumUserStatisticsService;
import com.dianba.userdomain.sysdictionary.service.SysCodeService;
import com.dianba.userdomain.sysdictionary.service.SystemConfigService;
import com.dianba.userdomain.user.service.AddressService;
import com.dianba.userdomain.user.service.UserService;


@Service
public class ServiceVo {
	@Autowired
	private UserService userService;
	@Autowired
	private MerchantService merchantService;
	@Autowired
	private MerchantInfoService merchantInfoService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private MerchantOpenTimeService merchantOpenTimeService;
	@Autowired
	private MenuTypeService menuTypeService;
	@Autowired
	private TomPlatformAduitService tomPlatformAduitService;
	@Autowired
	private TsmGradeService tsmGradeService;
	@Autowired
	private SystemConfigService systemConfigService;
	@Autowired
	private TomMerchantMemberDiscountService tomMerchantMemberDiscountService;
	@Autowired
	private TomMerchantMemberInfoService tomMerchantMemberInfoService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderMenuService orderMenuService;
	@Autowired
	private RechargeService rechargeService;
	@Autowired
	private PayService payService;

	@Autowired 
	private TumUserStatisticsService tumUserStatisticsService;
	@Autowired
	private OrderCommentService orderCommentService;
	@Autowired
	private SysCodeService sysCodeService;
	@Autowired
	private OrderStateService orderStateService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public MerchantService getMerchantService() {
		return merchantService;
	}

	public void setMerchantService(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	public MerchantInfoService getMerchantInfoService() {
		return merchantInfoService;
	}

	public void setMerchantInfoService(MerchantInfoService merchantInfoService) {
		this.merchantInfoService = merchantInfoService;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}

	public MerchantOpenTimeService getMerchantOpenTimeService() {
		return merchantOpenTimeService;
	}

	public void setMerchantOpenTimeService(MerchantOpenTimeService merchantOpenTimeService) {
		this.merchantOpenTimeService = merchantOpenTimeService;
	}

	public MenuTypeService getMenuTypeService() {
		return menuTypeService;
	}

	public void setMenuTypeService(MenuTypeService menuTypeService) {
		this.menuTypeService = menuTypeService;
	}

	public TomPlatformAduitService getTomPlatformAduitService() {
		return tomPlatformAduitService;
	}

	public void setTomPlatformAduitService(TomPlatformAduitService tomPlatformAduitService) {
		this.tomPlatformAduitService = tomPlatformAduitService;
	}

	public TsmGradeService getTsmGradeService() {
		return tsmGradeService;
	}

	public void setTsmGradeService(TsmGradeService tsmGradeService) {
		this.tsmGradeService = tsmGradeService;
	}

	public SystemConfigService getSystemConfigService() {
		return systemConfigService;
	}

	public void setSystemConfigService(SystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}

	public TomMerchantMemberDiscountService getTomMerchantMemberDiscountService() {
		return tomMerchantMemberDiscountService;
	}

	public void setTomMerchantMemberDiscountService(TomMerchantMemberDiscountService tomMerchantMemberDiscountService) {
		this.tomMerchantMemberDiscountService = tomMerchantMemberDiscountService;
	}

	public TomMerchantMemberInfoService getTomMerchantMemberInfoService() {
		return tomMerchantMemberInfoService;
	}

	public void setTomMerchantMemberInfoService(TomMerchantMemberInfoService tomMerchantMemberInfoService) {
		this.tomMerchantMemberInfoService = tomMerchantMemberInfoService;
	}

	public CouponService getCouponService() {
		return couponService;
	}

	public void setCouponService(CouponService couponService) {
		this.couponService = couponService;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public OrderMenuService getOrderMenuService() {
		return orderMenuService;
	}

	public void setOrderMenuService(OrderMenuService orderMenuService) {
		this.orderMenuService = orderMenuService;
	}

	public RechargeService getRechargeService() {
		return rechargeService;
	}

	public void setRechargeService(RechargeService rechargeService) {
		this.rechargeService = rechargeService;
	}

	public PayService getPayService() {
		return payService;
	}

	public void setPayService(PayService payService) {
		this.payService = payService;
	}

	public TumUserStatisticsService getTumUserStatisticsService() {
		return tumUserStatisticsService;
	}

	public void setTumUserStatisticsService(TumUserStatisticsService tumUserStatisticsService) {
		this.tumUserStatisticsService = tumUserStatisticsService;
	}

	public OrderCommentService getOrderCommentService() {
		return orderCommentService;
	}

	public void setOrderCommentService(OrderCommentService orderCommentService) {
		this.orderCommentService = orderCommentService;
	}

	public SysCodeService getSysCodeService() {
		return sysCodeService;
	}

	public void setSysCodeService(SysCodeService sysCodeService) {
		this.sysCodeService = sysCodeService;
	}

	public OrderStateService getOrderStateService() {
		return orderStateService;
	}

	public void setOrderStateService(OrderStateService orderStateService) {
		this.orderStateService = orderStateService;
	}
	
}
