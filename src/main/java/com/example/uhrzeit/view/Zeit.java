package com.example.uhrzeit.view;

import javafx.scene.layout.Pane;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

import static java.lang.Thread.sleep;

    public class Zeit implements Runnable {
        int min;
        int st;
        int sek;        Pane minutes;
        Pane hours;



        public Zeit(Pane minutes, Pane hour) {
            st = ZonedDateTime.now().getHour();
            min = ZonedDateTime.now().getMinute();
            sek = ZonedDateTime.now().getSecond();
            this.minutes = minutes;
            hours = hour;
        }

        public Zeit() {

        }


        public void gettime() {
            System.out.println("Time: " + st + ":" + min + ":" + sek);
        }


        public void gethintergrund() {
            if ((st >= 6 && min >= 0 && sek >= 0) && (st <= 18 && min <= 59 && sek <= 59)) {
                System.out.println("Hell");
            } else {
                System.out.println("Dunkel");
            }
        }




        @Override
        public void run() {
            boolean showTime = true;
            while (showTime) {
                Calendar calendar = GregorianCalendar.getInstance();
                final double seedSecondDegrees = calendar.get(Calendar.SECOND) * (360 / 60);
                final double seedMinuteDegrees = (calendar.get(Calendar.MINUTE) + seedSecondDegrees / 360.0) * (360 / 60);
                final double seedHourDegrees = (calendar.get(Calendar.HOUR) + seedMinuteDegrees / 360.0) * (360 / 12);

                minutes.setRotate(seedMinuteDegrees);
                hours.setRotate(seedHourDegrees);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
