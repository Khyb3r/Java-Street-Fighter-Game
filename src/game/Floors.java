package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Floors extends StaticBody {
    private static final Shape groundFloorshape =
            new BoxShape(25, 0.5f);

    private static final Shape firstFloorShape =
            new BoxShape(19.5f,0.25f);
    private static final Shape secondFloorShape =
            new BoxShape(7.5f,0.25f);

   // private static final Shape thirdFloorShape =
   //         new BoxShape()
    private BodyImage floorImage;
    private String floorLevel;

    private static Shape getFloorShape(String floorLevel) {
        if (floorLevel == "ground") {
            return groundFloorshape;
        } else if (floorLevel == "floorOne") {
            return firstFloorShape;
        } else if (floorLevel == "floorTwoRight" || floorLevel == "floorTwoLeft") {
            return secondFloorShape;
        } else return null;
    }

    public Floors(World world, String floorLevel) {
        super(world,getFloorShape(floorLevel));
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
                this.setPosition(new Vec2(-15,-0.5f));
            //    floorImage = new BodyImage();
             //   addImage();
                break;
            case "floorTwoRight":
                this.setPosition(new Vec2(15,-0.5f));
             //   addImage();
                break;
            case "floorThree":
        }
    }
}
