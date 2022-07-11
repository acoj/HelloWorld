package com.example.GOF23;

public class Decorate {

    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink milk = new Milk(coffee);
        System.out.println(milk.info() + ": " + milk.cost());

        Drink sugar = new Sugar(milk);
        System.out.println(sugar.info() + ": " + sugar.cost());


    }
    public void Test1() {

    }
}

interface Drink {
    double cost();
    String info();
}

class Coffee implements Drink{
    private String name;
    public Coffee() {
        this.name = "coffee";
    }
    @Override
    public double cost() {
        return 10;
    }
    @Override
    public String info() {
        return name;
    }
}

abstract class Decor implements Drink{
    private Drink drink;
    public Decor(Drink drink){
        this.drink = drink;
    }
    @Override
    public double cost() {
        return this.drink.cost();
    }
    @Override
    public String info() {
        return this.drink.info();
    }
}

class Milk extends Decor{
    public Milk(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*4;
    }
    @Override
    public String info() {
        return super.info() + " plus milk";
    }
}

class Sugar extends Decor{
    public Sugar(Drink drink) {
        super(drink);
    }
    @Override
    public double cost() {
        return super.cost()*2;
    }
    @Override
    public String info() {
        return super.info() + " plus sugar";
    }
}