import java.util.ArrayList;
import java.util.Scanner;

public class StudentCourse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();
        int choice;
        do {
            System.out.println("\n===== Student Course Registration =====");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter course name: ");
                    String course = sc.nextLine();
                    courses.add(course);
                    System.out.println("Course added successfully.");
                    break;
                case 2:
                    if (courses.isEmpty()) {
                        System.out.println("No courses available.");
                    } else {
                        System.out.print("Enter course name to remove: ");
                        String removeCourse = sc.nextLine();
                        if (courses.remove(removeCourse)) {
                            System.out.println("Course removed successfully.");
                        } else {
                            System.out.println("Course not found.");
                        }
                    }
                    break;
                case 3:
                    if (courses.isEmpty()) {
                        System.out.println("No courses registered.");
                    } else {
                        StringBuffer sb = new StringBuffer();
                        sb.append("\nRegistered Courses:\n");
                        for (int i = 0; i < courses.size(); i++) {
                            sb.append((i + 1))
                              .append(". ")
                              .append(courses.get(i))
                              .append("\n");
                        }
                        System.out.println(sb);
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
        sc.close();
    }
}




