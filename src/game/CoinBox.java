package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.beans.Statement;
/**
 * CoinBox class represents a static body in the game world that acts as a container for coins.
 * It extends the StaticBody class from the city.cs.engine package.
 */
public class CoinBox extends StaticBody {
    private static final Shape boxRightShape = new BoxShape(0.25f,1.25f);;
    private static final Shape boxBottomShape = new BoxShape(1.25f,0.25f);;
    private static BodyImage boxImage;
    /**
     * Returns the appropriate Shape object based on the provided shape string.
     *
     * @param shape a string indicating the desired shape ("right" or "bottom")
     * @return the corresponding Shape object, or null if the shape string is invalid
     */
    private static Shape getBoxShape(String shape) {
        if (shape == "right") {
            return boxRightShape;
        } else if (shape == "bottom") {
            return boxBottomShape;
        }
        else return null;
    }
    /**
     * Constructs a CoinBox object with the specified shape at the given position in the world.
     *
     * @param world the world in which the CoinBox will be created
     * @param shape a string indicating the desired shape ("right" or "bottom")
     */
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
