interface Printable{
	void printdetail();
}
class Student implements Printable{
	String name;
	int rollNo;
	Student(String name,int rollNo){
		this.name=name;
		this.rollNo=rollNo;
	}
	public void printdetail(){
		System.out.println("Student Name: "+name);
		System.out.println("Roll Number: "+rollNo);
	}
}
class Employee implements Printable{
	String name;
	int id;
	Employee(String name,int id){
		this.name=name;
		this.id=id;
	}
	public void printdetail(){
		System.out.println("Employee Name: "+name);
		System.out.println("Employee ID: "+id);
	}
}
public class PrintableDemo{
	public static void main(String[] args){
		Printable student=new Student("Vyom Mittal",220);
		Printable employee=new Employee("Rahul Sharma",101);
		student.printdetail();
		employee.printdetail();
	}
}


