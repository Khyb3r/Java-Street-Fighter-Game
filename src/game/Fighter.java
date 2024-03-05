package game;
import city.cs.engine.*;

public class Fighter extends Walker {

    private static final Shape studentShape = new BoxShape(1,1.5f);

    private static final BodyImage image =
            new BodyImage("data/enemyCombatFighter.gif", 4f);

    public Fighter(World world) {
        super(world, studentShape);
        addImage(image);
    }
}
