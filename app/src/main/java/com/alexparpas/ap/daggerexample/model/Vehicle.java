package com.alexparpas.ap.daggerexample.model;

import javax.inject.Inject;

/**
 * Created by Alex on 3/8/2017.
 */

public class Vehicle {
    private Motor motor;

    @Inject
    public Vehicle(Motor motor) {
        this.motor = motor;
    }

    public void increaseSpeed(int value){
        motor.accelerate(value);
    }

    public void decreaseSpeed(int value){
        motor.decelerate(value);
    }

    public void stop(){
        motor.brake();
    }

    public int getSpeed(){
        return motor.getRpm();
    }
}
