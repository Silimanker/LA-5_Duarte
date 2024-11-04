package LA5_Duarte.SimpleCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JTextField tfNumber1;
    private JPanel ContentPane;
    private JTextField tfNumber2;
    private JButton btnCompute;
    private JComboBox<String> cbOperations;
    private JLabel lblResult;
    private JPanel pane1;


    public SimpleCalculator() {
        setContentPane(ContentPane);


        cbOperations.setSelectedIndex(-1);


        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    double number2 = Double.parseDouble(tfNumber1.getText());
                    double number1 = Double.parseDouble(tfNumber2.getText());


                    if (cbOperations.getSelectedItem() == null) {
                        JOptionPane.showMessageDialog(null,"Please select an operation.");
                        return;
                    }

                    String operation = (String) cbOperations.getSelectedItem();
                    double result = 0;


                    switch (operation) {
                        case "+":
                            result = number1 + number2;
                            break;
                        case "-":
                            result = number1 - number2;
                            break;
                        case "*":
                            result = number1 * number2;
                            break;
                        case "/":
                            if (number2 == 0.0) {
                                JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                                return;
                            }
                            result = number1 / number2;
                            break;
                    }


                    lblResult.setText("Result: " + result);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,"Invalid input. Please enter numbers.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SimpleCalculator s = new SimpleCalculator();
        s.setTitle("Simple Calculator");
        s.setSize(300, 300);
        s.setDefaultCloseOperation(EXIT_ON_CLOSE);
        s.setVisible(true);
    }
}
