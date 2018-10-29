package com.hanxiaocu.elastic.entity;

import java.util.Date;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 3:10 PM
 */
public class Book {
    String name;
    String message;
    Date postDate;
    String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
