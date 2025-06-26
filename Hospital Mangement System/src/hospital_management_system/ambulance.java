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
        table.setBounds(50, 50, 700, 200);
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
        gender.setBounds(193, 20, 100, 20);
        gender.setFont(new Font("Arial", Font.BOLD, 13));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel available = new JLabel("Availability");
        available.setBounds(330, 20, 100, 20);
        available.setFont(new Font("Arial", Font.BOLD, 13));
        available.setForeground(Color.WHITE);
        panel.add(available);


        JLabel car_name = new JLabel("Car Name");
        car_name.setBounds(468, 20, 100, 20);
        car_name.setFont(new Font("Arial", Font.BOLD, 13));
        car_name.setForeground(Color.WHITE);
        panel.add(car_name);

        JLabel phone_no = new JLabel("Phone No");
        phone_no.setBounds(610, 20, 100, 20);
        phone_no.setFont(new Font("Arial", Font.BOLD, 13));
        phone_no.setForeground(Color.WHITE);
        panel.add(phone_no);

        // Hiring ambulance and update its availability
        JButton hireButton = new JButton("Hire Ambulance");
        hireButton.setBounds(50, 310, 150, 30);
        hireButton.setFont(new Font("Arial", Font.BOLD, 12));
        hireButton.setBackground(new Color(109, 164, 170));
        hireButton.setForeground(Color.WHITE);
        hireButton.addActionListener(_ -> {
            try {
                conection c = new conection();
                String str = "update ambulance set availability = 'unavailable' where availability = 'available' limit 1";
                int check = c.statement.executeUpdate(str);


                // ResultSet rs = c.statement.executeQuery("select * from Ambulance where availability = 'unavailable' limit 1");
                // if (rs.next()) {
                //     String carId = rs.getString("car_id");
                //     JOptionPane.showMessageDialog(null, "Ambulance with Car ID: " + carId + " has been hired.");
                // } else {
                //     JOptionPane.showMessageDialog(null, "No available ambulances to hire.");
                // }
                if(check > 0){
                JOptionPane.showMessageDialog(null, "Ambulance Hired Successfully");
                ResultSet rss = c.statement.executeQuery("select * from Ambulance");
                table.setModel(DbUtils.resultSetToTableModel(rss));
                }else{
                    JOptionPane.showMessageDialog(null, "No available ambulances to hire.");
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        panel.add(hireButton);
        // Update availability button via car_id 
        JButton updateButton = new JButton("Update Availability");
        updateButton.setBounds(220, 310, 150, 30);
        updateButton.setFont(new Font("Arial", Font.BOLD, 12));
        updateButton.setBackground(new Color(109, 164, 170));
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(_ -> {
            String carId = JOptionPane.showInputDialog("Enter Car ID to update availability:");
            // If user clicks cancel, carId will be null
            if (carId == null) {
                return;
            }
            if (!carId.trim().isEmpty()) {
                try {
                    conection c = new conection();
                    String str = "update ambulance set availability = 'available' where car_id = '" + carId + "'";
                    int rowsAffected = c.statement.executeUpdate(str);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Ambulance with Car ID: " + carId + " is now available.");
                        ResultSet rss = c.statement.executeQuery("select * from Ambulance");
                        table.setModel(DbUtils.resultSetToTableModel(rss));
                    } else {
                        JOptionPane.showMessageDialog(null, "No ambulance found with Car ID: " + carId);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Car ID cannot be empty.");
            }
        });
        panel.add(updateButton);
        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(400, 310, 150, 30);
        exitButton.setFont(new Font("Arial", Font.BOLD, 12));
        exitButton.setBackground(new Color(109, 164, 170));
        exitButton.setForeground(Color.WHITE);
        exitButton.addActionListener(_ -> {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        setUndecorated(true);
        setSize(800, 400);
        setLocation(350, 200);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ambulance();
    }
}
