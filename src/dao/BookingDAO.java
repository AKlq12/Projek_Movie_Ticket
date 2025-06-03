package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import util.DatabaseConnection;

public class BookingDAO {
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id_booking"),
                    rs.getInt("id_movie"),
                    rs.getString("movie_title"),
                    rs.getString("genre"),
                    rs.getString("seat"),
                    rs.getInt("total_price"),
                    rs.getTimestamp("purchased_date"),
                    rs.getTimestamp("created_at")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public List<Booking> searchBookings(String searchTerm) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE movie_title LIKE ? OR genre LIKE ? OR seat LIKE ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, "%" + searchTerm + "%");
            stmt.setString(2, "%" + searchTerm + "%");
            stmt.setString(3, "%" + searchTerm + "%");
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id_booking"),
                    rs.getInt("id_movie"),
                    rs.getString("movie_title"),
                    rs.getString("genre"),
                    rs.getString("seat"),
                    rs.getInt("total_price"),
                    rs.getTimestamp("purchased_date"),
                    rs.getTimestamp("created_at")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}