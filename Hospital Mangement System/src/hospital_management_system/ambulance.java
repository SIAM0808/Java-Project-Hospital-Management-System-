package hospital_management_system;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

// import javax.swing.*;
// import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;


public class ambulance extends JFrame{
    ambulance(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 400);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);



        JTable table = new JTable();
        table.setBounds(50, 50, 700, 300);
        table.setBackground(new Color(111, 164, 190));
        table.setFont(new Font("Arial", Font.BOLD, 11));
        panel.add(table);

        try {
            conection c = new conection();
            String str = "select * from Ambulance";
            ResultSet rs = c.statement.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }


        JLabel name = new JLabel("Name");
        name.setBounds(50, 20, 100, 20);
        name.setFont(new Font("Arial", Font.BOLD, 13));
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(220, 20, 100, 20);
        gender.setFont(new Font("Arial", Font.BOLD, 13));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel available = new JLabel("Availability");
        available.setBounds(400, 20, 100, 20);
        available.setFont(new Font("Arial", Font.BOLD, 13));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel car_name = new JLabel("Car Name");
        car_name.setBounds(600, 20, 100, 20);
        car_name.setFont(new Font("Arial", Font.BOLD, 13));
        car_name.setForeground(Color.WHITE);
        panel.add(car_name);


        setSize(800, 400);
        setLocation(350, 200);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ambulance();
    }
}
