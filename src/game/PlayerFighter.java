package game;

import city.cs.engine.World;

public class PlayerFighter extends Fighter {
    private int coins;

    public PlayerFighter(World world, String type) {
        super(world,type);
        coins = 0;
    }
    public int getCoins() {return coins;}
    public void setCoins(int coins) {this.coins = coins;}
}

