package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentKeyController implements KeyListener {


    private Student student;

    public StudentKeyController(Student student1) {
        this.student = student1;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed " + e.getKeyChar() );
        if (e.getKeyChar() == 'w')  {
            System.out.println("Jumping!");
            student.jump(10f);
        } else if (e.getKeyChar() == 'd') {
            student.startWalking(3);
        } else if (e.getKeyChar() == 'a') {
            student.startWalking(-3);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'd') {
            student.stopWalking();
        } else if (e.getKeyChar() == 'a') {
            student.stopWalking();
        }
    }
}