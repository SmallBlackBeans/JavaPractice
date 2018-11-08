package com.hanxiaocu.sample.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 4:28 PM
 */
//通过FilterRegistrationBean注册的时候就不要用下面这个注解了
//@WebFilter(filterName = "customFilter", urlPatterns = "/*")
@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("dofilter 处理请求");
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        //直接抛给下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}
