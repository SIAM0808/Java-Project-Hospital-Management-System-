package hospital_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminRegister extends JFrame implements ActionListener {
    JButton submit, cancel;
    JTextField textField, emailField, add_filed;
    JPasswordField passwordFeild1, passwordField2;
    JComboBox<String> comboBox;

    adminRegister() {
        int posX = 250;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 550, 450);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);
        JLabel username = new JLabel("New Username: ");
        username.setBounds(55, 60, 150, 30);
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setForeground(Color.WHITE);
        panel.add(username);

        textField = new JTextField();
        textField.setBounds(posX, 60, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(textField);

        JLabel password1 = new JLabel("New Password: ");
        password1.setBounds(55, 110, 150, 30);
        password1.setFont(new Font("Arial", Font.BOLD, 16));
        password1.setForeground(Color.WHITE);
        panel.add(password1);

        passwordFeild1 = new JPasswordField();
        passwordFeild1.setBounds(posX, 110, 200, 30);
        passwordFeild1.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordFeild1);

        JLabel password2 = new JLabel("Confirm Password: ");
        password2.setBounds(55, 160, 150, 30);
        password2.setFont(new Font("Arial", Font.BOLD, 16));
        password2.setForeground(Color.WHITE);
        panel.add(password2);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(posX, 160, 200, 30);
        passwordField2.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField2);

        JLabel email = new JLabel("Email: ");
        email.setBounds(55, 210, 150, 30);
        email.setFont(new Font("Arial", Font.BOLD, 16));
        email.setForeground(Color.WHITE);
        panel.add(email);

        emailField = new JTextField();
        emailField.setBounds(posX, 210, 200, 30);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(emailField);

        JLabel permanent_add = new JLabel("Permanent Address: ");
        permanent_add.setBounds(55, 260, 170, 30);
        permanent_add.setFont(new Font("Arial", Font.BOLD, 16));
        permanent_add.setForeground(Color.WHITE);
        panel.add(permanent_add);

        add_filed = new JTextField();
        add_filed.setBounds(posX, 260, 200, 30);
        add_filed.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(add_filed);

        comboBox = new JComboBox<>(new String[] { "Admin", "Patient" });
        comboBox.setBounds(posX, 310, 200, 30);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox.setBackground(new Color(109, 164, 170));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        submit = new JButton("Submit");
        submit.setBounds(95, 370, 100, 30);
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(215, 370, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(_ -> {
            adminRegister.this.setVisible(false);
        });
        panel.add(cancel);
        setUndecorated(true);
        setSize(550, 450);
        // setSize(950, 950);
        setLocation(970, 330);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new adminRegister();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String person = (String) comboBox.getSelectedItem();
        if (e.getSource() == submit) {
            conection c = new conection();
            String user = textField.getText();
            char[] passwordChars = passwordFeild1.getPassword();
            String Pass = new String(passwordChars);
            String perm_add = add_filed.getText();
            System.out.println("Username: " + user);
            System.out.println("Password: " + Pass);

            // Check if passwords match
            if (!Pass.equals(new String(passwordField2.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
                return;
            }

            // Check if any field is empty
            if (user.isEmpty() || Pass.isEmpty() || emailField.getText().isEmpty() || add_filed.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields!");
                return;
            }

            // Check valid email format
            String email = emailField.getText();
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!email.matches(emailRegex)) {
                JOptionPane.showMessageDialog(null, "Invalid email format!");
                return;
            }
            String q = null;
            if(person.equals("Admin")) {
                q = "insert into login (ID, PW) values ('" + user + "', '" + Pass + "')";
            } else if(person.equals("Patient")) {
                q = "insert into patientLogin (username, password, permanent_add, gmail) values ('" + user + "', '" + Pass + "', '" + perm_add + "', '" + email + "')";
            }

            System.out.println("query: " + q);
            if(q != null) {
                try {
                    int rowsAffected = c.statement.executeUpdate(q);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Sign Up Successful! You can now Sign In.");
                        // this.setVisible(false);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sign Up Failed. Please try again.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }else{
                JOptionPane.showMessageDialog(null, "Please select a valid user type (Admin/Patient).");
            }
        }
    }
}
