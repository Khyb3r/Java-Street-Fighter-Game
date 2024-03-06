package game;

import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class PlayerFighter extends Fighter {
    private int coinCount;
    private int liveCount;
    public PlayerFighter(World world, String type) {
        super(world,type);
        coinCount = 0;
        liveCount = 2;
    }

    // method to shoot projectiles from the Player fighter
    public void shootOrb() {
        OrbProjectile orbProjectile = new OrbProjectile(getWorld());
        // position of the projectile is the same as the fighters
        orbProjectile.setPosition(getPosition());
        // force for the orb
        orbProjectile.applyForce(new Vec2(10,0));
    }
    public int getCoins() {return coinCount;}
    public void setCoins(int coins) {this.coinCount = coins;}
    public int getLives() {return liveCount;}
    public void setLives(int lives) {this.liveCount = lives;}
}

