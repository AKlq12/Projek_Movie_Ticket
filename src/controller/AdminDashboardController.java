package controller;

import dao.BookingDAO;
import dao.MovieDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Booking;
import model.Movie;
import view.AdminDashboard;
import view.CreateMovieFrm;
import view.UpdateMovieFrm;

public class AdminDashboardController {
    private AdminDashboard view;
    private MovieDAO movieDAO;
    private BookingDAO bookingDAO;

    public AdminDashboardController(AdminDashboard view) {
        this.view = view;
        this.movieDAO = new MovieDAO();
        this.bookingDAO = new BookingDAO();
        
        initController();
        loadMovieData();
    }

    private void initController() {
        // Add action listeners
        view.getManagemovieBtn().addActionListener(e -> showMoviePanel());
        view.getViewbookingsBtn().addActionListener(e -> showBookingPanel());
        view.getLogoutBtn().addActionListener(e -> logout());
        view.getCreateBtn().addActionListener(e -> openCreateMovieForm());
        view.getEditBtn().addActionListener(e -> openUpdateMovieForm());
        view.getViewInvoice().addActionListener(e -> viewInvoice());
        
        // Add table selection listener
        view.getMovieTable().getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                view.getEditBtn().setEnabled(view.getMovieTable().getSelectedRow() != -1);
            }
        });
        
        // Add search functionality
        view.getSearchTextField().addActionListener(e -> searchBookings());
    }

    private void showMoviePanel() {
        view.getManageMoviePanel().setVisible(true);
        view.getViewBookingPanel().setVisible(false);
        loadMovieData();
    }

    private void showBookingPanel() {
        view.getManageMoviePanel().setVisible(false);
        view.getViewBookingPanel().setVisible(true);
        loadBookingData();
    }

    private void logout() {
        view.dispose();
        // You would typically open a login window here
        // new LoginForm().setVisible(true);
        JOptionPane.showMessageDialog(view, "Logged out successfully!");
    }

    private void openCreateMovieForm() {
        CreateMovieFrm createMovieFrm = new CreateMovieFrm();
        new CreateMovieController(createMovieFrm, this);
        createMovieFrm.setVisible(true);
    }

    private void openUpdateMovieForm() {
        int selectedRow = view.getMovieTable().getSelectedRow();
        if (selectedRow >= 0) {
            int movieId = (int) view.getMovieTable().getValueAt(selectedRow, 0);
            UpdateMovieFrm updateMovieFrm = new UpdateMovieFrm(movieId);
            new UpdateMovieController(updateMovieFrm, this);
            updateMovieFrm.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(view, "Please select a movie to edit.");
        }
    }

    private void viewInvoice() {
        int selectedRow = view.getViewBookingsTable().getSelectedRow();
        if (selectedRow >= 0) {
            int bookingId = (int) view.getViewBookingsTable().getValueAt(selectedRow, 0);
            // Implement invoice viewing logic here
            JOptionPane.showMessageDialog(view, "Viewing invoice for booking ID: " + bookingId);
        } else {
            JOptionPane.showMessageDialog(view, "Please select a booking to view invoice.");
        }
    }

    private void searchBookings() {
        String searchTerm = view.getSearchTextField().getText();
        List<Booking> bookings = bookingDAO.searchBookings(searchTerm);
        populateBookingTable(bookings);
    }

    public void loadMovieData() {
        List<Movie> movies = movieDAO.getAllMovies();
        populateMovieTable(movies);
    }

    public void loadBookingData() {
        List<Booking> bookings = bookingDAO.getAllBookings();
        populateBookingTable(bookings);
    }

    private void populateMovieTable(List<Movie> movies) {
        DefaultTableModel model = (DefaultTableModel) view.getMovieTable().getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Movie movie : movies) {
            Object[] row = {
                movie.getId(),
                movie.getTitle(),
                movie.getGenre(),
                movie.getRating(),
                movie.getDate(),
                movie.getTime(),
                movie.getShowtime(),
                movie.getContentRating(),
                movie.getScreen(),
                movie.getTicketPrice()
            };
            model.addRow(row);
        }
    }

    private void populateBookingTable(List<Booking> bookings) {
        DefaultTableModel model = (DefaultTableModel) view.getViewBookingsTable().getModel();
        model.setRowCount(0); // Clear existing data
        
        for (Booking booking : bookings) {
            Object[] row = {
                booking.getId(),
                booking.getCustomerId(),
                booking.getMovieId(),
                booking.getMovieTitle(),
                booking.getGenre(),
                booking.getSeat(),
                booking.getPurchasedDate(),
                booking.getTotalAmount(),
                booking.getCreatedAt()
            };
            model.addRow(row);
        }
    }
}