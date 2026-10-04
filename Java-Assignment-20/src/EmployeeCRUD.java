import java.sql.*;
import java.util.Scanner;

public class EmployeeCRUD {
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
                System.out.println("\n===== Employee Management =====");
                System.out.println("1. Create Employee");
                System.out.println("2. Read Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        createEmployee(con, sc);
                        break;
                    case 2:
                        readEmployees(con);
                        break;
                    case 3:
                        updateEmployee(con, sc);
                        break;
                    case 4:
                        deleteEmployee(con, sc);
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
    static void createEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter department: ");
        String department = sc.nextLine();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();
        String query = "insert into employee values (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, department);
        ps.setDouble(4, salary);
        ps.executeUpdate();
        System.out.println("Employee added successfully.");
    }
    static void readEmployees(Connection con) throws SQLException {
        String query = "select * from employee";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("\n===== Employee Records =====");
        while (rs.next()) {
            System.out.println("Employee ID: " +
                    rs.getInt("employee_id"));
            System.out.println("Name: " +
                    rs.getString("employee_name"));
            System.out.println("Department: " +
                    rs.getString("department"));
            System.out.println("Salary: " +
                    rs.getDouble("salary"));
            System.out.println("----------------------------");
        }
    }
    static void updateEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new employee name: ");
        String name = sc.nextLine();
        System.out.print("Enter new department: ");
        String department = sc.nextLine();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();
        String query = "update employee set employee_name = ?, department = ?, salary = ? where employee_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, department);
        ps.setDouble(3, salary);
        ps.setInt(4, id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
    static void deleteEmployee(Connection con, Scanner sc) throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();
        String query = "delete from employee where employee_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }
}
