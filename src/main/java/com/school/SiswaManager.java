package com.school;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;

public class SiswaManager {

    // Menambahkan siswa baru
    public void addSiswa(String namaSiswa, String jurusan, String kelas) {
        String query = "INSERT INTO siswa (nama_siswa, jurusan, kelas) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaSiswa);
            statement.setString(2, jurusan);
            statement.setString(3, kelas);

            // Eksekusi query untuk menambah siswa
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Siswa berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan siswa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua siswa
    public ObservableList<Siswa> getAllSiswa() {
        List<Siswa> siswaList = new ArrayList<>();
        String query = "SELECT * FROM siswa";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaSiswa = resultSet.getString("nama_siswa");
                String jurusan = resultSet.getString("jurusan");
                String kelas = resultSet.getString("kelas");

                // Menambahkan objek Siswa ke dalam daftar
                Siswa siswa = new Siswa(id, namaSiswa, jurusan, kelas);
                siswaList.add(siswa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (ObservableList<Siswa>) siswaList;
    }

    // Memperbarui data siswa berdasarkan ID
    public void updateSiswa(int id, String namaSiswa, String jurusan, String kelas) {
            String query = "UPDATE siswa SET nama_siswa = ?, jurusan = ?, kelas = ? WHERE id = ?";
            
            try (Connection connection = DatabaseConnector.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
    
                // Menetapkan nilai parameter pada query
                statement.setString(1, namaSiswa);
                statement.setString(2, jurusan);
                statement.setString(3, kelas);
            statement.setInt(4, id);

            // Eksekusi query untuk memperbarui data siswa
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Siswa berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui siswa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus siswa berdasarkan ID
    public void deleteSiswa(int id) {
        String query = "DELETE FROM siswa WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai ID siswa yang akan dihapus
            statement.setInt(1, id);

            // Eksekusi query untuk menghapus siswa
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Siswa berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus siswa.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
