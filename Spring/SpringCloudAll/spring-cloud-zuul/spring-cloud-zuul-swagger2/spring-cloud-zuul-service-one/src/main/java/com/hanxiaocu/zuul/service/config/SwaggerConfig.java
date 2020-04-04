package com.hanxiaocu.zuul.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @desc: swagger 配置类
 * @author: hanchenghai
 * @date: 2018/11/12 3:43 PM
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	//是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
	@Value(value = "${swagger.enabled}")
	Boolean swaggerEnabled;

	@Bean
	public Docket creageRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
				.enable(swaggerEnabled).select()
				.apis(RequestHandlerSelectors.basePackage("com.hanxiaocu.zuul.service"))
				.paths(PathSelectors.any()).build().pathMapping("/");
	}

	// 设置 api 信息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("路由网关(Zuul): 利用swagger2 聚合API文档-service-one")
				.description("hanxiaocu|韩小醋")
				.contact(new Contact("hanxiaocu", "https://github.com/SmallBlackBeans", "374802597@qq.com"))
				.version("v1.0.0")
				.build();
	}
}
