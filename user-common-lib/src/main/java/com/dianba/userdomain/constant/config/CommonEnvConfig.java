package com.dianba.userdomain.constant.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.dianba.userdomain.util.AliOcsMemcachedUtil;

/**
 * <pre>
 * 配置方式 
 * classpath:/properties/${spring.profiles.active}.properties
 * 配置(web.xml配置spring.profiles.active) 
 * spring.profiles.active = devel(开发)/test(测试)/product(生产)
 * </pre>
 * 
 * @author folo
 */
@Configuration
public class CommonEnvConfig {
    @Autowired private CommonUserConfig userConfig;

    @Autowired private CommonThirdConfig thirdConfig;

    @Autowired private CommonInitConfig initConfig;

    @Autowired private CommonDomainConfig domainConfig;

    @Autowired private CommonBaiduConfig baiduConfig;

    /** 用户调试配置 */
    public static CommonUserConfig user;

    /** 第三方平台配置 */
    public static CommonThirdConfig third;

    /** 初始配置 */
    public static CommonInitConfig init;

    /** 域名访问配置 */
    public static CommonDomainConfig domain;

    /** 百度相关配置 */
    public static CommonBaiduConfig baidu;

    @PostConstruct
    public void init() {
        user = userConfig;
        third = thirdConfig;
        init = initConfig;
        domain = domainConfig;
        baidu = baiduConfig;
        
        AliOcsMemcachedUtil.initMemcached();
    }
}
