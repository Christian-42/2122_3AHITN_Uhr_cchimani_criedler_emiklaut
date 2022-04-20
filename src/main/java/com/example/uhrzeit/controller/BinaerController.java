package com.example.uhrzeit.controller;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.time.ZonedDateTime;

/**
 * @author criedler
 * BinaerController ist zuständig für die binary.fxml Datei
 * Es wird für alle Circles Speicherplatz reserviert.
 */
public class BinaerController {

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


    /**
     * Initialize wird beim Start des Fensters aufgerufen
     * Alle circles werden in ein Array gespeichert
     * Es wird ein neues Thread Objekt angelegt.
     * In der run methode werden 3 String variablen angelegt jeweils für die Anzahl der Stunden in Binaer und in Minuten.
     * In werden diese dann zumsammengefuegt.
     * In binm und binh wird jeweils die aktuelle Stunde oder Minute in einen Binary String konvertiert,
     * wobei die Anzahl der Stellen bei Stunden auf 5 Stellen und bei Minuten auf 6 Stellen mit Nullen aufgefuellt wird.
     * In einer for-Schleife wird dann das ganze circlearray durchgegangen und jeder Kreis entweder auf die Farbe rot,
     * oder auf transparent, also nichts, gesetzt. Abhaengig davon ob an der Stelle im binaryString eine 1 steht oder eine 0.
     * Der Thread wird bis zum schließen des Programms ausgefuehrt wobei er jede Sekunde updatet.
     */
    public void initialize() {
        Circle[] name = {h16, h8, h4, h2, h1, m32, m16, m8, m4, m2, m1};


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
                                name[i].setFill(Color.RED);
                            }else {
                                name[i].setFill(Color.TRANSPARENT);

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
