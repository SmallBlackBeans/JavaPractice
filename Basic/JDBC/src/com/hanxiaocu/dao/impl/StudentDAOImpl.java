package com.hanxiaocu.dao.impl;

import com.hanxiaocu.dao.IStudentDAO;
import com.hanxiaocu.handler.impl.BeanHandler;
import com.hanxiaocu.handler.impl.BeanListHandler;
import com.hanxiaocu.pojo.Student;
import com.hanxiaocu.util.JdbcTemplate;

import java.util.List;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/26 10:04 AM
 */
@SuppressWarnings("all")
public class StudentDAOImpl implements IStudentDAO {

    public void save(Student stu) {
        String sql = "INSERT INTO t_student (name,age) VALUES(?,?)";
        Object[] params = {stu.getName(), stu.getAge()};
        JdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM t_student WHERE id = ?";
        JdbcTemplate.update(sql, id);
    }

    public void update(Student stu) {
        String sql = "UPDATE t_student SET name = ?, age = ? WHERE id = ?";
        Object[] params = {stu.getName(), stu.getAge(), stu.getId()};
        JdbcTemplate.update(sql, params);
    }

    public Student get(Long id) {
        String sql = "SELECT * FROM t_student WHERE id = ?";
        return JdbcTemplate.query(sql, new BeanHandler<>(Student.class), id);
    }

    public List<Student> list() {
        String sql = "SELECT * FROM t_student";
        return JdbcTemplate.query(sql, new BeanListHandler<>(Student.class));
    }
}