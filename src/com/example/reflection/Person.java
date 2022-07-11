package com.example.reflection;

public class Person extends Creature<String>{
    private String name;
    protected int id;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private Person(String name) {
        this.name = name;
    }
    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void show(){
        System.out.println("hello, I'm a person");
    }
    private String showNation(String nation){
        System.out.println("my country is: " + nation);
        return nation;
    }
}
