package com.dianba.commons.exception.lang;

import java.util.Collection;

import org.springframework.util.StringUtils;

import com.dianba.commons.exception.APIIllegalArgumentException;
import com.dianba.commons.exception.DataNotFoundException;
import com.dianba.commons.exception.EnumerationCheckException;
import com.dianba.commons.exception.EnumerationException;
import com.dianba.commons.exception.core.AssertCore;

/**
 * APP 接口判断的工具类,
 * 
 * @author mjorcen
 * @date 2016-03-07 11:43:49
 */
public class Assert {
	/**
	 * 判断参数是否是空,假设是,飞出 APIIllegalArgumentException
	 * 
	 * @param obj
	 *            判断对象
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public static final void checkArgumentNotNull(Object obj, String msg) {
		if (obj == null) {
			throw new APIIllegalArgumentException(msg);
		}
	}

	/**
	 * 判断条件是否是真 ,假设否,飞出 APIIllegalArgumentException
	 * 
	 * @param b
	 *            判断对象
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 * @author mjorcen
	 */
	public static final void checkArgumentIsTrue(boolean b, String msg) {
		if (!b) {
			throw new APIIllegalArgumentException(msg);
		}
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 APIIllegalArgumentException
	 * 
	 * @param obj
	 *            判断对象
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 * @author mjorcen
	 */
	public static final void checkArgumentNotEmpty(Collection<?> obj, String msg) {
		checkArgumentIsTrue(obj == null || obj.isEmpty(), msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 APIIllegalArgumentException
	 * 
	 * @param cs
	 *            判断对象
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 * @author mjorcen
	 */
	public static final void checkArgumentNotEmpty(CharSequence cs, String msg) {
		checkArgumentIsTrue(cs == null || cs.length() > 0, msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 APIIllegalArgumentException
	 * 
	 * @param cs
	 *            判断对象
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 * @author mjorcen
	 */
	public static final void checkArgumentNotBlank(final CharSequence cs, String msg) {
		checkArgumentIsTrue(StringUtils.hasText(cs), msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 DataNotFoundException, 主要用户数据查找时发生的异常状况
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 * @param msg
	 *            替换默认的提示音,不需要可不传
	 */
	public static final void dataNotFound(Object obj, String msg) {
		if (obj == null) {
			throw new DataNotFoundException(msg);
		}
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 DataNotFoundException, 主要用户数据查找时发生的异常状况
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public static final void dataNotFound(Object obj) {
		dataNotFound(obj, null);
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
	public static final void notEmpty(Collection<?> obj, AssertCore coreEnum, String msg) {
		isTrue(obj == null || obj.isEmpty(), coreEnum, msg);
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
	public static final void notEmpty(CharSequence cs, AssertCore coreEnum, String msg) {
		isTrue(cs == null || cs.length() > 0, coreEnum, msg);
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
	public static final void notBlank(final CharSequence cs, AssertCore coreEnum, String msg) {
		isTrue(StringUtils.hasText(cs), coreEnum, msg);
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
	public static final void notNull(Object obj, AssertCore coreEnum, String msg) {
		isTrue(obj != null, coreEnum, msg);
	}

	/**
	 * 判断参数是否是空 ,假设空,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public static final void notNull(Object obj, AssertCore coreEnum) {
		isTrue(obj != null, coreEnum, "");
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
	public static final void isTrue(boolean b, AssertCore coreEnum, String msg, Object obj) {
		if (!b) {
			throw new EnumerationException(coreEnum, msg, obj);
		}
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
	public static final void isTrue(boolean b, AssertCore coreEnum, String msg) {
		if (!b) {
			throw new EnumerationException(coreEnum, msg, null);
		}
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
	public static final void checkIsTrue(boolean b, AssertCore coreEnum, String msg) throws EnumerationCheckException {
		if (!b) {
			throw new EnumerationCheckException(coreEnum, msg, null);
		}
	}

	/**
	 * 判断参数是否是真 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public static final void isTrue(boolean b, AssertCore coreEnum) {
		isTrue(b, coreEnum, "");
	}

	/**
	 * 判断参数是非空 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public static final void notEmpty(Collection<?> collection, AssertCore coreEnum) {
		isTrue(collection != null && !collection.isEmpty(), coreEnum, "");
	}

	/**
	 * 判断参数是空 ,假设否,飞出 coreEnum 对应错误码的异常类
	 * 
	 * @param obj
	 *            判断对象
	 * @param coreEnum
	 *            异常码
	 */
	public static final void isEmpty(Collection<?> collection, AssertCore coreEnum) {
		isTrue(collection == null || collection.isEmpty(), coreEnum, "");
	}

}
