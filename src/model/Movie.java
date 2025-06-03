package model;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private double rating;
    private Date date;  // java.sql.Date
    private Time time;  // java.sql.Time
    private Time showtime;  // java.sql.Time
    private String contentRating;
    private String description;
    private String screen;
    private int ticketPrice;
    private String uri;
    private byte[] poster;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Constructor
    public Movie() {}
    
    public Movie(int id, String title, String genre, double rating, Date date, Time time, 
                 Time showtime, String contentRating, String description, String screen, 
                 int ticketPrice, String uri, byte[] poster, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.date = date;
        this.time = time;
        this.showtime = showtime;
        this.contentRating = contentRating;
        this.description = description;
        this.screen = screen;
        this.ticketPrice = ticketPrice;
        this.uri = uri;
        this.poster = poster;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Time getShowtime() {
        return showtime;
    }

    public void setShowtime(Time showtime) {
        this.showtime = showtime;
    }

    public String getContentRating() {
        return contentRating;
    }

    public void setContentRating(String contentRating) {
        this.contentRating = contentRating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}