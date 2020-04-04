package com.hanxiaocu.auditlog.interceptor;

import com.hanxiaocu.auditlog.annotation.Access;
import com.sun.xml.internal.ws.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/27
 */
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
    //方法调用之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        Access access = method.getAnnotation(Access.class);
        if (access == null) {
            return true;
        }
        if (access.authorities().length > 0){
            String[] authorities = access.authorities();
            Set<String> authSet = new HashSet<>();
            for (String authority : authorities) {
                authSet.add(authority);
            }

            String role = request.getParameter("role");
            if (isNotBlank(role)){
                if (authSet.contains(role)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
