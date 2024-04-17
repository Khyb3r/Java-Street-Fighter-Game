package game;

import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerFighterKeyController implements KeyListener {


    private PlayerFighter playerFighter;

    public PlayerFighterKeyController(PlayerFighter fighter1) {
        this.playerFighter = fighter1;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    public void updatePlayer(PlayerFighter playerFighter) {
        this.playerFighter = playerFighter;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'w' || e.getKeyChar() == KeyEvent.VK_KP_UP)  {
            playerFighter.jump(9.25f);
        }
        else if (e.getKeyChar() == 'd' || e.getKeyChar() == KeyEvent.VK_KP_RIGHT) {
            playerFighter.removeAllImages();
            playerFighter.addImage(this.playerFighter.getPlayerImage());
            playerFighter.startWalking(6);
            playerFighter.setFacingLeft(false);
        }
        else if (e.getKeyChar() == 'a' || e.getKeyChar() == KeyEvent.VK_KP_LEFT) {
            playerFighter.removeAllImages();
            playerFighter.addImage(new BodyImage("data/leftPlayer.gif",2.65f));
            playerFighter.startWalking(-6);
            playerFighter.setFacingLeft(true);
        }
        else if (e.getKeyChar() == KeyEvent.VK_SPACE) {
            playerFighter.playerShootOrb();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            playerFighter.stopWalking();
        } else if (e.getKeyChar() == 'a') {
            playerFighter.stopWalking();
        }
    }
}