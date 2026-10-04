import java.sql.*;
import java.util.Scanner;

public class LoginApplication {
    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost:3306/jdbc_assignment22";
        String user = "root";
        String password = "password";

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String loginPassword = sc.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, password);
            String query = "select * from login where username = ? and password = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, loginPassword);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful.");
                System.out.println("Welcome, " + username + "!");
            } else {
                System.out.println("Invalid username or password.");
            }
            con.close();
            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
