package com.example.collection;

import java.util.*;

public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");list.add("f");list.add("e");list.add("d");
        Iterator<String> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());
            //ite.remove();
            //list.remove("c");
            //list.add("x");
        }

        /*for(String s : list){
            if("c".equals(s)){
                list.remove(s);
            }
        }*/
        for(String s : list){
            System.out.println(s);
        }

        System.out.println("-----------------");
        Set<String> set = new HashSet<>();
        set.add("a"); set.add("b"); set.add("c"); set.add("d");
        Iterator<String> ite1 = set.iterator();
        while(ite1.hasNext()){
            System.out.println(ite1.next());
        }

        Collections.sort(list);
        for(String s : list){
            System.out.println(s);
        }

        String s = "kafjksaf;";
        //Collections.sort();

        Integer i = 20;

    }
}
