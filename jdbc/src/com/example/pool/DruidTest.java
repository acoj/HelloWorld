package com.example.pool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.example.connnection.JDBCUtils;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author cxf
 * @create 2022-07-13 3:40 PM
 */

public class DruidTest {
    @Test
    public void testGetConnection() throws Exception {
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Properties prop = new Properties();
        prop.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        Connection conn = dataSource.getConnection();
        System.out.println("conn = " + conn);
        JDBCUtils.close(null,conn);
    }
}
