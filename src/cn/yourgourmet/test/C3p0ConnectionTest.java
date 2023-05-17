package cn.yourgourmet.test;

import cn.yourgourmet.util.C3P0Util;

import java.sql.Connection;

public class C3p0ConnectionTest {
    public static void main(String[] args) {
        Connection conn = C3P0Util.getConnection();
        if (conn != null) {
            System.out.println("连接成功！");
        } else {
            System.out.println("连接失败！");
        }
    }
}
