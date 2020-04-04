package com.hanxiaocu.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/26 10:22 AM
 */
public class JdbcUtil {
    private JdbcUtil() {
    }

    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Properties p = new Properties();
            ClassLoader loader = JdbcUtil.class.getClassLoader();
            InputStream in = loader.getResourceAsStream("db.properties");
            p.load(in);
            in.close();

            Class.forName(p.getProperty("driverClassName"));
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
