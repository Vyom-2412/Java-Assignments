import java.sql.*;
import java.util.Scanner;

public class HospitalStaffLogin {
    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost:3306/jdbc_assignment22";
        String user = "root";
        String password = "password";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter login ID: ");
        String loginId = sc.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, password);
            String query = "select * from hospital_staff where login_id = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, loginId);
            ps.setString(2, loginPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("staff_name");
                String role = rs.getString("role");
                System.out.println("Login successful.");
                System.out.println("Welcome " + name + ".");
                System.out.println("Role: " + role);
                System.out.println("Hospital staff access granted.");
            } else {
                System.out.println("Invalid login ID or password.");
                System.out.println("Access denied.");
            }
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
