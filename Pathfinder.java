import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Aidan on 6/5/2017.
 */
public class Pathfinder{
    private Heuristic heuristic;

    public Pathfinder(Heuristic heuristic){
        this.heuristic = heuristic;
    }

    public PathWrapper findPath(int startX, int startY, int endX, int endY, Map map, boolean allowDiag){
        ArrayList<Point> openPoints = new ArrayList<Point>();
        ArrayList<Point> closedPoints = new ArrayList<Point>();
        ArrayList<Point> traveledPoints = new ArrayList<Point>();
        Point destination = new Point(endX, endY);
        Point beginning = new Point(startX, startY);
        openPoints.clear();
        closedPoints.clear();
        openPoints.add(beginning);
        while(openPoints.size() > 0){
            Collections.sort(openPoints);
            Point currentPoint = openPoints.get(0);
            if(currentPoint.equals(destination)){
                return new PathWrapper(currentPoint, traveledPoints);
            }
            openPoints.remove(currentPoint);
            closedPoints.add(currentPoint);
            traveledPoints.add(currentPoint);
            for(int xx = -1; xx <= 1; xx++){
                for(int yy = -1; yy <= 1; yy++){
                    Point newPoint;
                    if(Math.abs(xx + yy) == 1){ //if we are directly above, below, to the left, or to the right
                        newPoint = new Point(currentPoint.getX() + xx, currentPoint.getY() + yy, currentPoint, 10);
                    }else if(allowDiag == true){
                        newPoint = new Point(currentPoint.getX() + xx, currentPoint.getY() + yy, currentPoint, 10);
                    }else{
                        continue;
                    }
                    newPoint.setH(heuristic.getDistance(newPoint.getX(), newPoint.getY(), endX, endY) * 10);
                    if(closedPoints.contains(newPoint) || !map.isValidPoint(newPoint)){
                        continue;
                    }else if(!openPoints.contains(newPoint)){
                        openPoints.add(newPoint);
                    }else{
                        if(openPoints.get(openPoints.indexOf(newPoint)).getG() > newPoint.getG()){
                            openPoints.remove(newPoint);
                            openPoints.add(newPoint);
                        }else{
                            continue;
                        }
                    }
                }
            }
        }

        return new PathWrapper();
    }
}
