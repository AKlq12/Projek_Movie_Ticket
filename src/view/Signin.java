package view;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import util.DatabaseConnection;

public class Signin extends javax.swing.JFrame {

    private String userType;

    public Signin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void setUserType(String userType) {
        this.userType = userType;
        if ("admin".equals(userType)) {
            jLabel2.setText("ADMIN SIGN UP");
        } else {
            jLabel2.setText("CUSTOMER SIGN UP");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextEmailSignIn = new javax.swing.JTextField();
        jPasswordSignIn = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        btnmasukakun = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextUsernameSignIn = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPasswordConfirmSignin = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/LOGINSIGNIN Costumer.png"))); // NOI18N
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, -1));

        jPanel1.setBackground(new java.awt.Color(56, 182, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setText("SIGN UP");

        jLabel3.setText("Email");

        jLabel4.setText("Password");

        jTextEmailSignIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextEmailSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextEmailSignInActionPerformed(evt);
            }
        });

        jPasswordSignIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Sudah Punya Akun?");

        btnmasukakun.setForeground(new java.awt.Color(255, 255, 255));
        btnmasukakun.setText("Masuk Akun");
        btnmasukakun.setBorder(null);
        btnmasukakun.setContentAreaFilled(false);
        btnmasukakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasukakunActionPerformed(evt);
            }
        });

        btnSignIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSignIn.setText("SIGN UP");
        btnSignIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        jLabel6.setText("Username");

        jTextUsernameSignIn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Confirm Password");

        jPasswordConfirmSignin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordSignIn)
                            .addComponent(jLabel4)
                            .addComponent(jTextEmailSignIn)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jTextUsernameSignIn)
                            .addComponent(jLabel7)
                            .addComponent(jPasswordConfirmSignin, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(35, 35, 35)
                                .addComponent(btnmasukakun, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextEmailSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUsernameSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPasswordSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel2))
                .addGap(7, 7, 7)
                .addComponent(jPasswordConfirmSignin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnmasukakun))
                .addGap(34, 34, 34)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 480, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnmasukakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasukakunActionPerformed
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnmasukakunActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        String email = jTextEmailSignIn.getText();
        String username = jTextUsernameSignIn.getText();
        String password = new String(jPasswordSignIn.getPassword());
        String confirmPassword = new String(jPasswordConfirmSignin.getPassword());

        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Email tidak valid", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this, "Password minimal 6 karakter", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password dan konfirmasi password tidak cocok", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean registered;
        if ("admin".equals(userType)) {
            registered = registerAdmin(email, username, password);
        } else {
            registered = registerCustomer(email, username, password);
        }

        if (registered) {
            JOptionPane.showMessageDialog(this, "Registrasi berhasil! Silakan login", "Success", JOptionPane.INFORMATION_MESSAGE);
            new Login().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnSignInActionPerformed

    private void jTextEmailSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextEmailSignInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextEmailSignInActionPerformed

    private boolean registerAdmin(String email, String username, String password) {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO admin (email, username, password) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Username atau email sudah digunakan", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean registerCustomer(String email, String username, String password) {
        // Existing customer registration code
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO customer (email, username, password) VALUES (?, ?, ?,)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            statement.setString(2, username);
            statement.setString(3, password);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate entry")) {
                JOptionPane.showMessageDialog(this, "Username atau email sudah digunakan", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                e.printStackTrace();
            }
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Signin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Signin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnmasukakun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordConfirmSignin;
    private javax.swing.JPasswordField jPasswordSignIn;
    private javax.swing.JTextField jTextEmailSignIn;
    private javax.swing.JTextField jTextUsernameSignIn;
    // End of variables declaration//GEN-END:variables
}
