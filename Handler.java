import javax.swing.*;
import java.awt.*;

/**
 * Created by Aidan on 6/5/2017.
 */
public class Handler extends JFrame{
    public Handler(){
        initUI();
    }

    private void initUI(){
        setTitle("A* Pathfinding");
        add(new Window());
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Handler myHandler = new Handler();
                myHandler.setVisible(true);
            }
        });
    }
}
