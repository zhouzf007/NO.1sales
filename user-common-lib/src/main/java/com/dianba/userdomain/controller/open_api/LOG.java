package com.dianba.userdomain.controller.open_api;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dianba.userdomain.controller.open_api.util.ValidUtil;


/**
 * 打印日志
 * @author folo
 *
 */
public class LOG {
	public static Map<String, Logger> logMap = new HashMap<>();
	
	public static String ERROR = "error";
	public static String WARN= "warn";
	public static String INFO = "info";
	public static String DEBUG = "debug";
	
	/**
	 * log按照固定格式打印日志
	 * @param format
	 * @param args [0]=methodName
	 */
	public static void log(StackTraceElement stack, String logLevel, String format, Object... args){
		Logger logger = logMap.get(stack.getClassName());
		if(null == logger){//cache logger
			logger = LoggerFactory.getLogger(stack.getClassName());
			logMap.put(stack.getClassName(), logger);
		}
		if(logLevel.equals(ERROR)) logger.error("---->【{}】" + format, getAllArgs(stack, args));
		else if(logLevel.equals(WARN)) logger.warn("---->【{}】" + format, getAllArgs(stack, args));
		else if(logLevel.equals(INFO)) logger.info("---->【{}】" + format, getAllArgs(stack, args));
		else if(logLevel.equals(DEBUG)) logger.debug("---->【{}】" + format, getAllArgs(stack, args));
	}
	
	
	public static Object[] getAllArgs(StackTraceElement stack, Object... args){
		Object[] allArgs = new Object[args.length + 1];
		allArgs[0] = stack.getMethodName();
		for (int i = 0; i < args.length; i++) {
			if(null == args[i]) allArgs[i+1] = "null";
			else if(ValidUtil.isBaseType(args[i])) allArgs[i+1] = args[i];
			else allArgs[i+1] = JSON.toJSONString(args[i]);
		}
		return allArgs;
	}
}
