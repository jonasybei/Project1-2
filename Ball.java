package com.mygdx.game;

public class Ball {
    private final double size = 0.5;
    private final int mass = 1;
    private final double g = 9.81; // the gravity accelertion
    private final double gravityForce =  this.mass * this.g;
    private double[] position = new double[2]; // x and y values
    private double velocity; //in m/s
    private double acceleration; // in m/s2
    private double[] nextPosition = new double[2]; // x and y values
<<<<<<< HEAD

=======
>>>>>>> 3bfce996481b6212659d267439b275d6bff56830

    public double getSize() {
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

<<<<<<< HEAD
    public double[] getNexrtPosition() {
=======
    public double[] getNextPosition() {
>>>>>>> 3bfce996481b6212659d267439b275d6bff56830
        return nextPosition;
    }
}
