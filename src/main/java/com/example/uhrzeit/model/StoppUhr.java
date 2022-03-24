package com.example.uhrzeit.model;

public class StoppUhr {
    public int sec, min, h;
    private boolean isRunning = true;
    public String ausgabe;

    public void validTimeFormat() {
        if (sec == 60) {
            min++;
            sec = 0;
        }
        if (min == 60) {
            h++;
            min = 0;
        }
    }


    public String run() {
        resetTime();

        while (isRunning) {
            try {
                Thread.sleep(999);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sec++;
            validTimeFormat();
            intTimeToString();
            ausgabe = (h + " : " + min + " : " + sec);


        }
        return ausgabe;
    }

    private void resetTime() {
        sec = 0;
        min = 0;
        h = 0;

    }

    public void intTimeToString() {
        String s = String.valueOf(sec);
        String m = String.valueOf(min);
        String hr = Integer.toString(h);

    }

}