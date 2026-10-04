import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class LibraryManagementGUI extends JFrame {
    JTextField bookIdField;
    JTextField titleField;
    JTextField authorField;
    JTextField priceField;
    JTextArea output;
    Connection con;
    public LibraryManagementGUI() {
        setTitle("Library Management System");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(new JLabel("Book ID:"));
        bookIdField = new JTextField(15);
        add(bookIdField);
        add(new JLabel("Title:"));
        titleField = new JTextField(15);
        add(titleField);
        add(new JLabel("Author:"));
        authorField = new JTextField(15);
        add(authorField);
        add(new JLabel("Price:"));
        priceField = new JTextField(15);
        add(priceField);
        JButton addButton = new JButton("Add Book");
        JButton viewButton = new JButton("View Books");
        add(addButton);
        add(viewButton);
        output = new JTextArea(15, 40);
        add(new JScrollPane(output));
        connectDatabase();
        addButton.addActionListener(e -> addBook());
        viewButton.addActionListener(e -> viewBooks());
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
            JOptionPane.showMessageDialog(
                    this,
                    "Database connection failed."
            );
        }
    }
    void addBook() {
        try {
            String query =
                    "insert into library_book values (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(bookIdField.getText()));
            ps.setString(2, titleField.getText());
            ps.setString(3, authorField.getText());
            ps.setDouble(4, Double.parseDouble(priceField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(
                    this,
                    "Book added successfully."
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Error: " + e.getMessage()
            );
        }
    }
    void viewBooks() {
        try {
            String query = "select * from library_book";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            output.setText("");
            while (rs.next()) {
                output.append(
                        "Book ID: " + rs.getInt("book_id") + "\n" +
                        "Title: " + rs.getString("title") + "\n" +
                        "Author: " + rs.getString("author") + "\n" +
                        "Price: " + rs.getDouble("price") + "\n" +
                        "-------------------------\n"
                );
            }
        } catch (Exception e) {
            output.setText("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        new LibraryManagementGUI();
    }
}
