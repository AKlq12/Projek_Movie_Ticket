package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/bioskop_db";
    private static final String USER = "root"; // Ganti jika perlu
    private static final String PASSWORD = ""; // Ganti jika perlu
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal terhubung ke database: " + e.getMessage(), 
                "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
}