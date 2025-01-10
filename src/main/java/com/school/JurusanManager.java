package com.school;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JurusanManager {

    // Menambahkan jurusan baru
    public void addJurusan(String namaJurusan) {
        String query = "INSERT INTO jurusan (nama_jurusan) VALUES (?)";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaJurusan);

            // Eksekusi query untuk menambah jurusan
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Jurusan berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan jurusan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua jurusan
    public List<Jurusan> getAllJurusan() {
        List<Jurusan> jurusanList = new ArrayList<>();
        String query = "SELECT * FROM jurusan";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String namaJurusan = resultSet.getString("nama_jurusan");

                // Menambahkan objek Jurusan ke dalam daftar
                Jurusan jurusan = new Jurusan(id, namaJurusan);
                jurusanList.add(jurusan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jurusanList;
    }

    // Memperbarui data jurusan berdasarkan ID
    public void updateJurusan(int id, String namaJurusan) {
        String query = "UPDATE jurusan SET nama_jurusan = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, namaJurusan);
            statement.setInt(2, id);

            // Eksekusi query untuk memperbarui data jurusan
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Jurusan berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui jurusan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus jurusan berdasarkan ID
    public void deleteJurusan(int id) {
        String query = "DELETE FROM jurusan WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai ID jurusan yang akan dihapus
            statement.setInt(1, id);

            // Eksekusi query untuk menghapus jurusan
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Jurusan berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus jurusan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
