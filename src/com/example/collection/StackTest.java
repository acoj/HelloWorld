package com.example.collection;

import java.util.List;
import java.util.Stack;

public class StackTest {
    private String name;
    public static void main(String[] args) {
        Stack<String> sta = new Stack<>();
        sta.push("a");
        sta.push("b");
        sta.push("c");

        System.out.println(sta.pop());
        System.out.println(sta.peek());

        System.out.println(sta.search("c"));

        StackTest stackTest = new StackTest();
        stackTest.print();
    }

    void print(){
        System.out.println("klajfalk");
    }
}
