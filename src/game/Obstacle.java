package game;

import city.cs.engine.*;

public class Obstacle extends StaticBody {

    private static final Shape spikeShape = new PolygonShape(-0.716f,-0.956f, 0.684f,-0.888f, -0.072f,0.984f, -0.688f,-0.76f
    );
    private static final BodyImage spikeImage = new BodyImage("data/spikeofficial.png",1.5f
    );
    private static final Shape boulderShape = new PolygonShape(-1.04f,-0.51f, -0.86f,0.65f, -0.15f,1.26f, 0.35f,1.29f, 0.86f,0.99f, 1.13f,-1.08f, -0.3f,-1.36f, -0.99f,-0.8f
    );
    private static final BodyImage boulderImage = new BodyImage("data/fire.gif",2.5f);
    Obstacle(World world,String type) {
        super(world);
        switch (type) {
            case "spike":
                SolidFixture solidFixture = new SolidFixture(this,spikeShape);
                addImage(spikeImage);
                break;
            case "boulder":
                SolidFixture solidFixture1 = new SolidFixture(this,boulderShape);
                addImage(boulderImage);
        }
    }
}

