package model;

import java.sql.Timestamp;

public class Booking {
    private int id;
    private int customerId;
    private int movieId;
    private String movieTitle;
    private String genre;
    private String seat;
    private Timestamp purchasedDate;
    private int totalAmount;
    private Timestamp createdAt;

    // Constructor
    public Booking() {}
    
    public Booking(int id, int customerId, int movieId, String movieTitle, String genre, 
                   String seat, Timestamp purchasedDate, int totalAmount, Timestamp createdAt) {
        this.id = id;
        this.customerId = customerId;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.seat = seat;
        this.purchasedDate = purchasedDate;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Timestamp getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Timestamp purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}