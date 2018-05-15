import com.badlogic.gdx.math.Vector2;

public class BotHandler {
  public Shot[] DCAI(Vector2 aStart, Vector2 aGoal){
    Point start = new Point(aStart.x, aStart.y);
    Point goal = new Point(aGoal.x, aGoal.y);
    return DCBot.compute(start, goal);
  }
}
