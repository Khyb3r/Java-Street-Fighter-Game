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
        Floors thirdFloor = new Floors(this,"floorThree");

        // walls created which surround the view
        Walls rightWall = new Walls(this,"rightWall");
        Walls leftWall = new Walls(this,"leftWall");

        // all the platforms
        Platform platformOne = new Platform(this,"first");
        Platform platformTwo = new Platform(this,"second");
        Platform platformTwoPartTwo = new Platform(this,"secondAngled");
        Platform platformThree = new Platform(this,"third");
        Platform platformThreePartTwo = new Platform(this,"thirdAngled");

        // the moving platforms
        MovingPlatform movingPlatform = new MovingPlatform(this);

        // the player character
        playerFighter = new PlayerFighter(this,"player");
        playerFighter.setPosition(new Vec2(17, -13));
        playerFighter.setAlwaysOutline(true);

        // the collision object for all the players related collisions
        PlayerFighterCollisions playerFighterCollisions = new PlayerFighterCollisions(playerFighter);
        playerFighter.addCollisionListener(playerFighterCollisions);

        // 3 enemy players
        Fighter enemyOne = new Fighter(this,"enemy");
        enemyOne.setPosition(new Vec2(5,-13));
        enemyOne.startWalking(-1.75f);
        enemyOne.setAlwaysOutline(true);
        Fighter enemyTwo = new Fighter(this,"enemy");
        enemyTwo.setPosition(new Vec2(-5,-13));
        enemyTwo.startWalking(1.75f);
        enemyTwo.setAlwaysOutline(true);
        Fighter enemyThree = new Fighter(this,"enemy");
        enemyThree.setPosition(new Vec2(-14f,-7f));
        enemyThree.startWalking(-1.75f);
        enemyThree.setAlwaysOutline(true);

        // the step listeners forenemy players
        EnemyFighterControllerPos enemyFighterControllerPos =
                new EnemyFighterControllerPos(enemyOne,8f,2f);
        EnemyFighterControllerNeg enemyFighterControllerNeg =
                new EnemyFighterControllerNeg(enemyTwo,-2f,-8f);
        EnemyFighterControllerNeg enemyFighterControllerNeg1 =
                new EnemyFighterControllerNeg(enemyThree,-10f,-16f);
        this.addStepListener(enemyFighterControllerNeg);
        this.addStepListener(enemyFighterControllerPos);
        this.addStepListener(enemyFighterControllerNeg1);


        // spike and fire obstacles
        Obstacle spikeOne = new Obstacle(this,"spike");
        Obstacle spikeTwo = new Obstacle(this,"spike");
        Obstacle spikeThree = new Obstacle(this,"spike");
        spikeOne.setPosition(new Vec2(-10,-13.1f));
        spikeTwo.setPosition(new Vec2(10,-13.1f));
        spikeThree.setPosition(new Vec2(-8,-6.85f));
        Obstacle fireObstacle = new Obstacle(this,"fire");
        fireObstacle.setPosition(new Vec2(6.75f,-7f));

        // trampoline on the first floor
        Trampoline trampolineOne = new Trampoline(this);
        trampolineOne.setPosition(new Vec2(0,-7.5f));

        // teh coins scattered across the game
        CoinCollectible coinOne = new CoinCollectible(this);
        CoinCollectible coinTwo = new CoinCollectible(this);
        CoinCollectible coinThree = new CoinCollectible(this);
        CoinCollectible coinFour = new CoinCollectible(this);
        coinFour.setPosition(new Vec2(-17.5f,-0.35f));
        coinOne.setPosition(new Vec2(0,-13.0f));
        coinTwo.setPosition(new Vec2(-18,-7f));
        coinThree.setPosition(new Vec2(17.5f,-1f));
        coinThree.setAlwaysOutline(true);
        coinOne.setAlwaysOutline(true);
        coinTwo.setAlwaysOutline(true);
        coinFour.setAlwaysOutline(true);


        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public PlayerFighter getPlayerFighter(){return this.playerFighter;}
}