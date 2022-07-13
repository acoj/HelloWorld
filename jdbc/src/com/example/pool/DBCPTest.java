package com.example.pool;

import com.example.connnection.JDBCUtils;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author cxf
 * @create 2022-07-13 3:06 PM
 */

public class DBCPTest {
    @Test
    public void testGetConnection() throws Exception {
        BasicDataSource source = new BasicDataSource();
        source.setDriverClassName("com.mysql.cj.jdbc.Driver");
        source.setUrl("jdbc:mysql://localhost:3306/entertainers");
        source.setUsername("cxf");
        source.setPassword("abc123");

        source.setInitialSize(10);

        Connection conn = source.getConnection();
        System.out.println("conn = " + conn);

        JDBCUtils.close(null,conn);

    }

    @Test
    public void testGetConnection1() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
        Properties prop = new Properties();
        prop.load(is);
        BasicDataSource dataSource = BasicDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();

        System.out.println("conn = " + conn);

        JDBCUtils.close(null,conn);
    }
}
