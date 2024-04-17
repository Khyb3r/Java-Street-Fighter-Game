package game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;


import java.awt.*;
import java.awt.event.MouseListener;


/**
 * Your main game entry point
 */
public class Game {


    /**
     * Initialise a new Game.
     */
    private GameLevel level;
    private GameView gameView;
    private PlayerFighterKeyController playerController;
    private SoundClip gameMusic;

    public Game() {

        // GameWorld world = new GameWorld();
        level = new Level1(this);

        try {
            gameMusic = new SoundClip("data/gametheme.wav");
            gameMusic.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);

            // make a view
            gameView = new GameView(level, 800, 600);
            playerController = new PlayerFighterKeyController(level.getPlayerFighter());
            gameView.addKeyListener(playerController);
            gameView.setFocusable(true);


            final JFrame frame = new JFrame("Street Fighter");
            frame.add(gameView);

            // draw a 1-metre grid over the view
            gameView.setGridResolution(1);

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
            JFrame debugView = new DebugViewer(level, 800, 600);

            // start our game world simulation!
            level.start();
            gameView.requestFocus();

        }
    }

    public void restartGame() {
        level.getPlayerFighter().resetHealth();
        level.getPlayerFighter().resetCoins();
        goToLevel1();
    }

    public void goToNextLevel() {
        if (level instanceof Level1) {
            level.stop();
            PlayerFighter prevFighter = level.getPlayerFighter();
            level = new Level2(this);
            gameView.setBackground("data/sky21.jpeg");
            PlayerFighter newFighter = level.getPlayerFighter();
            newFighter.setCoins(prevFighter.getCoins());
            newFighter.setHealthCount(prevFighter.getHealthCount());
            gameView.setWorld(level);
            playerController.updatePlayer(newFighter);
            gameView.updateView();
            level.start();
        } /*else if (level instanceof Level2) {
            level.stop();
            PlayerFighter previousFighter = level.getPlayerFighter();
            level = new Level3(this);
            PlayerFighter newestFighter = level.getPlayerFighter();
            gameView.setWorld(level);
            playerController.updatePlayer(newestFighter);
            level.start();
     //   } else if (level instanceof Level3) {
      //      level.stop(); */
    }

    public void goToLevel3() {
        if (level instanceof Level2) {
            level.stop();
            PlayerFighter previousFighter = level.getPlayerFighter();
            level = new Level3(this);
            gameView.setBackground("data/desert3.jpeg");
            PlayerFighter newestFighter = level.getPlayerFighter();
            newestFighter.setCoins(previousFighter.getCoins());
            newestFighter.setHealthCount(previousFighter.getHealthCount());
            gameView.setWorld(level);
            gameView.updateView();
            playerController.updatePlayer(newestFighter);
            level.start();
        }
    }

    public void goToLevel1() {
        level.stop();
        level = new Level1(this);
        gameView.setWorld(level);
        gameView.setBackground("data/back.jpg");
        playerController.updatePlayer(level.getPlayerFighter());
        level.start();
    }

    /**
     * Run the game.
     */
    public static void main(String[] args) {

        new Game();
    }
}
