package com.hanxiaocu.elastic.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanxiaocu.elastic.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 3:11 PM
 */
@RestController
public class ESRestController {


    @RequestMapping("/rest/book/{id}")
    public String getLogById(@PathVariable String id) throws Exception {
        Book book = null;
        RestTemplate template = new RestTemplate();
        HashMap<String, Object> params = new HashMap();
        params.put("id",id);
        String str = template.getForObject("http://localhost:9200/product/book/{id}",String.class,params);

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(str);
        JsonNode root = mapper.readTree(parser);
        JsonNode sourceNode = root.get("_source");
        //映射到Book 对象
        book = mapper.convertValue(sourceNode,Book.class);
        return book.getMessage();
    }

}
