package com.dianba.userdomain.constant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonUserConfig {
    /**
     * 是否开启用户调试模式
     */
    @Value("${debug.user.enable}") public Boolean debug_enable;

    /** 调试用户信息-id */
    @Value("${debug.user.id}") public String debug_userid;

    /** 调试用户信息-identity_id */
    @Value("${debug.identity_id}") public String debug_identity_id;

    /** 调试地理位置-经度 */
    @Value("${debug.user.longitude}") public String debug_longitude;

    /** 调试地理位置-纬度 */
    @Value("${debug.user.latitude}") public String debug_latitude;
}
