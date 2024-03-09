package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class MovingPlatform extends StaticBody implements StepListener{
    private static final Shape movingPlatformShape =
            new BoxShape(2f,0.15f);
    private BodyImage movingPlatImage;
    private float rightSide,leftSide;
    private float delta;
    private Vec2 startPos;
    MovingPlatform(World world) {
        super(world,movingPlatformShape);
        this.setPosition(new Vec2(-4.85f,3.5f));
        startPos = this.getPosition();
        rightSide = startPos.x+9.85f;
        leftSide = startPos.x-0.15f;
        delta = 0.08f;
        world.addStepListener(this);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().x > rightSide) {
            delta*=-1f;
        }
        if (getPosition().x < leftSide) {
            this.setPosition(startPos);
            delta*=-1f;
        }
        this.setPosition(new Vec2(this.getPosition().x+delta,this.getPosition().y));
    }

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
