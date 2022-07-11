package com.example.collection;

public class IGenericImpl implements IGeneric<String> {
    private String name;
    @Override
    public String getName(String name){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
