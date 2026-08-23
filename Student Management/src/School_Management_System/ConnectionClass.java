package School_Management_System;

import java.sql.*;

public class ConnectionClass {
    public Connection con;
    public Statement stm;

    ConnectionClass() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define connection URL
            String url = "jdbc:mysql://localhost:330/sms";
            String user = "root";
            String password = ""; // used "" as no password

            // Establish connection
            con = DriverManager.getConnection(url, user, password);
            stm = con.createStatement();

            if (con != null && !con.isClosed()) {
                System.out.println("Connected to Database");
            } else {
                System.out.println("Connection Failed");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(); // show the error
        }
    }

//    public static void main(String[] args) {
//        new ConnectionClass();
//    }
}
