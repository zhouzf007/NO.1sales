package com.dianba.userdomain.controller.open_api.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * class加该注解表示该class属性需要校验
 * field加该注解表示该field属性需要校验，默认校验非空
 * @author folo
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Check {
    /**
     * 校验的分组名称(checkutils根据不同分组名称进行校验)
     */
	String group() default "default";
    
    /**
     * 是否为空, (default true: 校验)<br/>
     * @ParamCheck 待校验数据不为空 ? true : false
     */
    boolean notEmpty() default true;//是否为空 true 校验非空，false 不校验

    // ##############CheckType String ParamCheck##############
    /**
     * 字符串最大长度, (default -1: 不校验)<br/>
     * @ParamCheck 待校验数据长度 <= {maxLength} ? true : false
     */
    int maxLength() default -1;

    /**
     * 字符串最小长度, (default -1: 不校验)<br/>
     * @ParamCheck 待校验数据长度 >= {minLength} ? true : false
     */
    int minLength() default -1;

    /**
     * 字符取值是否在限定取值访问访问 (default {}: 不校验)<br/>
     * @ParamCheck 待校验数据的值在 {val1,val2,val3} 这三个值之中 ? true : false
     */
    String[] inVal() default {};

    // ##############CheckType Number ParamCheck##############
    /**
     * 是否为数字, (default false: 不校验)<br/>
     * @ParamCheck 待校验数据为数字 ? true : false
     */
    boolean isNumber() default false;

    /**
     * 最小值校验, (default -1: 不校验)<br/>
     * @ParamCheck 待校验数据 >= {min} ? true : false
     */
    long min() default -1;

    /**
     * 最大值校验, (default -1: 不校验)<br/>
     * @ParamCheck 待校验数据 <= {max} ? true : false
     */
    long max() default -1;

    /**
     * 数字取值是否在限定取值访问访问, (default {}: 不校验)<br/>
     * @ParamCheck 待校验数据的值在 {longVal1, longVal2, longVal3} 这三个值之中 ? true : false
     */
    long[] inNumber() default {};
}
