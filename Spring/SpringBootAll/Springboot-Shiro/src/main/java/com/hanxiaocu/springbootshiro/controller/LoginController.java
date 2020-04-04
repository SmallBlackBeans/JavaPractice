package com.hanxiaocu.springbootshiro.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20
 */
@RestController
@Slf4j
public class LoginController {

    @GetMapping(value = "/hello")
    public String hello() {
        log.info("不登录也可以访问...");
        return "hello...";
    }

    @GetMapping(value = "/index")
    public String index() {
        log.info("登录成功了...");
        return "index";
    }

    @GetMapping(value = "/denied")
    public String denied() {
        log.info("权限不足，被拒绝");
        return "denied...";
    }

    @GetMapping("/login")
    public String login(String username, String password, RedirectAttributes model) {
        Subject               subject = SecurityUtils.getSubject();
        UsernamePasswordToken token   = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,用户不存在", username);
            token.clear();
            return "UnknownAccountException";
        } catch (LockedAccountException lae) {
            log.error("对用户[{}]进行登录验证,验证未通过,账户已锁定", username);
            token.clear();
            return "LockedAccountException";
        } catch (ExcessiveAttemptsException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,错误次数过多", username);
            token.clear();
            return "ExcessiveAttemptsException";
        } catch (AuthenticationException e) {
            log.error("对用户[{}]进行登录验证,验证未通过,堆栈轨迹如下", username, e);
            token.clear();
            return "AuthenticationException";
        }
        return "success";
    }

}
