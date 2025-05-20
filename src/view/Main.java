package view;

public class Main {
    public static void main(String[] args) {
        // Launch the role selection screen
        java.awt.EventQueue.invokeLater(() -> {
            new PilihLogin().setVisible(true);
        });
    }
}