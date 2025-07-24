package hospital_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class adminReception extends JFrame {
    private int textX = 0; // Initial x position of the text
    private final int textWidth = 500; // Width of the text area

    adminReception(String userId) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 160, width, height - 160);
        panel1.setBackground(new Color(109, 164, 170));
        add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(5, 5, width, 198);
        panel2.setBackground(new Color(100, 114, 110));
        add(panel2);

        // Custom JPanel to display moving text
        JPanel textPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.setColor(Color.WHITE);
                g.drawString("Welcome to DR. M R Khan Medical Center", textX, 30);
            }
        };
        textX = 600; // Start from the right side
        textPanel.setBounds(10, 105, 600, 30);
        textPanel.setBackground(new Color(109, 114, 110));
        panel2.add(textPanel);

        // Timer to update the text position
        Timer timer = new Timer(30, _ -> {
            textX -= 2; // Move text to the left
            if (textX + textWidth < 0) {
                textX = width; // Reset to the right side
            }
            textPanel.repaint();
        });
        timer.start();

        // Image moved 80 units to the left (from width - 100 to width - 180)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/JUST.jpg"));
        Image image1 = i1.getImage().getScaledInstance(115, 115, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(width - 180, 10, 115, 115);
        panel2.add(l1);

        // ROW 1 - Top row buttons
        JButton b2 = new JButton("Room");
        b2.setBackground(new Color(246, 215, 118));
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBounds(10, 10, 200, 30);
        panel2.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ROOM();
            }
        });

        JButton b3 = new JButton("Department");
        b3.setBackground(new Color(246, 215, 118));
        b3.setFont(new Font("Arial", Font.BOLD, 15));
        b3.setBounds(230, 10, 200, 30);
        panel2.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton b4 = new JButton("All Doctor Info");
        b4.setBackground(new Color(246, 215, 118));
        b4.setFont(new Font("Arial", Font.BOLD, 15));
        b4.setBounds(450, 10, 200, 30);
        panel2.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Emplyoee_info();
            }
        });

        JButton b5 = new JButton("Patient Info");
        b5.setBackground(new Color(246, 215, 118));
        b5.setFont(new Font("Arial", Font.BOLD, 15));
        b5.setBounds(670, 10, 200, 30);
        panel2.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new All_Patient_info("#AdmInfo#");
            }
        });

        // Logout button moved to top row
        JButton b10 = new JButton("Logout");
        b10.setBackground(new Color(246, 215, 118));
        b10.setFont(new Font("Arial", Font.BOLD, 15));
        b10.setBounds(890, 10, 200, 30);
        panel2.add(b10);

        // ROW 2 - Bottom row buttons
        JButton b8 = new JButton("Ambulance");
        b8.setBackground(new Color(246, 215, 118));
        b8.setFont(new Font("Arial", Font.BOLD, 15));
        b8.setBounds(10, 65, 200, 30);
        panel2.add(b8);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ambulance();
            }
        });

        JButton b9 = new JButton("Search Room");
        b9.setBackground(new Color(246, 215, 118));
        b9.setFont(new Font("Arial", Font.BOLD, 15));
        b9.setBounds(230, 65, 200, 30);
        panel2.add(b9);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new search_room();
            }
        });

        // Remove Admin button moved to bottom row
        JButton b11 = new JButton("Remove Admin");
        b11.setBackground(new Color(246, 215, 118));
        b11.setFont(new Font("Arial", Font.BOLD, 15));
        b11.setBounds(450, 65, 200, 30);
        panel2.add(b11);

        JButton b12 = new JButton("Register Admin");
        b12.setBackground(new Color(246, 215, 118));
        b12.setFont(new Font("Arial", Font.BOLD, 15));
        b12.setBounds(670, 65, 200, 30);
        panel2.add(b12);

        // Action Listeners
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
                adminReception.this.setVisible(false);
            }
        });

        b11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String adminId = JOptionPane.showInputDialog("Enter Admin ID to Remove:");
                if (adminId == null || adminId.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Admin ID cannot be empty.");
                    return;
                }

                String password = JOptionPane.showInputDialog("Enter Admin Password:");
                if (password == null || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Password cannot be empty.");
                    return;
                }

                try {
                    conection c = new conection();
                    String query = "SELECT * FROM login WHERE ID = '" + adminId + "' AND PW = '" + password + "'";
                    ResultSet rs = c.statement.executeQuery(query);

                    if (rs.next()) {
                        String deleteQuery = "DELETE FROM login WHERE ID = '" + adminId + "' AND PW = '" + password + "'";
                        int rowsAffected = c.statement.executeUpdate(deleteQuery);

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Admin removed successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to remove admin.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Admin ID or password.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred while removing the admin.");
                }
            }
        });

        b12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registerAdmin();
            }
        });

        conection c = new conection();

        // Collect admin name from login table for display using userId
        String userNameQuery = "SELECT * FROM login WHERE ID = '" + userId + "'";
        String userName;
        try {
            ResultSet rs = c.statement.executeQuery(userNameQuery);
            if (rs.next()) {
                userName = rs.getString("username");
                JLabel userLabel = new JLabel("Welcome: " + userName);
                userLabel.setFont(new Font("Arial", Font.BOLD, 30));
                userLabel.setBounds(500, 20, 500, 30);
                userLabel.setForeground(Color.WHITE);
                panel1.add(userLabel);
            } else {
                System.out.println("Admin not found for ID: " + userId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set full screen
        setSize(width, height);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new adminReception("admin");
    }
}