package com.example.reflection;

import com.example.server.ReflectTest;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.*;
import java.util.Properties;
import java.util.Random;

public class ReflectionTest {
    @Test
    public void test1(){
        Person p1 = new Person("Tome", 12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();
    }
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class pClass = Person.class;
        Constructor constructor = pClass.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        Person tom1 = (Person) tom;
        System.out.println(tom);

        Field age = pClass.getDeclaredField("age");
        age.set(tom, 10);
        System.out.println(tom);

        Method show = pClass.getDeclaredMethod("show");
        show.invoke(tom);

        System.out.println("------------------");

        Constructor constructor1 = pClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Object cxf = constructor1.newInstance("cxf");
        System.out.println(cxf);
        Field name = pClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(cxf, "chen");
        System.out.println(cxf);
        Method showNation = pClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        Object china = showNation.invoke(cxf, "New Federal State of  China");
        System.out.println(china);
    }
    @Test
    public void test3() throws ClassNotFoundException, NoSuchMethodException {
        Class<Person> cl1 = Person.class;
        System.out.println(cl1);

//        Person p1 = new Person();
//        Class<? extends Person> cl2 = p1.getClass();
//        System.out.println(cl2);

        Class<?> cl3 = Class.forName("com.example.reflection.Person");
        System.out.println(cl3);

        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        Class<?> cl4 = classLoader.loadClass("com.example.reflection.Person");
        System.out.println(cl4);

        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        System.out.println(String.class.getClassLoader());

//        System.out.println(cl1 == cl2);
        System.out.println(cl1 == cl3);
        System.out.println(cl1 == cl4);
    }
    @Test
    public void test4(){
        System.out.println(Object.class);
        System.out.println(Comparable.class);
        System.out.println(String[].class);
        System.out.println(int[][].class);
        System.out.println(ElementType.class);
        System.out.println(Override.class);
        System.out.println(int.class);
        System.out.println(void.class);
        System.out.println(Class.class);

        int[] a = new int[10];
        int[] b = new int[100];
        char[] c = new char[10];
        System.out.println(a.getClass());
        System.out.println(c.getClass());
        System.out.println(a.getClass() == b.getClass());
    }
    @Test
    public void Test5() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        properties.load(is);
        System.out.println(properties.getProperty("name"));

    }
    @Test
    public void Test6() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> cl = Person.class;
        Person person = cl.newInstance();
        System.out.println(person);

        Person p1 = cl.getConstructor().newInstance();
        System.out.println(p1);

        Person p2 = cl.getDeclaredConstructor().newInstance();
        System.out.println(p2);
    }
    @Test
    public void Test7() throws Exception {
        for(int i = 0; i < 100; i++){
            int a = new Random().nextInt(3);
            String classPath = "";
            switch (a){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.example.reflection.Person";
                    break;
            }
            System.out.println(getInstance(classPath));
        }


    }
    public Object getInstance(String classPath) throws Exception {
        Class<?> aClass = Class.forName(classPath);
//        Object o = aClass.newInstance();
        Object o = aClass.getConstructor().newInstance();
        return o;
    }
    @Test
    public void Test8(){
        Class<Person> cl = Person.class;
        Class<? super Person> superclass = cl.getSuperclass();
        System.out.println(superclass);
        Class<?>[] interfaces = cl.getInterfaces();
        for(Class in : interfaces){
            System.out.println(in);
        }
        Class<?>[] interfaces1 = superclass.getInterfaces();
        for(Class in : interfaces1){
            System.out.println(in);

        }
        System.out.println(cl.getPackage());
        Annotation[] annotations = cl.getAnnotations();
        for(Annotation anno: annotations){
            System.out.println(anno);
        }
        Type genericSuperclass = cl.getGenericSuperclass();
//        System.out.println(genericSuperclass);
//        if(genericSuperclass instanceof ParameterizedType){
            ParameterizedType paramType = (ParameterizedType) genericSuperclass;
//            System.out.println(paramType);
            Type[] actualTypeArguments = paramType.getActualTypeArguments();
//            System.out.println(actualTypeArguments);
//            System.out.println(actualTypeArguments[0]);
            System.out.println(actualTypeArguments[0].getTypeName());
            System.out.println(((Class)actualTypeArguments[0]).getName());
//        }
    }
    @Test
    public void Test9() throws Exception {
        Class<Person> cl = Person.class;
        Person p = cl.getConstructor().newInstance();
//        Field id = cl.getField("id"); // public
        Field id = cl.getDeclaredField("id");
        id.set(p, 1001);
        Object o = id.get(p);
        System.out.println(o);

        Field name = cl.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "cxf");
        System.out.println(name.get(p));
    }

}
