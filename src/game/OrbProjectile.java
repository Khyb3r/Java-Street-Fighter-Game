package game;

import city.cs.engine.*;

public class OrbProjectile extends DynamicBody {
    private static final Shape orbShape = new CircleShape(0.95f);
    private static final BodyImage OrbImage = new BodyImage("data/orb.png");


    OrbProjectile(World world) {
        super(world);
        SolidFixture orbFixture = new SolidFixture(this,orbShape);
        addImage(OrbImage);
    }
}
