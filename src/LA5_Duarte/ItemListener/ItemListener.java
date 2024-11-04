package LA5_Duarte.ItemListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemListener extends JFrame {
    private JCheckBox cCheckBox;
    private JCheckBox cppCheckBox;
    private JCheckBox cSharpCheckBox;
    private JCheckBox pythonCheckBox;
    private JCheckBox javaCheckBox;
    private JComboBox<String> proficiencyComboBox;
    private JLabel Header;
    private JLabel languageLabel;
    private JLabel ProfChoose;
    private JLabel proficiencyLabel;
    private JPanel ContentPane;

    public ItemListener() {
        setContentPane(ContentPane);
        proficiencyComboBox.setSelectedIndex(-1);

        ArrayList<String> selectedLanguages = new ArrayList<>();

        ActionListener checkboxListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    selectedLanguages.add(checkBox.getText());
                } else {
                    selectedLanguages.remove(checkBox.getText());
                }
                updateLanguageLabel(selectedLanguages);
            }
        };

        cCheckBox.addActionListener(checkboxListener);
        cppCheckBox.addActionListener(checkboxListener);
        cSharpCheckBox.addActionListener(checkboxListener);
        pythonCheckBox.addActionListener(checkboxListener);
        javaCheckBox.addActionListener(checkboxListener);


        proficiencyComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String proficiency = (String) proficiencyComboBox.getSelectedItem();
                if (proficiency != null) {
                    proficiencyLabel.setText("Proficiency: " + proficiency);
                }
            }
        });
    }

    private void updateLanguageLabel(ArrayList<String> selectedLanguages) {
        if (selectedLanguages.isEmpty()) {
            languageLabel.setText("My favorite languages: ");
        } else {
            languageLabel.setText("My favorite languages: " + String.join(", ", selectedLanguages));
        }
    }

    public static void main(String[] args) {
        ItemListener itemListener = new ItemListener();
        itemListener.setTitle("Item Listener");
        itemListener.setSize(400, 300);
        itemListener.setVisible(true);
        itemListener.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
