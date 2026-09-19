import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StudentRegistration extends JFrame implements ActionListener {
    JTextField nameField, rollField, ageField, courseField;
    JButton submitButton;
    StudentRegistration() {
        setTitle("Student Registration Form");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        JLabel nameLabel = new JLabel("Name:");
        JLabel rollLabel = new JLabel("Roll No:");
        JLabel ageLabel = new JLabel("Age:");
        JLabel courseLabel = new JLabel("Course:");

        nameField = new JTextField();
        rollField = new JTextField();
        ageField = new JTextField();
        courseField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(rollLabel);
        panel.add(rollField);

        panel.add(ageLabel);
        panel.add(ageField);

        panel.add(courseLabel);
        panel.add(courseField);

        panel.add(new JLabel(""));
        panel.add(submitButton);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String roll = rollField.getText();
        String age = ageField.getText();
        String course = courseField.getText();

        JOptionPane.showMessageDialog(this,
                "Student Details\n" +
                "Name: " + name +
                "\nRoll No: " + roll +
                "\nAge: " + age +
                "\nCourse: " + course);
    }
    public static void main(String[] args) {
        new StudentRegistration();
    }
}




