package game;

import city.cs.engine.World;

public abstract class GameLevel extends World {

    private PlayerFighter playerFighter;
    private Game game;

    public GameLevel(Game game) {
        this.game = game;
        playerFighter = new PlayerFighter(this, "player");
        playerFighter.addCollisionListener(new PlayerFighterCollisions(this,game,getPlayerFighter()));
    }
    public PlayerFighter getPlayerFighter() {
        return this.playerFighter;
    }
    public abstract boolean isComplete();

    private void updateGame() {
        if (playerFighter.getHealthCount() <= 0) {
            game.restartGame();
        }
    }
}
