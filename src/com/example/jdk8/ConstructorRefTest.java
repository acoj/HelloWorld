package com.example.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    @Test
    public void Test1(){
        Supplier<Employee> sup1 = () -> new Employee();
        System.out.println(sup1.get());

        Supplier<Employee> sup2 = Employee :: new;
        System.out.println(sup2.get());
    }
    @Test
    public void Test2(){
        Function<Integer, Employee> fun1 = id -> new Employee(id);
        System.out.println(fun1.apply(1001));

        Function<Integer, Employee> fun2 = Employee :: new;
        System.out.println(fun2.apply(1001));
    }
    @Test
    public void Test3(){
        BiFunction<Integer, String, Employee> bif1 = (id, name) -> new Employee(id, name);
        System.out.println(bif1.apply(1002, "cxf"));

        BiFunction<Integer, String, Employee> bif2 = Employee :: new;
        System.out.println(bif2.apply(1003, "chen"));
    }
    @Test
    public void Test4(){
        Function<Integer, String[]> fun1 = len -> new String[len];
        String[] arr1 = fun1.apply(10);
        System.out.println(Arrays.toString(arr1));

        Function<Integer, String[]> fun2 = String[] :: new;
        String[] arr2 = fun2.apply(10);
        System.out.println(Arrays.toString(arr2));
    }
}

class Employee{
    private int id;
    private String name;

    public Employee(){
        System.out.println("ConstructorRefTest");
    }

    public Employee(Integer id){
        this.id = id;
        System.out.println("ConstructorRefTest1");
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}