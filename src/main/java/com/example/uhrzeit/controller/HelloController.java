package com.example.uhrzeit.controller;

import com.example.uhrzeit.StoppUhr;
import com.example.uhrzeit.view.Zeit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class HelloController {
    public BorderPane hintergrund;
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

    public void onstoppuhrClick(ActionEvent actionEvent) throws InterruptedException {
        boolean isRunning = true;
        int sec=0;
        int min=0;
        int h=0;



        StoppUhr su = new StoppUhr();
        if (startUhr.isHover()) {
            while (h<=59) {
                stoppuhrausgabe.setText("sec:"+String.valueOf(sec)+" min: "+min+" h: "+h);
                sec++;
                //Thread.sleep(1000);
                if (sec==60){
                    min++;
                    sec=0;
                }
                if (min == 60){
                    h++;
                    min=0;
                }


            }

        }


    }


    public void hintergrund (BorderPane hintergrund){
        this.hintergrund = hintergrund;

    }

}




