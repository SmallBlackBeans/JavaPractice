package com.hanxiaocu.sample.Jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.hanxiaocu.sample.basic.domain.PO.User;

import java.io.IOException;

/**
 * Description: 自定义反序列化
 * User: hanchenghai
 * Date: 2018/10/25 11:16 AM
 */
public class UserDeserializer extends JsonDeserializer<User> {
    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        String name = node.get("user-name").asText();
        User user = new User();
        user.setName(name);
        return user;
    }
}
