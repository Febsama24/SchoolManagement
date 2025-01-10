package com.school;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class GuiController {

    @FXML private Button btnSiswa;
    @FXML private Button btnJurusan;
    @FXML private Button btnMataPelajaran;
    @FXML private Button btnKelas;
    @FXML private Button btnNilai;
    @FXML private Button btnUser;

    private Stage stage;
    private Scene siswaScene, jurusanScene, mataPelajaranScene, kelasScene, nilaiScene, userScene;

    // Constructor
    public GuiController() {
        // Initialize scenes
        this.stage = new Stage();
    }

    // Menampilkan form untuk mengelola data siswa
    @FXML
    private void handleSiswa() {
        try {
            if (siswaScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sekolah/siswaForm.fxml"));
                StackPane root = loader.load();
                siswaScene = new Scene(root);
            }
            stage.setTitle("Manajemen Siswa");
            stage.setScene(siswaScene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat form siswa.");
            e.printStackTrace();
        }
    }

    // Menampilkan form untuk mengelola data jurusan
    @FXML
    private void handleJurusan() {
        try {
            if (jurusanScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sekolah/jurusanForm.fxml"));
                StackPane root = loader.load();
                jurusanScene = new Scene(root);
            }
            stage.setTitle("Manajemen Jurusan");
            stage.setScene(jurusanScene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat form jurusan.");
            e.printStackTrace();
        }
    }

    // Menampilkan form untuk mengelola data mata pelajaran
    @FXML
    private void handleMataPelajaran() {
        try {
            if (mataPelajaranScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sekolah/mataPelajaranForm.fxml"));
                StackPane root = loader.load();
                mataPelajaranScene = new Scene(root);
            }
            stage.setTitle("Manajemen Mata Pelajaran");
            stage.setScene(mataPelajaranScene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat form mata pelajaran.");
            e.printStackTrace();
        }
    }

    // Menampilkan form untuk mengelola data kelas
    @FXML
    private void handleKelas() {
        try {
            if (kelasScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sekolah/kelasForm.fxml"));
                StackPane root = loader.load();
                kelasScene = new Scene(root);
            }
            stage.setTitle("Manajemen Kelas");
            stage.setScene(kelasScene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat form kelas.");
            e.printStackTrace();
        }
    }

    // Menampilkan form untuk mengelola data nilai
    @FXML
    private void handleNilai() {
        try {
            if (nilaiScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sekolah/nilaiForm.fxml"));
                StackPane root = loader.load();
                nilaiScene = new Scene(root);
            }
            stage.setTitle("Manajemen Nilai");
            stage.setScene(nilaiScene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat form nilai.");
            e.printStackTrace();
        }
    }

    // Menampilkan form untuk mengelola data user (autentikasi pengguna)
    @FXML
    private void handleUser() {
        try {
            if (userScene == null) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sekolah/userForm.fxml"));
                StackPane root = loader.load();
                userScene = new Scene(root);
            }
            stage.setTitle("Manajemen User");
            stage.setScene(userScene);
            stage.show();
        } catch (IOException e) {
            showAlert("Error", "Gagal memuat form user.");
            e.printStackTrace();
        }
    }

    // Menampilkan pesan peringatan
    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
