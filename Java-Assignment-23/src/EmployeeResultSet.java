import java.sql.*;

public class EmployeeResultSet {
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
            String query = "select * from employee";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Employee Records:\n");
            while (rs.next()) {
                System.out.println("Employee ID: " +
                        rs.getInt("employee_id"));
                System.out.println("Name: " +
                        rs.getString("name"));
                System.out.println("Department: " +
                        rs.getString("department"));
                System.out.println("Salary: " +
                        rs.getDouble("salary"));
                System.out.println("----------------------");
            }
            System.out.println("\nNavigating to first record:");
            if (rs.first()) {
                System.out.println(
                        rs.getInt("employee_id") + " - " +
                        rs.getString("name")
                );
            }
            System.out.println("\nNavigating to last record:");
            if (rs.last()) {
                System.out.println(
                        rs.getInt("employee_id") + " - " +
                        rs.getString("name")
                );
            }
            System.out.println("\nNavigating to second record:");
            if (rs.absolute(2)) {
                System.out.println(
                        rs.getInt("employee_id") + " - " +
                        rs.getString("name")
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
