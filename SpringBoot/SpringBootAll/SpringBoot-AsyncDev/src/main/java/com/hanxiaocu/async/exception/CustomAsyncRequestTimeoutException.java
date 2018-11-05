package com.hanxiaocu.async.exception;

/**
 * @desc: 自定义超时异常类
 * @author: hanchenghai
 * @date: 2018/11/05 2:25 PM
 */
public class CustomAsyncRequestTimeoutException extends RuntimeException {

	private static final long serialVersionUID = -6824871057153368026L;
	public CustomAsyncRequestTimeoutException(String uri) {
		super(uri);
	}
}
