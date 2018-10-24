package com.hanxiaocu.sample.config;

import org.beetl.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 渲染模板 提供扩展函数 共享变量
 * User: hanchenghai
 * Date: 2018/10/24 3:12 PM
 */

@Configuration
public class BeetlExtConfig {

    @Autowired
    //@Qualifier("groupTemplate")
    //GroupTemplate groupTemplate;
    //@Autowired
    ApplicationContext applicationContext;

    //@PostConstruct
    //public void config() {
    //    Map<String, Object> shared = new HashMap<String, Object>();
    //    shared.put("jsVersion", System.currentTimeMillis());
    //    groupTemplate.registerFunction("hi", applicationContext.getBean(SimpleFunction.class));
    //    groupTemplate.registerTagFactory("myTag", new TagFactory() {
    //
    //        @Override
    //        public Tag createTag() {
    //            return applicationContext.getBean(SimpleTag.class);
    //        }
    //
    //    });
    //    URL url = BeetlExtConfig.class.getResource("/templates/functions");
    //    System.out.print("==================" + url);
    //}

    @Component
    @Scope("prototype")//每次使用都会创建Tag
    private class SimpleTag extends Tag{

        @Override
        public void render() {
            System.out.println(this);
            try {
                ctx.byteWriter.writeString("hahah");
            }catch (IOException e){

            }
        }
    }

    @Component
    private class SimpleFunction implements Function {
        @Override
        public Object call(Object[] objects, Context context) {
            return "hi";
        }
    }
}
