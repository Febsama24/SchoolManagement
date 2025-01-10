package com.school;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Mengarahkan ke file FXML untuk login form
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        
        // Menyiapkan scene dan menampilkan login form
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Sistem Manajemen Nilai Sekolah");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);  // Menjalankan aplikasi JavaFX
    }
}
