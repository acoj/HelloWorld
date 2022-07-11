package com.example.thread;

import java.util.ArrayList;
import java.util.List;

public class HappyCinema {
    public static void main(String[] args) {
        List<Integer> available = new ArrayList<>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(4);
        available.add(6);
        available.add(8);
        HappyCinema cinema = new HappyCinema(available, "cxf");

        List<Integer> seats = new ArrayList<>();
        seats.add(1);
        seats.add(2);
        new Thread(new Person(cinema, seats), "chen").start();
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(4);
        seats1.add(3);
        seats1.add(8);
        new Thread(new Person(cinema, seats1), "xinfeng").start();
    }

    List<Integer> available;
    String name;

    public HappyCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }
    public synchronized boolean bookTickets(List<Integer> seats){
        System.out.println("current available seats: " + available);
        List<Integer> copy = new ArrayList<>();
        copy.addAll(available);
        copy.removeAll(seats);
        if(available.size() - copy.size() != seats.size()){
            return false;
        }
        available = copy;
        return true;
    }
}

class Person implements Runnable{
    HappyCinema cinema;
    List<Integer> seats;

    public Person(HappyCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        //synchronized (cinema){
            boolean flag = cinema.bookTickets(seats);
            if(flag){
                System.out.println("book tickets " + seats + " success.");
            }else{
                System.out.println("book tickets " + seats + " fail.");
            }
        //}
    }
}
