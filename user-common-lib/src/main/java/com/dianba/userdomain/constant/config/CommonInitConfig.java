package com.dianba.userdomain.constant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 初始配置
 * @author folo
 *
 */
@Configuration
public class CommonInitConfig {
    /** aop拦截日志开关（开启情况下 某些controller无法加载某些service） */
    @Value("${aop.log.enable}") public boolean aop_log_enable;

    // ############ 缓存配置 ############
    /** memcached地址 */
    @Value("${memcached.host}") public String memcached_host;

    /** memcached端口 */
    @Value("${memcached.port}") public String memcached_port;

    // ############ 短信配置 ############
    /** 是否开启短信发送 true=发送，false=不发送 */
    @Value("${sms.enable}") public boolean sms_enable;

    /** 是否缓存发送的验证码 true=验证码可多次使用 false=验证码只能使用一次 */
    @Value("${sms.cache}") public boolean sms_cache;
    
    /** 是否使用新支付接口 */
    @Value("${weixin.pay.enable}") public boolean weixin_pay_enable;
    /** 新支付接口url */
    @Value("${weixin.pay.url}") public String weixin_pay_url;

}
