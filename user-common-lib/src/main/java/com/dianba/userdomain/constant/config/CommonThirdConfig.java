package com.dianba.userdomain.constant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 第三方平台配置
 * @author folo
 *
 */
@Configuration
public class CommonThirdConfig {

    @Value("${third.debug.enable}") public boolean debug_enable;
}
