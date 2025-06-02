package model;

import java.sql.Date;

public class Invoice {
    private int userId;
    private int bookingId;
    private String seats;
    private int noOfTickets;
    private Date bookedDate;
    private String showtime;
    private int totalAmount;
    private String movieTitle;
    private String screen;

    // Constructor
    public Invoice(int userId, int bookingId, String seats, int noOfTickets, 
                  Date bookedDate, String showtime, int totalAmount, 
                  String movieTitle, String screen) {
        this.userId = userId;
        this.bookingId = bookingId;
        this.seats = seats;
        this.noOfTickets = noOfTickets;
        this.bookedDate = bookedDate;
        this.showtime = showtime;
        this.totalAmount = totalAmount;
        this.movieTitle = movieTitle;
        this.screen = screen;
    }

    // Getters
    public int getUserId() { return userId; }
    public int getBookingId() { return bookingId; }
    public String getSeats() { return seats; }
    public int getNoOfTickets() { return noOfTickets; }
    public Date getBookedDate() { return bookedDate; }
    public String getShowtime() { return showtime; }
    public int getTotalAmount() { return totalAmount; }
    public String getMovieTitle() { return movieTitle; }
    public String getScreen() { return screen; }
}