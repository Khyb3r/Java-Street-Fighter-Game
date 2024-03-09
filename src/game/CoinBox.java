package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.beans.Statement;

public class CoinBox extends StaticBody {
    private static final Shape boxRightShape = new BoxShape(0.25f,1.25f);;
    private static final Shape boxBottomShape = new BoxShape(1.25f,0.25f);;
    private static BodyImage boxImage;
    private static Shape getBoxShape(String shape) {
        if (shape == "right") {
            return boxRightShape;
        } else if (shape == "bottom") {
            return boxBottomShape;
        }
        else return null;
    }
    CoinBox(World world,String shape) {
        super(world,getBoxShape(shape));
        switch (shape) {
            case "bottom":
                this.setPosition(new Vec2(4,12f));
                break;
            case "right":
                this.setPosition(new Vec2(5.5f,13f));
        }

    }
}
