package view;

import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import util.DatabaseConnection;
import controller.AuthController;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private AuthController authController;
    private String userType;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        authController = new AuthController();
    }

    public void setUserType(String userType) {
        this.userType = userType;
        if ("admin".equals(userType)) {
            jLabel2.setText("LOGIN ADMIN");
            btnbuatakun.setVisible(false); // Hide create account for admin
            jLabel5.setVisible(false);
        } else {
            jLabel2.setText("LOGIN CUSTOMER");
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
        jTextUsernameLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnbuatakun = new javax.swing.JButton();
        jLoginPassword = new javax.swing.JPasswordField();
        btnLoginMasuk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/LOGINSIGNIN Costumer.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 264, -1));

        jPanel1.setBackground(new java.awt.Color(56, 182, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setText("LOGIN");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        jTextUsernameLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setText("Pengguna Baru?");

        btnbuatakun.setForeground(new java.awt.Color(255, 255, 255));
        btnbuatakun.setText("Buat Akun");
        btnbuatakun.setBorder(null);
        btnbuatakun.setContentAreaFilled(false);
        btnbuatakun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuatakunActionPerformed(evt);
            }
        });

        jLoginPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLoginPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginPasswordActionPerformed(evt);
            }
        });

        btnLoginMasuk.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLoginMasuk.setText("LOGIN");
        btnLoginMasuk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnLoginMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginMasukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jTextUsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel2)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuatakun))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnLoginMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jTextUsernameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(1, 1, 1)
                .addComponent(jLoginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnbuatakun))
                .addGap(18, 18, 18)
                .addComponent(btnLoginMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 460, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuatakunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuatakunActionPerformed
        Signin signin = new Signin();
        signin.setUserType("customer"); // Default to customer if coming from login screen
        signin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbuatakunActionPerformed

    private void jLoginPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLoginPasswordActionPerformed

    private void btnLoginMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginMasukActionPerformed
        String username = jTextUsernameLogin.getText();
        String password = new String(jLoginPassword.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username dan password tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean authenticated;
        if ("admin".equals(userType)) {
            authenticated = authController.authenticateAdmin(username, password);
        } else {
            authenticated = authController.authenticateCustomer(username, password);
        }

        if (authenticated) {
            if ("admin".equals(userType)) {
                new AdminDashboard().setVisible(true);
            } else {
                new CustomerDashboard().setVisible(true);
            }
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username atau password salah", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnLoginMasukActionPerformed

    private boolean validateLogin(String username, String password, boolean isAdmin) {
        Connection connection = DatabaseConnection.getConnection();
        String query = isAdmin
                ? "SELECT * FROM admin WHERE username = ? AND password = SHA2(?, 256)"
                : "SELECT * FROM customer WHERE username = ? AND password = SHA2(?, 256)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isCustomer = false;

    public void setIsCustomer(boolean isCustomer) {
        this.isCustomer = isCustomer;

        // Anda juga bisa mengubah tampilan berdasarkan jenis login
        if (!isCustomer) {
            jLabel2.setText("LOGIN ADMIN");
            // Atur ulang tampilan lainnya jika perlu
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoginMasuk;
    private javax.swing.JButton btnbuatakun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jLoginPassword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextUsernameLogin;
    // End of variables declaration//GEN-END:variables
}
