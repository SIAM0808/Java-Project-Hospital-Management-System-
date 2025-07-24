package hospital_management_system;

import java.awt.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
// import javax.swing.table.DefaultTableCellRenderer;

// import net.proteanit.sql.DbUtils;

public class patient_discharge extends JFrame{
    patient_discharge(String userId) {
      

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;

        int x = (width/2+200)-500;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, width-300, height);
        panel.setBackground(new Color(109, 164, 190));
        add(panel);

        JLabel l1 = new JLabel("Check-Out");
        l1.setBounds(x/2 - 30, 20, 150, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);
        panel.add(l1);

        JLabel l2 = new JLabel("Patient ID: ");
        l2.setBounds(25, 81, 80, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l2);


        // JTextField t1 = new JTextField();
        // t1.setBounds(120, 85, 150, 30);
        // t1.setFont(new Font("Arial", Font.BOLD, 15));
        // panel.add(t1);


        Choice c1 = new Choice();
        c1.setBounds(120, 88, 150, 30);
        c1.setFont(new Font("Arial", Font.BOLD, 11));  
        panel.add(c1); 




        try {
            conection c = new conection();
            ResultSet rs = c.statement.executeQuery("select * from patient_info where userId = '"+userId+"'");
            while (rs.next()) {
                c1.add(rs.getString("Number"));
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }



        JLabel l3 = new JLabel("Room no: ");
        l3.setBounds(25, 130, 100, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l3);

        JLabel l4 = new JLabel("In Time: ");
        l4.setBounds(25, 175, 100, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l4);

        JLabel RNo = new JLabel();
        RNo.setBounds(120, 130, 280, 30);
        RNo.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(RNo);

        JLabel ITime = new JLabel();
        ITime.setBounds(120, 175, 280, 30);
        ITime.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(ITime);


        JLabel l5 = new JLabel("Out Time: ");
        l5.setBounds(25, 220, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(l5);



        JLabel OUTtime = new JLabel();
        OUTtime.setBounds(120, 220, 150, 30);
        OUTtime.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(OUTtime);


        Date date = new Date();
        String str = date.toString();
        JLabel OTime = new JLabel(str);
        OTime.setBounds(120, 220, 280, 30);
        OTime.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(OTime);

        JButton check = new JButton("Check");
        check.setBounds(157, 290, 120, 30);
        check.setFont(new Font("Arial", Font.BOLD, 15));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);


        JButton discharge = new JButton("Discharge");
        discharge.setBounds(25, 290, 120, 30);
        discharge.setFont(new Font("Arial", Font.BOLD, 15));
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);

        JButton back = new JButton("Back");
        back.setBounds(285, 290, 120, 30);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);

        

        check.addActionListener(_ -> {
            try {
                conection c = new conection();
                String patient_id = c1.getSelectedItem();
                ResultSet rs = c.statement.executeQuery("select * from patient_info where Number = '"+patient_id+"'");
                while (rs.next()) {
                    RNo.setText(rs.getString("Room_Number"));
                    ITime.setText(rs.getString("Time"));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }});



        discharge.addActionListener(_ -> {
            try {
                conection c = new conection();
                String patient_id = c1.getSelectedItem();
                String query = "delete from patient_info where Number = '"+patient_id+"'";
                c.statement.executeUpdate(query);
                String q2 = "update room set Availability = 'Available' where room_no = '"+RNo.getText()+"'";
                c.statement.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Patient Discharged Successfully");
                setVisible(false);
                new patient_discharge(userId);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        });


        back.addActionListener(_ -> {
            this.setVisible(false);
        });


        setUndecorated(true);
        setSize(width/2, height/2+100);
        setLayout(null);
        setLocation(width/5 + 70, height/4);
        setVisible(true);
    }
    public static void main(String[] args) {
        new patient_discharge("No User Id Invoked in patient_discharge.java");
    }
}
