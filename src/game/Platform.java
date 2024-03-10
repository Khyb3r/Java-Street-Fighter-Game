package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Platform extends StaticBody {

    private static final Shape firstPlatformShape =
            new BoxShape(1.5f,0.25f);

    private static final Shape secondPlatformShape =
            new BoxShape(2f,0.2f);

  //  private static final BodyImage platformImage =
  //          new BodyImage()

    private static Shape getPlatformShape(String platformType) {
        if (platformType == "first" || platformType == "fourth") {
            return firstPlatformShape;
        }
        else if (platformType == "second" || platformType == "secondAngled"
        || platformType == "third" || platformType == "thirdAngled") {
            return secondPlatformShape;
        } else return null;
    }


    Platform(World world, String type) {
        super(world,getPlatformShape(type));
        SolidFixture platformFixture = new SolidFixture(this,getPlatformShape(type));
       // addImage();
        switch (type) {
            case "first":
                this.setPosition(new Vec2(17.5f,-11));
                break;
            case "secondAngled":
                this.setPosition(new Vec2(14f,-3.5f));
                this.setAngleDegrees(50);
                break;
            case "second":
                this.setPosition(new Vec2(17.25f,-2f));
                break;
            case "thirdAngled":
                this.setPosition(new Vec2(-13.4f,-3.25f));
                this.setAngleDegrees(-35);
                break;
            case "third":
                this.setPosition(new Vec2(-16.94f,-2.16f));
                break;
            case "fourth":
                this.setPosition(new Vec2(-17f,4.5f));
        }
    }
}