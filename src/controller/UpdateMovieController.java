package controller;

import dao.MovieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;  // For converting to java.sql.Date
import java.sql.Time;  // For handling Time objects
import java.util.Calendar;  // For date handling
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.Movie;
import view.UpdateMovieFrm;

public class UpdateMovieController {

    private UpdateMovieFrm view;
    private AdminDashboardController dashboardController;
    private MovieDAO movieDAO;
    private int movieId;

    public UpdateMovieController(UpdateMovieFrm view, AdminDashboardController dashboardController) {
        this.view = view;
        this.dashboardController = dashboardController;
        this.movieDAO = new MovieDAO();
        this.movieId = view.getId();

        initController();
    }

    private void initController() {
        view.getUpdateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMovie();
            }
        });

        view.getBrowsePosterBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browsePoster();
            }
        });
    }

    private void updateMovie() {
        // Get all selected genres
        List<String> selectedGenres = getSelectedGenres();

        if (selectedGenres.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please select at least one genre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create movie object
        Movie movie = new Movie();
        movie.setId(movieId);
        movie.setTitle(view.getMovieTitleTextField().getText());
        movie.setGenre(String.join(", ", selectedGenres));
        movie.setRating((Double) view.getRatingSpinner().getValue());
        movie.setContentRating(view.getContRatingCombo().getSelectedItem().toString());
        movie.setDescription(view.getDescriptionTextArea().getText());
        movie.setScreen(view.getScreenCombo().getSelectedItem().toString());
        // Handle null date case and convert java.util.Date to java.sql.Date
        java.util.Date selectedDate = view.getjDateChooser1().getDate();
        if (selectedDate == null) {
            selectedDate = new java.util.Date(); // Set current date if null
        }
        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime()); // Convert to java.sql.Date
        movie.setDate(sqlDate);

        // Handle timeSpinner for java.sql.Time
        java.util.Date timeUtil = (java.util.Date) view.getTimeSpinner().getValue();  // Get time from spinner
        java.sql.Time sqlTime = new java.sql.Time(timeUtil.getTime());  // Convert to java.sql.Time
        movie.setTime(sqlTime);

        // Handle showtimeSpinner for java.sql.Time
        java.util.Date showtimeUtil = (java.util.Date) view.getShotimeSpinner().getValue();  // Get showtime from spinner
        java.sql.Time sqlShowtime = new java.sql.Time(showtimeUtil.getTime());  // Convert to java.sql.Time
        movie.setShowtime(sqlShowtime);

        try {
            movie.setTicketPrice(Integer.parseInt(view.getTckPrcTextField().getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Please enter a valid ticket price.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        movie.setUri(view.getUriTextField().getText());

        // Set poster if available
        if (view.getPoster() != null) {
            movie.setPoster(view.getPoster());
        } else if (view.getPosterBytes() != null) {
            // Keep existing poster if no new one was selected
            movie.setPoster(view.getPosterBytes());
        }

        // Validate required fields
        if (movie.getTitle().isEmpty() || movie.getDescription().isEmpty() || movie.getUri().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Update in database
        try {
            if (movieDAO.updateMovie(movie)) {
                JOptionPane.showMessageDialog(view, "Movie updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dashboardController.loadMovieData(); // Refresh movie list in dashboard
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Failed to update movie.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error updating movie: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<String> getSelectedGenres() {
        List<String> genres = new ArrayList<>();
        JCheckBox[] genreCheckboxes = {
            view.getAdventureCheckBox(),
            view.getActionCheckBox(),
            view.getMysteryCheckBox(),
            view.getAnimationCheckBox(),
            view.getCrimeCheckBox(),
            view.getComedyCheckBox(),
            view.getHorrorCheckBox(),
            view.getThrillerCheckBox(),
            view.getFantasyCheckBox(),
            view.getDramaCheckBox()
        };

        for (JCheckBox checkbox : genreCheckboxes) {
            if (checkbox.isSelected()) {
                genres.add(checkbox.getText());
            }
        }

        return genres;
    }

    private void browsePoster() {
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        int returnValue = fileChooser.showOpenDialog(view);

        if (returnValue == javax.swing.JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            view.getPosterImgPath().setText(selectedFile.getAbsolutePath());

            try (FileInputStream fis = new FileInputStream(selectedFile)) {
                byte[] posterData = new byte[(int) selectedFile.length()];
                fis.read(posterData);
                view.setPoster(posterData);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(view, "Error reading image file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
