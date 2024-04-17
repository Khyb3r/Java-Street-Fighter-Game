package game;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;

public class Key extends StaticBody {
    private static final Shape keyShape = new PolygonShape(-0.88f,-1.58f, -0.84f,1.74f, 0.88f,1.74f, 0.83f,-1.57f
    );
    private static final BodyImage keyImage = new BodyImage("data/key.gif",3.25f);
    Key(GameLevel gameLevel) {
        super(gameLevel,keyShape);
        addImage(keyImage);
    }
}
