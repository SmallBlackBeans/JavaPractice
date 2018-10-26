package com.hanxiaocu.sample.basic.domain.VO;

import java.io.Serializable;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 4:39 PM
 */
public class OrderDetail implements Serializable {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
