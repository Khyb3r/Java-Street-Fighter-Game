package game;

import org.jbox2d.common.Vec2;
/**
 * Represents the third level of the game. This level introduces new challenges
 * such as trampolines, keys, multiple floors, and more enemies.
 */
public class Level3 extends GameLevel{
    /**
     * Constructs a new Level3 object.
     * @param game The Game object associated with this level.
     */
    Level3(Game game) {
        super(game);

        // walls, roof and floor created which surround the view
        Floors groundFloor = new Floors(this,"ground");
        Walls leftWall = new Walls(this,"leftWall");
        Walls roofWall = new Walls(this,"roofWall");
        Walls rightWall = new Walls(this,"rightWall");

        // multiple floors
        Floors floor1 = new Floors(this,"floorOne");
        Floors floor2 = new Floors(this,"floorOne");
        Floors floor3 = new Floors(this,"floorOne");
        Floors floor4 = new Floors(this,"floorOne");
        Floors floor5 = new Floors(this,"floorOne");
        floor1.setPosition(new Vec2(-15f,-10f));
        floor2.setPosition(new Vec2(-15f,-5f));
        floor3.setPosition(new Vec2(-15f,0f));
        floor4.setPosition(new Vec2(-15f,5f));
        floor5.setPosition(new Vec2(-15f,10f));

        // trampoline made
        Trampoline trampoline = new Trampoline(this);
        trampoline.setPosition(new Vec2(15f,-13.5f));

        // obstacles made
        Obstacle spike = new Obstacle(this,"spike");
        spike.setPosition(new Vec2(0,10.75f));

        // key, portal to end game
        Key key = new Key(this);
        key.setPosition(new Vec2(-15f,12.5f));

        // enemy fighter made
        for (int i = 0; i < 4; i++) {
            float[] yPosEnemy = {-10f,-5f,0f,6.5f};
            Fighter enemyFighter = new Fighter(this,"enemy");
            enemyFighter.setPosition(new Vec2(-10f,yPosEnemy[i]));
            EnemyFighterControllerNeg efcNeg = new EnemyFighterControllerNeg(enemyFighter,-1f,-15f);
            this.addStepListener(efcNeg);
        }
        // collectibles on the floor levels
        for (int i = 0; i < 4; i++) {
            float[] yCoinPos = {-8.5f,-3.5f,1.5f,6.5f};
            CoinCollectible coin = new CoinCollectible(this);
            coin.setPosition(new Vec2(-17f,yCoinPos[i]));
        }
        CoinCollectible coinOne = new CoinCollectible(this);
        coinOne.setPosition(new Vec2(-3,-12.5f));
        CoinCollectible coin2 = new CoinCollectible(this);
        coin2.setPosition(new Vec2(3,-12.5f));

        // player repositioned for level 3
        getPlayerFighter().setPosition(new Vec2(-15f,-13f));
    }
    /**
     * Checks if the level completion condition is met.
     * In this level, the condition is met if the player collects at least five coins.
     * @return true if the level is complete, false otherwise.
     */
    @Override
    public boolean isComplete() {
        if (getPlayerFighter().getCoins() >= 5) {
            return true;
        }
        else return false;
    }
}
