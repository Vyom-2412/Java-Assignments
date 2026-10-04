import java.sql.*;
public class ConnectionStatus {
    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost:3306/jdbc_assignment21";
        String user = "root";
        String password = "password";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(db, user, password);
            System.out.println("Database connection established successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}

