/**
 * Created by Aidan on 6/5/2017.
 */
public class Manhattan implements Heuristic{
    @Override
    public int getDistance(int startX, int startY, int endX, int endY){
        int distX = Math.abs(startX - endX);
        int distY = Math.abs(startY - endY);
        return distX + distY;
    }
}
