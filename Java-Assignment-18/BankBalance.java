import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BankBalance extends JFrame implements ActionListener {
    JTextField balanceField, amountField, resultField;
    JButton deposit, withdraw;
    BankBalance() {
        setTitle("Bank Balance Calculator");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(4, 2, 15, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        JLabel l1 = new JLabel("Initial Balance:");
        JLabel l2 = new JLabel("Transaction Amount:");
        JLabel l3 = new JLabel("Updated Balance:");
        balanceField = new JTextField();
        amountField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);
        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        panel.add(l1);
        panel.add(balanceField);
        panel.add(l2);
        panel.add(amountField);
        panel.add(l3);
        panel.add(resultField);
        panel.add(deposit);
        panel.add(withdraw);
        add(panel);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        double balance = Double.parseDouble(balanceField.getText());
        double amount = Double.parseDouble(amountField.getText());
        if (e.getSource() == deposit) {
            double newBalance = balance + amount;
            resultField.setText(String.valueOf(newBalance));
        }
        if (e.getSource() == withdraw) {
            double newBalance = balance - amount;
            resultField.setText(String.valueOf(newBalance));
        }
    }

    public static void main(String[] args) {
        new BankBalance();
    }
}

