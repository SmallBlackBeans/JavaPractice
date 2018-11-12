package com.hanxiaocu.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletResponse;

/**
 * @desc: 自定义异常类：常规http请求异常还是会转入ErrorFilter 中，然后指向/error页面
 * @author: hanchenghai
 * @date: 2018/11/12 3:21 PM
 */

/**
 * 配置中要停用默认的异常处理器SendErrorFilter
 * zuul.SendErrorFilter.error.disable=true
 */
@Slf4j
public class CustomErrorFilter extends SendErrorFilter {
	@Override
	public Object run() {
		//重写 run方法
		try {
			RequestContext ctx = RequestContext.getCurrentContext();
			//直接复用异常处理类
			ExceptionHolder exception = findZuulException(ctx.getThrowable());
			log.info("异常信息:{}", exception.getThrowable());
			//这里可对不同异常返回不同的错误码
			HttpServletResponse response = ctx.getResponse();
			response.getOutputStream().write(("{\"code\":\"999999\",\"msg\":\"" + exception.getErrorCause() + "\"}").getBytes());

		} catch (Exception ex) {
			ReflectionUtils.rethrowRuntimeException(ex);
		}
		return null;
	}
}
