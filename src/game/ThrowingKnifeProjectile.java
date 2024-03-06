package game;

import city.cs.engine.*;

public class ThrowingKnifeProjectile extends DynamicBody {
    private static final Shape knifeShape = new PolygonShape(-0.876f,0.052f, 0.9f,0.148f, 0.908f,-0.004f, 0.224f,-0.096f, -0.872f,-0.028f, -0.9f,0.032f
    );
    private static final BodyImage knifeImage = new BodyImage("data/knife2.jpg");

    ThrowingKnifeProjectile(World world) {
      super(world);
      SolidFixture orbFixture = new SolidFixture(this,knifeShape);
      addImage(knifeImage);
      setGravityScale(0);
    }
}
