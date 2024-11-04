package LA5_Duarte.LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JPanel ContentPane;
    private JButton checkYearButton;
    private JTextField yearTextField;
    private JPanel panel1;
    private JPanel panel2;

    public LeapYearChecker() {

        setContentPane(ContentPane);


        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = yearTextField.getText();
                try {
                    int year = Integer.parseInt(input);
                    boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

                    String message = (isLeapYear ? "Leap year" : "Not a leap year");
                    JOptionPane.showMessageDialog(null, message);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid year.");
                }
            }
        });
    }

    public static void main(String[] args) {
        LeapYearChecker frame = new LeapYearChecker();
        frame.setTitle("Leap Year Checker");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
