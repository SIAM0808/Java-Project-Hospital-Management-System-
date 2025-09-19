package hospital_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
public class NEW_PATIENT extends JFrame implements ActionListener{
    private String userId;
    JComboBox<String> comboBox, comboBox1;

    JTextField textFieldNumber, testName, textFieldCountry, textFieldDeposite, textFieldFaculty, textFieldDisease;

    JRadioButton r1, r2;

    Choice c1;

    JLabel date;

    JButton b1, b2;
    NEW_PATIENT(String userId){
        this.userId = userId; // Store the userId
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        System.out.println(height + " " + width);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, width, height);
        panel.setBackground(new Color(111, 164, 190));
        add(panel);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/patient.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(680, 150, 180, 180);
        panel.add(label);



        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(350, 10, 400, 30);
        labelName.setFont(new Font("Arial", Font.BOLD, 30));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);


        JLabel labelId = new JLabel("ID: ");
        labelId.setBounds(35, 76, 100, 14);
        labelId.setFont(new Font("Arial", Font.BOLD, 14));
        labelId.setForeground(Color.WHITE);
        panel.add(labelId);




        comboBox = new JComboBox<String>(new String[] {"Birth Certificate", "Driving License", "Passport"});
        comboBox.setBounds(240, 72, 200, 25);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number: ");
        labelNumber.setBounds(35, 106, 100, 14);
        labelNumber.setFont(new Font("Arial", Font.BOLD, 14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(240, 102, 200, 25);
        panel.add(textFieldNumber);


        JLabel labelName1 = new JLabel("Name: ");
        labelName1.setBounds(35, 136, 100, 14);
        labelName1.setFont(new Font("Arial", Font.BOLD, 14));
        labelName1.setForeground(Color.WHITE);
        panel.add(labelName1);

        testName = new JTextField();
        testName.setBounds(240, 132, 200, 25);
        panel.add(testName);


        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35, 166, 100, 14);
        labelGender.setFont(new Font("Arial", Font.BOLD, 14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton();
        r1.setText("Male");
        r1.setBounds(240, 162, 60, 25);
        r1.setBackground(new Color(109, 164, 170));
        r1.setForeground(Color.WHITE);
        panel.add(r1);

        r2 = new JRadioButton();
        r2.setText("Female");
        r2.setBounds(320, 162, 80, 25);
        r2.setBackground(new Color(109, 164, 170));
        r2.setForeground(Color.WHITE);
        panel.add(r2);


        JLabel labelCountry = new JLabel("Country: ");
        labelCountry.setBounds(35, 196, 100, 14);
        labelCountry.setFont(new Font("Arial", Font.BOLD, 14));
        labelCountry.setForeground(Color.WHITE);
        panel.add(labelCountry);


        textFieldCountry = new JTextField();
        textFieldCountry.setBounds(240, 192, 200, 25);
        panel.add(textFieldCountry);


        JLabel labelDisease = new JLabel("Disease: ");
        labelDisease.setBounds(35, 226, 100, 14);
        labelDisease.setFont(new Font("Arial", Font.BOLD, 14));
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(240, 222, 200, 25);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room No: ");
        labelRoom.setBounds(35, 256, 100, 14);
        labelRoom.setFont(new Font("Arial", Font.BOLD, 14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        // ROOM NO //
        c1 = new Choice();
        try{
            conection c = new conection();
            ResultSet resultSet = c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(240, 252, 200, 25);
        c1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(109, 164, 170));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time: ");
        labelDate.setBounds(35, 286, 100, 14);
        labelDate.setFont(new Font("Arial", Font.BOLD, 14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel(date1.toString());
        date.setBounds(240, 282, 250, 25);
        date.setForeground(Color.WHITE);
        panel.add(date);


        JLabel labelDeposite = new JLabel("Deposite: ");
        labelDeposite.setBounds(35, 316, 100, 14);
        labelDeposite.setFont(new Font("Arial", Font.BOLD, 14));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(240, 312, 200, 25);
        panel.add(textFieldDeposite);

        JLabel labelFaculty = new JLabel("Faculty: ");
        labelFaculty.setBounds(35, 346, 100, 14);
        labelFaculty.setFont(new Font("Arial", Font.BOLD, 14));
        labelFaculty.setForeground(Color.WHITE);
        panel.add(labelFaculty);

        comboBox1 = new JComboBox<String>(new String[] {"Engineering and Technology", "Applied Science and Technology"
        , "Biological Science and Technology", "Health Science",
              "Arts and Social Science", "Science",
            "Business Studies", "Veterinary Medicine"});
        comboBox1.setBounds(240, 342, 200, 25);
        panel.add(comboBox1);


        b1 = new JButton("Add");
        b1.setBackground(new Color(246, 215, 118));
        b1.setFont(new Font("Arial", Font.BOLD, 15));
        b1.setBounds(540, 250, 100, 30);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBackground(new Color(246, 215, 118));
        b2.setFont(new Font("Arial", Font.BOLD, 15));
        b2.setBounds(540, 300, 100, 30);
        panel.add(b2);

        b2.addActionListener(this);

        setUndecorated(true);
        setSize(width/2+100, height/2 - 20);
        setLayout(getLayout());
        setLocation(width/5, height/4 + 50);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){

            conection c = new conection();
            String radioBTN = null;
            if(r1.isSelected()){
                radioBTN = "Male";
            }else if (r2.isSelected()){
                radioBTN = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = testName.getText();
            String s4 = radioBTN;
            String s5 = textFieldCountry.getText();
            String s6 = textFieldDisease.getText();
            String s7 = c1.getSelectedItem();
            String s8 = date.getText();
            String s9 = textFieldDeposite.getText();
            String s10 = (String) comboBox1.getSelectedItem();


            try{
                String q = "insert into patient_info values('"+s1+"', '"+s2+"', '"+s3+"', '"+s4+"', '"+s6+"', '"+s7+"', '"+s8+"', '"+s9+"', '"+s5+"', '"+s10+"', '"+userId+"')";
                String q1 = "update room set Availability = 'Occupied' where room_no = '"+s7+"'";
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);  

                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                setVisible(false);
            }catch(Exception E){
                E.printStackTrace();
            }

    }else{
        // setVisible(false);
        this.dispose();
    }
}

    public static void main(String[] args) {
        new NEW_PATIENT("Siam");
    }
   
}
