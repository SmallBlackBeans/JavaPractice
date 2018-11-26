package com.hanxiaocu.eureka.provider.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/23 3:50 PM
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	public NotFoundException() {
		super("查找的资源不存在或者已被删除");
	}
	public NotFoundException(String message) {
		super(message);
	}
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
