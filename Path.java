import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Aidan on 6/5/2017.
 */
public class Path{
    private ArrayList<Point> pathArrayList;
    private int index = 0;

    public Path(Point p){ //generates a pathArrayList from a hierarchy of points
        pathArrayList = new ArrayList<Point>();
        while(p != null){
            pathArrayList.add(0, p);
            p = p.getParent();
        }
    }

    public Path(){
        pathArrayList = new ArrayList<Point>();
    }

    public ArrayList<Point> getpathArrayList(){
        return pathArrayList;
    }

    public void setpathArrayList(ArrayList<Point> pathArrayList){
        this.pathArrayList = pathArrayList;
    }

    public String toString(){
        String result = "";
        for(Point p : pathArrayList){
            result += p.toString() + "\n";
        }
        return result;
    }
}
