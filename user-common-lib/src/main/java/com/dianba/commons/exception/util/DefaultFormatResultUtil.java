package com.dianba.commons.exception.util;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.dianba.commons.exception.core.ApplicationException;
import com.dianba.commons.exception.core.ExceptionContent;
import com.dianba.commons.exception.lang.DefaultApiController;
import com.dianba.commons.exception.lang.Formatter;

/**
 * APP 接口的标准输出控制器
 * 
 * @date 2016-03-07 16:57:34
 * @author mjorcen
 *
 */
/**
 * APP 接口的标准输出控制器
 * 
 * @date 2016-03-07 16:57:34
 * @author mjorcen
 *
 */
public class DefaultFormatResultUtil implements Formatter<DefaultApiController> {
	protected final Log log = LogFactory.getLog(getClass());

	public boolean isFormatter(Class<?> clazz, Method joinMethod) {
		try {
			if (!DefaultApiController.class.isAssignableFrom(clazz)) {
				return false;
			}
			Method method = GenericsUtils.getMethodPermission(clazz, joinMethod);
			return method != null;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Object doSuccessfully(DefaultApiController obj, Method joinMethod, Object returnValue) throws Exception {

		return getResult(joinMethod.getReturnType(), returnValue);
	}

	@Override
	public Object doFailed(DefaultApiController obj, Method joinMethod, Throwable e) throws Throwable {
		Object returnValue = null;
		if (e instanceof ApplicationException) {
			PrintlnException.println(e);
			log.debug(e);
			ApplicationException appexc = (ApplicationException) e;
			ExceptionContent content = appexc.getContent();
			returnValue = getResult(joinMethod.getReturnType(), content);
		} else {
			PrintlnException.println(e);
			log.error(e);
			returnValue = getResult(joinMethod.getReturnType(), new ExceptionContent());
		}
		return returnValue;
	}

	/**
	 *
	 *
	 * @param returnType
	 * @param returnValue
	 * @return
	 * @author zhoucong
	 * @date 2016年3月22日 上午11:16:17
	 */
	private static Object getResult(Class<?> returnType, Object returnValue) {
		Object result = returnValue;
		if (returnValue == null || (returnValue instanceof String
				&& org.springframework.util.StringUtils.isEmpty(returnValue.toString()))) {
			result = new ExceptionContent();
		}
		if (String.class == returnType) {
			result = JSON.toJSONString(result);
		}

		if (Object.class == returnType) {
			// result = result;
		}
		return result;
	}

}
