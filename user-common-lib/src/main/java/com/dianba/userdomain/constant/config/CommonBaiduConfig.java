package com.dianba.userdomain.constant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 百度平台相关配置
 * @author folo
 *
 */
@Configuration
public class CommonBaiduConfig {

    // ############ 百度地图 ############
    /** 百度地图api ak */
    @Value("${baidu.map.api.ak}") public String BAIDU_AK;

    /** 百度地图接口地址 */
    @Value("${baidu.map.api.url}") public String BAIDU_MAP_URL;

    /** 百度地图接口二级地址 */
    @Value("${baidu.map.address.interface}") public String BAIDU_ADDRESS_INTERFACE;

}
