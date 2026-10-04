import java.sql.*;

public class DisplayRecords {
    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost:3306/jdbc_assignment23";
        String user = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, password);
            Statement stmt = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );
            String query = "select * from student";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Student Records:");
            while (rs.next()) {
                System.out.println(
                        "Roll No: " + rs.getInt("roll_no") +
                        ", Name: " + rs.getString("name") +
                        ", Course: " + rs.getString("course") +
                        ", Marks: " + rs.getInt("marks")
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

