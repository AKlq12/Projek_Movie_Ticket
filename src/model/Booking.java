package model;

import java.sql.Timestamp;

public class Booking {
    private int id;
    private int movieId;
    private String movieTitle;
    private String genre;
    private String seat;
    private int totalPrice;
    private Timestamp purchasedDate;
    private Timestamp createdAt;

    // Constructor, getters, and setters
    public Booking(int id, int movieId, String movieTitle, String genre, String seat, 
                  int totalPrice, Timestamp purchasedDate, Timestamp createdAt) {
        this.id = id;
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.seat = seat;
        this.totalPrice = totalPrice;
        this.purchasedDate = purchasedDate;
        this.createdAt = createdAt;
    }

    // Getters and setters untuk semua field
    public int getId() {
        return id;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getGenre() {
        return genre;
    }

    public String getSeat() {
        return seat;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Timestamp getPurchasedDate() {
        return purchasedDate;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
}