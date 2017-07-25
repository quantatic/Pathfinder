import java.util.Comparator;

/**
 * Created by Aidan on 6/5/2017.
 */
public class Point implements Comparable<Point>{
    private int x;
    private int y;
    private int f; //total "cost"
    private int g; //cost to get to this square so far
    private int h; //calculated heuristic to get to the end
    private Point parent;

    public Point(int x, int y, Point parent, int additionalG){
        this.x = x;
        this.y = y;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.parent = parent;
        if(this.parent != null){
            setG(parent.getG() + additionalG);
        }
    }

    public Point(int x, int y){
        this(x, y, null, 0);
    }

    public Point(){
        this(0, 0, null, 0);
    }

    public int getX(){
        return x;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getY(){
        return y;
    }

    public void setY(int y){
        this.y = y;
    }

    public Point getParent(){
        return parent;
    }

    public void setParent(Point parent){
        this.parent = parent;
    }

    public int getF(){
        return f;
    }

    public int getG(){
        return g;
    }

    public void setG(int g){
        this.g = g;
        updateF();
    }

    public int getH(){
        return h;
    }

    public void setH(int h){
        this.h = h;
        updateF();
    }

    private void updateF(){
        f = g + h;
    }

    public String toString(){
        return "(" + getX() + ", " + getY() + ")";
    }
    
    @Override
    public int compareTo(Point o){ //enables you to just sort the list
        if(getF() < o.getF()){
            return -1;
        }else if(getF() > o.getF()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        boolean isEqual = false;

        if(o instanceof Point){
            Point obj = (Point) o;
            isEqual = (obj.getX() == getX() && obj.getY() == getY());
        }

        return isEqual;
    }
}
