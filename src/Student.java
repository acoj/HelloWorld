import java.util.Objects;
import java.util.function.DoubleToIntFunction;

public class Student extends Person{
    private String name;
    private int age;
    private boolean gender;
    public int value = 1;
    public Student(String name, int age, boolean gender){
        System.out.println("子类构造器");
        this.name = name;
        name.length();
        this.age = age;
        this.gender = gender;
    }

    public Student() {
        System.out.println("子类构造器");

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    //@Override
    private void testPrivate(){
        System.out.println("testPrivate");
    }

   /* @Override
    public String toString(){
        return "Student={" + "name=" + name + ", age=" + age + ", gender=" + gender + "}";
    }*/

    public void showing(){
        System.out.println("showing from Student");
    }

    public void sayHello(){
        System.out.println("sayHello from Student");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        Student stu = (Student)o;
        return name.equals(stu.name) && age == stu.age && gender == stu.gender;
    }

    static{
        System.out.println("子类静态块");
    }
    {
        System.out.println("子类构造块");
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                gender == student.gender &&
                name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }*/
}
