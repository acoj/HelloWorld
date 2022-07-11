public class Person extends Object{
    /*public final void TestFinal(){
        System.out.println("father final");
    }

    private void testPrivate(){
        System.out.println("testPrivate");
    }*/

    static{
        System.out.println("父类静态块");
    }
    {
        System.out.println("父类构造块");
    }
    public Person(){
        System.out.println("父类构造器");
    }


    public void sayHello(){
        System.out.println("hello from Person");
    }

    public void acting(){
        System.out.println("acting from Person");
    }



    public int value = 100;

    /*public static void main(String[] args) {

    }*/
}
