package game;

import city.cs.engine.*;

public class Trampoline extends StaticBody {
    private static final Shape trampolineShape =
            new PolygonShape(-1.43f,-0.3f, -1.43f,0.46f, -0.92f,0.59f, 0.77f,0.57f, 1.34f,0.4f, 1.34f,-0.36f, 0.08f,-0.58f
            );
    private static final BodyImage tImage = new BodyImage("data/trampoline1.png",3.25f);
    Trampoline(World world) {
        super(world,trampolineShape);
        addImage(tImage);
    }
}
