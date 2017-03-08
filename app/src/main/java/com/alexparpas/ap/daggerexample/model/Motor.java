package com.alexparpas.ap.daggerexample.model;

/**
 * Created by Alex on 3/8/2017.
 */

public class Motor {
    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int value){
        rpm += value;
    }

    public void decelerate(int value){
        rpm -= value;
    }

    public void brake(){
        rpm = 0;
    }
}
