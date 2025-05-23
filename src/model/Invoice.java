package model;

import java.sql.Date;

public class Invoice {
    private String seat;
    private int noOfTickets;
    private Date bookedDate;
    private String showtime;
    private int totalAmount;
    private String movieTitle;
    private String screen;

    // Constructor
    public Invoice(String seat, int noOfTickets, Date bookedDate, String showtime, 
                  int totalAmount, String movieTitle, String screen) {
        this.seat = seat;
        this.noOfTickets = noOfTickets;
        this.bookedDate = bookedDate;
        this.showtime = showtime;
        this.totalAmount = totalAmount;
        this.movieTitle = movieTitle;
        this.screen = screen;
    }

    // Getters
    public String getSeat() { return seat; }
    public int getNoOfTickets() { return noOfTickets; }
    public Date getBookedDate() { return bookedDate; }
    public String getShowtime() { return showtime; }
    public int getTotalAmount() { return totalAmount; }
    public String getMovieTitle() { return movieTitle; }
    public String getScreen() { return screen; }
}