package com.example.pool;

import com.example.connnection.JDBCUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;

import java.sql.Connection;

/**
 * @author cxf
 * @create 2022-07-13 2:22 PM
 */

public class C3P0Test {
    @Test
    public void testGetConnection() throws Exception {

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/entertainers" );
        cpds.setUser("cxf");
        cpds.setPassword("abc123");

        cpds.setInitialPoolSize(10);

        Connection conn = cpds.getConnection();
        System.out.println("conn = " + conn);

        JDBCUtils.close(null, conn);


        DataSources.destroy(cpds);

    }

    @Test
    public void testGetConnection1() throws Exception{
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloC3p0");
        Connection conn = cpds.getConnection();
        System.out.println("conn = " + conn);
        JDBCUtils.close(null,conn);

    }
}
