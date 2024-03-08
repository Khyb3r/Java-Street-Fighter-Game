package game;

import city.cs.engine.*;

public class OrbProjectile extends DynamicBody {
    private static final Shape orbShape = new CircleShape(0.3f);
    private static final BodyImage orbImage = new BodyImage("data/orbOne.png");

    OrbProjectile(World world) {
      super(world);
      SolidFixture orbFixture = new SolidFixture(this,orbShape);
      addImage(orbImage);
      setGravityScale(0);
      // the orb projectile collision object for its behaviours
        addCollisionListener(new OrbProjectileCollisions(this));
    }
}
