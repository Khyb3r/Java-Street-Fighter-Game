package game;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import city.cs.engine.*;

public class CoinCollectible extends StaticBody {

    private static final Shape coinShape = new CircleShape(0.509f);
    private static final BodyImage coinImage = new BodyImage("data/coin.gif");
    private int coinsAmount;
    private static SoundClip coinSound;
    static {
        try {
            coinSound = new SoundClip("data/coinsound.wav");
            System.out.println("Loading books sound");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }
    @Override
    public void destroy() {
        coinSound.play();
        super.destroy();
    }
    CoinCollectible(World world) {
        super(world,coinShape);
        addImage(coinImage);
        this.coinsAmount = 0;
    }

    public int getCoinsAmount() {
        return coinsAmount;
    }

    public void setCoinsAmount(int coinsAmount) {
        this.coinsAmount = coinsAmount;
    }
}
