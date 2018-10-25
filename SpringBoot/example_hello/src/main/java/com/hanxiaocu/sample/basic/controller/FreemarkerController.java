package com.hanxiaocu.sample.basic.controller;

import com.hanxiaocu.sample.basic.domain.PO.User;
import com.hanxiaocu.sample.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 11:26 AM
 */
@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {

    @Autowired
    UserService userService;

    @GetMapping("/showUser.html")
    public ModelAndView showUserInfo(Long id) {
        ModelAndView view = new ModelAndView();
        User         user = userService.getUserById(id);
        view.addObject("user",user);
        view.setViewName("/userInfo");
        return view;
    }
}
