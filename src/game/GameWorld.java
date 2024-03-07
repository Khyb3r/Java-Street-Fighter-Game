package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private PlayerFighter playerFighter;

    public GameWorld() {
        super();

        // make the ground
        Shape groundShape = new BoxShape(25, 0.5f);
        StaticBody ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0f, -14.5f));

        // make walls around the entire view
        Shape wallShape = new BoxShape(0.5f,25f);
        StaticBody wallOne = new StaticBody(this,wallShape);
        wallOne.setPosition(new Vec2(-20f,0));
        StaticBody wallTwo = new StaticBody(this,wallShape);
        wallTwo.setPosition(new Vec2(20f,0));

        // make the player character
        playerFighter = new PlayerFighter(this,"player");
        playerFighter.setPosition(new Vec2(17, -13));
        playerFighter.setAlwaysOutline(true);

        // make a collision object for all the players related collisions
        PlayerFighterCollisions playerFighterCollisions = new PlayerFighterCollisions(playerFighter);
        playerFighter.addCollisionListener(playerFighterCollisions);

        // make 2 enemy players
        Fighter enemyOne = new Fighter(this,"enemy");
        enemyOne.setPosition(new Vec2(5,-13));
        enemyOne.startWalking(-1.75f);
        enemyOne.setAlwaysOutline(true);
        Fighter enemyTwo = new Fighter(this,"enemy");
        enemyTwo.setPosition(new Vec2(-5,-13));
        enemyTwo.startWalking(1.75f);
        enemyTwo.setAlwaysOutline(true);

        EnemyFighterControllerPos enemyFighterControllerPos =
                new EnemyFighterControllerPos(enemyOne,8f,2f);
        EnemyFighterControllerNeg enemyFighterControllerNeg =
                new EnemyFighterControllerNeg(enemyTwo,-2f,-8f);
        this.addStepListener(enemyFighterControllerNeg);
        this.addStepListener(enemyFighterControllerPos);


        // make 2 spike obstacles and a boulder
        Obstacle spikeOne = new Obstacle(this,"spike");
        Obstacle spikeTwo = new Obstacle(this,"spike");
        spikeOne.setPosition(new Vec2(-10,-13.23f));
        spikeTwo.setPosition(new Vec2(10,-13.23f));

        Obstacle boulderOne = new Obstacle(this,"boulder");
        boulderOne.setPosition(new Vec2(-3,6));

        // make a platform enclosure
        Shape roofShapeLeft = new BoxShape(19.5f,0.25f);
        StaticBody roofLeftSide = new StaticBody(this,roofShapeLeft);
        roofLeftSide.setPosition(new Vec2(-8,-8f));

        // make an elevated platform to get to floor 2
        Shape elevatedPlatformShape = new BoxShape(1.5f,0.25f);
        StaticBody elevatedPlatform = new StaticBody(this,elevatedPlatformShape);
        elevatedPlatform.setPosition(new Vec2(16,-11));

        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        // make another suspended platform using the same shape as the first
        StaticBody platform2 = new StaticBody(this,platformShape);
        platform2.setPosition(new Vec2(8,-4f));

        // and another...
        StaticBody platform3 = new StaticBody(this,platformShape);
        platform3.setPosition(new Vec2(4,-2f));
        platform3.setAngleDegrees(25);

        PlayerFighterCollisions gcl = new PlayerFighterCollisions(getPlayerFighter());
        playerFighter.addCollisionListener(gcl);
        ground.addCollisionListener(gcl);

        CoinCollectible coinOne = new CoinCollectible(this);
        coinOne.setPosition(new Vec2(0,-13.0f));
        coinOne.setAlwaysOutline(true);

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public PlayerFighter getPlayerFighter(){return this.playerFighter;}
}