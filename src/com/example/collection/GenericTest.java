package com.example.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericTest {
    @Test
    public void Test1(){
        Object[] arr1 = new Object[2];
        arr1[0] = 123;
        arr1[1] = "cxf";
//        System.out.println(arr1[0]);
        String[] arr2 = new String[2];
        arr2[0] = "chen";
        arr2[1] = "xinfeng";
        arr1 = arr2;
//        System.out.println(arr1[0]);

        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add(123);
        list1.add("cxf");
        list2.add("chen");
        list2.add("xinfeng");
//        list1 = list2;

        print(list1);
        print(list2);

        list1.forEach(System.out::println);
        list2.forEach(System.out::println);
    }
    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }

}
