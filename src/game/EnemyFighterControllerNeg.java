package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class EnemyFighterControllerNeg implements StepListener {
    private Fighter enemyFighter;
    private float rightBound;
    private float leftBound;

    EnemyFighterControllerNeg(Fighter enemyFighter, float rightBound, float leftBound) {
        this.enemyFighter = enemyFighter;
        this.rightBound = rightBound;
        this.leftBound = leftBound;
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        float currentXPos = this.enemyFighter.getPosition().x;
        // walk left when approaching right obstacle
        if (currentXPos > rightBound) {
            this.enemyFighter.startWalking(-2.5f);
        }
        // walk right when approaching left obstacle
        if (currentXPos < leftBound) {
            this.enemyFighter.startWalking(2.5f);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
