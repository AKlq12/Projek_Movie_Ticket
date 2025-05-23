package dao;

import model.Invoice;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public Invoice getInvoiceData(int userId, int bookedId) {
        String query = "SELECT bookings.seat, bookings.no_of_tickets, bookings.booked_date, " +
                      "bookings.showtime, bookings.total_amount, booked_movie.movie_title, " +
                      "booked_movie.screen FROM bookings INNER JOIN booked_movie ON " +
                      "bookings.booked_movie_id=booked_movie.id WHERE bookings.userid = ? " +
                      "AND bookings.booked_movie_id = ?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, userId);
            pst.setInt(2, bookedId);
            
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return new Invoice(
                        rs.getString("seat"),
                        rs.getInt("no_of_tickets"),
                        rs.getDate("booked_date"),
                        rs.getString("showtime"),
                        rs.getInt("total_amount"),
                        rs.getString("movie_title"),
                        rs.getString("screen")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}