package com.hanxiaocu.gradle.todo.repos;

import com.hanxiaocu.gradle.todo.model.TodoItem;
import com.hanxiaocu.gradle.todo.repository.TodoRepository;
import org.junit.Assert;
import org.junit.Test;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/17 2:21 PM
 */
public class TodoReposTest {
    private TodoRepository repository = new TodoRepository();

    @Test
    public void testSave() {
        TodoItem item = new TodoItem("hanxiaocu");

        repository.save(item);
        Assert.assertNotNull(repository.query(item.getName()));
        //Assert.assertNull(repository.query(item.getName()));

    }
}
