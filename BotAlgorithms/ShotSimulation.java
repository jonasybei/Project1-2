package com.mygdx.BotAlgorithms;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.Ball;
import com.mygdx.game.Map;
import com.mygdx.game.MapFactory;
import com.mygdx.game.SandSpot;

public class ShotSimulation {


    private Vector3 pos;
    private Map m;
    private float ep = 1 / (float) 4;

    public ShotSimulation(int level) {

        this.m = MapFactory.createMap(level);
    }


    public Vector2 simulate(int degree, int power, Vector2 ballPosition) {
        Ball rollingBall = new Ball();
        rollingBall.setInitialPosition(ballPosition, m);
        Vector2 ballPosAfterShot = new Vector2();
        float realPower = power / 10;
        rollingBall.setVelocity(realPower, fromDegreeToRadians(degree));


        while (rollingBall.isStationary() == false) {

            rollingBall.setNewPosition(m);
            pos = rollingBall.getNewPosition();

            if (pos.z < -0.1)
                rollingBall.resetPosition();

            if (pos.x > 10 || pos.x < -10 || pos.y > 10 || pos.y < -10)
                rollingBall.resetPosition();


            pos = rollingBall.getNewPosition();


            Vector3 tmpPos = rollingBall.getPosition();
            float mu = 0.3f;

            for (SandSpot s : m.getSandMap()) {
                if (s.getPosition().dst(pos.x, pos.y) < ep * s.getRadius()) {
                    mu = 0.6f;
                }
            }
            rollingBall.xRungeKutta(mu);
            rollingBall.yRungeKutta(mu);


        }


        ballPosAfterShot.x = rollingBall.getPosition().x;
        ballPosAfterShot.y = rollingBall.getPosition().y;

        return ballPosAfterShot;

    }

    public float fromDegreeToRadians(float degree) {
        float radians = (float) ((degree * Math.PI) / 180);
        return radians;
    }
}
