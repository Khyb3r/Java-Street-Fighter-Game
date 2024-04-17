package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class PortalLevel2 extends StaticBody {
    private static final Shape portalShape = new CircleShape(1f);
    private static final BodyImage portalImage = new BodyImage("data/cloud1.gif",2.5f);
    PortalLevel2(GameLevel world) {
        super(world,portalShape);
        this.setPosition(new Vec2());
        addImage(portalImage);
    }
}
