package com.hanxiaocu.sample.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanxiaocu.sample.domain.PO.User;
import com.hanxiaocu.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/24 5:20 PM
 */
@Controller
public class JacksonController {


    @Autowired
    ObjectMapper mapper;

    @Autowired
    UserService userService;

    @GetMapping("/jsonTree")
    public void jsonTree() throws IOException {
        String json = "{\"name\":\"hanxiaocu\",\"age\":10}";
        JsonNode node = mapper.readTree(json);
        String name = node.get("name").asText();
        int age = node.get("age").asInt();
    }

    @GetMapping("/jsonObject")
    public void jsonObject() throws IOException {
        String json = "{\"name\":\"hanxiaocu\",\"age\":10}";
        User user = mapper.readValue(json, User.class);
    }

    @GetMapping("/serialization.json")
    @ResponseBody
    public String serializationObject() throws JsonProcessingException {
        User user = userService.getUserById(1L);
        String s  = mapper.writeValueAsString(user);
        return s;
    }
}

