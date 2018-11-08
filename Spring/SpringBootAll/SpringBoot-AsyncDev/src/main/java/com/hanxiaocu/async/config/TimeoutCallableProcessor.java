package com.hanxiaocu.async.config;

import com.hanxiaocu.async.exception.CustomAsyncRequestTimeoutException;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.async.CallableProcessingInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Callable;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/05 2:28 PM
 */
public class TimeoutCallableProcessor implements CallableProcessingInterceptor {
	@Override
	public <T> Object handleTimeout(NativeWebRequest request, Callable<T> task) throws Exception {
		HttpServletRequest httpRequest = request.getNativeRequest(HttpServletRequest.class);
		//记录超时的url地址
		return new CustomAsyncRequestTimeoutException(httpRequest.getRequestURI());
	}
}
