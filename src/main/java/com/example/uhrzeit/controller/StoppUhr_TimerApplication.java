package com.example.uhrzeit.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * @author cchimani
 */
public class StoppUhr_TimerApplication extends Stage {
    Stage stage;
    public StoppUhr_TimerApplication() throws IOException {
        stage = this;
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/uhrzeit/StoppUhr_Timer.fxml")));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}