package com.example.uhrzeit.view;

import java.util.function.IntBinaryOperator;

public class Zeitformat extends Zeit{
    int min;
    int st;
    int sek;

    Zeitformat(int st, int min, int sek) {
        super(st, min, sek);
    }


    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSek() {
        return sek;
    }

    public void setSek(int sek) {
        this.sek = sek;
    }

    public void zeitformat24(int st, int min, int sek){
        this.st = st;
        this.min = min;
        this.sek = sek;
        if(st > 24) {
            st = st - 24;
            gettime();
        }else
            gettime();
    }

    public void zeitformat12(int st, int min, int sek){
        this.st = st;
        this.min = min;
        this.sek = sek;
        if(st > 12){
            st = st - 12;
            System.out.println(st + ":" + min + ":" + sek + "pm" );
        }else
            System.out.println(st + ":" + min + ":" + sek + "am" );
    }

    public void binaryzeitformat(int st, int min, int sek){
        this.st = st;
        this.min = min;
        this.sek = sek;

        System.out.println(Integer.toBinaryString(st)+ ":" + Integer.toBinaryString(min) + ":" + Integer.toBinaryString(sek));
    }


}




