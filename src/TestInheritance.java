import java.util.Arrays;

public class TestInheritance {
    public static void main(String[] args) {
        Student stu = new Student("cxf", 10, true);

        /*System.out.println(stu);
        Student stu1 = new Student("cxf", 10, true);
        System.out.println(stu.equals(stu1));*/

        Person p = new Student();
        p.sayHello(); // student
        p.acting();
        //p.showing();

        /*Person p1 = null;
        p1.sayHello();
        p1.acting();*/


        StringBuilder sb = new StringBuilder();
        sb.append("cxf");
        sb.delete(1,2);
        sb.reverse();

        StringBuffer sf = new StringBuffer();

        int[][] a = {{1, 2, 3}, {-1, -2, -3}};
        System.out.println(a.length);
        System.out.println(a[0].length);
        System.out.println(Arrays.toString(a[0]));
        System.out.println(Arrays.binarySearch(a[0], 1));

        Integer i = new Integer(100);
    }
}
