package com.example.jdk8;

import java.util.Comparator;

public class LambdaTest {
    public static void main(String[] args) {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(32, 12));
        //方法引用
        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(32, 12));
        Comparator<Integer> com3 = Integer::compareTo;
        System.out.println(com3.compare(32, 12));
//        System.out.println(Integer.valueOf(32).com3(12));
    }
}
