package game;

import org.jbox2d.common.Vec2;

import javax.sound.sampled.Port;

public class Level2 extends GameLevel{
    Level2(Game game) {
        super(game);
        // starting platform
        PlatformLevel2 startPosPlatform = new PlatformLevel2(this,"one");
        startPosPlatform.setPosition(new Vec2(-17f,11f));


        // floor and walls made
        Floors groundFloor = new Floors(this,"ground");
        Walls leftWall = new Walls(this,"leftWall");
        Walls roofWall = new Walls(this,"roofWall");
        Walls rightWall = new Walls(this,"rightWall");
        // platforms made
        PlatformLevel2 endPointPlatform = new PlatformLevel2(this,"one");
        PlatformLevel2 angledPlatform = new PlatformLevel2(this,"one");
        PlatformLevel2 trampolinePlatform = new PlatformLevel2(this,"two");
        endPointPlatform.setPosition(new Vec2(16f,11f));
        angledPlatform.setPosition(new Vec2(9.55f,9.2f));
        angledPlatform.setAngleDegrees(31);
        trampolinePlatform.setPosition(new Vec2(0f,-2f));
        // trampolines made
        Trampoline trampoline1 = new Trampoline(this);
        trampoline1.setPosition(new Vec2(-10,-13.5f));
        Trampoline trampoline2 = new Trampoline(this);
        trampoline2.setPosition(new Vec2(0,-1.5f));

        // obstacles made
        Obstacle spike1 = new Obstacle(this,"spike");
        Obstacle spike2 = new Obstacle(this,"spike");
        spike1.setPosition(new Vec2(0,-13.1f));
        spike2.setPosition(new Vec2(14.5f,-13.1f));

        // collectibles made
        CoinCollectible coin1 = new CoinCollectible(this);
        CoinCollectible coin2 = new CoinCollectible(this);
        coin1.setPosition(new Vec2(17.75f,-13f));
        coin2.setPosition(new Vec2(9f,10.55f));

        // cloud portal made
        PortalLevel2 cloudPortal = new PortalLevel2(this);
        cloudPortal.setPosition(new Vec2(17f,13f));

        // enemy Fighter made
        Fighter enemyFighter = new Fighter(this,"enemy");
        enemyFighter.setPosition(new Vec2(7.5f,-13f));
        EnemyFighterControllerPos efcPos = new EnemyFighterControllerPos(enemyFighter,12f,2f);
        this.addStepListener(efcPos);

        // player Fighter level 2 position
        getPlayerFighter().setPosition(new Vec2(-17,11.5f));
        }
        @Override
        public boolean isComplete() {
            if (getPlayerFighter().getCoins() >= 1) {
                return true;
            }
            else return false;
        }
    }
