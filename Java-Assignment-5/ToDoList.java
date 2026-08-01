import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        System.out.println("Enter 5 tasks: ");
        for(int i = 0;i<5;i++){
            System.out.print("Task "+(i+1)+": ");
            String task = sc.nextLine();
            tasks.add(task);
        }
        sb.append("\nTO DO LIST\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
        }
        System.out.print(sb);
        sc.close();
    }
}


