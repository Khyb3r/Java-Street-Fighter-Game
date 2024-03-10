package game;

import city.cs.engine.BodyImage;

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
        if (e.getKeyChar() == 'w' || e.getKeyChar() == KeyEvent.VK_KP_UP)  {
            fighter.jump(9.25f);
        }
        else if (e.getKeyChar() == 'd' || e.getKeyChar() == KeyEvent.VK_KP_RIGHT) {
            fighter.removeAllImages();
            fighter.addImage(this.fighter.getPlayerImage());
            fighter.startWalking(6);
            fighter.setFacingLeft(false);
        }
        else if (e.getKeyChar() == 'a' || e.getKeyChar() == KeyEvent.VK_KP_LEFT) {
            fighter.removeAllImages();
            fighter.addImage(new BodyImage("data/leftPlayer.gif",2.65f));
            fighter.startWalking(-6);
            fighter.setFacingLeft(true);
        }
        else if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            fighter.playerShootOrb();
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