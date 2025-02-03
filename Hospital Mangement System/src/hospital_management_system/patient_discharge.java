package hospital_management_system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

public class patient_discharge extends JFrame{
    patient_discharge() {
      

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        int x = (width/2+200)-500;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, width, height);
        panel.setBackground(new Color(109, 164, 190));
        add(panel);

        JLabel l1 = new JLabel("Check-Out");
        l1.setBounds(x/2 - 30, 20, 150, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel l2 = new JLabel("Patient ID");
        l2.setBounds(25, 85, 100, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l2);


        // JTextField t1 = new JTextField();
        // t1.setBounds(120, 85, 150, 30);
        // t1.setFont(new Font("Arial", Font.BOLD, 15));
        // panel.add(t1);


        Choice c1 = new Choice();
        c1.setBounds(120, 85, 150, 30);
        c1.setFont(new Font("Arial", Font.BOLD, 15));  
        panel.add(c1); 

        JLabel l3 = new JLabel("Room no: ");
        l3.setBounds(25, 130, 100, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l3);

        

        // setUndecorated(true);
        setSize((width/2+200)-500, (height/2+100)-200);
        setLayout(null);
        setLocation(width/5+300, height/4+100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new patient_discharge();
    }
}
