import faculty.Faculty;
import student.Student;
public class CollegeManagement{
	public static void main(String[] args){
		Student student=new Student("Vyom Mittal",220,"B.Tech CSE");
		Faculty faculty=new Faculty("Dr. Sharma",101,"Computer Science");
		System.out.println("Student Details");
		student.display();
		System.out.println();
		System.out.println("Faculty Details");
		faculty.display();
	}
}