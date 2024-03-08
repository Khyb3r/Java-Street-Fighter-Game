package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private PlayerFighter playerFighter;

    public GameWorld() {
        super();

        // floors are created
        Floors groundFloor = new Floors(this,"ground");
        Floors firstFloor = new Floors(this,"floorOne");
        Floors secondFloorLeft = new Floors(this,"floorTwoLeft");
        Floors secondFloorRight = new Floors(this,"floorTwoRight");

        // walls created which surround the view
        Walls rightWall = new Walls(this,"rightWall");
        Walls leftWall = new Walls(this,"leftWall");

        // the player character
        playerFighter = new PlayerFighter(this,"player");
        playerFighter.setPosition(new Vec2(17, -13));
        playerFighter.setAlwaysOutline(true);

        // the collision object for all the players related collisions
        PlayerFighterCollisions playerFighterCollisions = new PlayerFighterCollisions(playerFighter);
        playerFighter.addCollisionListener(playerFighterCollisions);



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


        // the elevated platform to get to floor 2
        Shape elevatedPlatformShape = new BoxShape(1.5f,0.25f);
        StaticBody elevatedPlatform = new StaticBody(this,elevatedPlatformShape);
        elevatedPlatform.setPosition(new Vec2(16,-11));




        CoinCollectible coinOne = new CoinCollectible(this);
        coinOne.setPosition(new Vec2(0,-13.0f));
        coinOne.setAlwaysOutline(true);

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public PlayerFighter getPlayerFighter(){return this.playerFighter;}
}