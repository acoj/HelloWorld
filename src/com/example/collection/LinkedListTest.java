package com.example.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> ll = new LinkedList<>();
        LinkedList<String> ll1 = new LinkedList<>();
        ll1.addFirst("a");
        ll1.addFirst("b");
        ll1.addFirst("c");
        for(String s : ll1){
            System.out.println(s);
        }
    }
}
