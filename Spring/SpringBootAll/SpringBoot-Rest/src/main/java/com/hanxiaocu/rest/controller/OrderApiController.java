package com.hanxiaocu.rest.controller;

import com.hanxiaocu.rest.bean.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@RestController
@RequestMapping("/api/v1")
public class OrderApiController {

    @GetMapping("/order/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
        return null;
    }

    @GetMapping("/order")
    public List<Order> getOrder(Integer offset) {
        Order order = new Order();
        order.setId("2018-10-30");
        List<Order> orders = new ArrayList<Order>();
        orders.add(order);
        return orders;
    }

    @PostMapping("/order")
    public String addOrder(@RequestBody Order order) throws Exception{
        return "{\"success\":true,\"message\":\"添加成功\"}";
    }

    @PostMapping("/orders")
    public String batchAdd(@RequestBody List<Order> order) throws Exception{
        return "{success:true,message:\"批量添加成功\"}";
    }

    @PutMapping("/order")
    public String updateOrder(Order order) throws Exception{
        return "{\"success\":true,\"message\":\"更新成功\"}";
    }


    @DeleteMapping("/order/{orderId}")
    public String cancelOrder(@PathVariable() String orderId) throws Exception{
        return "{\"success\":true,\"message\":\"订单取消成功\"}";
    }
}
