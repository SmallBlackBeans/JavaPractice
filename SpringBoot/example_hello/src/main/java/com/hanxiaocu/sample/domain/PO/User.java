package com.hanxiaocu.sample.domain.PO;


import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 12:42 PM
 */
public class User {
    long userId;

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
