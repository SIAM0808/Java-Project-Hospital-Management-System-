package hospital_management_system;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import net.proteanit.sql.DbUtils;



public class All_Patient_info extends JFrame{
    All_Patient_info(){

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
        table.setBounds(20, 50, width/2+150, 300);
        table.setBackground(new Color(111, 164, 190));
        table.setFont(new Font("Arial", Font.BOLD, 11));
        panel.add(table);

         // Custom cell renderer to increase row padding and wrap text
DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JTextArea textArea = new JTextArea(value != null ? value.toString() : "");
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(true);
        textArea.setFont(table.getFont());
        if (isSelected) {
            textArea.setBackground(table.getSelectionBackground());
            textArea.setForeground(table.getSelectionForeground());
        } else {
            textArea.setBackground(table.getBackground());
            textArea.setForeground(table.getForeground());
        }
        return textArea;
    }
};
renderer.setPreferredSize(new Dimension(0, 30)); // Increase the height of each row
table.setRowHeight(30); // Set the row height
table.setDefaultRenderer(Object.class, renderer);


JScrollPane scrollPane = new JScrollPane(table); // Line 38
        scrollPane.setBounds(20, 80, width / 2 + 150, 235);
        panel.add(scrollPane);

try {
    conection c = new conection();
    String q = "select * from patient_info";
    java.sql.ResultSet resultSet = c.statement.executeQuery(q);
    table.setModel(DbUtils.resultSetToTableModel(resultSet));
    
    // Set column widths
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setPreferredWidth(150); // Set the preferred width for each column
    }
} catch (Exception e) {
    e.printStackTrace();
}
        int x = (width/2+150)/2;
        JLabel label1 = new JLabel("Patients Information");
        label1.setBounds(x-50, 15, 200, 20);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        panel.add(label1);
        

        // JLabel label2 = new JLabel("Number");
        // label2.setBounds(x*2-50, 35, 100, 20);
        // label2.setFont(new Font("Arial", Font.BOLD, 11));
        // label2.setForeground(Color.WHITE);
        // panel.add(label2);


        // JLabel label3 = new JLabel("Name");
        // label3.setBounds(x*3-50, 35, 100, 20);
        // label3.setFont(new Font("Arial", Font.BOLD, 11));
        // label3.setForeground(Color.WHITE);
        // panel.add(label3);


        // JLabel label4 = new JLabel("Gender");
        // label4.setBounds(x*4-50, 35, 100, 20);
        // label4.setFont(new Font("Arial", Font.BOLD, 11));
        // label4.setForeground(Color.WHITE);
        // panel.add(label4);

        // JLabel label5 = new JLabel("Patient Disease");
        // label5.setBounds(x*5-75, 35, 100, 20);
        // label5.setFont(new Font("Arial", Font.BOLD, 11));
        // label5.setForeground(Color.WHITE);
        // panel.add(label5);


        // JLabel label6 = new JLabel("Room No");
        // label6.setBounds(x*6-50, 35, 100, 20);
        // label6.setFont(new Font("Arial", Font.BOLD, 11));
        // label6.setForeground(Color.WHITE);
        // panel.add(label6);


        // JLabel label7 = new JLabel("Time");
        // label7.setBounds(x*7-50, 35, 100, 20);
        // label7.setFont(new Font("Arial", Font.BOLD, 11));
        // label7.setForeground(Color.WHITE);
        // panel.add(label7);


        // JLabel label8 = new JLabel("Deposite");
        // label8.setBounds(x*8-50, 35, 100, 20);
        // label8.setFont(new Font("Arial", Font.BOLD, 11));
        // label8.setForeground(Color.WHITE);
        // panel.add(label8);


        // JLabel label9 = new JLabel("Country");
        // label9.setBounds(x*9-50, 35, 100, 20);
        // label9.setFont(new Font("Arial", Font.BOLD, 11));
        // label9.setForeground(Color.WHITE);
        // panel.add(label9);



        // JLabel label10 = new JLabel("Faculty");
        // label10.setBounds(x*10-50, 35, 100, 20);
        // label10.setFont(new Font("Arial", Font.BOLD, 11));
        // label10.setForeground(Color.WHITE);
        // panel.add(label10);

        JButton back = new JButton("BACK");
        back.setBounds(x-20, 425, 100, 30); // Adjust the position as needed
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(e -> {
            this.setVisible(false);
        });
        panel.add(back);


        setUndecorated(true);
        setSize(width/2+200, height/2+100);
        setLayout(null);
        setLocation(width/5, height/4);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new All_Patient_info();
    }
}
