package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
/**
 * EnemyFighterControllerPos class implements the StepListener interface to control the movement of an enemy fighter character.
 * This controller makes the enemy fighter move back and forth within specified bounds in the game world.
 */
public class EnemyFighterControllerPos implements StepListener {
    private Fighter enemyFighter;
    private float rightBound;
    private float leftBound;
    /**
     * Constructs an EnemyFighterControllerPos object with the specified enemy fighter and movement bounds.
     *
     * @param enemyFighter the enemy fighter character to control
     * @param rightBound   the right bound for movement
     * @param leftBound    the left bound for movement
     */
    EnemyFighterControllerPos(Fighter enemyFighter, float rightBound, float leftBound) {
        this.enemyFighter = enemyFighter;
        this.rightBound = rightBound;
        this.leftBound = leftBound;
        this.enemyFighter.startWalking(-1.75f);
    }
    /**
     * Controls the movement of the enemy fighter based on its position and bounds.
     */
    private void enemyFighterMovement() {
        float currentXPos = this.enemyFighter.getPosition().x;
        // if the first enemyFighter is approaching the right bound, hence walk left
        if (currentXPos > rightBound) {
            this.enemyFighter.startWalking(-2f);
        }
        // if the first enemyFighter is approaching the left bound, hence walk right
        if (currentXPos < leftBound) {
            this.enemyFighter.startWalking(2f);
        }
    }
    @Override
    public void preStep(StepEvent stepEvent) {
    enemyFighterMovement();
    }
    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
