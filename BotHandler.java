import com.badlogic.gdx.math.Vector2;

public class BotHandler {
  public Shot[] DCAI(int terrain, Vector2 aStart, Vector2 aGoal){
    DCBot bot = new DCBot(terrain);
    Point start = new Point(aStart.x, aStart.y);
    Point goal = new Point(aGoal.x, aGoal.y);
    return bot.compute(start, goal);
  }
}
