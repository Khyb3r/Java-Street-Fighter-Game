package game;
import city.cs.engine.*;

public class Fighter extends Walker {

    private static final Shape fighterShape = new BoxShape(1,1.5f);

    private static final BodyImage EnemyImage =
            new BodyImage("data/enemyCombatFighter.gif", 4f);
    private static final BodyImage PlayerImage = new BodyImage("data/playerFighter.gif",4f);

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
