import java.io.*;
import java.util.Scanner;
public class PatientFile{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		try{
			FileWriter writer=new FileWriter("patients.txt");
			System.out.print("Enter Patient ID: ");
			int id=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Patient Name: ");
			String name=sc.nextLine();
			System.out.print("Enter Age: ");
			int age=sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Diagnosis: ");
			String diagnosis=sc.nextLine();
			writer.write("Patient ID: "+id+"\n");
			writer.write("Patient Name: "+name+"\n");
			writer.write("Age: "+age+"\n");
			writer.write("Diagnosis: "+diagnosis+"\n");
			writer.close();
			BufferedReader reader=new BufferedReader(new FileReader("patients.txt"));
			String line;
			System.out.println("\nPatient Details");
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


