package com.hanxiaocu.sample.basic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 2:02 PM
 */
@Controller
public class ErrorController extends AbstractErrorController {

    Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @Autowired
    ObjectMapper objectMapper;

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }

    //@RequestMapping("/error")
    public ModelAndView getErrorPath(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
        //获取异常
        Throwable cause = getCause(request);

        int status = (int) model.get("status");

        String message      = (String) model.get("message");
        String errorMessage = getErrorMessage(cause);

        logger.info(status + "," + message, cause);
        response.setStatus(status);
        if (!isJsonRequest(request)) {//页面渲染请求错误
            ModelAndView view = new ModelAndView("/error.btl");
            view.addAllObjects(model);
            view.addObject("errorMessage", errorMessage);
            view.addObject("status", status);
            view.addObject("cause", cause);
            return view;
        } else {
            //json 请求错误
            Map error = new HashMap();
            error.put("succese", false);
            error.put("errorMessage", errorMessage);
            error.put("message", message);
            writeJson(response, error);
            return null;
        }
    }

    private void writeJson(HttpServletResponse response, Map error) {
    }

    private boolean isJsonRequest(HttpServletRequest request) {
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if (requestUri != null &&requestUri.endsWith(".json")) {
            return true;
        }
        if (request.getHeader("Accept").contains("application/json")) {
            return true;
        }
        return false;
    }

    private String getErrorMessage(Throwable cause) {
        if (cause instanceof SQLException){
            return "数据查询异常";
        }
        return "服务器错误，请联系管理员";
    }

    private Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null) {
                error = ((ServletException) error).getCause();
            }
        }
        return error;
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
