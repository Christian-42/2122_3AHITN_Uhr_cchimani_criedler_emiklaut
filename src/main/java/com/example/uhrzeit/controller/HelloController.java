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


    /**
     * @author criedler, cchimani
     * Zuerst werden alle Labels befüllt die nicht staendig aktualisiert werden muessen
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
                            aktuelleUhrzeit.setText(ZonedDateTime.now().getHour() - 12 + ":" + ZonedDateTime.now().getMinute() + ":" + ZonedDateTime.now().getSecond());

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



    public void onStoppUhr_Timer_click(ActionEvent actionEvent) throws InterruptedException, IOException {
        new StoppUhr_TimerApplication();
    }

    @FXML
    public void onAnalogclick(ActionEvent actionEvent) throws IOException {
        new AnalogApplication();
    }

    public void onBinaerclick(ActionEvent actionEvent) throws IOException {
        new BinaerApplication();
    }

    public void onswitchformatclick(ActionEvent actionEvent) {
        if (Objects.equals(formattext.getText(), "Switch to 12h Format")) {
             twelvehourformat= true;
            if (ZonedDateTime.now().getHour() < 12) {
                ampm.setText("am");
            } else {
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





