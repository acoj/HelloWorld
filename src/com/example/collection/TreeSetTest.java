package com.example.collection;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Integer i = 40;
        Set<String> set = new TreeSet<>();
        set.add("x");
        set.add("f");
        set.add("c");
        set.add("i");
        for(String  s: set){
            System.out.println(s);
        }

        System.out.println("--------------------");
        Set<User> set1 = new TreeSet<>();
        set1.add(new User("cxf", 18));
        set1.add(new User("cxf", 25));
        set1.add(new User("xf", 22));
        set1.add(new User("cxf", 22));
        for(User u : set1){
            System.out.println(u);
        }

        System.out.println("---------------------");
        Set<Student> set2 = new TreeSet<>(new StudentComparator());
        set2.add(new Student("cxf", 18));
        set2.add(new Student("cxf", 25));
        set2.add(new Student("xf", 22));
        set2.add(new Student("cxf", 22));
        for(Student u : set2){
            System.out.println(u);
        }


    }
}
