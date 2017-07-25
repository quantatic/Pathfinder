import java.awt.*;

/**
 * Created by Aidan on 6/6/2017.
 */
public class Map{
    private int width;
    private int height;
    private int squareSize;
    private boolean[][] obstacles; //access as obstacles[y][x]

    /**
     * Creates a map object, which can be drawn
     * @param width The width (in squares) of the map
     * @param height The height (in squares) of the map
     * @param squareSize The size of each individual square
     */
    public Map(int width, int height, int squareSize){
        this.width = width;
        this.height = height;
        this.squareSize = squareSize;
        this.obstacles = new boolean[height][width];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                obstacles[y][x] = false; //initialize all the squares to empty
            }
        }
    }
    
    /**
     * Creates a map from an existing array of obstacles and a square size
     * @param obstacles a 2d array of boolean values functioning as the obstacles
     * @param squareSize The size of each square
     */
    public Map(boolean[][] obstacles, int squareSize){
        this.obstacles = obstacles;
        this.width = obstacles[0].length;
        this.height = obstacles.length;
        this.squareSize = squareSize;
    }
    
    /**
     * Check if a given location is a valid position on the map
     * @param destinationX The x coordinate of the location to check
     * @param destinationY The y coordinate of the location to check
     * @return A boolean value, True or False, signifying if this is a valid location on the map.
     */
    public boolean isValidLocation(int destinationX, int destinationY){
        return (destinationX >= 0 && destinationX < width && destinationY >= 0 && destinationY < height && !isObstacle(destinationX, destinationY));
    }
    
    /**
     * Does the same as isValidLocation, except with a Point object instead of coordinates
     * @param p The point to check as valid
     * @return A boolean value signifying if this is a valid location on the map.
     */
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
