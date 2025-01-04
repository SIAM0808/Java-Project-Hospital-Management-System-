package hospital_management_system;

import java.awt.*;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reception extends JFrame {
    Reception(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;


        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,width,height);
        panel.setBackground(new Color(
           109,164,170
        ));
        add(panel);
        


        // set full screen
        setSize(width,height);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Reception();
    }
}
