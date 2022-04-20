package com.example.uhrzeit.controller;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ResourceBundle;

public class BinaerController implements Initializable {

    public Circle h16;
    public Circle h8;
    public Circle h4;
    public Circle h2;
    public Circle h1;
    public Circle m32;
    public Circle m16;
    public Circle m8;
    public Circle m4;
    public Circle m2;
    public Circle m1;
    public Circle[] circlesarr = new Circle[11];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Circle[] name = {h16, h8, h4, h2, h1, m32, m16, m8, m4, m2, m1};
        circlesarr = name;


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        String binh;
                        String binm;
                        String bin;

                        binm = String.format("%6s", Integer.toBinaryString(ZonedDateTime.now().getMinute())).replace(' ', '0');
                        binh= String.format("%5s", Integer.toBinaryString(ZonedDateTime.now().getHour())).replace(' ', '0');
                        bin = binh + binm;

                        for (int i = 0; i < 11; i++) {
                            if (bin.charAt(i) == '1') {
                                circlesarr[i].setFill(Color.RED);
                            }else {
                                circlesarr[i].setFill(Color.TRANSPARENT);

                            }
                        }
                    }
                };

                while (true) {
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
