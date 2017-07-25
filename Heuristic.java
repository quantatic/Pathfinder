/**
 * Created by Aidan on 6/5/2017.
 */
public interface Heuristic{
	/**
	 * Gets the distance between two points.
	 * @param startX The starting x position.
	 * @param startY The starting y position.
	 * @param endX The ending x position.
	 * @param endY The ending y position.
	 * @return The distance between two points.
	 */
    public int getDistance(int startX, int startY, int endX, int endY);
}
