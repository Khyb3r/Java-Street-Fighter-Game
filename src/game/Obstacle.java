package game;

import city.cs.engine.*;

public class Obstacle extends StaticBody {

    private static final Shape spikeShape = new PolygonShape(-0.716f,-0.956f, 0.684f,-0.888f, -0.072f,0.984f, -0.688f,-0.76f
    );
    private static final BodyImage spikeImage = new BodyImage("data/spikeofficial.png",1.5f
    );
    private static final Shape FireShape = new PolygonShape(-0.64f,-0.84f, -0.596f,0.916f, 0.628f,0.892f, 0.62f,-0.88f

    );
    private static final BodyImage FireImage = new BodyImage("data/firepit.png",2.5f);
    Obstacle(World world,String type) {
        super(world);
        switch (type) {
            case "spike":
                SolidFixture solidFixture = new SolidFixture(this,spikeShape);
                addImage(spikeImage);
                break;
            case "boulder":
                SolidFixture solidFixture1 = new SolidFixture(this,FireShape);
                addImage(FireImage);
        }
    }
}

