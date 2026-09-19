import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmployeeRegistration extends JFrame implements ActionListener {
    JTextField idField, nameField, deptField, salaryField;
    JButton submitButton;
    EmployeeRegistration() {
        setTitle("Employee Registration Form");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel idLabel = new JLabel("Employee ID:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel deptLabel = new JLabel("Department:");
        JLabel salaryLabel = new JLabel("Salary:");

        idField = new JTextField();
        nameField = new JTextField();
        deptField = new JTextField();
        salaryField = new JTextField();

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        panel.add(idLabel);
        panel.add(idField);

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(deptLabel);
        panel.add(deptField);

        panel.add(salaryLabel);
        panel.add(salaryField);

        panel.add(new JLabel(""));
        panel.add(submitButton);

        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String id = idField.getText();
        String name = nameField.getText();
        String department = deptField.getText();
        String salary = salaryField.getText();
        JOptionPane.showMessageDialog(this,
                "Employee Details\n" +
                "Employee ID: " + id +
                "\nName: " + name +
                "\nDepartment: " + department +
                "\nSalary: " + salary);
    }
    public static void main(String[] args) {
        new EmployeeRegistration();
    }
}



