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
import javax.swing.JPanel;

public class Reception extends JFrame {
    private int textX = 0; // Initial x position of the text
    private final int textWidth = 500; // Width of the text area
    private String userId;
    // private final int panel2Height = 198; // Height of panel2
    public Reception(String userId) {
        this.userId = userId; // Store the userId
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
        panel2.setBackground(new Color(109, 114, 110));
        add(panel2);;

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
            // textWidth = 400; // Adjust the width of the text as needed
        textX = 600; // Start from the right side
        textPanel.setBounds(10, 105, 600, 30); // Adjust the position and size as needed
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



        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/JUST.jpg"));
        Image image1 = i1.getImage().getScaledInstance(115, 115, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(width-150, 10, 115, 115); // Adjust the position and size as needed
        panel2.add(l1); // Add the label to panel2


        JButton b1 = new JButton("Add new Patitent");
        b1.setBackground(new Color(246, 215, 118));
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b1.setBounds(10, 10, 200, 30);
        panel2.add(b1);
        b1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new NEW_PATIENT(userId);
            }
        });


        JButton b2 = new JButton("Room");
        b2.setBackground(new Color(246, 215, 118));
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b2.setBounds(10, 65, 200, 30);
        panel2.add(b2);
        b2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               new ROOM(); // Open the Room frame
            }
        });


        JButton b3 = new JButton("Department");
        b3.setBackground(new Color(246, 215, 118));
        b3.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b3.setBounds(230, 10, 200, 30);
        panel2.add(b3);
        b3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Department();
            }
        });


        JButton b4 = new JButton("All Doctor Info");
        b4.setBackground(new Color(246, 215, 118));
        b4.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b4.setBounds(230, 65, 200, 30);
        panel2.add(b4);
        b4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Emplyoee_info();
            }
        });
        
        JButton b5 = new JButton("Patient Info");
        b5.setBackground(new Color(246, 215, 118));
        b5.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b5.setBounds(450, 10, 200, 30);
        panel2.add(b5);
        b5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new All_Patient_info(userId);
            }
        });

        JButton b6 = new JButton("Patient Discharge");
        b6.setBackground(new Color(246, 215, 118));
        b6.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b6.setBounds(450, 65, 200, 30);
        panel2.add(b6);
        b6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new  patient_discharge(userId);
            }
        });

        JButton b7 = new JButton("Update Patient Details");
        b7.setBackground(new Color(246, 215, 118));
        b7.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b7.setBounds(670, 10, 200, 30);
        panel2.add(b7);
        b7.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new update_patient_details(userId);
            }
        });

        JButton b8 = new JButton("Ambulance");
        b8.setBackground(new Color(246, 215, 118));
        b8.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b8.setBounds(670, 65, 200, 30);
        panel2.add(b8);
        b8.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new ambulance();
            }
        });

        JButton b9 = new JButton("Search Room");
        b9.setBackground(new Color(246, 215, 118));
        b9.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b9.setBounds(890, 10, 200, 30);
        panel2.add(b9);
        b9.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               new search_room();
            }
        });

        JButton b10 = new JButton("Logout");
        b10.setBackground(new Color(246, 215, 118));
        b10.setFont(new Font("Arial", Font.BOLD, 15));
        // b1.setForeground(Color.WHITE);
        b10.setBounds(890, 65, 200, 30);
        panel2.add(b10);
        b10.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new Login();
                Reception.this.setVisible(false);
            }
        });
        conection c = new conection();

        // collect username form userRegister Table for display using userId
        String userNameQuery = "SELECT username FROM userRegister WHERE userId = '" + this.userId + "'";
        String userName;
        try{
            ResultSet rs = c.statement.executeQuery(userNameQuery);
            if(rs.next()){
                userName = rs.getString("username");
                JLabel userLabel = new JLabel("Welcome! " + userName);
                userLabel.setFont(new Font("Arial", Font.BOLD, 30));
                userLabel.setBounds(600, 20, 400, 30); // Adjust the position and size as needed
                userLabel.setForeground(Color.WHITE);
                panel1.add(userLabel); // Add the label to panel1
            }else {
                System.out.println("User not found for userId: " + userId);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        // set full screen
        setSize(width, height);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception("Siam"); // Pass a sample userId for testing
    }
}