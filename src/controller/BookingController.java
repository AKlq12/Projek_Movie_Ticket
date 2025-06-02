package controller;

import dao.BookingDAO;
import java.security.Timestamp;
import model.Booking;
import java.sql.Date;
import java.util.List;

public class BookingController {
    private BookingDAO bookingDAO;

    public BookingController() {
        this.bookingDAO = new BookingDAO();
    }

    public boolean createBooking(int userId, int movieId, String seat, int noOfTickets, 
                               Timestamp purchasedDate, Date bookedDate, int totalAmount) {
        Booking booking = new Booking();
        booking.setCustomerId(userId);
        booking.setMovieId(movieId);
        booking.setSeat(seat);
        booking.setNoOfTickets(noOfTickets);
        booking.setPurchasedDate(purchasedDate);
        booking.setBookedDate(bookedDate);
        booking.setTotalAmount(totalAmount);
        
        return bookingDAO.createBooking(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    public List<Booking> getBookingsByUserId(int userId) {
        return bookingDAO.getBookingsByUserId(userId);
    }

    public List<Booking> getBookingsByDateRange(Date startDate, Date endDate) {
        return bookingDAO.getBookingsByDateRange(startDate, endDate);
    }
}