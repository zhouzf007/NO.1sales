package com.dianba.userdomain.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * 校验相关的类.
 * @author folo
 * 
 */
public final class ValidUtil {
    public static final String[] FALSE_NAMES = new String[] { Boolean.FALSE.toString(), "fail", "failed", "no" };

    /**
     * 检查集合是否为空(集合为空 或集合的长度为空)
     * @param c
     * @return 为空=true, 不为空=false
     */
    public static boolean isEmpty(Collection<?> c) {
        if (null == c || c.isEmpty()) return true;
        return false;
    }

    /**
     * 检查Map是否为空(Map为空 或Map的长度为空)
     * @param map
     * @return 为空=true, 不为空=false
     */
    public static boolean isEmpty(Map<?, ?> map) {
        if (null == map || map.isEmpty()) return true;
        return false;
    }

    /**
     * 检查所有对象中是否为空(其中任意一个为空 返回true)
     * @param args 需要校验的参数
     * @return 为空=true 不为空=false
     */
    public static boolean anyEmpty(Object... args) {
        for (Object o : args) {
            if (o == null) return true;
            else if (o instanceof String && StringUtils.isEmpty((String) o)) return true;
            else if (o instanceof Integer && ((Integer) o) <= 0) return true;
            else if (o instanceof Long && ((Long) o) <= 0) return true;
            else if (o instanceof List<?> && ((List<?>) o).size() <= 0) return true;
            else if (o instanceof Map<?, ?> && ((Map<?, ?>) o).size() <= 0) return true;
        }
        return false;
    }

    public static boolean anyVals(Object target, Object... vals){
        for (Object obj : vals) {
            if(obj.equals(target)) return true;
        }
        return false;
    }

    /**
     * 判断是否java基本类型
     * @param o
     * @return
     */
    public static boolean isBaseType(Object o) {
        if (o instanceof String || o instanceof Long || o instanceof Integer || o instanceof Double || o instanceof Float
                        || o instanceof Character || o instanceof Boolean || o instanceof Byte)
            return true;
        return false;
    }
    
    
    /*
     * 验证经纬度是否为0 空 和空字符串
     * */
    public static boolean isEmptyLocation(String lng,String lat){
        return !ValidUtil.anyEmpty(lng) &&  !ValidUtil.anyEmpty(lat) ;
    }

    public static boolean isNumber(Object o) {
        if (o instanceof Long || o instanceof Integer || o instanceof Double || o instanceof Float) return true;
        return false;
    }
}
