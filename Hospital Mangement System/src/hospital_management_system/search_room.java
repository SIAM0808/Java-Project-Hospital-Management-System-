package hospital_management_system;

import java.awt.*;
import java.sql.ResultSet;

import javax.swing.*;
// import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;

public class search_room extends JFrame{
    Choice c1;
    JTable table;
    search_room(){


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);

        JLabel For = new JLabel("Search For Room");
        For.setBounds(350, 20,2100, 30);
        For.setFont(new Font("Arial", Font.BOLD, 15));
        For.setForeground(Color.WHITE);
        panel.add(For);


        JLabel status = new JLabel("Status: ");
        status.setBounds(50, 100, 100, 20);
        status.setFont(new Font("Arial", Font.BOLD, 13));
        status.setForeground(Color.BLACK);
        panel.add(status);

        c1 = new Choice();
        c1.setBounds(150, 100, 150, 20);
        c1.add("Available");
        c1.add("Occupied");
        panel.add(c1);


        table = new JTable();
        table.setBounds(20, 150, 750, 300);
        table.setBackground(new Color(111, 164, 190));
        table.setFont(new Font("Arial", Font.BOLD, 11));
        panel.add(table);


        try {
            conection c = new conection();
            String str = "select * from room";
            ResultSet rs = c.statement.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            
            e.printStackTrace();
        }



        JLabel rmno = new JLabel("Room No");
        rmno.setBounds(20, 130, 100, 20);
        rmno.setFont(new Font("Arial", Font.BOLD, 13));
        rmno.setForeground(Color.BLACK);
        panel.add(rmno);

        JLabel av = new JLabel("Availability");
        av.setBounds(210, 130, 100, 20);
        av.setFont(new Font("Arial", Font.BOLD, 13));
        av.setForeground(Color.BLACK);
        panel.add(av);

        JLabel pr = new JLabel("Price");
        pr.setBounds(400, 130, 100, 20);
        pr.setFont(new Font("Arial", Font.BOLD, 13));
        pr.setForeground(Color.BLACK);
        panel.add(pr);

        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(600, 130, 100, 20);
        bed.setFont(new Font("Arial", Font.BOLD, 13));
        bed.setForeground(Color.BLACK);
        panel.add(bed);

        JButton search = new JButton("Search");
        search.setBounds(350, 100, 100, 20);
        search.setBackground(new Color(0, 0, 0));
        search.setForeground(Color.WHITE);
        panel.add(search);
        

        search.addActionListener(_ -> {
            try {
                conection c = new conection();
                String str = "select * from room where Availability = '"+c1.getSelectedItem()+"'";
                ResultSet rs = c.statement.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300, 510, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);


        back.addActionListener(_ -> {
            setVisible(false);
        });

        setUndecorated(true);
        setSize(800, 600);
        setLocation(220, 70);
        setLayout(null);
        setVisible(true);
    }


    

    public static void main(String[] args) {
        new search_room();
    }
}
