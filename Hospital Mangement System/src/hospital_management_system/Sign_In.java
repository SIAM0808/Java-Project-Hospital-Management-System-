package hospital_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Sign_In extends JFrame implements ActionListener {
    JTextField textField;
    JButton sign_in, sign_up, cancel;
    JPasswordField passwordField;
    JComboBox<String> comboBox;

    Sign_In() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 450);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);

        JLabel username = new JLabel("Username");
        username.setBounds(55, 60, 100, 30);
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setForeground(Color.WHITE);
        panel.add(username);

        textField = new JTextField();
        textField.setBounds(155, 60, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(textField);

        JLabel password = new JLabel("Password");
        password.setBounds(55, 110, 100, 30);
        password.setFont(new Font("Arial", Font.BOLD, 16));
        password.setForeground(Color.WHITE);
        panel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(155, 110, 200, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField);

        sign_in = new JButton("Sign In");
        sign_in.setBounds(95, 230, 100, 30);
        sign_in.setFont(new Font("Arial", Font.BOLD, 16));
        sign_in.setBackground(Color.BLACK);
        sign_in.setForeground(Color.WHITE);
        // sign_in.addActionListener(_ -> {
        // System.exit(0);
        // });
        sign_in.addActionListener(this);
        panel.add(sign_in);

        sign_up = new JButton("Sign Up");
        sign_up.setBounds(215, 230, 100, 30);
        sign_up.setFont(new Font("Arial", Font.BOLD, 16));
        sign_up.setBackground(Color.BLACK);
        sign_up.setForeground(Color.WHITE);
        sign_up.addActionListener(_ -> {
            new Sign_Up();
            Sign_In.this.setVisible(false);
        });
        panel.add(sign_up);

        cancel = new JButton("Cancel");
        cancel.setBounds(175, 300, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        panel.add(cancel);

        cancel.addActionListener(_ -> {
            // Only close the Sign_In window, not the whole app
            Sign_In.this.setVisible(false);
        });

        comboBox = new JComboBox<>(new String[] { "Admin", "Patient" });
        comboBox.setBounds(155, 160, 200, 30);
        comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        comboBox.setBackground(new Color(109, 164, 170));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        setUndecorated(true);
        setSize(450, 450);
        // setSize(950, 950);
        setLocation(970, 330);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Sign_In();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String person = (String) comboBox.getSelectedItem();
        if (e.getSource() == sign_in) {
            try {
                conection c = new conection();
                String user = textField.getText();

                char[] passwordChars = passwordField.getPassword();
                String Pass = new String(passwordChars);

                System.out.println("Username: " + user);
                System.out.println("Password: " + Pass);
                String q;
                if (person == "Admin") {
                    q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
                } else {
                    q = "select * from userRegister where username = '" + user + "' and password = '" + Pass + "'";
                }

                System.out.println("query: " + q);
                ResultSet resultSet = c.statement.executeQuery(q);
                // if(resultSet.next()) {
                // System.out.println("Result: " + resultSet.next());
                // }
                // resultSet.next() = 0;
                if (resultSet.next()) {
                    // Use the result only once
                    if (person.equals("Admin")) {
                        new adminReception();
                    } else if (person.equals("Patient")) {
                        // Query to find userId using username and password
                        String userIdQuery = "SELECT userId FROM userRegister WHERE username = '" + user
                                + "' AND password = '" + Pass + "'";
                        try {
                            ResultSet rs = c.statement.executeQuery(userIdQuery);
                            if (rs.next()) {
                                String userId = rs.getString("userId");
                                System.out.println("User ID: " + userId); // Debugging
                                new Reception(userId); // Open Reception window
                            } else {
                                JOptionPane.showMessageDialog(null, "User not found!");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception E) {
                System.out.println("Error in resultSet");
                E.printStackTrace();
            }

        } else {
            new Sign_Up();
            setVisible(false);
        }

    }

}
