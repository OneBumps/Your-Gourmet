package cn.yourgourmet.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Util {
    private static DataSource dataSource = null;

    static {
        dataSource = new com.mchange.v2.c3p0.ComboPooledDataSource("mysqlConn");
    }

    public static Connection getConnection() {
        try {
            System.out.println("connection ok!");
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
