package com.school;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NilaiManager {

    // Menambahkan nilai baru untuk siswa
    public void addNilai(int siswaId, int mataPelajaranId, double nilai) {
        String query = "INSERT INTO nilai (siswa_id, mata_pelajaran_id, nilai) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setInt(1, siswaId);
            statement.setInt(2, mataPelajaranId);
            statement.setDouble(3, nilai);

            // Eksekusi query untuk menambah nilai
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nilai berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan nilai.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua nilai siswa
    public List<Nilai> getAllNilai() {
        List<Nilai> nilaiList = new ArrayList<>();
        String query = "SELECT * FROM nilai";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int siswaId = resultSet.getInt("siswa_id");
                int mataPelajaranId = resultSet.getInt("mata_pelajaran_id");
                double nilai = resultSet.getDouble("nilai");

                // Menambahkan objek Nilai ke dalam daftar
                Nilai nilaiObj = new Nilai(id, siswaId, mataPelajaranId, nilai);
                nilaiList.add(nilaiObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nilaiList;
    }

    // Memperbarui nilai siswa berdasarkan ID
    public void updateNilai(int id, double nilai) {
        String query = "UPDATE nilai SET nilai = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setDouble(1, nilai);
            statement.setInt(2, id);

            // Eksekusi query untuk memperbarui nilai
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nilai berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui nilai.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus nilai berdasarkan ID
    public void deleteNilai(int id) {
        String query = "DELETE FROM nilai WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai ID nilai yang akan dihapus
            statement.setInt(1, id);

            // Eksekusi query untuk menghapus nilai
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Nilai berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus nilai.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
