import java.util.ArrayList;

public class GolfBot {

  //index of terrain
  private int terrainIndex;

  public GolfBot(int terrainIndex) {
    this.terrainIndex = terrainIndex;
  }

  public void play(Point start, Point goal){
    //if we can reach the goal in one shot, go for it!
    if(canReach(start, goal)) {
      shoot(start, goal);
    } else {
      //Start the algorithm.
      //For now, the bot only shoots twice. This should be enough.
      boolean done = false;
      //Specify the points!
      Subspace terrainSpace = new Subspace();
      ArrayList<Subspace> subspaces = terrainSpace.getSubspaces();
      while(!done) {
        
      }
    }
    return null;
  }

  //computes the power required from start to finish
  public int computePower(Point start, Point goal) {
    //???
    return 0;
  }


  public void shoot(Point start, Point goal) {
    //???
  }

  public boolean canReach(Point point, Point goal){
    int steps = 10000; //This is wrong! MUST BE CHANGED!

    for(int i = 1; i < steps; i++) {
      double t = i/steps;
      if(Terrain.compute(terrainIndex, (point.getX() + t * (goal.getX() - point.getX())), (point.getY() + t * (goal.getY() - point.getY()))) < 0) {

        return false;
      }
    }
    return true;
  }
}
