package com.dianba.commons.aop;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.dianba.commons.exception.lang.Formatter;
import com.dianba.commons.exception.util.PrintlnException;
import com.dianba.commons.exception.util.VoidFormatResultUtil;

public class AbstractExceptionAspect {
	protected List<Formatter<?>> formatters = new LinkedList<>();
	protected Log log = LogFactory.getLog(getClass());

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AbstractExceptionAspect(Formatter... formatters) {
		if (formatters != null) {
			for (Formatter<Object> formatter : formatters) {
				this.formatters.add(formatter);
			}
		} else {
			this.formatters.add(new VoidFormatResultUtil());
		}
	}

	public Object process(ProceedingJoinPoint point) throws Throwable {
		Object[] args = point.getArgs();
		MethodSignature signature = (MethodSignature) point.getSignature();
		Method method = signature.getMethod();
		Object returnValue = null;
		Formatter<Object> formatter = getFormatter(point.getTarget().getClass(), method);
		try {
			returnValue = point.proceed(args);
			if (formatter != null) {
				returnValue = formatter.doSuccessfully(point.getTarget(), method, returnValue);
			}
		} catch (Throwable e) {
			if (formatter == null) {
				PrintlnException.println(e);
				throw e;
			}
			returnValue = formatter.doFailed(point.getTarget(), method, e);
		}
		return returnValue;
	}

	/**
	 *
	 *
	 * @param class1
	 * @param method
	 * @return
	 * @author zhoucong
	 * @date 2016年3月30日 下午4:11:53
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Formatter<Object> getFormatter(Class<? extends Object> clazz, Method method) {
		for (Formatter formatter : formatters) {
			if (formatter.isFormatter(clazz, method)) {
				return formatter;
			}
		}
		return null;
	}

}