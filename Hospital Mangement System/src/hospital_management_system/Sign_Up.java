package hospital_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Sign_Up extends JFrame implements ActionListener {
    JButton submit, cancel;
    JTextField textField;
    JPasswordField passwordField;
    Sign_Up(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 450, 450);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);
        JLabel username = new JLabel("New Username: ");
        username.setBounds(55, 60, 150, 30);
        username.setFont(new Font("Arial", Font.BOLD, 16));
        username.setForeground(Color.WHITE);
        panel.add(username);

        textField = new JTextField();
        textField.setBounds(200, 60, 200, 30);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(textField);

        JLabel password = new JLabel("New Password: ");
        password.setBounds(55, 110, 150, 30);
        password.setFont(new Font("Arial", Font.BOLD, 16));
        password.setForeground(Color.WHITE);
        panel.add(password);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 110, 200, 30);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
        panel.add(passwordField);

        submit = new JButton("Submit");
        submit.setBounds(95, 230, 100, 30);
        submit.setFont(new Font("Arial", Font.BOLD, 16));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(215, 230, 100, 30);
        cancel.setFont(new Font("Arial", Font.BOLD, 16));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(_ -> {
            Sign_Up.this.setVisible(false);
        });
        panel.add(cancel);
        setUndecorated(true);
        setSize(450, 450);
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
       if(e.getSource() == submit){
            conection c = new conection();
            String user = textField.getText();
            char[] passwordChars = passwordField.getPassword();
            String Pass = new String(passwordChars);
            System.out.println("Username: " + user);
            System.out.println("Password: " + Pass);
            String q = "insert into login (ID, PW) values ('" + user + "', '" + Pass + "')";
            try {
                int rowsAffected = c.statement.executeUpdate(q);
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Sign Up Successful! You can now Sign In.");
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Sign Up Failed. Please try again.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
       }
    }
}

