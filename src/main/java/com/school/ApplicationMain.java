package com.school;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Buat elemen GUI sederhana
        Label label = new Label("Welcome to JavaFX Application");
        StackPane root = new StackPane(label);

        // Buat scene dan tambahkan ke stage
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("JavaFX Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(ApplicationMain.class, args);
    }
}
