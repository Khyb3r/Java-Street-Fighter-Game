package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class PlayerFighterCollisions implements CollisionListener {

    private PlayerFighter playerFighter;
    public PlayerFighterCollisions(PlayerFighter playerFighter) {
        this.playerFighter = playerFighter;
    }
    private int counter = 0;

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Obstacle) {
            playerFighter.setLives(playerFighter.getLives()-1);
        }
        else if (e.getOtherBody() instanceof CoinCollectible) {
            playerFighter.setCoins(playerFighter.getCoins()+1);
            e.getOtherBody().destroy();
        }
        else if (e.getOtherBody() instanceof Fighter) {
            playerFighter.setLives(playerFighter.getLives()-1);
        }
    }

    

}
