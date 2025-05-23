package dao;

import model.Booking;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {
    private Connection connection;

    public BookingDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Create a new booking
    public boolean createBooking(Booking booking) {
        String query = "INSERT INTO bookings (userid, booked_movie_id, seat, no_of_tickets, " +
                      "purchased_date, booked_date, total_amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, booking.getUserId());
            pst.setInt(2, booking.getBookedMovieId());
            pst.setString(3, booking.getSeat());
            pst.setInt(4, booking.getNoOfTickets());
            pst.setDate(5, booking.getPurchasedDate());
            pst.setDate(6, booking.getBookedDate());
            pst.setInt(7, booking.getTotalAmount());
            
            int result = pst.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT id, userid, booked_movie_id, seat, no_of_tickets, " +
                      "purchased_date, booked_date, total_amount FROM bookings";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id"),
                    rs.getInt("userid"),
                    rs.getInt("booked_movie_id"),
                    rs.getString("seat"),
                    rs.getInt("no_of_tickets"),
                    rs.getDate("purchased_date"),
                    rs.getDate("booked_date"),
                    rs.getInt("total_amount")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Get bookings by user ID
    public List<Booking> getBookingsByUserId(int userId) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT id, userid, booked_movie_id, seat, no_of_tickets, " +
                      "purchased_date, booked_date, total_amount FROM bookings WHERE userid=?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id"),
                    rs.getInt("userid"),
                    rs.getInt("booked_movie_id"),
                    rs.getString("seat"),
                    rs.getInt("no_of_tickets"),
                    rs.getDate("purchased_date"),
                    rs.getDate("booked_date"),
                    rs.getInt("total_amount")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Get bookings by date range
    public List<Booking> getBookingsByDateRange(Date startDate, Date endDate) {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT id, userid, booked_movie_id, seat, no_of_tickets, " +
                      "purchased_date, booked_date, total_amount FROM bookings " +
                      "WHERE booked_date BETWEEN ? AND ?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setDate(1, startDate);
            pst.setDate(2, endDate);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()) {
                Booking booking = new Booking(
                    rs.getInt("id"),
                    rs.getInt("userid"),
                    rs.getInt("booked_movie_id"),
                    rs.getString("seat"),
                    rs.getInt("no_of_tickets"),
                    rs.getDate("purchased_date"),
                    rs.getDate("booked_date"),
                    rs.getInt("total_amount")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}