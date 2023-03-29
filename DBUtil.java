package com.csi.util;

import java.sql.*;

/**
 * JDBC的封装
 */
public class DBUtil {
    public static final String DRIVER="com.mysql.jdbc.Driver";
    public static final String URL="jdbc:mysql:///s2?useSSL=false&useServerPrepStmts=true";
    public static final String USERNAME="root";
    public static final String PASSWORD="Ygl990206";
    private Connection conn;

    public DBUtil() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        // 设置Class.forname
        Class.forName(DRIVER).newInstance();
        conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }
    // 设置获取Statement
    public Statement getStmt() throws SQLException {
        return conn.createStatement();
    }
    // 创建预编译
    public PreparedStatement getPrep(String sql) throws SQLException {
        return conn.prepareStatement(sql);
    }
    public void close() throws SQLException {
        if (conn!=null)conn.close();
    }
}
