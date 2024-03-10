package game;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.Port;

public class PlayerFighterCollisions implements CollisionListener {
    private PlayerFighter playerFighter;

    private GameWorld world;
    public PlayerFighterCollisions(PlayerFighter playerFighter, GameWorld world) {
        this.playerFighter = playerFighter;
        this.world = world;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Obstacle || e.getOtherBody() instanceof Fighter) {
            if (playerFighter.getPosition().x < e.getOtherBody().getPosition().x) {
                playerFighter.setLinearVelocity(new Vec2(-4.5f,10));
            }
            if (playerFighter.getPosition().x > e.getOtherBody().getPosition().x){
                playerFighter.setLinearVelocity(new Vec2(4.5f,10));
            }
            playerFighter.setHealthCount(playerFighter.getHealthCount() - 1);
        } else if (e.getOtherBody() instanceof CoinCollectible) {
            playerFighter.setCoins(playerFighter.getCoins() + 1);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Trampoline) {
            float trampolineTopYPos = e.getOtherBody().getPosition().y + 0.075f;
            if (playerFighter.getPosition().y - 1.5f >= trampolineTopYPos) {
                playerFighter.setLinearVelocity(new Vec2(0, 50));
            }
        } else if (e.getOtherBody() instanceof Portal) {
            world.stop();
        }
    }
}