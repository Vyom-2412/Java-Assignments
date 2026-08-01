class Employee {
    int empId;
    String name;
    double salary;
    Employee(int empId, String name, double salary) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
    }
    void displayEmployee() {
        System.out.println("Employee ID : " + empId);
        System.out.println("Name        : " + name);
        System.out.println("Salary      : Rs." + salary);
    }
}
class Manager extends Employee {
    String department;
    Manager(int empId, String name, double salary, String department) {
        super(empId, name, salary);
        this.department = department;
    }
    void displayManager() {
        displayEmployee();
        System.out.println("Department  : " + department);
    }
}
class Developer extends Employee {
    String programmingLanguage;
    Developer(int empId, String name, double salary, String programmingLanguage) {
        super(empId, name, salary);
        this.programmingLanguage = programmingLanguage;
    }
    void displayDeveloper() {
        displayEmployee();
        System.out.println("Programming Language : " + programmingLanguage);
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Manager m = new Manager(101, "Rahul Sharma", 80000, "Sales");
        Developer d = new Developer(102, "Ananya Patel", 70000, "Java");
        System.out.println("Manager Details");
        m.displayManager();
        System.out.println();
        System.out.println("Developer Details");
        d.displayDeveloper();
    }
}






