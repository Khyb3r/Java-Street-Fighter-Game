package game;

import city.cs.engine.World;
/**
 * Represents a level in the game. Each level extends the World class and contains
 * the player fighter and methods for checking if a level is complete.
 */
public abstract class GameLevel extends World {

    private PlayerFighter playerFighter;
    private Game game;
    /**
     * Constructs a new GameLevel object.
     * @param game The Game object associated with this level.
     */
    public GameLevel(Game game) {
        this.game = game;
        playerFighter = new PlayerFighter(this, "player");
        playerFighter.addCollisionListener(new PlayerFighterCollisions(this,game,getPlayerFighter()));
    }
    /**
     * Gets the player fighter associated with this level.
     * @return The player fighter.
     */
    public PlayerFighter getPlayerFighter() {
        return this.playerFighter;
    }

    /**
     * Checks if the level is complete.
     * @return True if the level is complete, false otherwise.
     */
    public abstract boolean isComplete();

    private void updateGame() {
        if (playerFighter.getHealthCount() <= 0) {
            game.restartGame();
        }
    }
}
