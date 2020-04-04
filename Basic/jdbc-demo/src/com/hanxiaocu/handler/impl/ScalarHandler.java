package com.hanxiaocu.handler.impl;

import com.hanxiaocu.handler.IResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description: 聚合函数的结果处理
 * User: hanchenghai
 * Date: 2018/09/26 10:20 AM
 */
public class ScalarHandler implements IResultSetHandler<Long> {
    @Override
    public Long handle(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return rs.getLong(1);
        }
        return 0L;
    }
}
