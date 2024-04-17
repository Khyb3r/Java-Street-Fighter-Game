package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

public class PlayerFighter extends Fighter {
    private boolean facingLeft;
    private int coinCount;
    private int healthCount;
    private AttachedImage attachedImage;

    public PlayerFighter(World world, String type) {
        super(world,type);
        coinCount = 0;
        healthCount = 100;
        facingLeft = false;
    }
    public boolean getFacingLeft() {
        return facingLeft;
    }

    public void setFacingLeft(boolean facingLeft) {
        this.facingLeft = facingLeft;
    }

    public void resetHealth() {
        healthCount = 100;
    }
    public void resetCoins() {
        coinCount = 0;
    }
    // methods to shoot projectiles from the Player fighter
    public void playerShootOrb() {
        OrbProjectile orbProjectile = new OrbProjectile(getWorld());
        float playerPosX = this.getPosition().x;
        float playerPosY = this.getPosition().y;
        // position of the projectile is the same as the fighters

        // force for the orb
        if (this.getFacingLeft()) {
            orbProjectile.setPosition(new Vec2(playerPosX - 1, playerPosY + 0.5f));
            orbProjectile.setLinearVelocity(new Vec2(-15,0));
            orbProjectile.setAlwaysOutline(true);
        } else {
            orbProjectile.setPosition(new Vec2(playerPosX + 1, playerPosY + 0.5f));
            orbProjectile.setLinearVelocity(new Vec2(15, 0));
            orbProjectile.setAlwaysOutline(true);
        }

    }

    public int getCoins() {return coinCount;}
    public void setCoins(int coins) {this.coinCount = coins;}
    public int getHealthCount() {return healthCount;}
    public void setHealthCount(int healthCount) {this.healthCount = healthCount;}

}

