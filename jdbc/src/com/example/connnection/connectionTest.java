package com.example.connnection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author cxf
 * @create 2022-07-11 4:26 PM
 */

public class connectionTest {
    @Test
    public void testConnection1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();

        String url = "jdbc:mysql://localhost:3306/entertainers";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "nNF81120XMlE");
        Connection connect = driver.connect(url, properties);
        System.out.println("connection = " + connect);
    }

    @Test
    public void testConnection2() throws Exception {
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        String url = "jdbc:mysql://localhost:3306/entertainers";
        Properties properties = new Properties();

        properties.setProperty("user", "root");
        properties.setProperty("password", "nNF81120XMlE");

        Connection connect = driver.connect(url, properties);

        System.out.println("connect = " + connect);
    }

    @Test
    public void testConnection3() throws Exception {
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) aClass.getDeclaredConstructor().newInstance();

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainers", "root", "nNF81120XMlE");
        System.out.println("connection = " + connection);

    }

    @Test
    public void testConnection4() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");  // static code block in Driver class

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entertainers", "root", "nNF81120XMlE");
        System.out.println("connection = " + connection);
    }

    // decouple the code and the data
    // don't need to re-jar
    @Test
    public void testConnection5() throws Exception {
        InputStream is = connectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties prop = new Properties();
        prop.load(is);

        String url = prop.getProperty("url");
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        String driverClass = prop.getProperty("driverClass");

        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println("connection = " + connection);
    }
}
