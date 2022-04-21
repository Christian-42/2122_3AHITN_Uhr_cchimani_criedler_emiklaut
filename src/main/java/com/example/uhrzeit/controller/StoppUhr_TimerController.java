package com.example.uhrzeit.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.stage.FileChooser;

import java.io.File;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @author Christian Chimani
 * @version 1.5
 */
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
    public Button Stop;
    int min=0;
    int sec=0;
    static int count = 0;


    /**
     *
     * @throws InterruptedException mit try catch abfangen falls Thread unterbrochen wird
     * Man gibt die gewünschten Sekunden ein, soblad start gedrückt wird gehen die Sekunden hinunter.
     * Sobald die Zeit abgelaufen ist wird ein Image ausgegeben(Probleme mit ImageView)
     *
     */
    public void startpause(ActionEvent actionEvent) throws InterruptedException {




        eingabe = Integer.parseInt(eingabedergewuenchtenzeit.getText());
        System.out.println(eingabe);

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {

                        eingabe--;
                        timeausgabe1.setText(String.valueOf(eingabe));
                        if (eingabe == 0) {
                            Image glocke = new Image("https://images.clipartlogo.com/files/istock/previews/8367/83671109-bell-icon-symbol.jpg");
                            imageview.setImage(glocke);

                        }
                    }
                };

                while (eingabe > 1) {


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


    /**
     *
     *
     * @throws InterruptedException mit try catch abfangen falls Thread unterbrochen wird
     * Die Zeitmessung startet bei Click auf Startund wird mit Stopp angehalten
     */
    public void stoppstart(ActionEvent actionEvent)throws InterruptedException {
        count=0;


        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater1 = new Runnable() {

                    @Override
                    public void run() {


                        if (sec==6&&count==9){
                            sec=0;
                            count=0;
                            min++;
                        }
                        if (count==9){
                            count=0;
                            sec++;
                        }

                        count++;
                        timeausgabe.setText("00:"+"0"+min+":"+sec+count);

                    }
                };

                while (!Stop.isHover()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater1);

                }
            }

        });
        // don't let thread prevent JVM shutdown
        thread2.setDaemon(true);
        thread2.start();
    }
}
