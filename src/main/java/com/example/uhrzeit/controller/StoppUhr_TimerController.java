package com.example.uhrzeit.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class StoppUhr_TimerController {
    public Button runde;
    public Button stoppstart;
    public Label ausgabefeldstoppuhr;
    public Label timeausgabe;
    public Button abbrechen;
    public Button startpause;
    public TextField eingabedergewuenchtenzeit;
    public Label timeausgabe1;
    public Label timerabgelaufensymbol;
    static int eingabe = 0;
    public ImageView imageview;

    public void startpause(ActionEvent actionEvent) throws InterruptedException {



        eingabe= Integer.valueOf(eingabedergewuenchtenzeit.getText());
        System.out.println(eingabe);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {

                        eingabe--;
                        timeausgabe1.setText(String.valueOf(eingabe));
                    }
                };

                while (eingabe>1) {

                    if (eingabe==0){
                        File file = new File("com/example/resources/symbole-glocke.jpg");
                        Image image = new Image(file.toURI().toString());
                        imageview = new ImageView(image);

                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);

                }
            }


        });
        // don't let thread prevent JVM shutdown
        thread.setDaemon(true);
        thread.start();
    }


}
