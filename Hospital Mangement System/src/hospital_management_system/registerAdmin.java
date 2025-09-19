package hospital_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

// import javax.swing.Timer;
// import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class registerAdmin extends JFrame implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel labelName, labelId1, labelId2, labelPassword1, labelPassword2, labelEmail, labelPhone;
    JTextField textFieldId, textFieldUsername, textFieldEmail, textFieldPhone;
    JPasswordField passwordField1, passwordField2;
    JButton registerButton, cancelButton;

    registerAdmin() {
        setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 490, 450);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);

        // First label - remains at original position
        labelName = new JLabel("Register Admin");
        labelName.setBounds(170, 10, 200, 30);
        labelName.setFont(new Font("Arial", Font.BOLD, 24));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        // Admin ID label and field - moved 30 units down
        labelId1 = new JLabel("Admin ID: ");
        labelId1.setBounds(20, 90, 100, 30);
        labelId1.setFont(new Font("Arial", Font.PLAIN, 18));
        labelId1.setForeground(Color.WHITE);
        panel.add(labelId1);

        textFieldId = new JTextField();
        textFieldId.setBounds(200, 90, 200, 30);
        textFieldId.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(textFieldId);

        // Username label and field - moved 30 units down
        labelId2 = new JLabel("Username: ");
        labelId2.setBounds(20, 140, 100, 30);
        labelId2.setFont(new Font("Arial", Font.PLAIN, 18));
        labelId2.setForeground(Color.WHITE);
        panel.add(labelId2);
        
        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(200, 140, 200, 30);
        textFieldUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(textFieldUsername);

        // Password label and field - moved 30 units down
        labelPassword1 = new JLabel("Password: ");
        labelPassword1.setBounds(20, 190, 100, 30);
        labelPassword1.setFont(new Font("Arial", Font.PLAIN, 18));
        labelPassword1.setForeground(Color.WHITE);
        panel.add(labelPassword1);

        passwordField1 = new JPasswordField();
        passwordField1.setBounds(200, 190, 200, 30);
        passwordField1.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField1);
        
        // Confirm password label and field - moved 30 units down
        labelPassword2 = new JLabel("Confirm Password: ");
        labelPassword2.setBounds(20, 240, 170, 30);
        labelPassword2.setFont(new Font("Arial", Font.PLAIN, 18));
        labelPassword2.setForeground(Color.WHITE);
        panel.add(labelPassword2);

        passwordField2 = new JPasswordField();
        passwordField2.setBounds(200, 240, 200, 30);
        passwordField2.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField2);

        // Register button
        registerButton = new JButton("Register");
        registerButton.setBounds(240, 300, 100, 30);
        registerButton.setFont(new Font("Arial", Font.BOLD, 16));
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(this);
        panel.add(registerButton);

        // Cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(120, 300, 100, 30);
        cancelButton.setFont(new Font("Arial", Font.BOLD, 16));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);
        cancelButton.addActionListener(_ -> {
            this.setVisible(false);
        });


        setUndecorated(true);
        setSize(490, 450);
        setLocation(450, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
    }
       
    public static void main(String[] args) {
        new registerAdmin();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String adminId = textFieldId.getText();
            String username = textFieldUsername.getText();
            String password = new String(passwordField1.getPassword());
            String confirmPassword = new String(passwordField2.getPassword());

            // Validation
            if (adminId.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all fields!");
                return;
            }

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(null, "Passwords do not match!");
                return;
            }

            try {
                conection c = new conection();
                
                // Check if admin ID already exists
                String checkQuery = "SELECT * FROM login WHERE ID = '" + adminId + "'";
                ResultSet rs = c.statement.executeQuery(checkQuery);
                
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Admin ID already exists!");
                    return;
                }

                // Insert new admin
                String insertQuery = "INSERT INTO login (ID, PW, username) VALUES ('" + adminId + "', '" + password + "', '" + username + "')";
                int rowsAffected = c.statement.executeUpdate(insertQuery);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Admin registered successfully!");
                    // this.setVisible(false);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error occurred during registration!");
            }
        }
    }
}