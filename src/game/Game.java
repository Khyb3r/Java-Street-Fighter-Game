package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.plaf.basic.BasicTreeUI;

/**
 * Your main game entry point
 */
public class Game {


    /** Initialise a new Game. */

    public Game() {

        GameWorld world = new GameWorld();
        GameView view = new GameView(world, 700, 540);
        MouseListener mouseListener = new GiveFocus();

        view.addKeyListener(new StudentKeyController(world.getStudent()));
        BallMouseController ballMouseController = new BallMouseController(world,view);
        view.addMouseListener(ballMouseController);



        view.setFocusable(true);

        final JFrame frame = new JFrame("City Game");
        frame.add(view);

        // draw a 1-metre grid over the view
        view.setGridResolution(1);

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
         JFrame debugView = new DebugViewer(world, 500, 500);

        // start our game world simulation!
        world.start();
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
