package com.example.thread;

public class LambdaTest1 {
    static class Like1 implements ILike{
        @Override
        public void lambda() {
            System.out.println("I like lambda1");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        like = new Like1();
        like.lambda();

        class Like2 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lambda2");
            }
        }
        like = new Like2();
        like.lambda();

        like = new ILike(){
            @Override
            public void lambda() {
                System.out.println("I like lambda3");
            }
        };
        like.lambda();

        like = () -> {
            System.out.println("I like lambda4");
        };
        like.lambda();

        /*() -> {
            System.out.println("I like lambda5");
        }.lambda();*/
    }
}
interface ILike{
    void lambda();
//    void lambda2();
}
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("I like lambda");
    }

}
