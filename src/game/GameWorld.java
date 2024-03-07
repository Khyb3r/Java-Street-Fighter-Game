package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private PlayerFighter playerFighter;

    public GameWorld() {
        super();

        // the ground
       /* Shape groundShape = new BoxShape(25, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -14.5f)); */

        // walls around the entire view
        Shape wallShape = new BoxShape(0.5f,25f);
        StaticBody wallOne = new StaticBody(this,wallShape);
        wallOne.setPosition(new Vec2(-20f,0));
        StaticBody wallTwo = new StaticBody(this,wallShape);
        wallTwo.setPosition(new Vec2(20f,0));

        // the player character
        playerFighter = new PlayerFighter(this,"player");
        playerFighter.setPosition(new Vec2(17, -13));
        playerFighter.setAlwaysOutline(true);

        // the collision object for all the players related collisions
        PlayerFighterCollisions playerFighterCollisions = new PlayerFighterCollisions(playerFighter);
        playerFighter.addCollisionListener(playerFighterCollisions);

        // the orb projectile collision object for its behaviours


        // 2 enemy players
        Fighter enemyOne = new Fighter(this,"enemy");
        enemyOne.setPosition(new Vec2(5,-13));
        enemyOne.startWalking(-1.75f);
        enemyOne.setAlwaysOutline(true);
        Fighter enemyTwo = new Fighter(this,"enemy");
        enemyTwo.setPosition(new Vec2(-5,-13));
        enemyTwo.startWalking(1.75f);
        enemyTwo.setAlwaysOutline(true);

        // the step listeners for both enemy players
        EnemyFighterControllerPos enemyFighterControllerPos =
                new EnemyFighterControllerPos(enemyOne,8f,2f);
        EnemyFighterControllerNeg enemyFighterControllerNeg =
                new EnemyFighterControllerNeg(enemyTwo,-2f,-8f);
        this.addStepListener(enemyFighterControllerNeg);
        this.addStepListener(enemyFighterControllerPos);


        // 2 spike obstacles and a boulder
        Obstacle spikeOne = new Obstacle(this,"spike");
        Obstacle spikeTwo = new Obstacle(this,"spike");
        spikeOne.setPosition(new Vec2(-10,-13.23f));
        spikeTwo.setPosition(new Vec2(10,-13.23f));

        Obstacle boulderOne = new Obstacle(this,"boulder");
        boulderOne.setPosition(new Vec2(-3,6));

        // the platform enclosure
        Shape roofShapeLeft = new BoxShape(19.5f,0.25f);
        StaticBody roofLeftSide = new StaticBody(this,roofShapeLeft);
        roofLeftSide.setPosition(new Vec2(-8,-8f));

        // the elevated platform to get to floor 2
        Shape elevatedPlatformShape = new BoxShape(1.5f,0.25f);
        StaticBody elevatedPlatform = new StaticBody(this,elevatedPlatformShape);
        elevatedPlatform.setPosition(new Vec2(16,-11));

        // the second floor roof/ ground for 3rd layer upwards
        Shape roofShapeSecondFloor = new BoxShape(7.5f,0.25f);
        StaticBody roofSecondFloorLeftSide = new StaticBody(this,roofShapeSecondFloor);
        StaticBody roofSecondFloorRightSide = new StaticBody(this,roofShapeSecondFloor);
        roofSecondFloorLeftSide.setPosition(new Vec2(-15,-0.5f));
        roofSecondFloorRightSide.setPosition(new Vec2(15,-0.5f));

        Floors groundFloor = new Floors(this,"ground");


        CoinCollectible coinOne = new CoinCollectible(this);
        coinOne.setPosition(new Vec2(0,-13.0f));
        coinOne.setAlwaysOutline(true);

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public PlayerFighter getPlayerFighter(){return this.playerFighter;}
}