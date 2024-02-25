package game;

import city.cs.engine.*;
import game.Student;
import org.jbox2d.common.Vec2;

public class GameWorld extends World {
    private Student student;
    private Ball ball;

    public GameWorld() {
        super();

        // make the ground
        Shape shape = new BoxShape(50, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make the character
        student = new Student(this);
        student.setPosition(new Vec2(7, -9));
        student.setAlwaysOutline(true);


        // make a professor
        Professor professor = new Professor(this);
        professor.setPosition(new Vec2(2,10));
        professor.setAlwaysOutline(true);

        // make a suspended platform
        Shape platformShape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-8, -4f));

        // make another suspended platform using the same shape as the first
        StaticBody platform2 = new StaticBody(this,platformShape);
        platform2.setPosition(new Vec2(8,-4f));

        // and another...
        StaticBody platform3 = new StaticBody(this,platformShape);
        platform3.setPosition(new Vec2(4,-2f));
        platform3.setAngleDegrees(25);

        // make a ball
        ball = new Ball(this);
        ball.setPosition(new Vec2(6,1));

        //**move** here the rest of the code from Game.java that
        //populates the World - add platforms, Student, etc.
        //(don't add anything related to the view)

        }
    public Student getStudent(){return this.student;}
}