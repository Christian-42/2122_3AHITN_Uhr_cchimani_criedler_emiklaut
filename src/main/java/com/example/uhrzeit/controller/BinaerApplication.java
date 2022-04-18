package com.example.uhrzeit.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BinaerApplication extends Stage {
    Stage stage;
    public BinaerApplication() throws IOException {
        stage = this;
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/uhrzeit/binary.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}