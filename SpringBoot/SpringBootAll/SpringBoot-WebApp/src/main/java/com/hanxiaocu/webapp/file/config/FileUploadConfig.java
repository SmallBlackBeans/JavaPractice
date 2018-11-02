package com.hanxiaocu.webapp.file.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/02 3:33 PM
 */
@Configuration
public class FileUploadConfig {

	@Bean
	public MultipartResolver fileResolver() {
		return new CommonsMultipartResolver();
	}
}
