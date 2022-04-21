package com.example.uhrzeit.controller;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author criedler, cchimani
 * Verantwortlich fuer die Funktionalitaet im Menu_Digital.fxml
 * Die Kompononenten die im fxml eine fxid haben werden initalisiert um sie zu bearbeiten.
 */

public class HelloController {
    public Label aktuelleUhrzeit;
    public Label aktuellesDatum;
    public Label aktuelleKalenderWoche;
    public BorderPane Hintergrund;
    public Label ampm;
    public Button formattext;
    public boolean twelvehourformat=false;
    public boolean vormittag=false;


    /**
     * @author criedler, cchimani
     * Zuerst werden alle Labels befüllt die nicht staendig aktualisiert werden muessen wie Datum und Kalenderwoche
     * Anschließend wird ein neuer Thread erstellt.
     * In der run methode werden dann Stunden minuten und Sekunden jede Sekunde neu akutalisiert
     * Abhängig davon welches der 2 Zeitformate ausgewählt ist wird die Uhrzeit dann dementsprechend ausgegeben
     *
     *
     */
    public void initialize() {

        aktuellesDatum.setText(ZonedDateTime.now().getDayOfMonth() + "." + ZonedDateTime.now().getMonthValue() + "." + ZonedDateTime.now().getYear());

        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        aktuelleKalenderWoche.setText(String.valueOf(calendar.get(Calendar.WEEK_OF_YEAR)));
        formattext.setText("Switch to 12h Format");


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        if(!twelvehourformat) {

                            aktuelleUhrzeit.setText(ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());
                        }else {
                            if (!vormittag) {
                                aktuelleUhrzeit.setText(ZonedDateTime.now().getHour() - 12 + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());
                            }else{
                                aktuelleUhrzeit.setText(ZonedDateTime.now().getHour() + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());

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


    /**
     *
     * Ruft den Konstruktur der StoppUhr_TimerApplication Klase auf
     */
    public void onStoppUhr_Timer_click() throws IOException {
        new StoppUhr_TimerApplication();
    }

    /**
     *      * Ruft den Konstruktur der AnalogApplication Klasse auf
     */
    @FXML
    public void onAnalogclick() throws IOException {
        new AnalogApplication();
    }

    /**
     * Ruft den Konstruktur der BinaerApplication Klasse auf
     */
    public void onBinaerclick() throws IOException {
        new BinaerApplication();
    }

    /**
     * Überprüft in was fuer einem Format die Uhr aktuell ausgegeben wird in dem der Text im Label verglichen wird.
     * Wenn im button "Switch to 12h format" steht, heißt das, dass der Benutzer auf 12h format wechseln möchte,
     * dementsprechend wird die variable twelvehourformat auf wahr gesetzt.
     * Anschließend muss man noch herausfinden ob es vor oder nachmittag ist um zu wiisen ob am oder pm angezeigt werden muss.
     * Wenn die Anzahl der Stunden weniger wie 12 ist wird vormittag auf wahr gesetzt.
     * Mit dieser variable kann spaeter heruasgefunden werden ob die Stunden -12 gerechnet werden muessen.
     * Zu Ende wird der Text im Switch Button noch auf das davorige Zeitformat gesetzt (24h Format).
     * Falls im Label nicht "Switch to 12h Format" steht wird twelvehourformat auf False gesetzt,
     * der Text im Button auf "Switch to 12h format" gesetzt und das am/pm lable gecleared
     *
     */
    public void onswitchformatclick() {
        if (Objects.equals(formattext.getText(), "Switch to 12h Format")) {
             twelvehourformat= true;
            if (ZonedDateTime.now().getHour() < 12) {
                vormittag=true;
                ampm.setText("am");
            } else {
                vormittag=false;
                ampm.setText("pm");
            }
            formattext.setText("Switch to 24h Format");
        } else {
            twelvehourformat=false;
            formattext.setText("Switch to 12h Format");
            ampm.setText("");

        }

    }
}





