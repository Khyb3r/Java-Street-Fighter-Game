package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Floors class represents static bodies in the game world that act as floors or platforms.
 * It extends the StaticBody class from the city.cs.engine package.
 */
public class Floors extends StaticBody {
    private static final Shape groundFloorshape =
            new BoxShape(25, 0.5f);

    private static final Shape firstFloorShape =
            new BoxShape(22.5f,0.25f);
    private static final Shape secondFloorShape =
            new BoxShape(7.5f,0.25f);

    private static final Shape thirdFloorShape =
            new BoxShape(18.5f,0.25f);
    private BodyImage floorImage;
    private String floorLevel;
    /**
     * Returns the appropriate Shape object based on the provided floor level.
     *
     * @param floorLevel a string indicating the floor level ("ground", "floorOne", "floorTwoRight", "floorTwoLeft", or "floorThree")
     * @return the corresponding Shape object for the floor level
     */
    private static Shape getFloorShape(String floorLevel) {
        if (floorLevel == "ground") {
            return groundFloorshape;
        } else if (floorLevel == "floorOne") {
            return firstFloorShape;
        } else if (floorLevel == "floorTwoRight" || floorLevel == "floorTwoLeft") {
            return secondFloorShape;
        } else if (floorLevel == "floorThree") {
            return thirdFloorShape;
        } else return null;
    }
    /**
     * Constructs a Floors object with the specified floor level and adds it to the provided world.
     *
     * @param world      the world in which the Floors object will be added
     * @param floorLevel a string indicating the floor level ("ground", "floorOne", "floorTwoRight", "floorTwoLeft", or "floorThree")
     */
    public Floors(World world, String floorLevel) {
        super(world,getFloorShape(floorLevel));
        SolidFixture solidFixture = new SolidFixture(this,getFloorShape(floorLevel));
        solidFixture.setFriction(1f);
        switch (floorLevel) {
            case "ground":
                this.setPosition(new Vec2(0f,-14.5f));
             //   floorImage = new BodyImage();
             //   addImage();
                break;
            case "floorOne":
                this.setPosition(new Vec2(-8,-8f));
            //    floorImage = new BodyImage();
             //   addImage();
                break;
            case "floorTwoLeft":
                this.setPosition(new Vec2(-15,1.5f));
            //    floorImage = new BodyImage();
             //   addImage();
                break;
            case "floorTwoRight":
                this.setPosition(new Vec2(15,1.5f));
             //   addImage();
                break;
            case "floorThree":
                this.setPosition(new Vec2(4.05f,8.5f));
        }
    }
}
