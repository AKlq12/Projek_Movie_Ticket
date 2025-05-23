package model;

import java.sql.Date;

public class Booking {
    private int id;
    private int userId;
    private int bookedMovieId;
    private String seat;
    private int noOfTickets;
    private Date purchasedDate;
    private Date bookedDate;
    private int totalAmount;
    
    // Constructors, getters, and setters
    public Booking() {}

    public Booking(int id, int userId, int bookedMovieId, String seat, int noOfTickets, 
                 Date purchasedDate, Date bookedDate, int totalAmount) {
        this.id = id;
        this.userId = userId;
        this.bookedMovieId = bookedMovieId;
        this.seat = seat;
        this.noOfTickets = noOfTickets;
        this.purchasedDate = purchasedDate;
        this.bookedDate = bookedDate;
        this.totalAmount = totalAmount;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    public int getBookedMovieId() { return bookedMovieId; }
    public void setBookedMovieId(int bookedMovieId) { this.bookedMovieId = bookedMovieId; }
    public String getSeat() { return seat; }
    public void setSeat(String seat) { this.seat = seat; }
    public int getNoOfTickets() { return noOfTickets; }
    public void setNoOfTickets(int noOfTickets) { this.noOfTickets = noOfTickets; }
    public Date getPurchasedDate() { return purchasedDate; }
    public void setPurchasedDate(Date purchasedDate) { this.purchasedDate = purchasedDate; }
    public Date getBookedDate() { return bookedDate; }
    public void setBookedDate(Date bookedDate) { this.bookedDate = bookedDate; }
    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }
}