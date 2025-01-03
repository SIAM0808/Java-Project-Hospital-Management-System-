package hospital_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField passwordField;
    JButton b1, b2;

    Login() {

        // **backgroud image:
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        // **width, height variable setting
        // ImageIcon backgroundImage = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        // Image i = backgroundImage.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        // ImageIcon ii = new ImageIcon(i);
        // JLabel l1 = new JLabel(ii);
        // l1.setBounds(0, 0, width, height);
        // add(l1);

        // Set layout to null for absolute positioning
        // setLayout(null);

        // **Username
        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(width - 500 - 100, height / 2 - 15, 100, 30); // Adjusted position
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        // **password
        JLabel password = new JLabel("Password");
        password.setBounds(width - 500 - 100, height / 2 + 35, 100, 30); // Adjusted position
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        // **textfield for username
        textField = new JTextField();
        textField.setBounds(width - 370 - 100, height / 2 - 15, 200, 30); // Adjusted position
        textField.setFont(new Font("Poppins", Font.PLAIN, 16));
        add(textField);

        // **passwordfield for password
        passwordField = new JPasswordField();
        passwordField.setBounds(width - 370 - 100, height / 2 + 35, 200, 30); // Adjusted position
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 16));
       add(passwordField);

        // **login button
        b1 = new JButton("Login");
        b1.setBounds(width - 370 - 100, height / 2 + 90, 100, 30); // Adjusted position
        b1.setFont(new Font("serif", Font.BOLD, 16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);

        add(b1);

        // **cancel button
        b2 = new JButton("Cancel");
        b2.setBounds(width - 260 - 100, height / 2 + 90, 100, 30); // Adjusted position
        b2.setFont(new Font("serif", Font.BOLD, 16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        // **set layout and size:
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocation(400, 270);
        setLayout(null);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                conection c = new conection();
                String user = textField.getText();
                
                char[] passwordChars = passwordField.getPassword();
                String Pass = new String(passwordChars);
    
                System.out.println("Username: " + user);
                System.out.println("Password: " + Pass);
    
                String q = "select * from login where ID = '" + user + "' and PW = '" + Pass + "'";
                System.out.println("query: " + q);
                ResultSet resultSet = c.statement.executeQuery(q);
    
                if (resultSet.next()) { // Use the result only once
                    new test();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            System.exit(0);
        }
    }
    
}
