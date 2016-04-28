/**
 * 
 */
package com.dianba.commons.exception.lang;

import java.lang.reflect.Method;

/**
 *
 *
 * @author zhoucong
 * @date 2016年3月30日 上午11:39:43
 */
public interface Formatter<T> {

	public boolean isFormatter(Class<?> clazz, Method joinMethod);

	public Object doFailed(T obj, Method joinMethod, Throwable e) throws Throwable;

	public Object doSuccessfully(T obj, Method joinMethod, Object returnValue) throws Exception;
}
