package com.example.collection;

public class ShowMsg {
//    public void showFlag(Generic<?> generic){
    public void showFlag(Generic<? super Integer> generic){
        System.out.println(generic.getFlag());
    }
}
