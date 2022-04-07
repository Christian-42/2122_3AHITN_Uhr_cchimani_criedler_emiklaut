package com.example.uhrzeit.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BinaerController extends Stage {
    Stage stage;
    public BinaerController() throws IOException {
        stage = this;
        Parent root = FXMLLoader.load(getClass().getResource("com/example/uhrzeit/binary.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}