package com.hanxiaocu.rest.controller;

import com.hanxiaocu.rest.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: RestTemplate 来辅助发起一个 REST 请求
 * User: hanchenghai
 * Date: 2018/10/28
 */
@Controller
@RequestMapping("/test")
public class RestClientCrontroller {

    @Value(value = "${api.order}")
    String base;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/get/{orderId}")
    public @ResponseBody
    Order getOrder(@PathVariable String orderId) {
        RestTemplate client = restTemplateBuilder.build();
        Map          map    = new HashMap();
        map.put("orderId", orderId);
        String uri = base + "/order/{orderId}";

        ResponseEntity<Order> responseEntity = client.getForEntity(uri, Order.class, map);//包含响应头
        HttpHeaders           headers        = responseEntity.getHeaders();

        Order order = client.getForObject(uri, Order.class, map);
        return order;
    }

    @GetMapping("/addoder")
    public @ResponseBody
    String addOrder() {
        RestTemplate client = restTemplateBuilder.build();
        String       uri    = base + "/order";
        Order        order  = new Order();
        order.setName("mybatis");
        HttpEntity<Order> body = new HttpEntity<Order>(order);
        String            ret  = client.postForObject(uri, body, String.class);
        return ret;
    }

    @GetMapping("/getorders")
    public @ResponseBody
    List<Order> queryOrder() throws Exception {
        RestTemplate client = restTemplateBuilder.build();
        String       uri    = base + "/orders?offset={offset}";
        Integer      offset = 1;
        //无参数
        HttpEntity                              body    = null;
        //包含泛型类型 防止反序列化的时候，类型擦除，不知道需要的是什么类型
        // 在子类中会保留 父类的泛型信息，这里的 ParameterizedTypeReference是抽象类，typeRef是其子类
        ParameterizedTypeReference<List<Order>> typeRef = new ParameterizedTypeReference<List<Order>>() {
        };
        ResponseEntity<List<Order>>             rs      = client.exchange(uri, HttpMethod.GET, body, typeRef, offset);
        List<Order>                             order   = rs.getBody();
        return order;

    }
}
