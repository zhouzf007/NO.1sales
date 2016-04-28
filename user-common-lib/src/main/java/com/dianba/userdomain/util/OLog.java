package com.dianba.userdomain.util;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.dianba.userdomain.controller.open_api.LOG;

/**
 * StackTraceElement 获得方式: Thread.currentThread().getStackTrace()[1]
 * @author folo
 */
public class OLog {
    public static final String INFO_REQ_FMT = "({}ms)\n--->【request】:{}\n<===【response】:{}";
    public static final String EXCEPTION_REQ_FMT = "({}ms)\n--->【request】:{}\n<===【exception】:{}";
    

    public static void debug(StackTraceElement stack, String format, Long start, HttpServletRequest request, Object ret) {
        debug(stack, format, System.currentTimeMillis() - start, JSON.toJSONString(request.getParameterMap()), JSON.toJSONString(ret));
    }

    public static void info(StackTraceElement stack, String format, Long start, HttpServletRequest request, Object ret) {
        info(stack, format, System.currentTimeMillis() - start, JSON.toJSONString(request.getParameterMap()), JSON.toJSONString(ret));
    }
    
    public static void warn(StackTraceElement stack, String format, Long start, HttpServletRequest request, Object ret) {
        warn(stack, format, System.currentTimeMillis() - start, JSON.toJSONString(request.getParameterMap()), JSON.toJSONString(ret));
    }
    
    public static void error(StackTraceElement stack, String format, Long start, HttpServletRequest request, Object ret) {
        error(stack, format, System.currentTimeMillis() - start, JSON.toJSONString(request.getParameterMap()), JSON.toJSONString(ret));
    }
    
    public static void debug(StackTraceElement stack, String format, Object... args) {
        LOG.log(stack, LOG.DEBUG, format, args);
    }

    public static void info(StackTraceElement stack, String format, Object... args) {
        LOG.log(stack, LOG.INFO, format, args);
    }
    
    public static void warn(StackTraceElement stack, String format, Object... args) {
        LOG.log(stack, LOG.WARN, format, args);
    }
    
    public static void error(StackTraceElement stack, String format, Object... args) {
        LOG.log(stack, LOG.ERROR, format, args);
    }
}
