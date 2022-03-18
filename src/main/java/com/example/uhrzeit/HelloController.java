package com.example.uhrzeit;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class HelloController {
    public BorderPane Hintergrund;
    public Label aktuelleUhrzeit;
    public Label aktuellesDatum;
    public Label aktuelleKalenderWoche;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}