package com.hanxiaocu.sample.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 4:59 PM
 */
@ControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandle(Exception e) {
        Map<String, Object> result = new HashMap<>();
        result.put("respCode", "9999");
        result.put("respMsg", e.getMessage());
        //正常开发中，创建一个统一的响应实体，CommonResp
        return result;
    }

    //@requestbody 检验
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,Object> handleBindException(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("参数校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "01002");
        result.put("respMsg", fieldError.getDefaultMessage());
        return result;
    }


    //校验 除了 requestbody 注解方式的参数校验 对应的 bindingresult 为 BeanPropertyBindingResult
    @ExceptionHandler(BindException.class)
    public Map<String,Object> handleBindException(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldError();
        log.info("必填校验异常:{}({})", fieldError.getDefaultMessage(),fieldError.getField());
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("respCode", "01002");
        result.put("respMsg", fieldError.getDefaultMessage());
        return result;
    }

    //现在基本都是前后端分离，返回页面这种方式不太常用了
    //@ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("Error.btl");
        return mav;
    }
}
