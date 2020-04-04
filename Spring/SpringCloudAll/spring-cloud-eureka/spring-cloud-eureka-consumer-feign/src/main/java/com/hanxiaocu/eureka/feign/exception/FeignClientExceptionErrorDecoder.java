package com.hanxiaocu.eureka.feign.exception;

import com.google.common.collect.Lists;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/23 3:54 PM
 */
@Component
public class FeignClientExceptionErrorDecoder implements ErrorDecoder {


	private final ErrorDecoder delegate = new ErrorDecoder.Default();

	@Override
	public Exception decode(String methodKey, Response response) {

		if (response.status() >= 500) {
			return delegate.decode(methodKey,response);
		}

		// 必须是json
		if (response.headers().getOrDefault("Content-Type", Lists.newArrayList()).stream()
		.filter(s -> s.toLowerCase().contains("json")).count() > 0) {
			try {
				String body = Util.toString(response.body().asReader());
				//转换并返回异常对象
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


		return delegate.decode(methodKey,response);
	}
}
