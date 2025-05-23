package dao;

import model.Movie;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    private Connection connection;

    public MovieDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Add a new movie
    public boolean addMovie(Movie movie) {
        String query = "INSERT INTO movies (movie_title, genre, rating, hour, minute, content_rating, " +
                      "description, screen, ticket_price, uri, poster) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, movie.getMovieTitle());
            pst.setString(2, movie.getGenre());
            pst.setDouble(3, movie.getRating());
            pst.setInt(4, movie.getHour());
            pst.setInt(5, movie.getMinute());
            pst.setString(6, movie.getContentRating());
            pst.setString(7, movie.getDescription());
            pst.setString(8, movie.getScreen());
            pst.setInt(9, movie.getTicketPrice());
            pst.setString(10, movie.getUri());
            pst.setBlob(11, movie.getPoster());
            
            int result = pst.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update a movie
    public boolean updateMovie(Movie movie) {
        String query = "UPDATE movies SET movie_title=?, genre=?, rating=?, hour=?, minute=?, " +
                      "content_rating=?, description=?, screen=?, ticket_price=?, uri=?, poster=? WHERE id=?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setString(1, movie.getMovieTitle());
            pst.setString(2, movie.getGenre());
            pst.setDouble(3, movie.getRating());
            pst.setInt(4, movie.getHour());
            pst.setInt(5, movie.getMinute());
            pst.setString(6, movie.getContentRating());
            pst.setString(7, movie.getDescription());
            pst.setString(8, movie.getScreen());
            pst.setInt(9, movie.getTicketPrice());
            pst.setString(10, movie.getUri());
            pst.setBlob(11, movie.getPoster());
            pst.setInt(12, movie.getId());
            
            int result = pst.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT id, movie_title, genre, rating, hour, minute, content_rating, " +
                      "description, screen, ticket_price, uri, poster FROM movies";
        
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                Movie movie = new Movie(
                    rs.getInt("id"),
                    rs.getString("movie_title"),
                    rs.getString("genre"),
                    rs.getDouble("rating"),
                    rs.getInt("hour"),
                    rs.getInt("minute"),
                    rs.getString("content_rating"),
                    rs.getString("description"),
                    rs.getString("screen"),
                    rs.getInt("ticket_price"),
                    rs.getString("uri"),
                    rs.getBlob("poster")
                );
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    // Get movie by ID
    public Movie getMovieById(int id) {
        String query = "SELECT id, movie_title, genre, rating, hour, minute, content_rating, " +
                      "description, screen, ticket_price, uri, poster FROM movies WHERE id=?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return new Movie(
                    rs.getInt("id"),
                    rs.getString("movie_title"),
                    rs.getString("genre"),
                    rs.getDouble("rating"),
                    rs.getInt("hour"),
                    rs.getInt("minute"),
                    rs.getString("content_rating"),
                    rs.getString("description"),
                    rs.getString("screen"),
                    rs.getInt("ticket_price"),
                    rs.getString("uri"),
                    rs.getBlob("poster")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete a movie
    public boolean deleteMovie(int id) {
        String query = "DELETE FROM movies WHERE id=?";
        
        try (PreparedStatement pst = connection.prepareStatement(query)) {
            pst.setInt(1, id);
            int result = pst.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}