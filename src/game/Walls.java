package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Walls extends StaticBody {
    private static final Shape wallShape = new BoxShape(0.5f,25f);

    private static final Shape roofWallShape = new BoxShape(25f,0.25f);
    private static Shape getWallShape(String whichWall) {
        if (whichWall == "rightWall" || whichWall == "leftWall") {
            return wallShape;
        } else if (whichWall == "roofWall") {
            return roofWallShape;
        }
        else return null;
    }
    private BodyImage wallImage;
    Walls(World world, String whichWall) {
        super(world,getWallShape(whichWall));
        switch (whichWall) {
            case "rightWall":
                this.setPosition(new Vec2(20f,0f));
                break;
            case "leftWall":
                this.setPosition(new Vec2(-20f,0f));
                break;
            case "roofWall":
                this.setPosition(new Vec2(0,15f));
        }
    }
}
