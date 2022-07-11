package com.example.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.add("bjsxt"));
        list.add(1, "cxf");
        /*System.out.println(list.get(0));
        System.out.println(list.get(1));*/
        for(String s : list){
            System.out.println(s);
        }
        System.out.println("-----------------");
        Object[] objs = list.toArray();
        for(Object obj : objs){
            System.out.println(obj);
        }
        String[] str = list.toArray(new String[2]);
        for(String s : str){
            System.out.println(s);
        }
        System.out.println("--------------");
        List<String> a = new ArrayList<>();
        a.add("a"); a.add("b");
        List<String> b = new ArrayList<>();
        b.add("c"); b.add("x");
        System.out.println(a.addAll(b));
        for(String s : a){
            System.out.println(s);
        }
    }
}
