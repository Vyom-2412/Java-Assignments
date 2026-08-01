class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void displayPerson() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}
class Student extends Person {
    int rollNo;
    String course;
    Student(String name, int age, int rollNo, String course) {
        super(name, age);
        this.rollNo = rollNo;
        this.course = course;
    }
    void displayStudent() {
        displayPerson();
        System.out.println("Roll No : " + rollNo);
        System.out.println("Course  : " + course);
    }
}
public class StudentInheritance{
    public static void main(String[] args) {
        Student s = new Student("Vyom Mittal", 19, 220, "B.Tech CSE");
        System.out.println("Student Details");
        s.displayStudent();
    }
}






