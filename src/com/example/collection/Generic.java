package com.example.collection;

public class Generic<T>{
    private T flag;
    /*public static T demo(T name){   // 静态方法不能使用类的范型
        return null;
    }*/
    public void setFlag(T flag){
        this.flag = flag;
    }
    public T getFlag(){
        return this.flag;
    }

    public <T> void method(T ... args){
        for(T arg : args){
            System.out.println(arg);
        }
    }
}
