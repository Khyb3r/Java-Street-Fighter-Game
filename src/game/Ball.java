package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ball extends DynamicBody {

    private static final Shape ballShape = new CircleShape(1.5f);

    private static final BodyImage ballImage = new BodyImage("data/glove.png",4f);

    private AttachedImage BallAttachedImage;
    public Ball(World world) {
        super(world,ballShape);
        addImage(ballImage);
        BallAttachedImage = new AttachedImage(this,ballImage,0,0,getPosition());
    }
}
