package controller;

import dao.MovieDAO;
import model.Movie;
import java.sql.Blob;
import java.util.List;

public class MovieController {
    private MovieDAO movieDAO;

    public MovieController() {
        this.movieDAO = new MovieDAO();
    }

    public boolean addMovie(String title, String genre, double rating, String date, String time, String showtime,
                            String contentRating, String description, String screen, 
                            int ticketPrice, String uri, Blob poster) {
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setRating(rating);
        movie.setDate(date);
        movie.setTime(time);
        movie.setShowtime(showtime);
        movie.setContentRating(contentRating);
        movie.setDescription(description);
        movie.setScreen(screen);
        movie.setTicketPrice(ticketPrice);
        movie.setUri(uri);
        
        return movieDAO.addMovie(movie);
    }

    public boolean updateMovie(int id, String title, String genre, double rating, String date, String time, String showtime
                            , String contentRating, String description, 
                             String screen, int ticketPrice, String uri, Blob poster) {
        Movie movie = new Movie();
        movie.setId(id);
        movie.setTitle(title);
        movie.setGenre(genre);
        movie.setRating(rating);
        movie.setDate(date);
        movie.setTime(time);
        movie.setShowtime(showtime);
        movie.setContentRating(contentRating);
        movie.setDescription(description);
        movie.setScreen(screen);
        movie.setTicketPrice(ticketPrice);
        movie.setUri(uri);
        
        return movieDAO.updateMovie(movie);
    }

    public List<Movie> getAllMovies() {
        return movieDAO.getAllMovies();
    }

    public Movie getMovieById(int id) {
        return movieDAO.getMovieById(id);
    }

    public boolean deleteMovie(int id) {
        return movieDAO.deleteMovie(id);
    }
}