package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DatabaseConnection;

public class AuthController {
    public boolean authenticateAdmin(String username, String password) {
        String query = "SELECT * FROM admin WHERE username = ? AND password = SHA2(?, 256)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.setString(2, password);
            
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean authenticateCustomer(String username, String password) {
        String query = "SELECT * FROM customer WHERE username = ? AND password = SHA2(?, 256)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            
            pst.setString(1, username);
            pst.setString(2, password);
            
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}