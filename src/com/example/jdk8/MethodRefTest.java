package com.example.jdk8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefTest {
    public String getName() {
        return "xinfeng";
    }

    @Test
    public void Test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("cxf");

        PrintStream ps = System.out;
//        Consumer<String> con2 = System.out :: println;
        Consumer<String> con2 = ps::println;
        con2.accept("xinfeng");
    }

    @Test
    public void Test2() {
        Supplier<String> sup1 = () -> "cxf";
        System.out.println(sup1.get());

        Supplier<String> sup2 = new MethodRefTest()::getName;
        System.out.println(sup2.get());
    }

    @Test
    public void Test3() {
        Comparator<Integer> com1 = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com1.compare(12, 31));

        Comparator<Integer> com2 = Integer::compare;    // static
        System.out.println(com2.compare(21, 2));

        Comparator<Integer> com3 = Integer::compareTo;  // non-static
        System.out.println(com3.compare(1, 1));
    }

    @Test
    public void Test4() {
        Function<Double, Long> fun1 = d -> Math.round(d); // static
        System.out.println(fun1.apply(12.3));

        Function<Double, Long> fun2 = Math::round;
        System.out.println(fun2.apply(12.6));
    }

    @Test
    public void Test5() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("a", "e"));

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("e", "a"));
    }

    @Test
    public void Test6() {
        BiPredicate<String, String> bip1 = (s1, s2) -> s1.equals(s2);
        System.out.println(bip1.test("a", "a"));

        BiPredicate<String, String> bip2 = String::equals;
        System.out.println(bip2.test("a", "v"));
    }

    @Test
    public void Test7() {
        Function<MethodRefTest, String> fun1 = methodRefTest -> methodRefTest.getName();
        System.out.println(fun1.apply(new MethodRefTest()));

        Function<MethodRefTest, String> fun2 = MethodRefTest :: getName;
        System.out.println(fun2.apply(new MethodRefTest()));

    }

}
