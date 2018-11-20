package com.hanxiaocu.springbootshiro.cache;

import com.hanxiaocu.springbootshiro.entity.User;

import java.util.*;

/**
 * @desc:
 * @author: hanchenghai
 * @date: 2018/11/20 6:05 PM
 */
public class DBCache {

    /**
     * 用户名
     * 用户信息
     */
    public static final Map<String , User>       USERS_CACHE = new HashMap<>();
    /**
     * 角色ID
     * 权限编码
     */
    public static final Map<String , Collection<String>> PERMISSIONS_CACHE = new HashMap<>();


    static {
        USERS_CACHE.put("u1", new User(1L, "u1", "p1", "admin", true));
        USERS_CACHE.put("u2", new User(2L, "u2", "p2", "admin", false));
        USERS_CACHE.put("u3", new User(3L, "u3", "p3", "guest", true));

        PERMISSIONS_CACHE.put("admin", Arrays.asList("user:list", "user:add", "user:edit"));
        PERMISSIONS_CACHE.put("guest", Collections.singletonList("user:list"));

    }

}
