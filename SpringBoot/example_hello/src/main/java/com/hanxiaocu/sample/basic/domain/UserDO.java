package com.hanxiaocu.sample.basic.domain;

import javax.validation.constraints.NotNull;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/23 11:43 AM
 */
public class UserDO {
    @NotNull
    String name;

    public static void main(String[] args) {
        UserDO userDO = new UserDO();
        userDO.name = null;
    }
}
