package com.school;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginForm {
    
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;

    // Method yang dipanggil ketika tombol Login ditekan
    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        // Autentikasi pengguna
        if (authenticateUser(username, password)) {
            // Jika login berhasil, buka jendela utama
            openMainWindow();
        } else {
            // Jika login gagal, tampilkan pesan error
            showErrorMessage("Username atau Password salah!");
        }
    }

    // Fungsi untuk mengecek autentikasi pengguna
    private boolean authenticateUser(String username, String password) {
        // Cek kredensial pengguna. Ini hanya contoh, Anda bisa menghubungkan ke database.
        return username.equals("admin") && password.equals("admin123");
    }

    // Menampilkan pesan kesalahan
    private void showErrorMessage(String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Login Gagal");
        alert.setHeaderText("Login gagal");
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Membuka jendela utama setelah login berhasil
    private void openMainWindow() {
        try {
            // Muat layout jendela utama
            Stage mainStage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainWindow.fxml"));
            javafx.scene.Parent root = loader.load();

            // Buat scene dan tampilkan jendela utama
            Scene scene = new Scene(root, 600, 400);
            mainStage.setTitle("Sistem Manajemen Nilai Sekolah");
            mainStage.setScene(scene);
            mainStage.show();
            
            // Tutup jendela login setelah login berhasil
            Stage currentStage = (Stage) usernameField.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
