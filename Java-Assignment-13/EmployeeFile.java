import java.io.*;
import java.util.Scanner;
public class EmployeeFile{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		try{
			FileWriter writer=new FileWriter("employees.txt");
			System.out.print("Enter Employee ID: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Employee Name: ");
			String name=sc.nextLine();
			System.out.print("Enter Department: ");
			String department=sc.nextLine();
			System.out.print("Enter Salary: ");
			double salary=sc.nextDouble();
			writer.write("Employee ID: "+id+"\n");
			writer.write("Employee Name: "+name+"\n");
			writer.write("Department: "+department+"\n");
			writer.write("Salary: "+salary+"\n");
			writer.close();
			BufferedReader reader=new BufferedReader(new FileReader("employees.txt"));
			String line;
			System.out.println("\nEmployee Details");
			while((line=reader.readLine())!=null){
				System.out.println(line);
			}
			reader.close();
		}catch(IOException e){
			System.out.println("File error: "+e.getMessage());
		}
		sc.close();
	}
}


