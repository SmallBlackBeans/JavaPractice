package com.hanxiaocu.jdbc;

import java.sql.*;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/09/25 3:15 PM
 */
public class JdbcTest {

    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/mysql_study?autoReconnect=true&useSSL=false";

    private static final String USER_NAME = "root";

    private static final String PWD = "Mysql@Han0302";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            //加载驱动 现在不需要这句话了，因为定义了一个规范，会去jar包，META-INF/service 文件夹下查找
            //Class.forName(DRIVER_NAME);
            //获取连接
            connection = DriverManager.getConnection(URL, USER_NAME, PWD);
            String sql = "SELECT * FROM apps where app_name like '%宝%'";
            PreparedStatement prst = connection.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                System.out.println("---" + rs.getString("app_name"));
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
