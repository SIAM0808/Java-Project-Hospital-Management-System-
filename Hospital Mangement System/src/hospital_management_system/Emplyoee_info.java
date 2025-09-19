package hospital_management_system;



import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;



public class Emplyoee_info extends JFrame{

    Emplyoee_info(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, width-10, height-10);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);


        JTable table = new JTable();
        table.setBounds(20, 60, width/2+100, 300);
        // table.setBounds(20, 20, 1000, 500);
        table.setBackground(new Color(111, 164, 190));
        panel.add(table);


        // Custom cell renderer to increase row padding
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setPreferredSize(new Dimension(0, 30)); // Increase the height of each row
        table.setRowHeight(30); // Set the row height
        table.setDefaultRenderer(Object.class, renderer);

        try{
            conection c = new conection();
            String q = "select * from Doctor_info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }
        int x = (width/2+100)/6;
        JLabel labelName = new JLabel("Name");
        labelName.setBounds((width/2+100)/6 - 80, 30, 100, 20);
        labelName.setFont(new Font("Arial", Font.BOLD, 15));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);


        JLabel labelAge = new JLabel("Age");
        labelAge.setBounds(x*2 - 80, 30, 100, 20);
        labelAge.setFont(new Font("Arial", Font.BOLD, 15));
        labelAge.setForeground(Color.WHITE);
        panel.add(labelAge);


        JLabel labelGender = new JLabel("Phone_no");
        labelGender.setBounds(x*3 - 80, 30, 100, 20);
        labelGender.setFont(new Font("Arial", Font.BOLD, 15));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);


        JLabel labelJob = new JLabel("Salary");
        labelJob.setBounds(x*4 - 80, 30, 100, 20);
        labelJob.setFont(new Font("Arial", Font.BOLD, 15));
        labelJob.setForeground(Color.WHITE);
        panel.add(labelJob);


        JLabel labelCompany = new JLabel("Gmail");
        labelCompany.setBounds(x*5 - 80, 30, 100, 25);
        labelCompany.setFont(new Font("Arial", Font.BOLD, 15));
        labelCompany.setForeground(Color.WHITE);
        panel.add(labelCompany);

        JLabel nid = new JLabel("NID Number");
        nid.setBounds(x*6 - 110, 30, 100, 25);
        nid.setFont(new Font("Arial", Font.BOLD, 13));
        nid.setForeground(Color.WHITE);
        panel.add(nid);


        JButton back = new JButton("BACK");
        back.setBounds(355, 425, 100, 30); // Adjust the position as needed
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(_ -> {
            this.dispose();
        });
        panel.add(back);




        setUndecorated(true);
        setSize(width/2+100, height/2+100);
        setLayout(getLayout());
        setLocation(width/5, height/4+50);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Emplyoee_info();
    }
}
