package com.school;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SiswaController {

    @FXML private TextField namaSiswaField;
    @FXML private TextField jurusanField;
    @FXML private TextField kelasField;
    @FXML private TableView<Siswa> siswaTable;
    @FXML private TableColumn<Siswa, Integer> idColumn;
    @FXML private TableColumn<Siswa, String> namaSiswaColumn;
    @FXML private TableColumn<Siswa, String> jurusanColumn;
    @FXML private TableColumn<Siswa, String> kelasColumn;

    private SiswaManager siswaManager;

    public void initialize() {
        siswaManager = new SiswaManager();

        // Menghubungkan kolom dengan data siswa
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        namaSiswaColumn.setCellValueFactory(cellData -> cellData.getValue().namaSiswaProperty());
        jurusanColumn.setCellValueFactory(cellData -> cellData.getValue().jurusanProperty());
        kelasColumn.setCellValueFactory(cellData -> cellData.getValue().kelasProperty());

        // Memuat data siswa ke dalam tabel
        siswaTable.setItems(siswaManager.getAllSiswa());
    }

    @FXML
    private void handleAddSiswa() {
        String namaSiswa = namaSiswaField.getText();
        String jurusan = jurusanField.getText();
        String kelas = kelasField.getText();

        if (namaSiswa.isEmpty() || jurusan.isEmpty() || kelas.isEmpty()) {
            showAlert("Input Salah", "Semua field harus diisi!");
            return;
        }

        siswaManager.addSiswa(namaSiswa, jurusan, kelas);
        siswaTable.setItems(siswaManager.getAllSiswa());
        clearFields();
    }

    @FXML
    private void handleUpdateSiswa() {
        Siswa selectedSiswa = siswaTable.getSelectionModel().getSelectedItem();
        if (selectedSiswa == null) {
            showAlert("Pilih Siswa", "Pilih siswa yang ingin diperbarui.");
            return;
        }

        String namaSiswa = namaSiswaField.getText();
        String jurusan = jurusanField.getText();
        String kelas = kelasField.getText();

        if (namaSiswa.isEmpty() || jurusan.isEmpty() || kelas.isEmpty()) {
            showAlert("Input Salah", "Semua field harus diisi!");
            return;
        }

        siswaManager.updateSiswa(selectedSiswa.getId(), namaSiswa, jurusan, kelas);
        siswaTable.setItems(siswaManager.getAllSiswa());
        clearFields();
    }

    @FXML
    private void handleDeleteSiswa() {
        Siswa selectedSiswa = siswaTable.getSelectionModel().getSelectedItem();
        if (selectedSiswa == null) {
            showAlert("Pilih Siswa", "Pilih siswa yang ingin dihapus.");
            return;
        }

        siswaManager.deleteSiswa(selectedSiswa.getId());
        siswaTable.setItems(siswaManager.getAllSiswa());
        clearFields();
    }

    private void clearFields() {
        namaSiswaField.clear();
        jurusanField.clear();
        kelasField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
