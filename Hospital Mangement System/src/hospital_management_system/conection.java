package hospital_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conection {
    Connection connection;
    Statement statement;

    public conection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "565656");
            if (connection != null) {
                statement = connection.createStatement();
                System.out.println("Database connected successfully!");
            } else {
                System.out.println("Failed to establish connection!");
            }
        } catch (Exception e) {
            System.out.println("Error in database connection: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
}
