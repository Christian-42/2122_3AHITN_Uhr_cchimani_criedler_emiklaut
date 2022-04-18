package com.example.uhrzeit.controller;

import com.example.uhrzeit.view.Zeit;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class AnalogController {
    @FXML
    private Pane minuterotate;

    @FXML
    private Pane stundenrotate;

    public void initialize() throws InterruptedException {
        Zeit time = new Zeit(minuterotate,stundenrotate);
        Thread t = new Thread(time);
        t.join();
        t.start();
    }
}
