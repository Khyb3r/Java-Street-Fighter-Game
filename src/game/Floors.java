package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class Floors extends StaticBody {
    private Shape floorshape;
    private BodyImage floorImage;
    private String floorLevel;
    public Floors(World world, String floorLevel) {
        super(world);
        switch (floorLevel) {
            case "ground":
                floorshape = new

                break;
            case "floorOne":

                break;
            case "floorTwo":

                break;
            case "floorThree":

        }
    }
}
