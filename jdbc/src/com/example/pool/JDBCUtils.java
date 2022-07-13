package com.example.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author cxf
 * @create 2022-07-13 2:58 PM
 */

public class JDBCUtils {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloC3p0");
    public static Connection getConnection1() throws Exception {
        Connection conn = cpds.getConnection();
        return conn;
    }

    private static BasicDataSource dataSource = null;
    static{
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
            dataSource = BasicDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2() throws Exception {
        Connection conn = dataSource.getConnection();
        return conn;
    }

    private static  DataSource dataSource1 = null;
    static{
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties prop = new Properties();
        try {
            prop.load(is);
            dataSource1 = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws SQLException {
        Connection conn = dataSource1.getConnection();
        return conn;
    }

    public static void close(Connection conn){
        DbUtils.closeQuietly(conn,null,null);
    }

    public static void close(Connection conn, PreparedStatement ps){
        DbUtils.closeQuietly(conn,ps, null);
    }

    public static void close(Connection conn, PreparedStatement ps, ResultSet rs){
        DbUtils.closeQuietly(conn,ps,rs);
    }
}
