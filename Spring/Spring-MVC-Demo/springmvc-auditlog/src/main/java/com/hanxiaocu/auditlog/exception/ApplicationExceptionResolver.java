package com.hanxiaocu.auditlog.exception;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.annotation.FastJsonFilter;
import com.hanxiaocu.auditlog.utils.FastjsonFilterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @desc: 全局异常处理器
 * @author: hanchenghai
 * @date: 2018/12/03 4:47 PM
 */
@Slf4j
public class ApplicationExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		log.info("异常拦截器执行...");
		this.writeJsonByFilter(response, this.resolveExceptionCustom(ex), null, null);
		return new ModelAndView();
	}

	private void writeJsonByFilter(HttpServletResponse response, Object object, String[] includesProperties, String[] excludesProperties) {

		try {
			// excludes优先于includes
			FastjsonFilterUtil filter = new FastjsonFilterUtil();
			if (excludesProperties != null && excludesProperties.length > 0) {
				filter.getExcludes().addAll(Arrays.<String> asList(excludesProperties));
			}
			if (includesProperties != null && includesProperties.length > 0) {
				filter.getIncludes().addAll(Arrays.<String> asList(includesProperties));
			}
			// 使用SerializerFeature.WriteDateUseDateFormat特性来序列化日期格式的类型为yyyy-MM-dd
			// hh24:mi:ss
			// 使用SerializerFeature.DisableCircularReferenceDetect特性关闭引用检测和生成
			String json = JSON.toJSONString(object, filter,
					SerializerFeature.WriteDateUseDateFormat,
					SerializerFeature.DisableCircularReferenceDetect);
			log.info("JSON String is:" + json);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		}
		catch (IOException e) {
			log.error("An error occurred when object was converted to JSON", e);
		}
	}

	/**
	 * 异常信息解析方法
	 *
	 * @param ex
	 * @return
	 */
	private Object resolveExceptionCustom(Exception ex) {
		return null;
	}
}
