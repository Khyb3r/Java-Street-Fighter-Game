package game;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

public class PlayerFighterCollisions implements CollisionListener {

    private PlayerFighter playerFighter;

    public PlayerFighterCollisions(PlayerFighter playerFighter) {
        this.playerFighter = playerFighter;
    }

    private int counter = 0;

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Obstacle) {
            playerFighter.setLives(playerFighter.getLives() - 1);
        } else if (e.getOtherBody() instanceof CoinCollectible) {
            playerFighter.setCoins(playerFighter.getCoins() + 1);
            e.getOtherBody().destroy();
        } else if (e.getOtherBody() instanceof Fighter) {
            playerFighter.setLives(playerFighter.getLives() - 1);
        }
        else if (e.getOtherBody() instanceof Trampoline) {
            float trampolineTopYPos = e.getOtherBody().getPosition().y + 0.075f;
            if (playerFighter.getPosition().y - 1.5f >= trampolineTopYPos) {
                playerFighter.setLinearVelocity(new Vec2(0, 100));
            }
        } else if (e.getOtherBody() instanceof MovingPlatform) {
            this.playerFighter.setLinearVelocity(new Vec2(0,25));
            MovingPlatform movingPlatform = new MovingPlatform()
        }
    }
}