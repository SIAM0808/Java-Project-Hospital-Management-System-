package hospital_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Sign_Up extends JFrame implements ActionListener {
    JButton submit, cancel;
    JTextField textField, emailField, add_filed, userIdField;
    JPasswordField passwordFeild1, passwordField2;

    Sign_Up() {
        int posX = 250;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 490, 450);
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

        JLabel indentity = new JLabel("User Register");
        indentity.setBounds(posX - 80, 20, 200, 30);
        indentity.setFont(new Font("Arial", Font.BOLD, 20));
        indentity.setForeground(Color.WHITE);
        panel.add(indentity);

        JLabel userID = new JLabel("User ID: ");
        userID.setBounds(55, 310, 150, 30);
        userID.setFont(new Font("Arial", Font.BOLD, 16));
        userID.setForeground(Color.WHITE);
        panel.add(userID);

        userIdField = new JTextField();
        userIdField.setBounds(posX, 310, 200, 30);
        userIdField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(userIdField);

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
            Sign_Up.this.setVisible(false);
        });
        panel.add(cancel);
        setUndecorated(true);
        setSize(490, 450);
        // setSize(950, 950);
        setLocation(970, 330);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Sign_Up();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            conection c = new conection();
            String user = textField.getText();
            char[] passwordChars = passwordFeild1.getPassword();
            String Pass = new String(passwordChars);
            String perm_add = add_filed.getText();
            System.out.println("Username: " + user);
            System.out.println("Password: " + Pass);

            String userId = userIdField.getText();
            // Check if passwords match
            if (!Pass.equals(new String(passwordField2.getPassword()))) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
                return;
            }

            // Check if any field is empty
            if (userId.isEmpty() || user.isEmpty() || Pass.isEmpty() || emailField.getText().isEmpty() || add_filed.getText().isEmpty()) {
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
            String q1, q2;
            // unique userId check
            q1 = "select * from userRegister where userId = '" + userId + "'";
            q2 = "insert into userRegister (username, password, userId, permanent_add, gmail) values ('" + user + "', '" + Pass + "', '" + userId + "', '" + perm_add + "', '" + email + "')";
            // System.out.println("query: " + q1);
            System.out.println("query: " + q2);

                try {
                    ResultSet rs = c.statement.executeQuery(q1);
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "User ID already exists! Please choose a different User ID.");
                        return;
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
                try {
                    int rowsAffected = c.statement.executeUpdate(q2);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Registered Successful! You can now Login In.");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Registeration Failed. Please try again.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
        }
    }
}
