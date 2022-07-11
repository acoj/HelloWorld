package com.example.collection;

public class Test2 {
    public static void main(String[] args) {
        IGenericImpl ig = new IGenericImpl();
        String name = ig.getName("cxf");
        System.out.println(name);
        ig.setName("cxff");

        IGeneric<String> ig1 = new IGenericImpl();
        System.out.println(ig1.getName("cxf1").getClass());

    }
}
