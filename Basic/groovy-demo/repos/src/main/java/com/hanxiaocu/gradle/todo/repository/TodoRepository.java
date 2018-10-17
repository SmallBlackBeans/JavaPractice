package com.hanxiaocu.gradle.todo.repository;

import com.hanxiaocu.gradle.todo.model.TodoItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/17 2:22 PM
 */
public class TodoRepository {
    private Map<String, TodoItem> map = new HashMap<>();
    public void save(TodoItem item) {
        map.put(item.getName(),item);
    }

    public TodoItem query(String name) {
        return this.map.get(name);
    }
}
