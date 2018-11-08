package com.hanxiaocu.cache.entity;

import sun.rmi.runtime.Log;

import java.io.Serializable;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/29 4:18 PM
 */
public class Menu implements Serializable {
    Long   id;
    String name;
    Long    parentId;

    String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
