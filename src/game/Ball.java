package game;

import city.cs.engine.*;

public class Ball extends DynamicBody {

    private static final Shape ballShape = new CircleShape(1.5f);

    private static final BodyImage ballImage = new BodyImage("data/glove.png",4f);

    public Ball(World world) {
        super(world,ballShape);
        addImage(ballImage);
    }
}
