package controller;

import dao.BookingDAO;
import java.sql.Timestamp;
import model.Booking;
import java.sql.Date;
import java.util.List;

public class BookingController {
    private BookingDAO bookingDAO;

    public BookingController() {
        this.bookingDAO = new BookingDAO();
    }

    public boolean createBooking(int bookingid, int userId, int movieId, String title, String genre, String seat, 
                                int totalAmount) {
        Booking booking = new Booking();
        booking.setId(bookingid);
        booking.setCustomerId(userId);
        booking.setMovieId(movieId);
        booking.setMovieTitle(title);
        booking.setGenre(genre);
        booking.setSeat(seat);
        booking.setTotalAmount(totalAmount);
        
        return bookingDAO.createBooking(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }
}