package com.example.commonclass;

import org.junit.*;

public class JUnitTest {
    private static Object[] array;
    private static int total;

    @BeforeClass
    public static void init(){
        System.out.println("init");
        array = new Object[5];
    }

    @Before
    public void before(){
        System.out.println("before, total=" + total);
    }

    @Test
    public void add(){
        System.out.println("add");
        array[total++] = "hello";
    }

    @After
    public void after(){
        System.out.println("after, total=" + total);
    }

    @AfterClass
    public static void destroy(){
        array = null;
        System.out.println("destroy");
    }

}
