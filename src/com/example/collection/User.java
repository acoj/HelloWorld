package com.example.collection;

public class User implements Comparable<User>{
    private String username;
    private int age;
    public User(String username, int age){
        this.username = username;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public int compareTo(User u){
        if(this.age < u.getAge()){
            return -1;
        }
        if(this.age == u.getAge()){
            return this.username.compareTo(u.getUsername());
        }
        return 1;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
