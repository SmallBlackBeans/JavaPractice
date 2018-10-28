package com.hanxiaocu.rest.config;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@Configuration
public class RestConfig implements RestTemplateCustomizer {
    public void customize(RestTemplate restTemplate) {
        OkHttp3ClientHttpRequestFactory okHttp = (OkHttp3ClientHttpRequestFactory)restTemplate.getRequestFactory();
        okHttp.setReadTimeout(5000);
        okHttp.setWriteTimeout(3000);
    }
}
