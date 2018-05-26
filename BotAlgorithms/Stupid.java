package com.mygdx.BotAlgorithms;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Terrain;

public class Stupid {
    private Vector2 endPos;
    private Terrain t = new Terrain();
    private ShotSimulation simulation;

    public Stupid(int terrainNumber) {
        this.endPos = this.t.endPos(terrainNumber);
        this.simulation = new ShotSimulation(terrainNumber);
    }

    public int[] getNextShot(Vector2 ballPosition) {

        int degree = 0;
        int power = 0;
        double distance = 1000000000;

        for (int i = 0; i < 360; i++) {
            for (int j = 0; j < 100; j++) {
                // simulate is a method which simulated a shot in certyain terrain and outputs the position of the ball after the shot
                Vector2 ballPos = simulation.simulate(i, j, ballPosition);
                System.out.println(" degree= " + i + " power= " + j + "  distance= " + getDistantsToEnd(ballPos));

                if (getDistantsToEnd(ballPos) < distance) {
                    distance = getDistantsToEnd(ballPos);
                    degree = i;
                    power = j;
                }
            }
        }

        int[] nextShot = {degree, power};
        System.out.println("nextShot power " + power + "  nextShot degree " + degree);

        return nextShot;
    }

    public double getDistantsToEnd(Vector2 pos) {
        double distance = Math.abs(Math.sqrt(Math.pow((double) this.endPos.x - pos.x, 2) + Math.pow((double) this.endPos.y - pos.y, 2)));
        return distance;
    }

}
