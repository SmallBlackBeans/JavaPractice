package com.hanxiaocu.sample.config;

import com.hanxiaocu.sample.basic.domain.PO.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: 全局MVC 配置
 * User: hanchenghai
 * Date: 2018/10/24 10:52 AM
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	//拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//对admin路径进行拦截
		registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
	}

	//跨域访问配置 Cross-origin resource sharing

	/**
	 * 跨域原理简单点理解就是发起跨域请求的时候 ，
	 * 浏览器会对请求域返回的响应信息检查 HTTP 头 ，
	 * 如果 Access-Contro1-Allow-Origin 包含了自身域，
	 * 则表示允许访问 , 否则报错，这就是 allowedOrigins的作用 。
	 *
	 * @param registry
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		//运行来自指定域名的跨域访问，并限定访问路径为/api
		registry.addMapping("/api/**")
				.allowedOrigins("http://domain2.com")
				.allowedMethods("POST", "GET")
				.allowCredentials(true).maxAge(3600);
	}

	//格式化
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
	}

	//注册Controllor 这样就不用创建Controller了
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//对于 index.html 的请求，设置返回的视图为 index.btl。
		//所有以 .do 结尾的请求重定向到/index.html 请求
		registry.addViewController("/index.html").setViewName("/index.btl");
		registry.addRedirectViewController("/**/*.do", "/index.html");
	}

	class SessionHandlerInterceptor implements HandlerInterceptor {

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
			User user = (User) request.getSession().getAttribute("user");
			if (user == null) {
				response.sendRedirect("/login.html");
				return false;
			}
			return true;
		}

		@Override
		public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
			//Controller方法处理后，页面还没有渲染前 调用
			//可以在这 里将渲染的视图名称更改为其他视图名称
		}

		@Override
		public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
			//页面渲染完毕后调用，通常清除资源
		}
	}
}
