package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Booking;
import util.DatabaseConnection;

public class BookingDAO {
    private Connection connection;

    public BookingDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";
        
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id_booking"));
                booking.setCustomerId(rs.getInt("id_customer"));
                booking.setMovieId(rs.getInt("id_movie"));
                booking.setMovieTitle(rs.getString("movie_title"));
                booking.setGenre(rs.getString("genre"));
                booking.setSeat(rs.getString("seat"));
                booking.setPurchasedDate(rs.getTimestamp("purchased_date"));
                booking.setTotalAmount(rs.getInt("total_amount"));
                booking.setCreatedAt(rs.getTimestamp("created_at"));
                
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Search bookings by movie title or customer ID
    public List<Booking> searchBookings(String searchTerm) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings WHERE movie_title LIKE ? OR id_customer = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + searchTerm + "%");
            
            // Try to parse search term as customer ID
            try {
                int customerId = Integer.parseInt(searchTerm);
                ps.setInt(2, customerId);
            } catch (NumberFormatException e) {
                ps.setInt(2, -1); // Invalid ID that won't match anything
            }
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setId(rs.getInt("id_booking"));
                booking.setCustomerId(rs.getInt("id_customer"));
                booking.setMovieId(rs.getInt("id_movie"));
                booking.setMovieTitle(rs.getString("movie_title"));
                booking.setGenre(rs.getString("genre"));
                booking.setSeat(rs.getString("seat"));
                booking.setPurchasedDate(rs.getTimestamp("purchased_date"));
                booking.setTotalAmount(rs.getInt("total_amount"));
                booking.setCreatedAt(rs.getTimestamp("created_at"));
                
                bookings.add(booking);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}