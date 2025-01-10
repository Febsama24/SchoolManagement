package com.school;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KelasManager {

    // Menambahkan kelas baru
    public void addKelas(String namaKelas) {
        String query = "INSERT INTO kelas (nama_kelas) VALUES (?)";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaKelas);

            // Eksekusi query untuk menambah kelas
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Kelas berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan kelas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua kelas
    public List<Kelas> getAllKelas() {
        List<Kelas> kelasList = new ArrayList<>();
        String query = "SELECT * FROM kelas";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaKelas = resultSet.getString("nama_kelas");

                // Menambahkan objek Kelas ke dalam daftar
                Kelas kelas = new Kelas(id, namaKelas);
                kelasList.add(kelas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return kelasList;
    }

    // Memperbarui data kelas berdasarkan ID
    public void updateKelas(int id, String namaKelas) {
        String query = "UPDATE kelas SET nama_kelas = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaKelas);
            statement.setInt(2, id);

            // Eksekusi query untuk memperbarui data kelas
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Kelas berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui kelas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus kelas berdasarkan ID
    public void deleteKelas(int id) {
        String query = "DELETE FROM kelas WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai ID kelas yang akan dihapus
            statement.setInt(1, id);

            // Eksekusi query untuk menghapus kelas
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Kelas berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus kelas.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
