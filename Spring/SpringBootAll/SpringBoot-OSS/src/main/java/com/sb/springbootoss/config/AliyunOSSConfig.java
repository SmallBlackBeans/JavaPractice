package com.sb.springbootoss.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/12/19 1:13 PM
 */
@Component
@Getter
@Setter
@ToString
@Slf4j
@PropertySource(value = "classpath:application-oss.properties")
public class AliyunOSSConfig {
	private String bucketname;
	private String endpoint;
	private String keyid;
	private String keysecret;
	private String filehost;
}
