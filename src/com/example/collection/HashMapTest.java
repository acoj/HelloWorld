package com.example.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        map.put("d", "D");
        map.put("e", "E");
        System.out.println(map.get("a"));
        Set<String> set = map.keySet();
        for(String s : set){
            System.out.println(s + ":" + map.get(s));
        }
        System.out.println("-------------------");

        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        for(Map.Entry<String, String> entry : entrySet){
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }


        Map<User, String> map1 = new TreeMap<>();

    }
}
