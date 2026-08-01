class Student {
    String name;
    int age;
    Student() {
        name = "Unknown";
        age = 0;
    }
    Student(String n, int a) {
        name = n;
        age = a;
    }
    Student(Student s) {
        name = s.name;
        age = s.age;
    }
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println();
    }
}

public class StudentConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        System.out.println("Object Created Using Default Constructor");
        s1.display();
        Student s2 = new Student("Vyom Mittal", 19);
        System.out.println("Object Created Using Parameterized Constructor");
        s2.display();
        Student s3 = new Student(s2);
        System.out.println("Object Created Using Copy Constructor");
        s3.display();
    }
}








