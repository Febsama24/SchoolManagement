package com.school;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    // Menambahkan pengguna baru
    public void addUser(String username, String password, String role) {
        String query = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);

            // Eksekusi query untuk menambah pengguna
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pengguna berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan pengguna.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mengambil semua pengguna
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM user";

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String role = resultSet.getString("role");

                // Menambahkan objek User ke dalam daftar
                User user = new User(id, username, password, role);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    // Memperbarui data pengguna berdasarkan ID
    public void updateUser(int id, String username, String password, String role) {
        String query = "UPDATE user SET username = ?, password = ?, role = ? WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter pada query
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);
            statement.setInt(4, id);

            // Eksekusi query untuk memperbarui data pengguna
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pengguna berhasil diperbarui.");
            } else {
                System.out.println("Gagal memperbarui pengguna.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menghapus pengguna berdasarkan ID
    public void deleteUser(int id) {
        String query = "DELETE FROM user WHERE id = ?";
        
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai ID pengguna yang akan dihapus
            statement.setInt(1, id);

            // Eksekusi query untuk menghapus pengguna
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pengguna berhasil dihapus.");
            } else {
                System.out.println("Gagal menghapus pengguna.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Menemukan pengguna berdasarkan username dan password untuk autentikasi login
    public User authenticateUser(String username, String password) {
        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        User user = null;

        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Menetapkan nilai parameter
            statement.setString(1, username);
            statement.setString(2, password);

            // Eksekusi query dan ambil hasilnya
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String role = resultSet.getString("role");

                // Membuat objek User jika login berhasil
                user = new User(id, username, password, role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;  // Jika user tidak ditemukan, akan mengembalikan null
    }
}
