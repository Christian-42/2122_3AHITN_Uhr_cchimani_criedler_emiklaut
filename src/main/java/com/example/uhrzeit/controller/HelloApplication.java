package com.example.uhrzeit.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * @author criedler
 * Verantwortlich fuer das oeffnen der Menu_Digital.fxml Datei
 */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/uhrzeit/Menu_Digital.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu_Digital");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();


    }

}