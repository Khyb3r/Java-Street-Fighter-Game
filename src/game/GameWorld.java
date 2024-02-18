package game;

import city.cs.engine.*;
import game.Student;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    public GameWorld() {
        super();

        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make the character
        Student student = new Student(this);
        student.setPosition(new Vec2(7, -9));
        student.setCredits(15);

        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        // make another suspended platform using the same shape as the first
        StaticBody platform2 = new StaticBody(this,platformShape);
        platform2.setPosition(new Vec2(8,-4f));
        platform2.setAngleDegrees(-25);

        // and another...
        StaticBody platform3 = new StaticBody(this,platformShape);
        platform3.setPosition(new Vec2(4,-2f));
        platform2.setAngleDegrees(25);

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)
    }
}