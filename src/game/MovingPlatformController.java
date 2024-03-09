package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class MovingPlatformController implements StepListener {

    private MovingPlatform movingPlatform;
    private float rightBound;
    private float leftBound;

    MovingPlatformController(MovingPlatform movingPlatform,float rightBound,float leftBound) {
        this.movingPlatform = movingPlatform;
        this.rightBound = rightBound;
        this.leftBound = leftBound;
    }
    @Override
    public void preStep(StepEvent stepEvent) {
        float currentXPos = this.movingPlatform.getPosition().x;
        // when the platform reaches the right bound move left
        if (currentXPos > rightBound) {
            this.movingPlatform.startWalking(-1.5f);
        }
        // when the platform reaches the left bound move right
        if (currentXPos < leftBound) {
            this.movingPlatform.startWalking(1.5f);
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
