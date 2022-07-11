package com.example.commonclass;

import org.junit.Test;

import java.util.ArrayList;

//@MyAnnotations({@MyAnnotation("hi"), @MyAnnotation("hello")})
@MyAnnotation("hi")
@MyAnnotation("yes")
public class Annotation {
//    @MyAnnotation
    public Annotation(){
        System.out.println(this.getClass());
    }

    @Test
    public void testGetAnnotation(){
//        Class<Son> sonClass = Son.class;
//        java.lang.annotation.Annotation[] annotations = sonClass.getAnnotations();
//        for(int i = 0; i < annotations.length; i++){
//            System.out.println(annotations[i]);
//        }
        Annotation annotation = new Annotation();
        System.out.println(annotation.getClass());
        System.out.println("cxf " + Annotation.class);
    }
}

class Son extends Annotation{

}


class Generic<@MyAnnotation T> {
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }
}