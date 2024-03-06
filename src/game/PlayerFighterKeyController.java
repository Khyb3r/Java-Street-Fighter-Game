package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLOutput;

public class PlayerFighterKeyController implements KeyListener {


    private PlayerFighter fighter;

    public PlayerFighterKeyController(PlayerFighter fighter1) {
        this.fighter = fighter1;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w')  {
            System.out.println("jumped");
            fighter.jump(9.75f);
        }
        else if (e.getKeyChar() == 'd') {
            fighter.startWalking(6);

        }
        else if (e.getKeyChar() == 'a') {
            fighter.startWalking(-6);
            fighter.getPlayerAttachedImage().flipVertical();
        }
        else if (e.getKeyChar() == 'c') {
            fighter.shootKnifeLeft();
        }
        else if (e.getKeyChar() == 'v') {
            fighter.shootKnifeRight();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            fighter.stopWalking();
        } else if (e.getKeyChar() == 'a') {
            fighter.stopWalking();
        }
    }
}