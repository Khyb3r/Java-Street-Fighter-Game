import city.cs.engine.BodyImage;
import city.cs.engine.World;
import game.Fighter;

public class PlayerFighter extends Fighter {

    private int coins;

    private static final BodyImage playerImage = new BodyImage("data/3F3F.gif",4f);

    public PlayerFighter(World world) {
        super(world);
        addImage(playerImage);
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
