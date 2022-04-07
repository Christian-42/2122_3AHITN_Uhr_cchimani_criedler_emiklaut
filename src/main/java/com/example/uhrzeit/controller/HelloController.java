package com.example.uhrzeit.controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class HelloController{
    public BorderPane hintergrund;
    public Label aktuelleUhrzeit;
    public Label aktuellesDatum;
    public Label aktuelleKalenderWoche;
    /*
    public Label stoppuhrausgabe;
    public Button stoppuhr;
    public Button startUhr;
    */
    public BorderPane Hintergrund;


    public void initialize() {
        aktuellesDatum.setText(ZonedDateTime.now().getDayOfMonth() + "." + ZonedDateTime.now().getMonthValue() + "." + ZonedDateTime.now().getYear());
        aktuelleUhrzeit.setText(ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        aktuelleKalenderWoche.setText(String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)));

    }




        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                   // Platform.runLater();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                aktuelleUhrzeit.setText(ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());
                Calendar calendar = Calendar.getInstance();
                Date date = new Date();
                calendar.setTime(date);
                aktuelleKalenderWoche.setText(String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)));
                aktuellesDatum.setText(ZonedDateTime.now().getDayOfMonth() + "." + ZonedDateTime.now().getMonthValue() + "." + ZonedDateTime.now().getYear());
            }
        }





    public void hintergrund(BorderPane hintergrund) {
        this.hintergrund = hintergrund;
    }

    public void onStoppUhr_Timer_click(ActionEvent actionEvent) throws InterruptedException, IOException {
        System.out.println("received click");
        new StoppUhr_TimerController();
        /*boolean isRunning = true;
        int sec = 0;
        int min = 0;
        int h = 0;

        if (startUhr.isHover()) {
            while (h <= 59) {
                stoppuhrausgabe.setText("sec:" + String.valueOf(sec) + " min: " + min + " h: " + h);
                sec++;
                //Thread.sleep(1000);
                if (sec == 60) {
                    min++;
                    sec = 0;
                }
                if (min == 60) {
                    h++;
                    min = 0;
                }
            }
        }
        */
    }

    @FXML
    public void onAnalogclick(ActionEvent actionEvent) throws IOException {
        new AnalogController();
    }

    public void onBinaerclick(ActionEvent actionEvent) throws IOException {
        new BinaerController();
    }
}




