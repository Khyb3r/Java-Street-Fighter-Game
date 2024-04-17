package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
/**
 * Fighter class represents a character in the game world. It extends the Walker class from the city.cs.engine package.
 * It can represent both player-controlled and enemy fighters.
 */
public class Fighter extends Walker {

    protected static final Shape enemyFighterShape = new BoxShape(1, 1.2f);

    protected static final Shape playerFighterShape = new PolygonShape(-0.689f, -0.972f, -0.449f, 0.996f, 0.623f, 0.992f, 0.687f, -0.988f
    );
    protected BodyImage enemyImage;
    protected BodyImage playerImage;
    protected AttachedImage playerAttachedImage;
    /**
     * Returns the appropriate Shape object based on the provided fighter type.
     *
     * @param type a string indicating the type of fighter ("player" or "enemy")
     * @return the corresponding Shape object for the fighter type
     */
    private static Shape getFighterShape(String type) {
        if (type == "player") {
            return playerFighterShape;
        }
        else return enemyFighterShape;
    }
    /**
     * Constructs a Fighter object with the specified type and adds it to the provided world.
     *
     * @param world the world in which the Fighter will be added
     * @param type  a string indicating the type of fighter ("player" or "enemy")
     */
    public Fighter(World world, String type) {
        super(world, getFighterShape(type));
        SolidFixture fighterFixture = new SolidFixture(this,getFighterShape(type));
        switch (type) {
            case "player":
                fighterFixture.setFriction(1f);
                playerImage = new BodyImage("data/streetfighterPlayer.gif", 2.65f);
                addImage(playerImage);
                this.setPosition(new Vec2(-17f,-13f));
                break;
            case "enemy":
                enemyImage = new BodyImage("data/enemyCombatFighter.gif", 2.85f);
                addImage(enemyImage);
                break;
        }
    }
    /**
     * Gets the image of the player fighter.
     *
     * @return the image of the player fighter
     */
    public BodyImage getPlayerImage() {
        return playerImage;
    }
}
