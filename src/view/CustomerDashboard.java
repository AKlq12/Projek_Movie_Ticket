package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import util.DatabaseConnection;

public class CustomerDashboard extends javax.swing.JFrame {
    
    private void loadData() {
    DefaultTableModel model = new DefaultTableModel(new String[]{"ID Movie", "Title", "Genre", "Rating", "Date",  "Duration", "Showtime"}, 0);

    try {
        Connection conn = DatabaseConnection.getConnection(); // Gunakan koneksi dari class util
        if (conn != null) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id_movie, movie_title, genre, rating, date, time, showtime FROM movies");

            while (rs.next()) {
                String id = rs.getString("id_movie");
                String title = rs.getString("movie_title");
                String genre = rs.getString("genre");
                String rating = rs.getString("rating");
                String date = rs.getString("date");
                String time = rs.getString("time");
                String showtime = rs.getString("showtime");

                model.addRow(new Object[]{id, title, genre, rating, date, time, showtime});
            }

            jTable1.setModel(model);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public CustomerDashboard() {
        initComponents();
        loadData();
        next.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
            String idMovie = jTable1.getValueAt(selectedRow, 0).toString();
            String title = jTable1.getValueAt(selectedRow, 1).toString();
            String genre = jTable1.getValueAt(selectedRow, 2).toString();
            String rating = jTable1.getValueAt(selectedRow, 3).toString();
            String time = jTable1.getValueAt(selectedRow, 4).toString();
            String showtime = jTable1.getValueAt(selectedRow, 5).toString();

            // Buat objek Seat dan oper data film
            Seat seatFrame = new Seat(idMovie, title, genre, rating, time, showtime);
            seatFrame.setVisible(true);
            dispose(); // Tutup jendela saat ini jika ingin
        } else {
            javax.swing.JOptionPane.showMessageDialog(null, "Pilih film terlebih dahulu.");
        }
    }
});

        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        next = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Movie", "Title", "Genre", "Rating", "Date", "Duration", "Showtime"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setText("Booking Film");

        next.setBackground(new java.awt.Color(0, 255, 0));
        next.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        next.setText("Next");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(297, 297, 297))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(next)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton next;
    // End of variables declaration//GEN-END:variables
}