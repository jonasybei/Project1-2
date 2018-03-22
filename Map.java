package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

class Map {
    private final double sandFrinction = 0.6;
    private final double grassFriction = 0.3;

    private ArrayList<Tree> treeMap;
    private ArrayList<SandSpot> sandMap;

    private Vector2 startPos;
    private Vector2 endPos;


    private int terrain;

    private int width;
    private int height;

    Map(ArrayList<Tree> atreeMap, ArrayList<SandSpot> asandMap, int t){
        treeMap = atreeMap;
        sandMap = asandMap;

        terrain = t;

        startPos = Terrain.startPos(t);
        endPos = Terrain.endPos(t);
    }
<<<<<<< HEAD

    public int getTerrain() {
        return terrain;
    }

    public Vector2 getEndPos() {
        return endPos;
    }

    public Vector2 getStartPos() {
        return startPos;
    }

    public ArrayList<Tree> getTreeMap() {
        return treeMap;
    }

    public ArrayList<SandSpot> getSandMap() {
        return sandMap;
    }
=======
>>>>>>> 3bfce996481b6212659d267439b275d6bff56830
}
