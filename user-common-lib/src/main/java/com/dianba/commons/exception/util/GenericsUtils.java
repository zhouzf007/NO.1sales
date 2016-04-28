package com.dianba.commons.exception.util;

import java.lang.reflect.Method;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类定义工具类
 *
 * @author zhoucong
 * @date 2016年3月30日 下午4:05:19
 */
public class GenericsUtils {

	/**
	 * 获取可执行的方法[指定的 类 和 方法 ]
	 * 
	 * @param clazz
	 * @param joinMethod
	 * @return
	 * @throws Exception
	 * @author zhoucong
	 * @date 2016年3月30日 下午4:04:30
	 */
	public static Method getMethodPermission(Class<?> clazz, Method joinMethod) throws Exception {

		Method method = clazz.getMethod(joinMethod.getName(), joinMethod.getParameterTypes());
		if (method.isAnnotationPresent(RequestMapping.class)) {
			// RequestMapping requestMapping =
			// method.getAnnotation(RequestMapping.class);
			return method;
		}
		return null;
	}

}
