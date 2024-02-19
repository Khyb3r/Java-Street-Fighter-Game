package game;

import city.cs.engine.*;

public class Professor extends DynamicBody{
    private static final Shape professorShape =
            new PolygonShape(0.92f,5.0f, 3.2f,4.62f, 3.82f,3.54f, 4.2f,-4.94f, -2.08f,-4.86f, -4.04f,3.5f, -0.8f,4.64f);
    private static final BodyImage image = new BodyImage("data/professor.png",10f);

    public Professor(GameWorld world) {
        super(world,professorShape);
        addImage(image);
    }

}
