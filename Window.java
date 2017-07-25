import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by Aidan on 6/5/2017.
 */
public class Window extends JPanel{
    private int startX = 2;
    private int startY = 2;
    private int endX = 14;
    private int endY = 8;
    private Map map = new Map(128, 128, 8);

    public Window(){
        initUI();
        addMouseMotionListener(new MotionAdapter());
        addMouseListener(new Adapter());
    }

    private void initUI(){
        setFocusable(true);
        setPreferredSize(new Dimension(map.getWidth() * map.getSquareSize(), map.getHeight() * map.getSquareSize()));
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int size = map.getSquareSize();

        Graphics2D g2d = (Graphics2D) g;
        Pathfinder finder = new Pathfinder(new Manhattan()); //we're using the manhattan method here
        PathWrapper path = finder.findPath(startX, startY, endX, endY, map, true);

        for(int x = 0; x < map.getWidth(); x++){
            for(int y = 0; y < map.getHeight(); y++){
                if(map.isObstacle(x, y)){
                    g2d.setColor(Color.blue);
                    g2d.fillRect(x * size, y * size, size, size);
                }
            }
        }

        for(Point p : path.getTraveled()){
            g2d.setColor(Color.lightGray);
            g2d.fillRect(p.getX() * size, p.getY() * size, size, size);
        }

//        for(Point p : path.getTraveled()){
//            g2d.setColor(Color.black);
//            g2d.drawString(Integer.toString(p.getF()), p.getX() * size, (int)((p.getY() + 0.5) * size));
//        }

        for(Point p : path.getPath().getpathArrayList()){
            if(p.getParent() != null){
                g2d.setColor(Color.black);
                g2d.drawLine((int)((p.getX() + 0.5) * size), (int)((p.getY() + 0.5) * size), (int)((p.getParent().getX() + 0.5) * size), (int)((p.getParent().getY() + 0.5) * size));
//                g2d.setFont(g2d.getFont().deriveFont(9.0f)); //uncomment to show the cost of each square
//                g2d.drawString(Integer.toString(p.getF()), p.getX() * size, p.getY() * size);
            }
        }

        g2d.setColor(Color.green);
        g2d.fillRect((int)(startX) * size, (int)(startY) * size, size, size);
        g2d.setColor(Color.red);
        g2d.fillRect((int)(endX) * size, (int)(endY) * size, size, size);
    }

    private class MotionAdapter extends MouseMotionAdapter{
        @Override
        public void mouseMoved(MouseEvent e){
            startX = (int)(e.getX() / map.getSquareSize());
            startY = (int)(e.getY() / map.getSquareSize());
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                map.addObstacle((int) (e.getX() / map.getSquareSize()), (int) (e.getY() / map.getSquareSize()));
            }else if(SwingUtilities.isRightMouseButton(e)){
                map.removeObstacle((int) (e.getX() / map.getSquareSize()), (int) (e.getY() / map.getSquareSize()));
            }
            repaint();
        }
    }

    private class Adapter extends MouseAdapter{
        @Override
        public void mouseReleased(MouseEvent e){
            if(SwingUtilities.isLeftMouseButton(e)){
                map.addObstacle((int) (e.getX() / map.getSquareSize()), (int) (e.getY() / map.getSquareSize()));
            }else if(SwingUtilities.isRightMouseButton(e)){
                map.removeObstacle((int) (e.getX() / map.getSquareSize()), (int) (e.getY() / map.getSquareSize()));
            }
            repaint();
        }
    }
}
