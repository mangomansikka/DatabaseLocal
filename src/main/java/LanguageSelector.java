import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

public class LanguageSelector extends JFrame {
    private final JComboBox<String> languageComboBox;
    private final JLabel nameLabel;
    private final JLabel lastnameLabel;
    private final JLabel emailLabel;
    private final JTextField nameField;
    private final JTextField lastnameField;
    private final JTextField emailField;
    private final JButton saveButton;

    private ResourceBundle bundle;
    private AddEmployees addEmployees;
    private String languageCode = "en";

    public LanguageSelector() {
        setTitle("Employee Data Entry");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        languageComboBox = new JComboBox<>(new String[]{"English", "Farsi", "Japanese"});
        languageComboBox.addActionListener(new LanguageChangeListener());
        nameLabel = new JLabel();
        lastnameLabel = new JLabel();
        emailLabel = new JLabel();
        nameField = new JTextField();
        lastnameField = new JTextField();
        emailField = new JTextField();
        saveButton = new JButton();

        saveButton.addActionListener(e -> {
                addEmployees = new AddEmployees(languageCode, nameField.getText(), lastnameField.getText(), emailField.getText());
                addEmployees.AddEmployee();
                System.out.println("Employee data saved successfully.");
        });

        add(new JLabel("Select Language:"));
        add(languageComboBox);
        add(nameLabel);
        add(nameField);
        add(lastnameLabel);
        add(lastnameField);
        add(emailLabel);
        add(emailField);
        add(new JLabel());
        add(saveButton);

        updateLabels(Locale.ENGLISH);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    private void updateLabels(Locale locale) {
        bundle = ResourceBundle.getBundle("MessageBundle", locale);
        nameLabel.setText(bundle.getString("name"));
        lastnameLabel.setText(bundle.getString("lastname"));
        emailLabel.setText(bundle.getString("email"));
        saveButton.setText(bundle.getString("save"));
    }

    private class LanguageChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedLanguage = (String) languageComboBox.getSelectedItem();
            switch (Objects.requireNonNull(selectedLanguage)) {
                case "Farsi":
                    updateLabels(new Locale("fa"));
                    languageCode = "fa";
                    break;
                case "Japanese":
                    updateLabels(new Locale("ja"));
                    languageCode = "ja";
                    break;
                default:
                    updateLabels(Locale.ENGLISH);
                    languageCode = "en";
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new LanguageSelector();
    }
}