package com.dianba.commons.exception.util;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dianba.commons.exception.core.ApplicationException;
import com.dianba.commons.exception.core.ExceptionContent;
import com.dianba.commons.exception.lang.AbstractApiController;
import com.dianba.commons.exception.lang.Formatter;

/**
 * APP 接口的标准输出控制器
 * 
 * @date 2016-03-07 16:57:34
 * @author mjorcen
 *
 */
public class VoidFormatResultUtil implements Formatter<AbstractApiController> {
	protected final Log log = LogFactory.getLog(getClass());

	public boolean isFormatter(Class<?> clazz, Method joinMethod) {
		try {
			if (!AbstractApiController.class.isAssignableFrom(clazz)) {
				return false;
			}
			Method method = GenericsUtils.getMethodPermission(clazz, joinMethod);
			return method != null && isVoid(joinMethod.getReturnType());
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Object doSuccessfully(AbstractApiController obj, Method joinMethod, Object returnValue) throws Exception {
		returnValue = obj.getResponseContent();

		return getResult(obj, joinMethod.getReturnType(), returnValue);
	}

	@Override
	public Object doFailed(AbstractApiController obj, Method joinMethod, Throwable e) throws Throwable {
		Object returnValue = null;
		if (e instanceof ApplicationException) {
			PrintlnException.println(e);
			log.debug(e);
			ApplicationException appexc = (ApplicationException) e;
			ExceptionContent content = appexc.getContent();
			returnValue = getResult(obj, joinMethod.getReturnType(), content);
		} else {
			PrintlnException.println(e);
			log.error(e);
			returnValue = getResult(obj, joinMethod.getReturnType(), new ExceptionContent());
		}
		return returnValue;
	}

	private static Object getResult(AbstractApiController obj, Class<?> returnType, Object returnValue) {
		try {
			ThreadContent.println(JSONObject.toJSONString(returnValue, SerializerFeature.WriteMapNullValue,
					SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
					SerializerFeature.WriteNullBooleanAsFalse));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	private static boolean isVoid(Class<?> returnType) {
		return "void".equalsIgnoreCase(returnType.getName());
	}

}
