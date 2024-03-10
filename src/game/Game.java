package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.MouseListener;

/**
 * Your main game entry point
 */
public class Game {


    /** Initialise a new Game. */

    public Game() {

        GameWorld world = new GameWorld();
        GameView view = new GameView(world, 800, 600);

        view.setFocusable(true);
        view.addKeyListener(new PlayerFighterKeyController(world.getPlayerFighter()));


        final JFrame frame = new JFrame("Street Fighter");
        frame.add(view);

        // draw a 1-metre grid over the view
       // view.setGridResolution(1);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        //optional: uncomment this to make a debugging view
    // JFrame debugView = new DebugViewer(world, 800, 600);

        // start our game world simulation!
        world.start();
        view.requestFocus();

    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
