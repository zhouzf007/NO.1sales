/**
 * 
 */
package com.dianba.commons.exception.core;

import java.util.Collection;

/**
 * 默认判断操作
 *
 * @author zhoucong
 * @date 2016年3月25日 下午3:35:45
 */
public interface ExceptionCode {
//	/**
//	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 * @param msg
//	 *            替换默认的提示音,不需要可不传
//	 */
//	default public void notEmpty(Collection<?> obj, String msg) {
//		isTrue(obj == null || obj.isEmpty(), msg);
//	}
//
//	/**
//	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param cs
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 * @param msg
//	 *            替换默认的提示音,不需要可不传
//	 */
//	default public void notEmpty(CharSequence cs, String msg) {
//		isTrue(cs == null || cs.length() > 0, msg);
//	}
//
//	/**
//	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param cs
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 * @param msg
//	 *            替换默认的提示音,不需要可不传
//	 */
//	default public void notBlank(CharSequence cs, String msg) {
//		isTrue(org.springframework.util.StringUtils.hasText(cs), msg);
//	}
//
//	/**
//	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 * @param msg
//	 *            替换默认的提示音,不需要可不传
//	 */
//	default public void notNull(Object obj, String msg) {
//		isTrue(obj != null, msg);
//	}
//
//	/**
//	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 */
//	default public void notNull(Object obj) {
//		isTrue(obj != null, "");
//	}
//
//	/**
//	 * 判断参数是否是真 ,假设否,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 * @param msg
//	 *            替换默认的提示音,不需要可不传
//	 */
//	default public void isTrue(boolean b, String msg) {
//		isTrue(b, msg);
//	}
//
//	/**
//	 * 判断参数是否是真 ,假设否,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 */
//	default public void isTrue(boolean b) {
//		isTrue(b, "");
//	}
//
//	/**
//	 * 判断参数是非空 ,假设否,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 */
//	default public void notEmpty(Collection<?> collection) {
//		isTrue(collection != null && !collection.isEmpty(), "");
//	}
//
//	/**
//	 * 判断参数是空 ,假设否,飞出 coreEnum 对应错误码的异常类
//	 * 
//	 * @param obj
//	 *            判断对象
//	 * @param coreEnum
//	 *            异常码
//	 */
//	default public void isEmpty(Collection<?> collection) {
//		isTrue(collection == null || collection.isEmpty(), "");
//	}

}
