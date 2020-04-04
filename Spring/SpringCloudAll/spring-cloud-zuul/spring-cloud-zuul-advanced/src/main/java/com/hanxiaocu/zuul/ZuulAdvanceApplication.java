package com.hanxiaocu.zuul;

import com.hanxiaocu.zuul.component.EurekaClientFallback;
import com.hanxiaocu.zuul.filter.AccessZuulFilter;
import com.hanxiaocu.zuul.filter.CustomErrorFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/12 2:46 PM
 */
// http://xujin.org/sc/sc-zuul-s3/
@SpringBootApplication
@Slf4j
public class ZuulAdvanceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZuulAdvanceApplication.class,args);
		log.info("spring-cloud-zuul-advanced 启动...");
	}


	@Bean
	public AccessZuulFilter accessZuulFilter(){
		return new AccessZuulFilter();
	}

	@Bean
	public EurekaClientFallback eurekaClientFallback(){
		return new EurekaClientFallback();
	}

	@Bean
	@ConditionalOnProperty(name = "zuul.SendErrorFilter.error.disable")
	public CustomErrorFilter customErrorFilter(){
		return new CustomErrorFilter();
	}
}
