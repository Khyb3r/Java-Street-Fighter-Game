package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlayerObstacleCollision implements CollisionListener {

    private PlayerFighter playerFighter;
    public PlayerObstacleCollision(PlayerFighter playerFighter) {
        this.playerFighter = playerFighter;
    }
    private int counter = 0;

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Obstacle) {
            playerFighter.setLives(playerFighter.getLives()-1);
        }
    }

}
