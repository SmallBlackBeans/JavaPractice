package com.hanxiaocu.auditlog.controller;

import com.hanxiaocu.auditlog.annotation.Access;
import com.hanxiaocu.auditlog.annotation.AuditLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/27
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @AuditLog(module = "", operation = "", objType = "", description = "")
    public ResponseEntity deleteBuild(HttpServletRequest request, @PathVariable long id) {
        log.info("delete autio");
        return null;
    }


    @RequestMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
    @Access(authorities = {"admin"})
    public String hello(){
        return "hello, admin";
    }

}
