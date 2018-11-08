package com.hanxiaocu.rest.bean;

import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
public class Order {

    private String id;

    private String name;

    private Date createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
