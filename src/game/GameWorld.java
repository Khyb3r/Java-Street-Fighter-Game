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
        Walls roofWall = new Walls(this,"roofWall");

        // create Coin Box in last floor
        CoinBox coinBox = new CoinBox(this,"bottom");
        CoinBox coinBox1 = new CoinBox(this,"right");

        // all the platforms
        Platform platformOne = new Platform(this,"first");
        Platform platformTwo = new Platform(this,"second");
        Platform platformTwoPartTwo = new Platform(this,"secondAngled");
        Platform platformThree = new Platform(this,"third");
        Platform platformThreePartTwo = new Platform(this,"thirdAngled");
        Platform platformFour = new Platform(this,"fourth");

        // the moving platforms
        MovingPlatform movingPlatform = new MovingPlatform(this);

        // the player character
        playerFighter = new PlayerFighter(this,"player");

        // the collision object for all the players related collisions
        PlayerFighterCollisions playerFighterCollisions = new PlayerFighterCollisions(playerFighter);
        playerFighter.addCollisionListener(playerFighterCollisions);

        // 3 enemy players
        Fighter enemyOne = new Fighter(this,"enemy");
        enemyOne.setPosition(new Vec2(5,-13));
        Fighter enemyTwo = new Fighter(this,"enemy");
        enemyTwo.setPosition(new Vec2(-5,-13));
        Fighter enemyThree = new Fighter(this,"enemy");
        enemyThree.setPosition(new Vec2(-14f,-7f));
        Fighter enemyFour = new Fighter(this,"enemy");
        enemyFour.setPosition(new Vec2(10f,2.5f));
        Fighter enemyFive = new Fighter(this,"enemy");
        enemyFive.setPosition(new Vec2(3.5f,9f));

        // the step listeners forenemy players
        EnemyFighterControllerPos efcPos = new EnemyFighterControllerPos(enemyOne,8f,2f);
        EnemyFighterControllerNeg efcNeg = new EnemyFighterControllerNeg(enemyTwo,-2f,-8f);
        EnemyFighterControllerNeg efcNeg1 = new EnemyFighterControllerNeg(enemyThree,-10f,-16f);
        EnemyFighterControllerNeg efcNeg2 = new EnemyFighterControllerNeg(enemyFour,13f,9f);
        EnemyFighterControllerPos efcPos1 = new EnemyFighterControllerPos(enemyFive,7f,0f);
        this.addStepListener(efcPos);
        this.addStepListener(efcNeg);
        this.addStepListener(efcNeg1);
        this.addStepListener(efcNeg2);
        this.addStepListener(efcPos1);


        // spike and fire obstacles
        Obstacle spikeOne = new Obstacle(this,"spike");
        Obstacle spikeTwo = new Obstacle(this,"spike");
        Obstacle spikeThree = new Obstacle(this,"spike");
        Obstacle spikeFour = new Obstacle(this,"spike");
        Obstacle spikeFive = new Obstacle(this,"spike");
        Obstacle spikeSix = new Obstacle(this,"spike");
        spikeSix.setPosition(new Vec2(9f,9.62f));
        spikeFive.setPosition(new Vec2(-2f,9.62f));
        spikeOne.setPosition(new Vec2(-10,-13.1f));
        spikeTwo.setPosition(new Vec2(10,-13.1f));
        spikeThree.setPosition(new Vec2(-8,-6.85f));
        spikeFour.setPosition(new Vec2(15f,2.65f));
        Obstacle fire = new Obstacle(this,"fire");
        Obstacle fireOne = new Obstacle(this,"fire");
        fire.setPosition(new Vec2(6.75f,-6.5f));
        fireOne.setPosition(new Vec2(-8.5f,10f));

        // trampoline on the first floor
        Trampoline trampolineOne = new Trampoline(this);
        trampolineOne.setPosition(new Vec2(0,-7.5f));

        // teh coins scattered across the game
        CoinCollectible coinOne = new CoinCollectible(this);
        CoinCollectible coinTwo = new CoinCollectible(this);
        CoinCollectible coinThree = new CoinCollectible(this);
        CoinCollectible coinFour = new CoinCollectible(this);
        CoinCollectible coinFive = new CoinCollectible(this);
        CoinCollectible coinSix = new CoinCollectible(this);
        CoinCollectible coinSeven = new CoinCollectible(this);
        coinSeven.setPosition(new Vec2(13f,9.75f));
        coinSix.setPosition(new Vec2(4.25f,13f));
        coinFive.setPosition(new Vec2(18f,2.65f));
        coinFour.setPosition(new Vec2(-17.5f,-0.35f));
        coinOne.setPosition(new Vec2(0,-13.0f));
        coinTwo.setPosition(new Vec2(-18,-7f));
        coinThree.setPosition(new Vec2(17.5f,-1f));

        // create the portal which is the end of the game
        Portal portal = new Portal(this);

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public PlayerFighter getPlayerFighter(){return this.playerFighter;}
}