import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {
    static String db = "jdbc:mysql://localhost:3306/jdbc_assignment20";
    static String user = "root";
    static String password = "password";
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, password);
            Scanner sc = new Scanner(System.in);
            int choice;
            do {
                System.out.println("\n===== Student Management =====");
                System.out.println("1. Create Student");
                System.out.println("2. Read Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        createStudent(con, sc);
                        break;
                    case 2:
                        readStudents(con);
                        break;
                    case 3:
                        updateStudent(con, sc);
                        break;
                    case 4:
                        deleteStudent(con, sc);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 5);
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void createStudent(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter roll number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter course: ");
        String course = sc.nextLine();
        System.out.print("Enter marks: ");
        int marks = sc.nextInt();
        String query = "insert into student values (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, rollNo);
        ps.setString(2, name);
        ps.setString(3, course);
        ps.setInt(4, marks);
        ps.executeUpdate();
        System.out.println("Student added successfully.");
    }
    static void readStudents(Connection con) throws SQLException {
        String query = "select * from student";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("\n===== Student Records =====");
        while (rs.next()) {
            System.out.println("Roll Number: " +
                    rs.getInt("roll_no"));
            System.out.println("Name: " +
                    rs.getString("name"));
            System.out.println("Course: " +
                    rs.getString("course"));
            System.out.println("Marks: " +
                    rs.getInt("marks"));
            System.out.println("----------------------------");
        }
    }
    static void updateStudent(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter roll number to update: ");
        int rollNo = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new student name: ");
        String name = sc.nextLine();
        System.out.print("Enter new course: ");
        String course = sc.nextLine();
        System.out.print("Enter new marks: ");
        int marks = sc.nextInt();
        String query = "update student set name = ?, course = ?, marks = ? where roll_no = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, course);
        ps.setInt(3, marks);
        ps.setInt(4, rollNo);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    static void deleteStudent(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter roll number to delete: ");
        int rollNo = sc.nextInt();
        String query = "delete from student where roll_no = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, rollNo);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
}

