package com.example.collection;

import java.util.List;
import java.util.Vector;

public class VectorTest {
    public static void main(String[] args) {
        List<String> v = new Vector<>();
        v.add("a"); v.add("b"); v.add("c");
        for(int i = 0; i < v.size(); i++){
            System.out.println(v.get(i));
        }
        for(String s : v){
            System.out.println(s);
        }
    }
}
