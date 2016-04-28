package com.dianba.commons.exception.lang;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;
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
public class AbstractApiController implements AopAble {
	protected Log log = LogFactory.getLog(getClass());

	public ResponseContent getResponseContent() {

		ResponseContent content = ThreadContent.getResponseContent();
		if (content == null) {
			content = new ResponseContent();
			ThreadContent.setResponseContent(content);
		}

		return content;
	}

	/**
	 * 设置response返回结果
	 *
	 * @param obj
	 * @return
	 * @author zhoucong
	 * @date 2016年3月26日 下午12:27:25
	 */
	public ResponseContent addResponseBody(Object obj) {
		ResponseContent content = getResponseContent();
		content.addResponseBody(obj);
		return content;
	}

	/**
	 * 设置response返回结果
	 *
	 * @param obj
	 * @return
	 * @author zhoucong
	 * @date 2016年3月26日 下午12:27:25
	 */
	public ResponseContent addAllResponse(Map<String, Object> obj) {
		ResponseContent content = getResponseContent();
		content.addAllResponse(obj);
		return content;
	}

	/**
	 * 设置返回结果
	 *
	 * @param obj
	 * @return
	 * @author zhoucong
	 * @date 2016年3月26日 下午12:27:25
	 */
	public ResponseContent addResponse(String key, Object obj) {
		ResponseContent content = getResponseContent();
		content.getResponse().put(key, obj);
		return content;
	}

	/**
	 * 获取 Double 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return 如果没有对应的参数则返回 默认参数
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public Double getDouble(String key, Double defalutValue) {
		String value = getParamValue(key);
		if (StringUtils.isEmpty(value)) {
			return defalutValue;
		}
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
	 * @return 如果没有对应的参数则返回 默认参数
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public Integer getInt(String key, Integer defalutValue) {
		String value = getParamValue(key);
		if (StringUtils.isEmpty(value)) {
			return defalutValue;
		}
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			Assert.checkArgumentIsTrue(false, "参数:" + key + "必须是 Integer 类型!");
		}
		return 0;
	}

	/**
	 * 获取 Long 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return 如果没有对应的参数则返回默认参数
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public Long getLong(String key, Long defalutValue) {
		String value = getParamValue(key);
		if (StringUtils.isEmpty(value)) {
			return defalutValue;
		}
		try {
			return Long.valueOf(value);
		} catch (Exception e) {
			Assert.checkArgumentIsTrue(false, "参数:" + key + "必须是 Integer 类型!");
		}
		return 0L;
	}

	/**
	 * 获取 String 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return 如果没有对应的参数则返回默认参数
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public String getText(String key, String defalutValue) {
		String value = getParamValue(key);
		if (StringUtils.isEmpty(value)) {
			return defalutValue;
		}
		return value;
	}

	/**
	 * 获取 Date 类型的参数值,
	 * 
	 * @param key
	 *            参数名
	 * @return 如果没有对应的参数则返回默认参数
	 * @author zhoucong
	 * @date 2016年3月15日 上午10:41:11
	 */
	public Timestamp getTimestamp(String key, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		String value = getParamValue(key);
		if (StringUtils.isEmpty(value)) {
			return null;
		}
		try {
			return new Timestamp(dateFormat.parse(value).getTime());
		} catch (Exception e) {
			Assert.checkArgumentIsTrue(false, "参数:" + key + "必须是 Date 类型!");
		}
		return null;
	}

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
		Double value = getDouble(key, null);
		Assert.checkArgumentNotNull(value, "参数:" + key + "不能为空!");
		return value;
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
		Integer value = getInt(key, null);
		Assert.checkArgumentNotNull(value, "参数:" + key + "不能为空!");
		return value;
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
		Long value = getLong(key, null);
		Assert.checkArgumentNotNull(value, "参数:" + key + "不能为空!");
		return value;
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
		String value = getHttpServletRequest().getParameter(key);
		if(!StringUtils.isEmpty(value)){
			value= value.trim();
		}
		return value;
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
