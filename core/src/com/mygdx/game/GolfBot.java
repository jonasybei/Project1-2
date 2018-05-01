package com.mygdx.game;

import java.awt.*;
import java.util.ArrayList;


public class GolfBot {

  private int terrain;

  public GolfBot(int terrain) {
    this.terrain = terrain;
  }

  public int[] play(Point start, Point goal){
    //if we can reach the goal in one shot, go for it!
    if(canReachGoal(start, goal)) {
      //compute power
      //shoot
    } else {
      //Start the algorithm.
      ArrayList<Point> points = new ArrayList<Point>();

    }
    return null;
  }

  public boolean canReachGoal(Point point, Point goal){
    int steps = 100; //This is wrong! MUST BE CHANGED!

    for(int i = 1; i < steps; i++) {
      double t = i/steps;
      if(Terrain.compute(terrain, (point.getX() + t * (goal.getX() - point.getX())), (point.getY() + t * (goal.getY() - point.getY()))) < 0) {

        return false;
      }
    }
    return true;
  }

}
