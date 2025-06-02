package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Movie;
import util.DatabaseConnection;

public class MovieDAO {
    private Connection connection;

    public MovieDAO() {
        connection = DatabaseConnection.getConnection();
    }

    // Get all movies
    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM movies";
        
        try (PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id_movie"));
                movie.setTitle(rs.getString("movie_title"));
                movie.setGenre(rs.getString("genre"));
                movie.setRating(rs.getDouble("rating"));
                movie.setDate(rs.getString("date"));
                movie.setTime(rs.getString("time"));
                movie.setShowtime(rs.getString("showtime"));
                movie.setContentRating(rs.getString("content_rating"));
                movie.setDescription(rs.getString("description"));
                movie.setScreen(rs.getString("screen"));
                movie.setTicketPrice(rs.getInt("ticket_price"));
                movie.setUri(rs.getString("uri"));
                movie.setPoster(rs.getBytes("poster"));
                movie.setCreatedAt(rs.getTimestamp("created_at"));
                movie.setUpdatedAt(rs.getTimestamp("updated_at"));
                
                movies.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movies;
    }

    // Add a new movie
    public boolean addMovie(Movie movie) {
        String query = "INSERT INTO movies (movie_title, genre, rating, date, time, showtime, " +
                       "content_rating, description, screen, ticket_price, uri, poster) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setDouble(3, movie.getRating());
            ps.setString(4, movie.getDate());
            ps.setString(5, movie.getTime());
            ps.setString(6, movie.getShowtime());
            ps.setString(7, movie.getContentRating());
            ps.setString(8, movie.getDescription());
            ps.setString(9, movie.getScreen());
            ps.setInt(10, movie.getTicketPrice());
            ps.setString(11, movie.getUri());
            ps.setBytes(12, movie.getPoster());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update a movie
    public boolean updateMovie(Movie movie) {
        String query = "UPDATE movies SET movie_title=?, genre=?, rating=?, date=?, time=?, " +
                       "showtime=?, content_rating=?, description=?, screen=?, ticket_price=?, " +
                       "uri=?, poster=?, updated_at=CURRENT_TIMESTAMP WHERE id_movie=?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getGenre());
            ps.setDouble(3, movie.getRating());
            ps.setString(4, movie.getDate());
            ps.setString(5, movie.getTime());
            ps.setString(6, movie.getShowtime());
            ps.setString(7, movie.getContentRating());
            ps.setString(8, movie.getDescription());
            ps.setString(9, movie.getScreen());
            ps.setInt(10, movie.getTicketPrice());
            ps.setString(11, movie.getUri());
            ps.setBytes(12, movie.getPoster());
            ps.setInt(13, movie.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a movie
    public boolean deleteMovie(int movieId) {
        String query = "DELETE FROM movies WHERE id_movie=?";
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, movieId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get movie by ID
    public Movie getMovieById(int movieId) {
        String query = "SELECT * FROM movies WHERE id_movie=?";
        Movie movie = null;
        
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, movieId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id_movie"));
                movie.setTitle(rs.getString("movie_title"));
                movie.setGenre(rs.getString("genre"));
                movie.setRating(rs.getDouble("rating"));
                movie.setDate(rs.getString("date"));
                movie.setTime(rs.getString("time"));
                movie.setShowtime(rs.getString("showtime"));
                movie.setContentRating(rs.getString("content_rating"));
                movie.setDescription(rs.getString("description"));
                movie.setScreen(rs.getString("screen"));
                movie.setTicketPrice(rs.getInt("ticket_price"));
                movie.setUri(rs.getString("uri"));
                movie.setPoster(rs.getBytes("poster"));
                movie.setCreatedAt(rs.getTimestamp("created_at"));
                movie.setUpdatedAt(rs.getTimestamp("updated_at"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }
}