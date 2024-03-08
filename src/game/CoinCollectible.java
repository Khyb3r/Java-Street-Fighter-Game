package game;

import city.cs.engine.*;

public class CoinCollectible extends StaticBody {

    private static final Shape coinShape = new CircleShape(0.509f);
    private static final BodyImage coinImage = new BodyImage("data/coin.gif");
    private int coinsAmount;
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
