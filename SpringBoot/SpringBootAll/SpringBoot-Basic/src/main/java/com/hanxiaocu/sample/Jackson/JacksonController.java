package com.hanxiaocu.sample.Jackson;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanxiaocu.sample.basic.domain.PO.User;
import com.hanxiaocu.sample.basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

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
        String   json = "{\"name\":\"hanxiaocu\",\"age\":10}";
        JsonNode node = mapper.readTree(json);
        String   name = node.get("name").asText();
        int      age  = node.get("age").asInt();
    }

    @GetMapping("/databind.json")
    public void databind() throws IOException {
        String json = "{\"name\":\"hanxiaocu\",\"age\":10}";
        User   user = mapper.readValue(json, User.class);
    }

    @GetMapping("/serialization.json")
    @ResponseBody
    public String serializationObject() throws JsonProcessingException {
        User   user = userService.getUserById(1L);
        String s    = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/parse.html")
    @ResponseBody
    public String parse() throws IOException {
        String      json    = "{\"name\":\"hanxiaocu\",\"age\":10}";
        JsonFactory factory = mapper.getFactory();

        String     key    = null, value = null;
        JsonParser parser = factory.createParser(json);
        //忽略第一个token "{" 代表一个对象的开始
        JsonToken token = parser.nextToken();
        token = parser.nextToken();
        if (token == JsonToken.FIELD_NAME) {
            //name
            key = parser.getCurrentName();
        }

        token = parser.nextToken();
        // hanxiaocu
        value = parser.getValueAsString();
        parser.close();
        return key + "," + value;
    }

    //生成json
    @RequestMapping("/generator.html")
    public @ResponseBody
    String generator() throws IOException {
        JsonFactory   factory   = mapper.getFactory();
        StringWriter  w         = new StringWriter();
        JsonGenerator generator = factory.createGenerator(w);

        generator.writeStartObject();

        generator.writeStringField("name", "hanxiaocu");
        generator.writeEndObject();
        generator.close();
        return w.toString();

    }

    //指定序列化组，只返回对应的属性
    @JsonView(User.IdView.class)
    @RequestMapping("/id.json")
    public @ResponseBody
    User queryIds() {
        User user = new User();
        user.setUserId(1L);
        user.setName("hanxiaocu");
        return user;
    }

    //@RequestBody 将提交的json 自动映射到对应的参数中
    @RequestMapping("/updateUsers.json")
    public @ResponseBody
    String say(@RequestBody List<User> list) {
        StringBuffer sb = new StringBuffer();
        for (User user : list) {
            sb.append(user.getName()).append(" ");
        }
        return sb.toString();
    }

    @RequestMapping("/customize.json")
    public @ResponseBody
    String customize() throws IOException {
        String json = "[{\"id\":2,\"naeme\":\"Hanxiaocu\"}," +
                "{\"id\":3,\"naeme\":\"Jack\"}," +
                "{\"id\":4,\"naeme\":\"Lucy\"}]";
        JavaType type = getCollectionType(List.class, User.class);
        List<User> list = mapper.readValue(json,type);
        return String.valueOf(list.size());
    }

    public JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        //允许构造复杂的泛型类型描述
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}

