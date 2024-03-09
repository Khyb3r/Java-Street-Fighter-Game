package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;

public class MovingPlatform extends Walker {
    private static final Shape movingPlatformShape =
            new BoxShape(2f,0.15f);
    private BodyImage movingPlatImage;
    private boolean canMove = true;
    MovingPlatform(World world) {
        super(world,movingPlatformShape);
        setGravityScale(0);
        this.setPosition(new Vec2(0f,2.5f));
        GhostlyFixture ghostlyFixture =
                new GhostlyFixture(this,movingPlatformShape);
        ghostlyFixture.setDensity(0);
    }
}
