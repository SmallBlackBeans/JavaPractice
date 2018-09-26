package com.hanxiaocu.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description: 处理结果集规范
 * User: hanchenghai
 * Date: 2018/09/26 10:06 AM
 */
public interface IResultSetHandler<T> {
    /**
     * 处理结果集
     * @param rs 结果集对象
     * @return 处理后的对象
     * @throws SQLException
     */
    T handle(ResultSet rs) throws SQLException;
}
