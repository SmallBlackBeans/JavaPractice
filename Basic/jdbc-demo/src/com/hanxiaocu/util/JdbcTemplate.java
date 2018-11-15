package com.hanxiaocu.util;

import com.hanxiaocu.handler.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/26 10:05 AM
 */
public class JdbcTemplate {

    private JdbcTemplate() {
    }

    /**
     * DML 操作模板
     *
     * @param sql
     * @param params
     */
    public static void update(String sql, Object... params) {
        try (
                Connection conn = JdbcUtil.getConn();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * DQL 操作模板
     * @param sql
     * @param rsh
     * @param params
     * @param <T>
     * @return
     */
    public static <T> T query(String sql, IResultSetHandler<T> rsh, Object... params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConn();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            return rsh.handle(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcUtil.close(conn, ps, rs);
        }
    }
}
