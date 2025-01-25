package hospital_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class ROOM extends JFrame {
    JTable table;
    ROOM(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, width-10, height-10);
        panel.setBackground(new Color(109, 164, 170));
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/Room.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(700, 150, 200, 200);
        panel.add(label);


        table = new JTable();
        table.setBounds(20, 50, 500, 900);
        // table.setBounds(20, 20, 1000, 500);
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);
        
        try{
            conection c = new conection();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("ROOM NO");
        labelName.setBounds(20, 30, 100, 20);
        labelName.setFont(new Font("Arial", Font.BOLD, 10));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        JLabel labelAge = new JLabel("AVAILABILITY");
        labelAge.setBounds(145, 30, 100, 20);
        labelAge.setFont(new Font("Arial", Font.BOLD, 10));
        labelAge.setForeground(Color.WHITE);
        panel.add(labelAge);


        JLabel labelGender = new JLabel("PRICE");
        labelGender.setBounds(270, 30, 100, 20);
        labelGender.setFont(new Font("Arial", Font.BOLD, 10));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        JLabel labelCompany = new JLabel("STATUS");
        labelCompany.setBounds(395, 30, 100, 25);
        labelCompany.setFont(new Font("Arial", Font.BOLD, 10));
        labelCompany.setForeground(Color.WHITE);
        panel.add(labelCompany);


        JButton back = new JButton("Back");
        back.setBounds(width/2 - 200, height/2 - 100, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(width/2+100, height/2+100);
        setLayout(getLayout());
        setLocation(width/5, height/4);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ROOM();
    }
}
