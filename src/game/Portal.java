package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Portal extends StaticBody {
    private static final Shape portalShape = new CircleShape(1.5f);
    private BodyImage portalImage;

    Portal(World world) {
        super(world,portalShape);
        this.setPosition(new Vec2(17.5f,11f));
        portalImage = new BodyImage("data/portal.gif",5.5f);
        addImage(portalImage);
    }
}
