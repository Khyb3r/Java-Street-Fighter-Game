package game;

import city.cs.engine.*;

public class PlatformLevel2 extends StaticBody {
    private static final Shape shape = new BoxShape(3.5f,0.2f);
    private static final Shape shape1 = new BoxShape(1.5f,0.2f);
    private static Shape getShape(String type) {
        if (type == "one") {
            return shape;
        } else if (type == "two") {
            return shape1;
        } else return null;
    }
    PlatformLevel2(World world, String shapeType) {
        super(world,getShape(shapeType));
        SolidFixture solidFixture = new SolidFixture(this,getShape(shapeType));
        solidFixture.setFriction(1f);
    }
}
