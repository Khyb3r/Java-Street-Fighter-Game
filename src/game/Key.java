package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * Represents a key object in the game. Plays a sound when destroyed.
 */
public class Key extends StaticBody {
    private static final Shape keyShape = new PolygonShape(-0.88f,-1.58f, -0.84f,1.74f, 0.88f,1.74f, 0.83f,-1.57f
    );
    private static final BodyImage keyImage = new BodyImage("data/key.gif",3.25f);
    private static SoundClip keySound;
    static {
        try {
            keySound = new SoundClip("data/wingame.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Destroys the key, playing a sound effect.
     */
    @Override
    public void destroy() {
        keySound.play();
        super.destroy();
    }
    /**
     * Constructs a new Key object.
     * @param gameLevel The GameLevel object in which the key will be placed.
     */
    Key(GameLevel gameLevel) {
        super(gameLevel,keyShape);
        addImage(keyImage);
    }
}
