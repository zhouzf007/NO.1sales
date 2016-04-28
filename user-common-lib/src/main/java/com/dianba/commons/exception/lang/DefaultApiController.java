package com.dianba.commons.exception.lang;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dianba.commons.exception.APIIllegalArgumentException;
import com.dianba.commons.exception.core.AopAble;
import com.dianba.commons.exception.core.ResponseContent;
import com.dianba.commons.exception.util.ThreadContent;

/**
 * APP 接口的基础控制类
 *
 * @author zhoucong
 * @date 2016年3月15日 上午10:43:23
 */
public class DefaultApiController implements AopAble {

	/**
	 * 获取 Double 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return
	 * @throws APIIllegalArgumentException
	 *             没有对应参数或者类型错误是抛出
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public double mustDouble(String key) {
		String value = mustText(key);
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			Assert.checkArgumentIsTrue(false, "参数:" + key + "必须是 double 类型!");
		}
		return 0D;
	}

	/**
	 * 获取 Integer 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return
	 * @throws APIIllegalArgumentException
	 *             没有对应参数或者类型错误是抛出
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public int mustInt(String key) {
		String value = mustText(key);
		try {
			return Double.valueOf(value).intValue();
		} catch (Exception e) {
			Assert.checkArgumentIsTrue(false, "参数:" + key + "必须是 int 类型!");
		}
		return 0;
	}

	/**
	 * 获取 Long 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return
	 * @throws APIIllegalArgumentException
	 *             没有对应参数或者类型错误是抛出
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public long mustLong(String key) {
		String value = mustText(key);
		try {
			return Double.valueOf(value).longValue();
		} catch (Exception e) {
			Assert.checkArgumentIsTrue(false, "参数:" + key + "必须是 long 类型!");
		}
		return 0;
	}

	/**
	 * 获取 Text 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return
	 * @throws APIIllegalArgumentException
	 *             没有对应参数或者类型错误是抛出
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public String mustText(String key) {
		String value = getParamValue(key);
		Assert.checkArgumentNotBlank(value, "参数:" + key + "不能为空!");
		return value;
	}

	/**
	 * 获取 Text 类型的参数值,
	 * 
	 * @param keys
	 *            参数名
	 * @return
	 * @throws APIIllegalArgumentException
	 *             没有对应参数或者类型错误是抛出
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public String[] mustText(String... keys) {
		if (keys == null) {
			return new String[0];
		}
		String[] values = new String[keys.length];
		for (int i = 0; i < keys.length; i++) {
			values[i] = mustText(keys[i]);
		}
		return values;
	}

	/**
	 * 获取 参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public String getParamValue(String key) {
		return getHttpServletRequest().getParameter(key);
	}

	/**
	 * 获取 HttpServletRequest
	 *
	 * @return
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:43:05
	 */
	public HttpServletRequest getHttpServletRequest() {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		return request;
	}

}
