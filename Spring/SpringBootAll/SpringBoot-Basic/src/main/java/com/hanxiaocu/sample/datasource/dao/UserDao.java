package com.hanxiaocu.sample.datasource.dao;

import com.hanxiaocu.sample.datasource.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 3:48 PM
 */
@Repository("xxUserDao")
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate ;

    public User getUser(Long userId) {
        String sql = "select * from user where user_id=?";
        User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(),userId);
        return user;
    }


    public List<User> getUserByDepartmentId(Long departmentId) {
        String sql= "select * from user where department_id=?";
        List<User> users = jdbcTemplate.query(sql, new UserRowMapper(), departmentId);
        return users;
    }

    public Map getUserMap(Long userId) {
        String sql = "select * from user where user_id=?";
        return jdbcTemplate.queryForMap(sql,userId);
    }


    public Integer insertUser(final User user) {
        final String sql       = "insert into user (name,department_id) values(?,?)";
        KeyHolder  keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                //指出自增主键的列名
                PreparedStatement ps = connection.prepareStatement(sql,new String[]{"id"});
                ps.setString(1,user.getName());
                ps.setInt(2,user.getDepartment_id());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();
    }



    public int getCountOfDepartment(Long departmentId){
        String sql = "select count(1) from user where department_id=:deptId";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("deptId",departmentId);
        Integer count = namedParameterJdbcTemplate.queryForObject(sql,namedParameters,Integer.class);
        return count;
    }

    public void updateUser(Long userId) {
        User user = new User();
        user.setName("Jack");
        user.setDepartment_id(1);
        String sql = "upadate user set name=:name and department_id=:departmentId where id=:id";
        SqlParameterSource source = new BeanPropertySqlParameterSource(user);
        namedParameterJdbcTemplate.update(sql,source);
    }



    //ResultSet 到 POJO 的映射 。
    static class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setUser_id(rs.getInt("user_id"));
            user.setName(rs.getString("name"));
            user.setDepartment_id(rs.getInt("department_id"));
            return user;
        }
    }
}
