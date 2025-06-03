package controller;

import dao.MovieDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import model.Movie;
import view.CreateMovieFrm;

public class CreateMovieController {

    private CreateMovieFrm view;
    private AdminDashboardController dashboardController;
    private MovieDAO movieDAO;

    public CreateMovieController(CreateMovieFrm view, AdminDashboardController dashboardController) {
        this.view = view;
        this.dashboardController = dashboardController;
        this.movieDAO = new MovieDAO();

        initController();
    }

    private void initController() {
        view.getCreateBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMovie();
            }
        });

        view.getBrowsePosterBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                browsePoster();
            }
        });
    }

    private void createMovie() {
        // Get all selected genres
        List<String> selectedGenres = getSelectedGenres();

        if (selectedGenres.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please select at least one genre.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create movie object
        Movie movie = new Movie();
        movie.setTitle(view.getMovieTitleTextField().getText());
        movie.setGenre(String.join(", ", selectedGenres));
        movie.setRating((Double) view.getRatingSpinner().getValue());
        movie.setContentRating(view.getContRatingCombo().getSelectedItem().toString());
        movie.setDescription(view.getDescriptionTextArea().getText());
        movie.setScreen(view.getScreenCombo().getSelectedItem().toString());

        // Ticket price handling
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
        }

        // Validate required fields
        if (movie.getTitle().isEmpty() || movie.getDescription().isEmpty() || movie.getUri().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Please fill all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (view.getjDateChooser1().getDate() == null) {
            JOptionPane.showMessageDialog(view, "Please select a date.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        movie.setDate(new java.sql.Date(view.getjDateChooser1().getDate().getTime()));

        // Get time values from spinners (timeSpinner and showtimeSpinner)
        java.util.Date timeDate = ((javax.swing.SpinnerDateModel) view.getTimeSpinner().getModel()).getDate();
        if (timeDate != null) {
            movie.setTime(new java.sql.Time(timeDate.getTime()));
        } else {
            // Default to midnight if no time is selected
            movie.setTime(new java.sql.Time(0));
        }

        java.util.Date showtimeDate = ((javax.swing.SpinnerDateModel) view.getShowtimeSpinner().getModel()).getDate();
        if (showtimeDate != null) {
            movie.setShowtime(new java.sql.Time(showtimeDate.getTime()));
        } else {
            // Default to midnight if no showtime is selected
            movie.setShowtime(new java.sql.Time(0));
        }

        // Save to database
        try {
            if (movieDAO.addMovie(movie)) {
                JOptionPane.showMessageDialog(view, "Movie created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                dashboardController.loadMovieData(); // Refresh movie list in dashboard
                view.dispose();
            } else {
                JOptionPane.showMessageDialog(view, "Failed to create movie.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error creating movie: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
