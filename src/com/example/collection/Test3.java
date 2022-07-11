package com.example.collection;

import java.rmi.MarshalException;

public class Test3 {
    public static void main(String[] args) {
        MethodGeneric methodGeneric = new MethodGeneric();
        methodGeneric.setName("bjsxt");
        methodGeneric.setName(123);

        MethodGeneric methodGeneric1 = new MethodGeneric();
        System.out.println(methodGeneric1.getName("cxf").getClass());
        System.out.println(methodGeneric1.getName(1234).getClass());

        System.out.println("====================");

        MethodGeneric.setFlag("cxf");
        MethodGeneric.setFlag(123123);
        System.out.println(MethodGeneric.getFlag("cxfff"));
        System.out.println(MethodGeneric.getFlag(12312));
    }
}
