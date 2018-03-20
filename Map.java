package com.mygdx.game;

public class Map {
    private double heightFunction; //the height related to a specific x and y
    private final double sandFrinction = 0.6;
    private final double grassFriction = 0.3;
    private Tree[] treeMap;
    private SandSpot[] sandMap;

    public Map(Tree[] atreeMap,SandSpot[] asandMap){
        this.treeMap = atreeMap;
        this.sandMap = asandMap;
    }
}
