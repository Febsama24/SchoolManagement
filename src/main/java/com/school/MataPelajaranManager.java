package com.school;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MataPelajaranManager {

    // Menambahkan mata pelajaran baru
    public void addMataPelajaran(String namaMapel) {
        String query = "INSERT INTO mata_pelajaran (nama_mapel) VALUES (?)";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaMapel);

            // Eksekusi query untuk menambah mata pelajaran
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mata pelajaran berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan mata pelajaran.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua mata pelajaran
    public List<MataPelajaran> getAllMataPelajaran() {
        List<MataPelajaran> mataPelajaranList = new ArrayList<>();
        String query = "SELECT * FROM mata_pelajaran";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaMapel = resultSet.getString("nama_mapel");

                // Menambahkan objek MataPelajaran ke dalam daftar
                MataPelajaran mataPelajaran = new MataPelajaran(id, namaMapel);
                mataPelajaranList.add(mataPelajaran);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mataPelajaranList;
    }

    // Memperbarui data mata pelajaran berdasarkan ID
    public void updateMataPelajaran(int id, String namaMapel) {
        String query = "UPDATE mata_pelajaran SET nama_mapel = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaMapel);
            statement.setInt(2, id);

            // Eksekusi query untuk memperbarui data mata pelajaran
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mata pelajaran berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui mata pelajaran.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus mata pelajaran berdasarkan ID
    public void deleteMataPelajaran(int id) {
        String query = "DELETE FROM mata_pelajaran WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai ID mata pelajaran yang akan dihapus
            statement.setInt(1, id);

            // Eksekusi query untuk menghapus mata pelajaran
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Mata pelajaran berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus mata pelajaran.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
