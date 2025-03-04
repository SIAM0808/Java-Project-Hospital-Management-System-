package hospital_management_system;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;

public class update_patient_details extends JFrame {

    update_patient_details() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, width, height);
        panel.setBackground(new Color(109, 164, 190));
        add(panel);

        int x = (width/2)/2;

       


        JLabel l1 = new JLabel("Update Patient Details");
        l1.setBounds(x, 30, 400, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 30));
        l1.setForeground(Color.WHITE);
        panel.add(l1);


        JLabel name = new JLabel("Name: ");
        name.setBounds(50, 90, 80, 30);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(name);

        JTextField t = new JTextField();
        // t.setBounds(200, 90, 150, 30);
        t.setBounds(200, 140, 150, 30);
        t.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(t);


        JLabel l2 = new JLabel("Patient ID: ");
        l2.setBounds(50, 135, 80, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l2);

        Choice c1 = new Choice();
        // c1.setBounds(200, 140, 150, 30);
        c1.setBounds(200, 90, 150, 30);
        c1.setFont(new Font("Arial", Font.BOLD, 11));
        panel.add(c1);

        try {
            conection c = new conection();
            ResultSet rs = c.statement.executeQuery("select * from patient_info");
            while (rs.next()) {
                c1.add(rs.getString("Name"));
            }
        } catch (Exception e) {
            
        }

        JLabel l3 = new JLabel("Room Number: ");
        l3.setBounds(50, 190, 110, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l3);

        JTextField t1 = new JTextField();
        t1.setBounds(200, 190, 150, 30);
        t1.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(t1);

        JLabel l4 = new JLabel("In-Time: ");
        l4.setBounds(50, 225, 100, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l4);

        JTextField t2 = new JTextField();
        t2.setBounds(200, 225, 350, 30);
        t2.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(t2);



        JLabel l5 = new JLabel("Amount Paid (TK): ");
        l5.setBounds(50, 280, 150, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l5);

        JTextField t3 = new JTextField();
        t3.setBounds(200, 280, 150, 30);
        t3.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(t3);


        JLabel l6 = new JLabel("Pending Amount: ");
        l6.setBounds(50, 335, 150, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l6);


        JTextField t4 = new JTextField();
        t4.setBounds(200, 335, 150, 30);
        t4.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(t4);
        
        

        JButton b1 = new JButton("Check");
        b1.setBounds(50, 400, 100, 30);
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);


        JButton b2 = new JButton("Back");
        b2.setBounds(200, 400, 100, 30);
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        panel.add(b2);


        b1.addActionListener(_ -> {
            
            String patientID = c1.getSelectedItem();
            String q = "select * from patient_info where Name = '"+patientID+"'";

            try {
                conection c = new conection();
                ResultSet resultSet = c.statement.executeQuery(q);
                while(resultSet.next()){
                    t.setText(resultSet.getString("Number"));
                    t1.setText(resultSet.getString("Room_Number"));
                    t2.setText(resultSet.getString("Time"));
                    t3.setText(resultSet.getString("Deposite"));
                }

                ResultSet rs = c.statement.executeQuery("select * from Room where room_no = '"+t1.getText()+"'");
                while(rs.next()){
                    String s1 = rs.getString("Price");
                    int amountPaid = Integer.parseInt(s1) - Integer.parseInt(t3.getText());
                    t4.setText(""+amountPaid);
                    // t4.setText(rs.getString("Pending_Amount"));
                }
                // JOptionPane.showMessageDialog(null, "Patient Details Updated Successfully");
                // setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });



        b2.addActionListener(_ -> {
            setVisible(false);
        });




        JButton update = new JButton("Update");
        update.setBounds(50, 450, 100, 30);
        update.setFont(new Font("Arial", Font.BOLD, 15));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);


        update.addActionListener(_ -> {
            String patientID = c1.getSelectedItem();
            String roomNumber = t1.getText();
            String inTime = t2.getText();
            String amountPaid = t3.getText();
            String pendingAmount = t4.getText();

            String q = "update patient_info set Room_Number = '"+roomNumber+"', Time = '"+inTime+"', Deposite = '"+amountPaid+"' where Name = '"+patientID+"'";
            String q1 = "update Room set Pending_Amount = '"+pendingAmount+"' where room_no = '"+roomNumber+"'";

            try {
                conection c = new conection();
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Patient Details Updated Successfully");
                setVisible(false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        setUndecorated(true);
        setSize(width/2+200, height/2+130);
        setLayout(null);
        setLocation(width/5, height/5);
        setVisible(true);

    }
    public static void main(String[] args) {
        new update_patient_details();
    }
}
