package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private PlayerFighter playerFighter;
    private Ball ball;

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
        playerFighter.setPosition(new Vec2(7, -9));
        playerFighter.setAlwaysOutline(true);

        // make 3 enemy players
        Fighter enemyOne = new Fighter(this,"enemy");
        enemyOne.setPosition(new Vec2(10,6));
        enemyOne.setAlwaysOutline(true);
        Fighter enemyTwo = new Fighter(this,"enemy");
        enemyTwo.setPosition(new Vec2(13,9));
        enemyTwo.setAlwaysOutline(true);
        Fighter enemyThree = new Fighter(this,"enemy");
        enemyThree.setPosition(new Vec2(16,3));
        enemyThree.setAlwaysOutline(true);

        // make 2 obstacles on top of platforms
        Obstacle spikeOne = new Obstacle(this,"spike");
        spikeOne.setPosition(new Vec2(-2,-3));
        Obstacle boulderOne = new Obstacle(this,"boulder");
        boulderOne.setPosition(new Vec2(-3,6));




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

        // make a ball
        ball = new Ball(this);
        ball.setPosition(new Vec2(6,1));

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public PlayerFighter getPlayerFighter(){return this.playerFighter;}
}