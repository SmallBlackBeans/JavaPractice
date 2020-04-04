package com.hanxiaocu.jwt.security.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;

/**
 * @desc: 客户端交互的错误模型
 * @author: hanchenghai
 * @date: 2018/11/14 5:37 PM
 */
@Getter
@Setter
public class ErrorResponse {
	// HTTP 相应状态码
	private final HttpStatus status;

	// 错误信息
	private final String message;

	// 错误码
	private final ErrorCode errorCode;

	private final Date timestamp;

	public ErrorResponse(String message, ErrorCode errorCode, HttpStatus status) {
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
		this.timestamp = new Date();
	}

	public static ErrorResponse of(final String message, final ErrorCode errorCode, HttpStatus status) {
		return new ErrorResponse(message, errorCode, status);
	}
}
