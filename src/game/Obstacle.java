package game;

import city.cs.engine.*;

public class Obstacle extends StaticBody {

    private static final Shape spikeShape = new PolygonShape(-0.716f,-0.956f, 0.684f,-0.888f, -0.072f,0.984f, -0.688f,-0.76f
    );
    private static final BodyImage spikeImage = new BodyImage("data/spikeofficial.png",1.75f
    );
    private static final Shape fireShape = new PolygonShape(-1.23f,-0.85f, -1.57f,-0.42f, -1.25f,0.26f, -0.24f,1.21f, 1.01f,0.69f, 1.55f,-0.22f, 1.06f,-0.93f
    );
    private static final BodyImage fireImage = new BodyImage("data/fire10.png",3.7f);
    Obstacle(World world,String type) {
        super(world);
        this.setAlwaysOutline(true);
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

