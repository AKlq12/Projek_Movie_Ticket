package view;

import controller.CreateMovieController;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import util.DatabaseConnection;

/**
 *
 * @author nadinCodeHat
 */
public class CreateMovieFrm extends javax.swing.JFrame {

    public CreateMovieFrm() {
        initComponents();  // Add this line
        loadFrameImage();
    }

    int id;

    public CreateMovieFrm(int id) {
        initComponents();
        this.id = id;
        loadEditData();
        loadFrameImage();
    }

    public void loadFrameImage() {
        try {
            setIconImage(ImageIO.read(new File("logo.png")));
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(CreateMovieFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainPanel = new javax.swing.JPanel();
        editLabel = new javax.swing.JLabel();
        movieTitleLabel = new javax.swing.JLabel();
        movieTitleTextField = new javax.swing.JTextField();
        genrePanel = new javax.swing.JPanel();
        dramaCheckBox = new javax.swing.JCheckBox();
        adventureCheckBox = new javax.swing.JCheckBox();
        actionCheckBox = new javax.swing.JCheckBox();
        thrillerCheckBox = new javax.swing.JCheckBox();
        fantasyCheckBox = new javax.swing.JCheckBox();
        crimeCheckBox = new javax.swing.JCheckBox();
        horrorCheckBox = new javax.swing.JCheckBox();
        mysteryCheckBox = new javax.swing.JCheckBox();
        comedyCheckBox = new javax.swing.JCheckBox();
        animationCheckBox = new javax.swing.JCheckBox();
        ratingsPanel = new javax.swing.JPanel();
        contentRatingLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        ratingSpinner = new javax.swing.JSpinner();
        contRatingCombo = new javax.swing.JComboBox<>();
        runtimePanel = new javax.swing.JPanel();
        hoursLabel = new javax.swing.JLabel();
        hourSpinner = new javax.swing.JSpinner();
        minutesLabel = new javax.swing.JLabel();
        minuteSpinner = new javax.swing.JSpinner();
        descriptionPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        ticketPricesPanel = new javax.swing.JPanel();
        tckPrcLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tckPrcTextField = new javax.swing.JTextField();
        theaterLabel = new javax.swing.JLabel();
        screenCombo = new javax.swing.JComboBox<>();
        posterImgPath = new javax.swing.JTextField();
        browsePosterBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        uriTextField = new javax.swing.JTextField();
        uriLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Movie");
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        editLabel.setForeground(new java.awt.Color(51, 102, 255));
        editLabel.setText("Create movie");
        mainPanel.add(editLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        movieTitleLabel.setText("Movie Title");
        mainPanel.add(movieTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));
        mainPanel.add(movieTitleTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 348, 30));

        genrePanel.setBackground(new java.awt.Color(255, 255, 255));
        genrePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Genre", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        dramaCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        dramaCheckBox.setText("Drama");
        dramaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dramaCheckBoxActionPerformed(evt);
            }
        });

        adventureCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        adventureCheckBox.setText("Adventure");
        adventureCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adventureCheckBoxActionPerformed(evt);
            }
        });

        actionCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        actionCheckBox.setText("Action");
        actionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionCheckBoxActionPerformed(evt);
            }
        });

        thrillerCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        thrillerCheckBox.setText("Thriller");
        thrillerCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thrillerCheckBoxActionPerformed(evt);
            }
        });

        fantasyCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        fantasyCheckBox.setText("Fantasy");
        fantasyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fantasyCheckBoxActionPerformed(evt);
            }
        });

        crimeCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        crimeCheckBox.setText("Crime");
        crimeCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crimeCheckBoxActionPerformed(evt);
            }
        });

        horrorCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        horrorCheckBox.setText("Horror");
        horrorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horrorCheckBoxActionPerformed(evt);
            }
        });

        mysteryCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        mysteryCheckBox.setText("Mystery");
        mysteryCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mysteryCheckBoxActionPerformed(evt);
            }
        });

        comedyCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        comedyCheckBox.setText("Comedy");
        comedyCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comedyCheckBoxActionPerformed(evt);
            }
        });

        animationCheckBox.setBackground(new java.awt.Color(255, 255, 255));
        animationCheckBox.setText("Animation");
        animationCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout genrePanelLayout = new javax.swing.GroupLayout(genrePanel);
        genrePanel.setLayout(genrePanelLayout);
        genrePanelLayout.setHorizontalGroup(
            genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genrePanelLayout.createSequentialGroup()
                        .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(genrePanelLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(thrillerCheckBox))
                            .addComponent(adventureCheckBox)
                            .addGroup(genrePanelLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(mysteryCheckBox))
                            .addGroup(genrePanelLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(actionCheckBox)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fantasyCheckBox))
                    .addGroup(genrePanelLayout.createSequentialGroup()
                        .addComponent(comedyCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(horrorCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(genrePanelLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(crimeCheckBox))
                            .addComponent(animationCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dramaCheckBox)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        genrePanelLayout.setVerticalGroup(
            genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genrePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thrillerCheckBox)
                    .addComponent(adventureCheckBox)
                    .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mysteryCheckBox)
                        .addComponent(fantasyCheckBox))
                    .addComponent(actionCheckBox))
                .addGap(5, 5, 5)
                .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(crimeCheckBox)
                        .addComponent(dramaCheckBox))
                    .addComponent(comedyCheckBox)
                    .addGroup(genrePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(animationCheckBox)
                        .addComponent(horrorCheckBox)))
                .addContainerGap())
        );

        mainPanel.add(genrePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 350, -1));

        ratingsPanel.setBackground(new java.awt.Color(255, 255, 255));
        ratingsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ratings", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        contentRatingLabel.setText("Content Rating");

        ratingLabel.setText("Rating");

        ratingSpinner.setModel(new javax.swing.SpinnerNumberModel(1.0d, 1.0d, 10.0d, 1.0d));

        contRatingCombo.setBackground(new java.awt.Color(36, 34, 54));
        contRatingCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G", "PG", "PG-13", "R", "NC-17" }));

        javax.swing.GroupLayout ratingsPanelLayout = new javax.swing.GroupLayout(ratingsPanel);
        ratingsPanel.setLayout(ratingsPanelLayout);
        ratingsPanelLayout.setHorizontalGroup(
            ratingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ratingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ratingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ratingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ratingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentRatingLabel)
                    .addComponent(contRatingCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ratingsPanelLayout.setVerticalGroup(
            ratingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ratingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ratingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ratingsPanelLayout.createSequentialGroup()
                        .addGroup(ratingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(contentRatingLabel)
                            .addComponent(ratingLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contRatingCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ratingsPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(ratingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        mainPanel.add(ratingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 160, 90));

        runtimePanel.setBackground(new java.awt.Color(255, 255, 255));
        runtimePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Runtime", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        hoursLabel.setText("Hours:");

        hourSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 4, 1));

        minutesLabel.setText("Minutes:");

        minuteSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        javax.swing.GroupLayout runtimePanelLayout = new javax.swing.GroupLayout(runtimePanel);
        runtimePanel.setLayout(runtimePanelLayout);
        runtimePanelLayout.setHorizontalGroup(
            runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(runtimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hoursLabel)
                    .addComponent(hourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(minutesLabel)
                    .addComponent(minuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        runtimePanelLayout.setVerticalGroup(
            runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(runtimePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursLabel)
                    .addComponent(minutesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(runtimePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        mainPanel.add(runtimePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 160, -1));

        descriptionPanel.setBackground(new java.awt.Color(255, 255, 255));
        descriptionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descriptionTextArea);

        javax.swing.GroupLayout descriptionPanelLayout = new javax.swing.GroupLayout(descriptionPanel);
        descriptionPanel.setLayout(descriptionPanelLayout);
        descriptionPanelLayout.setHorizontalGroup(
            descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
        );
        descriptionPanelLayout.setVerticalGroup(
            descriptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        mainPanel.add(descriptionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 350, -1));

        ticketPricesPanel.setBackground(new java.awt.Color(255, 255, 255));
        ticketPricesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ticket Price", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        tckPrcLabel.setText("Set price :");

        jLabel10.setText("Rs.");

        tckPrcTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tckPrcTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout ticketPricesPanelLayout = new javax.swing.GroupLayout(ticketPricesPanel);
        ticketPricesPanel.setLayout(ticketPricesPanelLayout);
        ticketPricesPanelLayout.setHorizontalGroup(
            ticketPricesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketPricesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tckPrcLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tckPrcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        ticketPricesPanelLayout.setVerticalGroup(
            ticketPricesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ticketPricesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ticketPricesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tckPrcLabel)
                    .addComponent(jLabel10)
                    .addComponent(tckPrcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        mainPanel.add(ticketPricesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 160, 70));

        theaterLabel.setText("Screens");
        mainPanel.add(theaterLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        screenCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Screen 1", "Screen 2", "Screen 3" }));
        mainPanel.add(screenCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 110, -1));

        posterImgPath.setEditable(false);
        posterImgPath.setForeground(new java.awt.Color(0, 51, 204));
        mainPanel.add(posterImgPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 240, -1));

        browsePosterBtn.setText("Browse poster");
        browsePosterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browsePosterBtnActionPerformed(evt);
            }
        });
        mainPanel.add(browsePosterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 520, -1, -1));

        createBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/createBtn.png"))); // NOI18N
        createBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createBtnMouseExited(evt);
            }
        });
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        mainPanel.add(createBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 610, 80, 30));
        mainPanel.add(uriTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 270, -1));

        uriLabel.setText("Youtube URI:");
        mainPanel.add(uriLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, -1, -1));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    byte[] posterBytes = null;

    public void loadEditData() {
        //Retrieve data
        String query = "SELECT movie_title, genre, rating, hour, minute, content_rating, description, screen, ticket_price, uri, poster FROM `movies` WHERE id = '" + id + "'";
        String movietitle = null;
        String genre = null;
        Double rating = 0.0;
        int hour = 0;
        int minute = 0;
        String contentRating = null;
        String description = null;
        String screen = null;
        String ticketPrice = null;
        String uri = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = DatabaseConnection.getConnection().prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                movietitle = rs.getString("movie_title");
                genre = rs.getString("genre");
                rating = rs.getDouble("rating");
                hour = rs.getInt("hour");
                minute = rs.getInt("minute");
                contentRating = rs.getString("content_rating");
                description = rs.getString("description");
                screen = rs.getString("screen");
                ticketPrice = String.valueOf(rs.getInt("ticket_price"));
                uri = rs.getString("uri");
                posterBytes = rs.getBytes("poster");
            }
            pst.close();
            rs.close();
            DatabaseConnection.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(CreateMovieFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

        movieTitleTextField.setText(movietitle);
        ratingSpinner.setValue(rating);
        hourSpinner.setValue(hour);
        minuteSpinner.setValue(minute);
        contRatingCombo.setSelectedItem(contentRating);
        List<String> listGenre = Arrays.asList(genre.split(","));

        listGenre.forEach((String gen) -> {
            switch (gen) {
                case "Adventure":
                    adventureCheckBox.setSelected(true);
                case "Action":
                    actionCheckBox.setSelected(true);
                case "Mystery":
                    mysteryCheckBox.setSelected(true);
                case "Animation":
                    animationCheckBox.setSelected(true);
                case "Crime":
                    crimeCheckBox.setSelected(true);
                case "Comedy":
                    comedyCheckBox.setSelected(true);
                case "Horror":
                    horrorCheckBox.setSelected(true);
                case "Thriller":
                    thrillerCheckBox.setSelected(true);
                case "Fantasy":
                    fantasyCheckBox.setSelected(true);
                case "Drama":
                    dramaCheckBox.setSelected(true);
                default: {
                }
            }
        });
        descriptionTextArea.setText(description);
        screenCombo.setSelectedItem(screen);
        tckPrcTextField.setText(ticketPrice);
        uriTextField.setText(uri);
        if (posterBytes != null) {
            posterImgPath.setText("Poster already saved.");
        }
    }

    ArrayList<String> genreList = new ArrayList<>();
    String str;

    private void checkAdventureCheckBox() {
        if (adventureCheckBox.isSelected()) {
            genreList.add("Adventure");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Adventure");
            str = String.join(",", genreList);
        }
    }

    private void checkActionCheckBox() {
        if (actionCheckBox.isSelected()) {
            genreList.add("Action");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Action");
            str = String.join(",", genreList);
        }
    }

    private void checkMysteryCheckBox() {
        if (mysteryCheckBox.isSelected()) {
            genreList.add("Mystery");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Mystery");
            str = String.join(",", genreList);
        }
    }

    private void checkAnimationCheckBox() {
        if (animationCheckBox.isSelected()) {
            genreList.add("Animation");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Animation");
            str = String.join(",", genreList);
        }
    }

    private void checkCrimeCheckBox() {
        if (crimeCheckBox.isSelected()) {
            genreList.add("Crime");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Crime");
            str = String.join(",", genreList);
        }
    }

    private void checkComedyCheckBox() {
        if (comedyCheckBox.isSelected()) {
            genreList.add("Comedy");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Comedy");
            str = String.join(",", genreList);
        }
    }

    private void checkHorrorCheckBox() {
        if (horrorCheckBox.isSelected()) {
            genreList.add("Horror");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Horror");
            str = String.join(",", genreList);
        }
    }

    private void checkThrillerCheckBox() {
        if (thrillerCheckBox.isSelected()) {
            genreList.add("Thriller");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Thriller");
            str = String.join(",", genreList);
        }
    }

    private void checkFantasyCheckBox() {
        if (fantasyCheckBox.isSelected()) {
            genreList.add("Fantasy");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Fantasy");
            str = String.join(",", genreList);
        }
    }

    private void checkDramaCheckBox() {
        if (dramaCheckBox.isSelected()) {
            genreList.add("Drama");
            str = String.join(",", genreList);
        } else {
            genreList.remove("Drama");
            str = String.join(",", genreList);
        }
    }

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        checkAdventureCheckBox();
        checkActionCheckBox();
        checkMysteryCheckBox();
        checkAnimationCheckBox();
        checkCrimeCheckBox();
        checkComedyCheckBox();
        checkHorrorCheckBox();
        checkThrillerCheckBox();
        checkFantasyCheckBox();
        checkDramaCheckBox();

        // Collecting form data
        String movie_title = movieTitleTextField.getText();
        String genre = "";  // Initialize genre as an empty string
        Double rating = (Double) ratingSpinner.getValue();
        Integer hour = (Integer) hourSpinner.getValue();
        Integer minute = (Integer) minuteSpinner.getValue();
        String contentRating = contRatingCombo.getSelectedItem().toString();
        String description = descriptionTextArea.getText();
        String screen = screenCombo.getSelectedItem().toString();
        Integer ticketPrice = Integer.parseInt(tckPrcTextField.getText());
        String uri = uriTextField.getText();
        PreparedStatement pst = null;

        StringBuilder genreBuilder = new StringBuilder();

        if (adventureCheckBox.isSelected()) {
            genreBuilder.append("Adventure, ");
        }
        if (actionCheckBox.isSelected()) {
            genreBuilder.append("Action, ");
        }
        if (mysteryCheckBox.isSelected()) {
            genreBuilder.append("Mystery, ");
        }
        if (animationCheckBox.isSelected()) {
            genreBuilder.append("Animation, ");
        }
        if (crimeCheckBox.isSelected()) {
            genreBuilder.append("Crime, ");
        }
        if (comedyCheckBox.isSelected()) {
            genreBuilder.append("Comedy, ");
        }
        if (horrorCheckBox.isSelected()) {
            genreBuilder.append("Horror, ");
        }
        if (thrillerCheckBox.isSelected()) {
            genreBuilder.append("Thriller, ");
        }
        if (fantasyCheckBox.isSelected()) {
            genreBuilder.append("Fantasy, ");
        }
        if (dramaCheckBox.isSelected()) {
            genreBuilder.append("Drama, ");
        }

        // Remove the trailing comma and space
        if (genreBuilder.length() > 0) {
            genre = genreBuilder.substring(0, genreBuilder.length() - 2); // Remove last ", "
        }

        if (checkEmptyFields()) {
            // Insert new movie into the database
            String insertMovieQuery = "INSERT INTO movies (movie_title, genre, rating, hour, minute, content_rating, description, screen, ticket_price, uri, poster) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try {
                pst = DatabaseConnection.getConnection().prepareStatement(insertMovieQuery);
                pst.setString(1, movie_title);
                pst.setString(2, genre);
                pst.setDouble(3, rating);
                pst.setInt(4, hour);
                pst.setInt(5, minute);
                pst.setString(6, contentRating);
                pst.setString(7, description);
                pst.setString(8, screen);
                pst.setInt(9, ticketPrice);
                pst.setString(10, uri);
                if (posterBytes != null && poster != null) {
                    pst.setBytes(11, poster);
                }

                pst.executeUpdate();
                pst.close();
                DatabaseConnection.getConnection().close();

                // Show success message
                JOptionPane.showMessageDialog(null, "Movie created successfully!");

                // Return to AdminMainFrm
                this.setVisible(false);  // Hide current form
                AdminDashboard adminMainFrm = new AdminDashboard();
                adminMainFrm.setVisible(true);  // Show AdminMainFrm

            } catch (SQLException ex) {
                Logger.getLogger(CreateMovieFrm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_createBtnActionPerformed

    private boolean checkEmptyFields() {
        String movie_title = movieTitleTextField.getText();
        String description = descriptionTextArea.getText();
        String ticketPrice = tckPrcTextField.getText();
        String uri = uriTextField.getText();

        // Check for empty fields
        if (movie_title.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a movie title.", "Empty Field", 2);
            return false;
        }
        if (genreList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please provide at least (one) genre.", "Empty genre", 2);
            return false;
        }
        if (description.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please provide a movie description.", "Empty Field", 2);
            return false;
        }
        if (ticketPrice.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter a price for ticket.", "Empty Field", 2);
            return false;
        }
        if (uri.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the youtube uri.", "Empty Field", 2);
            return false;
        }
        return true;
    }

    private void createBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBtnMouseEntered
        try {
            Image updateBtnImgHover = ImageIO.read(getClass().getResource("/movie/ticketbooking/system/assets/components/updateBtnHover.png"));
            createBtn.setIcon(new ImageIcon(updateBtnImgHover));
        } catch (IOException ex) {
            Logger.getLogger(CreateMovieFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createBtnMouseEntered

    private void createBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createBtnMouseExited
        try {
            Image updateBtnImg = ImageIO.read(getClass().getResource("/movie/ticketbooking/system/assets/components/updateBtn.png"));
            createBtn.setIcon(new ImageIcon(updateBtnImg));
        } catch (IOException ex) {
            Logger.getLogger(CreateMovieFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createBtnMouseExited

    byte[] poster = null;
    private void browsePosterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsePosterBtnActionPerformed
        JFileChooser browseImageFile = new JFileChooser();
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            FileInputStream fis = null;
            try {
                File selectedImageFile = browseImageFile.getSelectedFile();
                String selectedImagePath = selectedImageFile.getAbsolutePath();
                posterImgPath.setText(selectedImagePath);
                //set to poster for sql insert
                fis = new FileInputStream(selectedImagePath);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                for (int readnum; (readnum = fis.read(buf)) != -1;) {
                    baos.write(buf, 0, readnum);
                }
                poster = baos.toByteArray();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_browsePosterBtnActionPerformed

    private void adventureCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adventureCheckBoxActionPerformed
        checkAdventureCheckBox();
    }//GEN-LAST:event_adventureCheckBoxActionPerformed

    private void actionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionCheckBoxActionPerformed
        checkActionCheckBox();
    }//GEN-LAST:event_actionCheckBoxActionPerformed

    private void thrillerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thrillerCheckBoxActionPerformed
        checkThrillerCheckBox();
    }//GEN-LAST:event_thrillerCheckBoxActionPerformed

    private void mysteryCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mysteryCheckBoxActionPerformed
        checkMysteryCheckBox();
    }//GEN-LAST:event_mysteryCheckBoxActionPerformed

    private void fantasyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fantasyCheckBoxActionPerformed
        checkFantasyCheckBox();
    }//GEN-LAST:event_fantasyCheckBoxActionPerformed

    private void comedyCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comedyCheckBoxActionPerformed
        checkComedyCheckBox();
    }//GEN-LAST:event_comedyCheckBoxActionPerformed

    private void horrorCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horrorCheckBoxActionPerformed
        checkHorrorCheckBox();
    }//GEN-LAST:event_horrorCheckBoxActionPerformed

    private void animationCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_animationCheckBoxActionPerformed
        checkAnimationCheckBox();
    }//GEN-LAST:event_animationCheckBoxActionPerformed

    private void crimeCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crimeCheckBoxActionPerformed
        checkCrimeCheckBox();
    }//GEN-LAST:event_crimeCheckBoxActionPerformed

    private void dramaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dramaCheckBoxActionPerformed
        checkDramaCheckBox();
    }//GEN-LAST:event_dramaCheckBoxActionPerformed

    private void tckPrcTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tckPrcTextFieldKeyPressed
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' && tckPrcTextField.getText().length() < 4 || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            tckPrcTextField.setEditable(true);
        } else {
            tckPrcTextField.setEditable(false);
        }
    }//GEN-LAST:event_tckPrcTextFieldKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            CreateMovieFrm view = new CreateMovieFrm();
            new CreateMovieController(view, null);
            view.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox actionCheckBox;
    private javax.swing.JCheckBox adventureCheckBox;
    private javax.swing.JCheckBox animationCheckBox;
    private javax.swing.JButton browsePosterBtn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox comedyCheckBox;
    private javax.swing.JComboBox<String> contRatingCombo;
    private javax.swing.JLabel contentRatingLabel;
    private javax.swing.JButton createBtn;
    private javax.swing.JCheckBox crimeCheckBox;
    private javax.swing.JPanel descriptionPanel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JCheckBox dramaCheckBox;
    private javax.swing.JLabel editLabel;
    private javax.swing.JCheckBox fantasyCheckBox;
    private javax.swing.JPanel genrePanel;
    private javax.swing.JCheckBox horrorCheckBox;
    private javax.swing.JSpinner hourSpinner;
    private javax.swing.JLabel hoursLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JSpinner minuteSpinner;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel movieTitleLabel;
    private javax.swing.JTextField movieTitleTextField;
    private javax.swing.JCheckBox mysteryCheckBox;
    private javax.swing.JTextField posterImgPath;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JSpinner ratingSpinner;
    private javax.swing.JPanel ratingsPanel;
    private javax.swing.JPanel runtimePanel;
    private javax.swing.JComboBox<String> screenCombo;
    private javax.swing.JLabel tckPrcLabel;
    private javax.swing.JTextField tckPrcTextField;
    private javax.swing.JLabel theaterLabel;
    private javax.swing.JCheckBox thrillerCheckBox;
    private javax.swing.JPanel ticketPricesPanel;
    private javax.swing.JLabel uriLabel;
    private javax.swing.JTextField uriTextField;
    // End of variables declaration//GEN-END:variables

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getPosterBytes() {
        return posterBytes;
    }

    public void setPosterBytes(byte[] posterBytes) {
        this.posterBytes = posterBytes;
    }

    public ArrayList<String> getGenreList() {
        return genreList;
    }

    public void setGenreList(ArrayList<String> genreList) {
        this.genreList = genreList;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public JCheckBox getActionCheckBox() {
        return actionCheckBox;
    }

    public void setActionCheckBox(JCheckBox actionCheckBox) {
        this.actionCheckBox = actionCheckBox;
    }

    public JCheckBox getAdventureCheckBox() {
        return adventureCheckBox;
    }

    public void setAdventureCheckBox(JCheckBox adventureCheckBox) {
        this.adventureCheckBox = adventureCheckBox;
    }

    public JCheckBox getAnimationCheckBox() {
        return animationCheckBox;
    }

    public void setAnimationCheckBox(JCheckBox animationCheckBox) {
        this.animationCheckBox = animationCheckBox;
    }

    public JButton getBrowsePosterBtn() {
        return browsePosterBtn;
    }

    public void setBrowsePosterBtn(JButton browsePosterBtn) {
        this.browsePosterBtn = browsePosterBtn;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JCheckBox getComedyCheckBox() {
        return comedyCheckBox;
    }

    public void setComedyCheckBox(JCheckBox comedyCheckBox) {
        this.comedyCheckBox = comedyCheckBox;
    }

    public JComboBox<String> getContRatingCombo() {
        return contRatingCombo;
    }

    public void setContRatingCombo(JComboBox<String> contRatingCombo) {
        this.contRatingCombo = contRatingCombo;
    }

    public JLabel getContentRatingLabel() {
        return contentRatingLabel;
    }

    public void setContentRatingLabel(JLabel contentRatingLabel) {
        this.contentRatingLabel = contentRatingLabel;
    }

    public JButton getCreateBtn() {
        return createBtn;
    }

    public void setCreateBtn(JButton createBtn) {
        this.createBtn = createBtn;
    }

    public JCheckBox getCrimeCheckBox() {
        return crimeCheckBox;
    }

    public void setCrimeCheckBox(JCheckBox crimeCheckBox) {
        this.crimeCheckBox = crimeCheckBox;
    }

    public JPanel getDescriptionPanel() {
        return descriptionPanel;
    }

    public void setDescriptionPanel(JPanel descriptionPanel) {
        this.descriptionPanel = descriptionPanel;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public JCheckBox getDramaCheckBox() {
        return dramaCheckBox;
    }

    public void setDramaCheckBox(JCheckBox dramaCheckBox) {
        this.dramaCheckBox = dramaCheckBox;
    }

    public JLabel getEditLabel() {
        return editLabel;
    }

    public void setEditLabel(JLabel editLabel) {
        this.editLabel = editLabel;
    }

    public JCheckBox getFantasyCheckBox() {
        return fantasyCheckBox;
    }

    public void setFantasyCheckBox(JCheckBox fantasyCheckBox) {
        this.fantasyCheckBox = fantasyCheckBox;
    }

    public JPanel getGenrePanel() {
        return genrePanel;
    }

    public void setGenrePanel(JPanel genrePanel) {
        this.genrePanel = genrePanel;
    }

    public JCheckBox getHorrorCheckBox() {
        return horrorCheckBox;
    }

    public void setHorrorCheckBox(JCheckBox horrorCheckBox) {
        this.horrorCheckBox = horrorCheckBox;
    }

    public JSpinner getHourSpinner() {
        return hourSpinner;
    }

    public void setHourSpinner(JSpinner hourSpinner) {
        this.hourSpinner = hourSpinner;
    }

    public JLabel getHoursLabel() {
        return hoursLabel;
    }

    public void setHoursLabel(JLabel hoursLabel) {
        this.hoursLabel = hoursLabel;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JSpinner getMinuteSpinner() {
        return minuteSpinner;
    }

    public void setMinuteSpinner(JSpinner minuteSpinner) {
        this.minuteSpinner = minuteSpinner;
    }

    public JLabel getMinutesLabel() {
        return minutesLabel;
    }

    public void setMinutesLabel(JLabel minutesLabel) {
        this.minutesLabel = minutesLabel;
    }

    public JLabel getMovieTitleLabel() {
        return movieTitleLabel;
    }

    public void setMovieTitleLabel(JLabel movieTitleLabel) {
        this.movieTitleLabel = movieTitleLabel;
    }

    public JTextField getMovieTitleTextField() {
        return movieTitleTextField;
    }

    public void setMovieTitleTextField(JTextField movieTitleTextField) {
        this.movieTitleTextField = movieTitleTextField;
    }

    public JCheckBox getMysteryCheckBox() {
        return mysteryCheckBox;
    }

    public void setMysteryCheckBox(JCheckBox mysteryCheckBox) {
        this.mysteryCheckBox = mysteryCheckBox;
    }

    public JTextField getPosterImgPath() {
        return posterImgPath;
    }

    public void setPosterImgPath(JTextField posterImgPath) {
        this.posterImgPath = posterImgPath;
    }

    public JLabel getRatingLabel() {
        return ratingLabel;
    }

    public void setRatingLabel(JLabel ratingLabel) {
        this.ratingLabel = ratingLabel;
    }

    public JSpinner getRatingSpinner() {
        return ratingSpinner;
    }

    public void setRatingSpinner(JSpinner ratingSpinner) {
        this.ratingSpinner = ratingSpinner;
    }

    public JPanel getRatingsPanel() {
        return ratingsPanel;
    }

    public void setRatingsPanel(JPanel ratingsPanel) {
        this.ratingsPanel = ratingsPanel;
    }

    public JPanel getRuntimePanel() {
        return runtimePanel;
    }

    public void setRuntimePanel(JPanel runtimePanel) {
        this.runtimePanel = runtimePanel;
    }

    public JComboBox<String> getScreenCombo() {
        return screenCombo;
    }

    public void setScreenCombo(JComboBox<String> screenCombo) {
        this.screenCombo = screenCombo;
    }

    public JLabel getTckPrcLabel() {
        return tckPrcLabel;
    }

    public void setTckPrcLabel(JLabel tckPrcLabel) {
        this.tckPrcLabel = tckPrcLabel;
    }

    public JTextField getTckPrcTextField() {
        return tckPrcTextField;
    }

    public void setTckPrcTextField(JTextField tckPrcTextField) {
        this.tckPrcTextField = tckPrcTextField;
    }

    public JLabel getTheaterLabel() {
        return theaterLabel;
    }

    public void setTheaterLabel(JLabel theaterLabel) {
        this.theaterLabel = theaterLabel;
    }

    public JCheckBox getThrillerCheckBox() {
        return thrillerCheckBox;
    }

    public void setThrillerCheckBox(JCheckBox thrillerCheckBox) {
        this.thrillerCheckBox = thrillerCheckBox;
    }

    public JPanel getTicketPricesPanel() {
        return ticketPricesPanel;
    }

    public void setTicketPricesPanel(JPanel ticketPricesPanel) {
        this.ticketPricesPanel = ticketPricesPanel;
    }

    public JLabel getUriLabel() {
        return uriLabel;
    }

    public void setUriLabel(JLabel uriLabel) {
        this.uriLabel = uriLabel;
    }

    public JTextField getUriTextField() {
        return uriTextField;
    }

    public void setUriTextField(JTextField uriTextField) {
        this.uriTextField = uriTextField;
    }

}
