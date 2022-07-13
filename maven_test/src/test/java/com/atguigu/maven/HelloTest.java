package com.atguigu.maven;

import org.junit.Test;

/**
 * @author cxf
 * @create 2022-07-13 6:31 PM
 */

public class HelloTest {
    @Test
    public void testHello(){
        Hello hello = new Hello();
        String maven = hello.sayHello("maven");
        System.out.println("maven = " + maven);
    }
}
