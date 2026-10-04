import java.sql.*;
public class StudentDatabaseConnection {
    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost:3306/jdbc_assignment21";
        String user = "root";
        String password = "vyom@2412";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, password);
            System.out.println("Connection established.");
            System.out.println("Student database connected successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Student database connection failed.");
            e.printStackTrace();
        }
    }
}
