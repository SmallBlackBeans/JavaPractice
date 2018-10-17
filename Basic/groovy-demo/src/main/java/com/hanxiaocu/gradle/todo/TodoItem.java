package com.hanxiaocu.gradle.todo;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/17 10:15 AM
 */
public class TodoItem {

    //代办事项名称
    private String name;

    private boolean hasDone;

    public TodoItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasDone() {
        return hasDone;
    }

    public void setHasDone(boolean hasDone) {
        this.hasDone = hasDone;
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "name='" + name + '\'' +
                (hasDone ? "hasDone" : "need to do") +
                '}';
    }
}
