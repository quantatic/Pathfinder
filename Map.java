import java.awt.*;

/**
 * Created by Aidan on 6/6/2017.
 */
public class Map{
    private int width;
    private int height;
    private int squareSize;
    private boolean[][] obstacles; //access as obstacles[y][x]

    public Map(int width, int height, int squareSize){
        this.width = width;
        this.height = height;
        this.squareSize = squareSize;
        this.obstacles = new boolean[height][width];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                obstacles[y][x] = false;
            }
        }
    }

    public Map(boolean[][] obstacles, int squareSize){
        this.obstacles = obstacles;
        this.width = obstacles[0].length;
        this.height = obstacles.length;
        this.squareSize = squareSize;
    }

    public boolean isValidLocation(int destinationX, int destinationY){
        return (destinationX >= 0 && destinationX < width && destinationY >= 0 && destinationY < height && !isObstacle(destinationX, destinationY));
    }

    public boolean isValidPoint(Point p){
        return (p.getX() >= 0 && p.getX() < width && p.getY() >= 0 && p.getY() < height && !isObstacle(p.getX(), p.getY()));
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getSquareSize(){
        return squareSize;
    }

    public void setSquareSize(int squareSize){
        this.squareSize = squareSize;
    }

    public void addObstacle(int x, int y){
        obstacles[y][x] = true;

    }

    public void removeObstacle(int x, int y){
        obstacles[y][x] = false;
    }

    public boolean isObstacle(int x, int y){
        return obstacles[y][x];
    }
}
