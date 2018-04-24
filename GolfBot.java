import java.util.ArrayList;

public class GolfBot {

  public static int[] play(double startX, double startY, double goalX, double goalY, int terrain){
    //if we can reach the goal in one shot, go for it!
    if(canReachGoal(startX, startY, goalX, goalY, terrain)) {
      //compute power
      //shoot
    } else {

    }
    return null;
  }

  public static boolean canReachGoal(double pointX, double pointY, double goalX, double goalY, int terrain){
    int steps = 100; //This is wrong! MUST BE CHANGED!

    for(int i = 1; i < steps; i++) {
      double t = i/steps;
      if(Terrain.compute(terrain, (pointX + t * (goalX - pointX)), (pointY + t * (goalY - pointY))) < 0) {

        return false;
      }
    }
    return true;
  }

}
