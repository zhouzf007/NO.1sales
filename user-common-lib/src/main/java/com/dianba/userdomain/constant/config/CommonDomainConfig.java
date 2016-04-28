package com.dianba.userdomain.constant.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 访问域名配置
 * @author folo
 *
 */
@Configuration
public class CommonDomainConfig {

    /** 主站域名 */
    @Value("${domain.main}") public String API_DOMAIN;

    /** 内部API域名 */
    @Value("${domain.innerApi}") public String INNER_API_DOMAIN;

    /** 外部调用1.5接口域名 */
    @Value("${domain.outApi}") public String OUT_API_DOMAIN;

    /** cookie主域名 */
    @Value("${domain.main.cookies}") public String COOKIES_DOMAIN;

    /** cookie有效时长 */
    @Value("${domain.main.cookies.maxAge}") public String MAXAGE_COOKIES_DOMAIN;
    /** cookie有效时长 */
    @Value("${domain.retail.url}") public String RETAIL_URL;

}
