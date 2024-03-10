package game;
import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    private GameWorld world;

    private static final Font font = new Font("Monospaced",Font.BOLD,15);

    public GameView(GameWorld world, int width, int height) {
        super(world, width, height);
        this.world = world;
        this.background = new ImageIcon("data/back.jpg").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
       g.drawImage(background,0,0,this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        int health = world.getPlayerFighter().getHealthCount();
        int coins = world.getPlayerFighter().getCoins();
        g.setColor(Color.GREEN);
        g.setFont(font);
        g.drawString("Player Health:" + health + "   " + "Coins:" + coins,15,20.5f);
    }

}

