package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Walls extends StaticBody {
    private static final Shape wallShape = new BoxShape(0.5f,25f);
    private BodyImage wallImage;
    Walls(World world, String whichWall) {
        super(world,wallShape);
        switch (whichWall) {
            case "rightWall":
                this.setPosition(new Vec2(20f,0f));
                break;
            case "leftWall":
                this.setPosition(new Vec2(-20f,0f));
        }
    }
}
