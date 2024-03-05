package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
            fighter.jump(10f);
        } else if (e.getKeyChar() == 'd') {
            fighter.startWalking(4.5f);
        } else if (e.getKeyChar() == 'a') {
            fighter.startWalking(-4.5f);
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