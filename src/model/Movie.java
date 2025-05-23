package model;

import java.sql.Blob;

public class Movie {
    private int id;
    private String movieTitle;
    private String genre;
    private double rating;
    private int hour;
    private int minute;
    private String contentRating;
    private String description;
    private String screen;
    private int ticketPrice;
    private String uri;
    private Blob poster;

    // Constructors, getters, and setters
    public Movie() {}

    public Movie(int id, String movieTitle, String genre, double rating, int hour, int minute, 
                String contentRating, String description, String screen, int ticketPrice, 
                String uri, Blob poster) {
        this.id = id;
        this.movieTitle = movieTitle;
        this.genre = genre;
        this.rating = rating;
        this.hour = hour;
        this.minute = minute;
        this.contentRating = contentRating;
        this.description = description;
        this.screen = screen;
        this.ticketPrice = ticketPrice;
        this.uri = uri;
        this.poster = poster;
    }

    // Getters and setters for all fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMovieTitle() { return movieTitle; }
    public void setMovieTitle(String movieTitle) { this.movieTitle = movieTitle; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }
    public int getMinute() { return minute; }
    public void setMinute(int minute) { this.minute = minute; }
    public String getContentRating() { return contentRating; }
    public void setContentRating(String contentRating) { this.contentRating = contentRating; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getScreen() { return screen; }
    public void setScreen(String screen) { this.screen = screen; }
    public int getTicketPrice() { return ticketPrice; }
    public void setTicketPrice(int ticketPrice) { this.ticketPrice = ticketPrice; }
    public String getUri() { return uri; }
    public void setUri(String uri) { this.uri = uri; }
    public Blob getPoster() { return poster; }
    public void setPoster(Blob poster) { this.poster = poster; }
}