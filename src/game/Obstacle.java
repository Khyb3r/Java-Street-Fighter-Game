package game;

import city.cs.engine.*;

public class Obstacle extends StaticBody {

    private static final Shape spikeShape = new PolygonShape(-0.716f,-0.956f, 0.684f,-0.888f, -0.072f,0.984f, -0.688f,-0.76f
    );
    private static final BodyImage spikeImage = new BodyImage("data/spikeofficial.png",1.75f
    );
    private static final Shape fireShape = new PolygonShape(-1.48f,-1.69f, -0.98f,0.91f, 1.33f,0.71f, 1.57f,-1.74f
    );
    private static final BodyImage fireImage = new BodyImage("data/firealt.gif",2.5f);
    Obstacle(World world,String type) {
        super(world);
        switch (type) {
            case "spike":
                SolidFixture solidFixture = new SolidFixture(this,spikeShape);
                addImage(spikeImage);
                break;
            case "fire":
                SolidFixture solidFixture1 = new SolidFixture(this,fireShape);
                addImage(fireImage);
        }
    }
}

