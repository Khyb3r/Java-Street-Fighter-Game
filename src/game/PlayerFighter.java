package game;

import city.cs.engine.AttachedImage;
import city.cs.engine.SolidFixture;
import city.cs.engine.SoundClip;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
/**
 * Represents the player's fighter character in the game. This class extends the Fighter class
 * and includes additional functionality specific to the player, such as keeping track of coins
 * collected and health status.
 */
public class PlayerFighter extends Fighter {
    private boolean facingLeft;
    private int coinCount;
    private int healthCount;
    private static SoundClip playerSound;
    static {
        try {
            playerSound = new SoundClip("data/grunt.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    public void playerGrunt() {
        playerSound.play();
    }


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

