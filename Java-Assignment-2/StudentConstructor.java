class Student {
    String name;
    int rollNo;
    Student() {
        name = "Unknown";
        rollNo = 0;
    }
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    void display() {
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println();
    }
}

public class StudentConstructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Vyom Mittal", 220);
        System.out.println("Default Constructor");
        s1.display();
        System.out.println("Parameterized Constructor");
        s2.display();
    }
}


