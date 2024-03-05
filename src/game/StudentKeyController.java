package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentKeyController implements KeyListener {


    private Fighter fighter;

    public StudentKeyController(Fighter fighter1) {
        this.fighter = fighter1;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed " + e.getKeyChar() );
        if (e.getKeyChar() == 'w')  {
            System.out.println("Jumping!");
            fighter.jump(10f);
        } else if (e.getKeyChar() == 'd') {
            fighter.startWalking(3);
        } else if (e.getKeyChar() == 'a') {
            fighter.startWalking(-3);
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