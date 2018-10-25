package com.hanxiaocu.sample.Jackson;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 11:03 AM
 */
@JsonIgnoreProperties({"profile","count"})
@JsonNaming(PropertyNamingStrategy.LowerCaseWithUnderscoresStrategy.class)
public class Department {
    Map map = new HashMap();


    int id;

    @JsonProperty("departmentName")//别名
    String name;

    int count;

    String profile;

    @JsonIgnore
    String password;

    @JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")
    private Date createDate;

    public Department(int id) {
        this.id = id;
        map.put("newAttr",id);
    }

    //对于没有找到对应属性会调用这个方法，我们用map,记录下来
    @JsonAnySetter
    public void other(String property, Object value) {
        map.put(property,value);
    }

    //jackjson 会将这个方法返回的map 也进行序列化
    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return map;
    }


}
