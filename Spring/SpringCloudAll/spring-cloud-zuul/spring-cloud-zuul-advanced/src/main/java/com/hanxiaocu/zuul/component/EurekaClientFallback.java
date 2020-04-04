package com.hanxiaocu.zuul.component;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @desc: 服务 XXX eureka-client 的 异常回退 处理类
 * @author: hanchenghai
 * @date: 2018/11/12 3:08 PM
 */

/**
 * 通过注册中心的服务ID进行自动转发，当远程服务不可用时，我们可以通过Hystrix进行服务回退处理
 */
public class EurekaClientFallback implements FallbackProvider {
	@Override
	public String getRoute() {
		return "eureka-provider-client";
	}

	@Override
	public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
		if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		} else {
			return response(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return status;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return status.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return status.getReasonPhrase();
			}

			@Override
			public void close() {

			}

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("{\"code\":\"999999\",\"msg\":\"服务暂时不可用\"}".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}
