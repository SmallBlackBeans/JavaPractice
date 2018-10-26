package com.hanxiaocu.sample.basic.controller;

import com.hanxiaocu.sample.basic.domain.PO.Order;
import com.hanxiaocu.sample.basic.service.OrderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 11:53 AM
 */

/**
 * 重定向好处：
 * 在详情页，当再次刷新的时候，不会再次提交表单，刷新的就是详情页
 */

@Controller
public class RedirectController {

    @Autowired
    OrderSerivce service;

    @RequestMapping("/order/saveorder.html")
    public RedirectView saveOrder(Order order) {
        long orderid = service.addOrder(order);
        //return "redirect:/order/detail/html?orderId=" + orderid;
        //ModelAndView view = new ModelAndView("redirect:/order/detail/html?orderId=" + orderid);

        RedirectView view = new RedirectView("/order/detail.html?orderId=" + orderid);

        return view;
    }
}
