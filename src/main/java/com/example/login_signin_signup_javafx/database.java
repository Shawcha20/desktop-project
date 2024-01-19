package com.example.login_signin_signup_javafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
    public static Connection connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxvideo", "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null; // Handle the exception appropriately in your application
        }
    }
}
