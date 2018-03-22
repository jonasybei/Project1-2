package com.mygdx.game;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Vector2;
import java.lang.Math;

public class Ball {
    private final double size = 0.5;
    private final int mass = 1;
    private final double g = 9.81; // the gravity accelertion
    private final double h = 0.0125;
    private final double gravityForce =  this.mass * this.g;
    private Vector3 pos = new Vector3(); // x and y values
    private Vector3 safePosition = new Vector3();
    private Vector3 velocity = new Vector3();
    private Vector3 lastPos = new Vector3();
    private double lastz;
    private double totalVelocity; //in m/s
    private double alfa;
    private double acceleration; // in m/s2
    private boolean target;
    private int stopN = 0;


    public void setInitialPosition (Vector2 position, Map m) {
        pos.x=position.x;
        pos.y=position.y;
        pos.z= (float) Terrain.compute(m.getTerrain(),pos.x,pos.y);
        lastPos.x = pos.x;
        lastPos.y = pos.y;
        lastPos.z = pos.z;
        safePosition.x=pos.x;
        safePosition.y=pos.y;

    }

    public void resetPosition() {
        pos.x = safePosition.x;
        pos.y = safePosition.y;
        pos.z = (float) Terrain.compute(2,pos.x,pos.y);

        velocity.set(0,0,0);
        totalVelocity = 0;
    }

    public void setVelocity (float input, float alfa) {
        totalVelocity=(input);

        velocity.x=(float)(Math.abs(totalVelocity*Math.cos(alfa)));
        velocity.y=(float)(Math.abs(totalVelocity*Math.sin(alfa)));
        velocity.z=0;
    }

    public void setNewPosition (Map m) {
        lastPos.x = pos.x;
        lastPos.y = pos.y;
        lastPos.z = pos.z;
        pos.x =(float) (pos.x+h*velocity.x);
        pos.y= (float)  (pos.y+h*velocity.y);
        pos.z= (float)  (Terrain.compute(m.getTerrain(),pos.x,pos.y));
    }

    public boolean isStationary() {
        if(totalVelocity == 0)
            stopN++;
        else
            stopN = 0;

        return stopN > 80;
    }

    public Vector3 getNewPosition () {
        return pos;
    }

    public void setNewVelocity(double mu) {
        if(velocity.x > 0) {
            velocity.x = (float) (velocity.x - (mu * g * h)* (((pos.z - lastPos.z)/(pos.x - lastPos.x))+1));
        }else {
            velocity.x = 0;
        }
        if(velocity.y > 0) {
            velocity.y = (float) (velocity.y - (mu * g * h)* (((pos.z - lastPos.z)/(pos.y - lastPos.y))+1));
        }else{
            velocity.y = 0;
        }
        if(velocity.x > 0 || velocity.y > 0) {
            //velocity.z = (float) (velocity.z - g * h * (pos.z - lastPos.z));
            velocity.z = (float) (velocity.z - g * h * (pos.z - lastPos.z));
        }else{
            velocity.z = 0;
        }
        totalVelocity=Math.sqrt(Math.pow(velocity.x,2)+Math.pow(velocity.y,2)+Math.pow(velocity.z,2));
    }



    public double getSize() {
        return size;
    }

    public double getMass() {
        return mass;
    }

    public Vector3 getPosition() {
        return pos;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void resetVelocity() {
        velocity.set(0,0,0);
        totalVelocity = 0;
    }
}
