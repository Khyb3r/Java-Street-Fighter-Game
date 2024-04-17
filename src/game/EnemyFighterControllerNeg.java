package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
/**
 * EnemyFighterControllerNeg class implements the StepListener interface to control the movement of an enemy fighter character.
 * This controller makes the enemy fighter move back and forth within specified bounds in the game world.
 */
public class EnemyFighterControllerNeg implements StepListener {
    private Fighter enemyFighter;
    private float rightBound;
    private float leftBound;
    /**
     * Constructs an EnemyFighterControllerNeg object with the specified enemy fighter and movement bounds.
     *
     * @param enemyFighter the enemy fighter character to control
     * @param rightBound   the right bound for movement
     * @param leftBound    the left bound for movement
     */
    EnemyFighterControllerNeg(Fighter enemyFighter, float rightBound, float leftBound) {
        this.enemyFighter = enemyFighter;
        this.rightBound = rightBound;
        this.leftBound = leftBound;
        this.enemyFighter.startWalking(1.75f);
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        float currentXPos = this.enemyFighter.getPosition().x;
        // walk left when approaching right obstacle
        if (currentXPos > rightBound) {
            this.enemyFighter.startWalking(-2f);
        }
        // walk right when approaching left obstacle
        if (currentXPos < leftBound) {
            this.enemyFighter.startWalking(2f);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
