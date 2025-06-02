package dao;

import model.Invoice;
import util.DatabaseConnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceDAO {
    private Connection connection;

    public InvoiceDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public Invoice getInvoiceData(int userId, int bookedId) {
        String query = "SELECT b.seat, b.total_amount, b.purchased_date, " +
                      "m.showtime, m.movie_title, m.screen " +
                      "FROM bookings b " +
                      "INNER JOIN movies m ON b.id_movie = m.id_movie " +
                      "WHERE b.id_customer = ? AND b.id_booking = ?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, userId);
            pst.setInt(2, bookedId);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String seats = rs.getString("seat");
                    int noOfTickets = seats.split(",").length; // Calculate tickets from seats
                    
                    return new Invoice(
                        userId,
                        bookedId,
                        seats,
                        noOfTickets,
                        rs.getDate("purchased_date"),
                        rs.getString("showtime"),
                        rs.getInt("total_amount"),
                        rs.getString("movie_title"),
                        rs.getString("screen")
                    );
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, "Error getting invoice data", e);
        }
        return null;
    }
}