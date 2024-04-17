package game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import city.cs.engine.*;
/**
 * CoinCollectible class represents a static body in the game world that represents a collectible coin.
 * It extends the StaticBody class from the city.cs.engine package.
 */
public class CoinCollectible extends StaticBody {

    private static final Shape coinShape = new CircleShape(0.509f);
    private static final BodyImage coinImage = new BodyImage("data/coin.gif");
    private int coinsAmount;
    private static SoundClip coinSound;
    static {
        try {
            coinSound = new SoundClip("data/coinsound.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * Destroys the coin and plays a coin sound effect.
     */
    @Override
    public void destroy() {
        coinSound.play();
        super.destroy();
    }
    /**
     * Constructs a CoinCollectible object and adds it to the specified world.
     *
     * @param world the world in which the CoinCollectible will be added
     */
    CoinCollectible(World world) {
        super(world,coinShape);
        addImage(coinImage);
        this.coinsAmount = 0;
    }
    /**
     * Gets the current amount of coins.
     *
     * @return the current amount of coins
     */
    public int getCoinsAmount() {
        return coinsAmount;
    }
    /**
     * Sets the amount of coins.
     *
     * @param coinsAmount the new amount of coins
     */
    public void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }
}
