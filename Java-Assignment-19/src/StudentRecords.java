import java.sql.*;

public class StudentRecords {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";
        try {
            Connection con = DriverManager.getConnection(db, user, password);
            System.out.println("Connection established");
            Statement stmt = con.createStatement();
            String query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\nStudent Records");
            System.out.println("--------------------------------");
            while (rs.next()) {
                System.out.println("Student ID: " +
                        rs.getInt("student_id"));
                System.out.println("Student Name: " +
                        rs.getString("student_name"));
                System.out.println("Course: " +
                        rs.getString("course"));
                System.out.println("Marks: " +
                        rs.getInt("marks"));
                System.out.println("--------------------------------");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
