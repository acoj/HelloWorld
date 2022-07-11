package com.example.thread;

public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();
    }
}
interface Marry{
    void happyMarry();
}
class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("I'm marrying.");
    }
}
class WeddingCompany implements Marry{
    private Marry y;

    public WeddingCompany(Marry y) {
        this.y = y;
    }

    @Override
    public void happyMarry() {
        before();
        this.y.happyMarry();
        after();
    }
    private void before(){
        System.out.println("before");
    }
    private void after(){
        System.out.println("after");
    }
}