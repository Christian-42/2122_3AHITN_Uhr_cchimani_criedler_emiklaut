package com.example.uhrzeit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class HelloController {
    public BorderPane Hintergrund;
    public Label aktuelleUhrzeit;
    public Label aktuellesDatum;
    public Label aktuelleKalenderWoche;
    public Label stoppuhrausgabe;
    public Button stoppuhr;
    @FXML
    private Label welcomeText;


    public void initialize(){
        aktuellesDatum.setText(ZonedDateTime.now().getDayOfMonth()+"."+ZonedDateTime.now().getMonthValue()+"."+ZonedDateTime.now().getYear());
        aktuelleUhrzeit.setText(ZonedDateTime.now().getHour()+":"+ZonedDateTime.now().getMinute()+":"+ZonedDateTime.now().getSecond());
        Calendar calendar=Calendar.getInstance();
        Date date=new Date();
        calendar.setTime(date);
        aktuelleKalenderWoche.setText(String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)));

    }
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onstoppuhrClick(ActionEvent actionEvent) {

        }}




