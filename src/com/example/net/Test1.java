package com.example.net;

import java.net.*;

public class Test1 {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

        addr = InetAddress.getByName("www.163.com");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        System.out.println(addr.getCanonicalHostName());

        System.out.println("----------------------");
        addr = InetAddress.getByName("116.77.73.215");
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
        System.out.println(addr.getCanonicalHostName());

        System.out.println("----------------------");
        InetSocketAddress sadd = new InetSocketAddress("127.0.01", 8080);
        InetSocketAddress sadd2 = new InetSocketAddress("localhost", 9000);
        System.out.println(sadd.getHostName());
        System.out.println(sadd.getAddress());
        System.out.println(sadd2.getHostName());
        System.out.println(sadd2.getAddress());
        System.out.println(sadd2.getPort());
        System.out.println(sadd.getPort());

        System.out.println("----------------------");
        URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
        System.out.println("protocol: " + url.getProtocol());
        System.out.println("host: " + url.getHost());
        System.out.println("port: " + url.getPort());
        System.out.println("default port: " + url.getDefaultPort());
        System.out.println("file: " + url.getFile());
        System.out.println("path: " + url.getPath());
        System.out.println("query: " + url.getQuery());
        System.out.println("ref: " + url.getRef());

    }
}
