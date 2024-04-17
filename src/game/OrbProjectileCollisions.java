package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.StaticBody;

public class OrbProjectileCollisions implements CollisionListener {

    private OrbProjectile orbProjectile;

    OrbProjectileCollisions(OrbProjectile orbProjectile) {
        this.orbProjectile = orbProjectile;
    }
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Fighter) {
            e.getOtherBody().destroy();
            e.getReportingBody().destroy();
        }
        else if (e.getOtherBody() instanceof Floors ||
                e.getOtherBody() instanceof Obstacle ||
                e.getOtherBody() instanceof CoinCollectible ||
                e.getOtherBody() instanceof Walls ||
                e.getOtherBody() instanceof Trampoline ||
                e.getOtherBody() instanceof Platform ||
                e.getOtherBody() instanceof MovingPlatform ||
                e.getOtherBody() instanceof Portal ||
                e.getOtherBody() instanceof CoinBox ||
                e.getOtherBody() instanceof PlatformLevel2 ||
                e.getOtherBody() instanceof PortalLevel2 ||
                e.getOtherBody() instanceof Key) {
            e.getReportingBody().destroy();
        }
    }
}
