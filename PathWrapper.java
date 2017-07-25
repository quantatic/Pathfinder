import java.util.ArrayList;

/**
 * Created by Aidan on 6/6/2017.
 */
public class PathWrapper{
    Path path;
    ArrayList<Point> traveled;

    public PathWrapper(Path path, ArrayList<Point> traveled){
        this.path = path;
        this.traveled = traveled;
    }

    public PathWrapper(Point p, ArrayList<Point> traveled){
        this.path = new Path(p);
        this.traveled = traveled;
    }

    public PathWrapper(){
        path = new Path();
        traveled = new ArrayList<Point>();
    }

    public Path getPath(){
        return path;
    }

    public void setPath(Path path){
        this.path = path;
    }

    public ArrayList<Point> getTraveled(){
        return traveled;
    }

    public void setTraveled(ArrayList<Point> traveled){
        this.traveled = traveled;
    }
}
