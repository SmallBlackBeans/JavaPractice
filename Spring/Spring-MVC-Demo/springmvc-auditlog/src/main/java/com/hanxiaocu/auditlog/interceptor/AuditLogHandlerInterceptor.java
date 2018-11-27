package com.hanxiaocu.auditlog.interceptor;

import com.hanxiaocu.auditlog.annotation.AuditLog;
import com.hanxiaocu.auditlog.biz.AuditLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/27
 */
@Slf4j
public class AuditLogHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            log.info("auditlog create");
            Method   method   = handlerMethod.getMethod();
            AuditLog auditLog = method.getAnnotation(AuditLog.class);
            if (auditLog == null) {
                return;
            }
            try {
                AuditLogInfo auditLogInfo = createAuditLog(auditLog, request, response);
                if (auditLogInfo != null) {

                }
            } catch (Exception e) {
                log.error("auditlog create error", e);
            }
        }
    }

    private AuditLogInfo createAuditLog(AuditLog auditLog, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
