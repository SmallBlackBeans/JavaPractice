package com.hanxiaocu.sample.Jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hanxiaocu.sample.basic.domain.PO.User;

import java.io.IOException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 11:13 AM
 */
//自定义序列化
public class Usererializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("user-name", user.getName());
        jsonGenerator.writeEndObject();
    }
}
