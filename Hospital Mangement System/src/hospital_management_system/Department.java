package hospital_management_system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;


public class Department extends JFrame{

    Department() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, width, height);
        panel.setBackground(new Color(109, 164, 190));
        add(panel);


        JTable table = new JTable();
        table.setBounds(20, 70, width/2+100, 300);
        table.setBackground(new Color(111, 164, 190));
        table.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(table);



         // Custom cell renderer to increase row padding
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setPreferredSize(new Dimension(0, 30)); // Increase the height of each row
        table.setRowHeight(30); // Set the row height
        table.setDefaultRenderer(Object.class, renderer);


        JLabel label1 = new JLabel("DEPARTMENT");
        label1.setBounds(230, 25, 200, 20);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label1);

        JLabel label2 = new JLabel("PHONE NUMBER");
        label2.setBounds(755, 25, 200, 20);
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(label2);

        try {
            conection c = new conection();
            String q = "select * from department";
            java.sql.ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JButton back = new JButton("BACK");
        back.setBounds(455, 425, 100, 30); // Adjust the position as needed
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> {
            this.setVisible(false);
        });
        panel.add(back);


        setUndecorated(true);
        setSize(width/2+100, height/2+100);
        setLayout(null);
        setLocation(width/5, height/4);
        setVisible(true);
        
        
    }
    public static void main(String[] args) {
        new Department();
    }
}
