package com.example.uhrzeit.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AnalogController extends Stage {
    Stage stage;
    public void Start() throws IOException {
        stage = this;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Analog.fxml")));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}