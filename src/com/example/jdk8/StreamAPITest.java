package com.example.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest {
    @Test
    public void Test1(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Stream<String> stream = list.stream();

        stream.filter(s -> {if(s.compareTo("a") > 0) return true; else return false;}).forEach(System.out::println);

        System.out.println();
        list.stream().limit(2).forEach(System.out::println);

        System.out.println();
        list.stream().skip(2).forEach(System.out::println);

        System.out.println();
        list.add("a");
        list.add("c");
        list.add("e");
        System.out.println(list);
        list.stream().distinct().forEach(System.out::println);


        Stream<String> parallelStream = list.parallelStream();
    }
    @Test
    public void Test2(){
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);
    }
    @Test
    public void Test3(){
        Stream<String> a = Stream.of("a", "b", "c");
    }
    @Test
    public void Test4(){
        Stream.iterate(1, t -> t*2).limit(20).forEach(System.out :: println);
        Stream.generate(Math :: random).limit(10).forEach(System.out :: println);
    }
    @Test
    public void Test5(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        list.stream().filter(s -> {if(s.compareTo("aa") > 0) return true; else return false;}).map(s -> s.charAt(0)).forEach(System.out::println);

        System.out.println();

        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest::fromStringToStream);
        characterStream.forEach(System.out::println);

    }
    public static Stream<Character> fromStringToStream(String s){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : s.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    @Test
    public void Test6(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "CC", "B", "A");
        list.stream().sorted().forEach(System.out::println);
        System.out.println();
        list.stream().sorted((s1, s2) -> -s1.compareTo(s2)).forEach(System.out::println);

        System.out.println();
        list.forEach(System.out::println);
    }
    @Test
    public void Test7(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(list.stream().reduce(0, (a1, a2) -> a1 + a2));
        System.out.println(list.stream().reduce(0, Integer::sum));
        System.out.println(list.stream().reduce(Integer::sum));

        Set<Integer> integerSet = list.stream().collect(Collectors.toSet());
        integerSet.forEach(System.out::println);
    }
}
