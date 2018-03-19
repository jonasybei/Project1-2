package com.mygdx.game;

public class Ball {
    private int size;
    private double mass;
    private double[] position = new double[2]; // x and y values
    private double velocity; //in m/s
    private double acceleration; // in m/s2
    private double[] nexrtPosition = new double[2]; // x and y values
    

    public int getSize() {
        return size;
    }

    public double getMass() {
        return mass;
    }

    public double[] getPosition() {
        return position;
    }

    public double getVelocity() {
        return velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public double[] getNexrtPosition() {
        return nexrtPosition;
    }
}
