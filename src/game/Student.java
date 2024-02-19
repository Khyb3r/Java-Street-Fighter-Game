package game;
import city.cs.engine.*;

public class Student extends Walker {

    private int credits;
    public int getCredits() {
        return credits;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    private static final Shape studentShape = new PolygonShape(1,2);

    private static final BodyImage image =
            new BodyImage("data/student.png", 4f);

    public Student(World world) {
        super(world, studentShape);
        addImage(image);
        this.credits = 0;

    }
}
