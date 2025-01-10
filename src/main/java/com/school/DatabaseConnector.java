package com.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    // Variabel untuk menyimpan URL, username, dan password database
    private static final String URL = "jdbc:mysql://localhost:3306/sekolah"; // Ganti dengan URL database Anda
    private static final String USER = "root";  // Ganti dengan username database Anda
    private static final String PASSWORD = "";  // Ganti dengan password database Anda

    private static Connection connection;

    // Fungsi untuk membuka koneksi ke database
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                // Memuat driver JDBC MySQL (Java 8+ biasanya otomatis)
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Membuat koneksi ke database
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Koneksi ke database berhasil!");
            } catch (ClassNotFoundException e) {
                System.err.println("Driver JDBC tidak ditemukan!");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Fungsi untuk menutup koneksi ke database
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Koneksi ke database ditutup.");
            }
        } catch (SQLException e) {
            System.err.println("Gagal menutup koneksi!");
            e.printStackTrace();
        }
    }
}
