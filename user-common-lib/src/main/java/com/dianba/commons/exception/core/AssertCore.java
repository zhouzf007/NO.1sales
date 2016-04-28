package com.dianba.commons.exception.core;

import java.util.Collection;

import com.dianba.commons.exception.EnumerationCheckException;
import com.dianba.commons.exception.lang.Assert;

public enum AssertCore implements ExceptionCode {
	/*
	 * 每种类型前10个错误码保留
	 */
	// 成功状态,0--999
	G0000("请求成功"),
	// 内部错误 1000 -3999
	G1000("系统繁忙"),

	G1010("保留"),
	// 调试错误 4000 -- 6999
	G4000("错误码:4000"),

	G4001("数据不存在"),

	G4002("操作过于频繁"),

	G4003("功能已经关闭"),

	G4004("参数错误"),

	G4005("保留"),

	// 业务错误 7000 -- >>
	G7000("错误码:7000"),

	G7010("保留"),

	G7011("默认地址不能删除"),

	G7012("查询不到该商家营业信息"), G7013("不能使用相同的密码"),

	 
	G7014("不存在商家信息"),
	G7015("该用户不存在"),
	G7016("查询不到该用户的地址信息,请联系技术人员"),
	G7017("orderId不能为空"),
	G7018("查询不到订单信息"),

	G7019("非法支付,重复支付"),
	G7020("非法支付,用户错误"),
	G7021("非法支付,金额错误"),
	G7022("不能再次确认收货"),
	G7023("商家已打烊"),
	G7024("部分商品不存在"),
	G7025("部分商品库存不足，请到店铺内选择其他商品下单"),
	G7026("部分商品已下架，请到店铺内选择其他商品下单"),
	G7027("部分商品已售完，请到店铺内选择其他商品下单"),
	G7028("部分商品促销状态改变，请到店铺内选择其他商品下单"),
	G7029("商家已关店"),
	G7030("查询不到用户订单"),
G9001("超出范围"),
	G9002("无效地址"),
	G9010("无法查询到该地址信息"),
	G9011("无法查询到商家信息"),
	G9012("检测存在旧密码，请输入旧密码"),
	G9013("密码验证失败"),
	G9014("不是有效的手机号码"),
	G9015("不是有效的验证码"),
	
	G9016("没有此版本！"),
	G9017("客户端版本类型不对!"),
	
	
	;
	// 内容
	/**
	 * 
	 * 以前版本
	 */
	public int code;
	/**
	 * 默认提示信息
	 */
	private String msg;

	private AssertCore(String msg) {
		this.msg = msg;
		this.code = Integer.parseInt(this.toString().replace("G", ""));
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	//

	/**
	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public void notEmpty(Collection<?> obj, String msg) {
		isTrue(obj == null || obj.isEmpty(), msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param cs
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public void notEmpty(CharSequence cs, String msg) {
		isTrue(org.springframework.util.StringUtils.hasText(cs), msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param cs
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public void notBlank(CharSequence cs, String msg) {
		isTrue(org.springframework.util.StringUtils.hasText(cs), msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public void notNull(Object obj, String msg) {
		isTrue(obj != null, msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public void notNull(Object obj) {
		isTrue(obj != null, "");
	}

	/**
	 * 判断参数是否是真 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public void isTrue(boolean b, String msg) {
		Assert.isTrue(b, this, msg);
	}

	/**
	 * 判断参数是否是真 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 * @throws EnumerationCheckException
	 */
	public void checkIsTrue(boolean b, String msg) throws EnumerationCheckException {
		Assert.checkIsTrue(b, this, msg);
	}

	/**
	 * 判断参数是否是真 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public void isTrue(boolean b) {
		isTrue(b, "");
	}

	/**
	 * 判断参数是非空 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public void notEmpty(Collection<?> collection) {
		isTrue(collection != null && !collection.isEmpty(), "");
	}

	/**
	 * 判断参数是空 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public void isEmpty(Collection<?> collection) {
		isTrue(collection == null || collection.isEmpty(), "");
	}

}
