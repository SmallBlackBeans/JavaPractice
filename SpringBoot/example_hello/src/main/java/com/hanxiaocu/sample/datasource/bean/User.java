package com.hanxiaocu.sample.datasource.bean;

import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 3:49 PM
 */
//@Setter
//@Getter
//@ToString(callSuper = true)
public class User {
    Integer    user_id;

    String name;

    Integer    department_id;

    Date create_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
