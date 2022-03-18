package com.example.uhrzeit.view;

import java.util.Objects;

public class Zeit{
    int min;
    int st;
    int sek;

    public void setMin(int min){
        this.min = min;
    }

    public void setSt(int st){
        this.st = st;
    }

    public void setSek(int sek) {
        this.sek = sek;
    }

    public Zeit(int st, int min, int sek) {
        setSt(st);
        setMin(min);
        setSek(sek);

    }

    public void gettime(){
        System.out.println("Time: " + st + ":" + min + ":" + sek);
    }


    public void gethintergrund(){
        if ((st >=6 && min >= 0 && sek >= 0)&&(st <= 18 && min <= 59 && sek <= 59)){
            System.out.println("Hell");
        }else {
            System.out.println("Dunkel");
        }
    }


    public Zeit clone(){
        Zeit z1 = new Zeit(st, min, sek);
        return z1;
    }

    public boolean equals(Zeit o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }else
            return min == o.min && st == o.st && sek == o.sek;
    }

}
