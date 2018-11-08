package com.hanxiaocu.session.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/30 9:43 AM
 */
@Controller
public class SpringSessionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/putsession.html")
    public @ResponseBody String putSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        logger.info(String.valueOf(session.getClass()));
        logger.info(session.getId());
        String name ="hanxiaocu";
        session.setAttribute("user",name);
        return "hey " + name;
    }

    @GetMapping("/getsession.html")
    public @ResponseBody String getSession(HttpServletRequest request) {
        logger.info(request.getRemoteAddr());
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        return "user= " + user;
    }

}
