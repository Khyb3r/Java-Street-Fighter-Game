package game;
import city.cs.engine.*;

public class Student extends Walker {

    private int credits;
    private static final Shape studentShape = new BoxShape(1,1.5f);

    private static final BodyImage image =
            new BodyImage("data/3F3F.gif", 4f);

    public Student(World world) {
        super(world, studentShape);
        addImage(image);
        this.credits = 0;
    }
    public void setCredits(int credits) {
        this.credits = credits;
    }
    public int getCredits() {return credits;}
}
