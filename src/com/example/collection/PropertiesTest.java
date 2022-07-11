package com.example.collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/jdbc.properties"));
        System.out.println(properties.get("name"));
        System.out.println(properties.get("password"));
        System.out.println(properties.get("password1"));
    }
}
