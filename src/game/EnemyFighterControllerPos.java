package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class EnemyFighterControllerPos implements StepListener {
    private Fighter enemyFighter;
    private float rightBound;
    private float leftBound;

    EnemyFighterControllerPos(Fighter enemyFighter, float rightBound, float leftBound) {
        this.enemyFighter = enemyFighter;
        this.rightBound = rightBound;
        this.leftBound = leftBound;
    }
    private void enemyFighterMovement() {
        float currentXPos = this.enemyFighter.getPosition().x;
        // if the first enemyFighter is approaching the right bound, hence walk left
        if (currentXPos > rightBound) {
            this.enemyFighter.startWalking(-2.5f);
        }
        // if the first enemyFighter is approaching the left bound, hence walk right
        if (currentXPos < leftBound) {
            this.enemyFighter.startWalking(2.5f);
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
