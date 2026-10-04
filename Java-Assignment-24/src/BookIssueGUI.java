import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class BookIssueGUI extends JFrame {
    JTextField bookIdField;
    JTextField studentField;
    JTextField issueDateField;
    JTextField returnDateField;
    JTextArea output;
    Connection con;
    public BookIssueGUI() {
        setTitle("Book Issue Tracking System");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Book ID:"));
        bookIdField = new JTextField(15);
        add(bookIdField);
        add(new JLabel("Student Name:"));
        studentField = new JTextField(15);
        add(studentField);
        add(new JLabel("Issue Date:"));
        issueDateField = new JTextField(15);
        add(issueDateField);
        add(new JLabel("Return Date:"));
        returnDateField = new JTextField(15);
        add(returnDateField);
        JButton addButton = new JButton("Issue Book");
        JButton viewButton = new JButton("View Records");
        JButton deleteButton = new JButton("Delete Record");
        add(addButton);
        add(viewButton);
        add(deleteButton);
        output = new JTextArea(15, 40);
        add(new JScrollPane(output));
        connectDatabase();
        addButton.addActionListener(e -> issueBook());
        viewButton.addActionListener(e -> viewRecords());
        deleteButton.addActionListener(e -> deleteRecord());
        setVisible(true);
    }
    void connectDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/jdbc_assignment24",
                    "root",
                    "password"
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Database connection failed.");
        }
    }
    void issueBook() {
        try {
            String query = "insert into book_issue values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(bookIdField.getText()));
            ps.setString(2,studentField.getText());
            ps.setString(3,issueDateField.getText());
            ps.setString(4,returnDateField.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this,"Book issue record added successfully.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error: " + e.getMessage());
        }
    }
    void viewRecords() {
        try {
            String query = "select * from book_issue";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            output.setText("");
            while (rs.next()) {
                output.append(
                        "Book ID: " + rs.getInt("book_id") + "\n" +
                        "Student Name: " + rs.getString("student_name") + "\n" +
                        "Issue Date: " + rs.getString("issue_date") + "\n" +
                        "Return Date: " + rs.getString("return_date") + "\n" +
                        "-------------------------\n");
            }
        } catch (Exception e) {
            output.setText("Error: " + e.getMessage());
        }
    }
    void deleteRecord() {
        try {
            String query = "delete from book_issue where book_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,Integer.parseInt(bookIdField.getText()));
            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this,"Record deleted successfully.");
            } else {
                JOptionPane.showMessageDialog(this,"Book record not found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new BookIssueGUI();
    }
}

