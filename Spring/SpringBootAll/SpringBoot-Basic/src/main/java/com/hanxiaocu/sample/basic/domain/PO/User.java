package com.hanxiaocu.sample.basic.domain.PO;


import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hanxiaocu.sample.Jackson.UserDeserializer;
import com.hanxiaocu.sample.Jackson.Usererializer;

import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 12:42 PM
 */
@JsonSerialize(using = Usererializer.class)//指定序列化方式
@JsonDeserialize(using = UserDeserializer.class)
public class User {


    public interface IdView{};
    public interface IdNameView extends IdView{};

    @JsonView(IdView.class)//序列化组，只需要id
    long userId;

    @JsonView(IdNameView.class)//序列化组，只需要name 和 id
    String name;

    int    sex;
    Date   birthday;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
