package game;
import city.cs.engine.*;

public class Fighter extends Walker {

    protected static final Shape fighterShape = new BoxShape(1,1.5f);

    protected static final BodyImage EnemyImage =
            new BodyImage("data/enemyCombatFighter.gif", 2.85f);
    protected static final BodyImage PlayerImage = new BodyImage("data/playerFighter.gif",2.85f);

    public Fighter(World world,String type) {
        super(world, fighterShape);
        switch (type) {
            case "player" :
                addImage(PlayerImage);
                break;
            case "enemy" :
                addImage(EnemyImage);
                break;
        }
    }
}
