package com.example.server;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        /*Class clz = new ReflectTest().getClass();
        System.out.println(clz);
        Class clz1 = ReflectTest.class;
        System.out.println(clz1);*/
        // recommend
        Class clz2 = Class.forName("com.example.server.ReflectTest");// package.class
        System.out.println(clz2);

//        ReflectTest r = (ReflectTest)clz.newInstance();     // not recommend
//        System.out.println(r);
        ReflectTest r1 = (ReflectTest)clz2.getConstructor().newInstance();  // recommend
        System.out.println(r1);
    }
}
