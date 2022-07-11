package com.example.jdk8;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void Test1(){
        String s = "cxf";
        Optional<String> s1 = Optional.of(s);
        System.out.println(s1);
        
//        s = null;
//        Optional<String> s2 = Optional.of(s);
    }
    @Test
    public void Test2(){
        String s = "cxf";
        Optional<String> s1 = Optional.ofNullable(s);
        System.out.println(s1);

        s = null;
        Optional<String> s2 = Optional.ofNullable(s);
        System.out.println(s2);
    }
    @Test
    public void Test3(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
    }
    public String getGirlName(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy cxf = boyOptional.orElse(new Boy(new Girl("cxf")));
        Girl girl = cxf.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl chen = girlOptional.orElse(new Girl("chen"));
        return chen.getName();
    }
    @Test
    public void Test4(){
        Boy boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
        System.out.println(boy);

        boy = new Boy();
        String girlName1 = getGirlName(boy);
        System.out.println(girlName1);
        System.out.println(boy);

        boy = new Boy(new Girl("jing"));
        String girlName2 = getGirlName(boy);
        System.out.println(girlName2);
        System.out.println(boy);
    }
}

class Girl{
    private String name;

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Boy{
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}