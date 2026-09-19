import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField num1, num2, result;
    JButton add, subtract;

    Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        JLabel l1 = new JLabel("First Number:");
        JLabel l2 = new JLabel("Second Number:");
        JLabel l3 = new JLabel("Result:");
        num1 = new JTextField();
        num2 = new JTextField();
        result = new JTextField();
        result.setEditable(false);
        add = new JButton("Add");
        subtract = new JButton("Subtract");
        add.addActionListener(this);
        subtract.addActionListener(this);
        panel.add(l1);
        panel.add(num1);
        panel.add(l2);
        panel.add(num2);
        panel.add(l3);
        panel.add(result);
        panel.add(add);
        panel.add(subtract);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        double n1 = Double.parseDouble(num1.getText());
        double n2 = Double.parseDouble(num2.getText());

        if (e.getSource() == add) {
            result.setText(String.valueOf(n1 + n2));
        }
        if (e.getSource() == subtract) {
            result.setText(String.valueOf(n1 - n2));
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}

