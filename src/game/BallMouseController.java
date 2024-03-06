package game;

import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BallMouseController implements MouseListener {

    private GameWorld world;
    private GameView view;

    public BallMouseController(GameWorld w, GameView v) {
        this.world = w;
        this.view = v;
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // create a new ball
        Ball balls = new Ball(world);
        ThrowingKnifeProjectile throwingKnifeProjectile = new ThrowingKnifeProjectile(world);

        // get the coordinates of the mouse click
        Point mousePoint = e.getPoint();

        // transform these coordinates into the world coordinates
        Vec2 worldPoint = view.viewToWorld(mousePoint);
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
