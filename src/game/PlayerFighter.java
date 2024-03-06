package game;

import city.cs.engine.AttachedImage;
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

    // methods to shoot projectiles from the Player fighter
    public void shootKnifeLeft() {
        ThrowingKnifeProjectile throwingKnifeProjectile = new ThrowingKnifeProjectile(getWorld());
        // position of the projectile is the same as the fighters
        throwingKnifeProjectile.setPosition(getPosition().add(new Vec2()));
        // force for the orb
        throwingKnifeProjectile.applyForce(new Vec2(50,0));
    }
    public void shootKnifeRight() {
        ThrowingKnifeProjectile throwingKnifeProjectile = new ThrowingKnifeProjectile(getWorld());
        // position of the projectile is the same as the fighters
        throwingKnifeProjectile.setPosition(getPosition());
        // force for the orb
        throwingKnifeProjectile.applyForce(new Vec2(-50,0));
    }

    public int getCoins() {return coinCount;}
    public void setCoins(int coins) {this.coinCount = coins;}
    public int getLives() {return liveCount;}
    public void setLives(int lives) {this.liveCount = lives;}

}

