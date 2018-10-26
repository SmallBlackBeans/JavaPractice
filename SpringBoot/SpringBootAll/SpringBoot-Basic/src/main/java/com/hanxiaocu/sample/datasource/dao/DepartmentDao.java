package com.hanxiaocu.sample.datasource.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/25 5:11 PM
 */
@Repository
public class DepartmentDao {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


}
