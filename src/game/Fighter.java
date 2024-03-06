package game;
import city.cs.engine.*;

import javax.swing.*;

public class Fighter extends Walker {

    protected static final Shape enemyFighterShape = new BoxShape(1, 1.5f);

    protected static final Shape playerFighterShape = new PolygonShape(-0.689f, -0.972f, -0.449f, 0.996f, 0.623f, 0.992f, 0.687f, -0.988f
    );
    protected static final BodyImage EnemyImage =
            new BodyImage("data/enemyCombatFighter.gif", 2.85f);
    protected static final BodyImage PlayerImage = new BodyImage("data/streetfighterPlayer.gif", 2.65f);

    private static Shape getFighterShape(String type) {
        if (type == "player") {
            return playerFighterShape;
        }
        else return enemyFighterShape;
    }
    public Fighter(World world, String type) {
        super(world, getFighterShape(type));
        SolidFixture fighterFixture = new SolidFixture(this,getFighterShape(type));
        fighterFixture.setFriction(0.3f);
        switch (type) {
            case "player":
                addImage(PlayerImage);
                break;
            case "enemy":
                addImage(EnemyImage);
                break;
        }
    }
}
