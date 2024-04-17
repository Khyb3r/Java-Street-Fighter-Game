package game;
import city.cs.engine.UserView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 * Represents the visual view of the game. Manages painting the background, foreground, and updating the view.
 */
public class GameView extends UserView {
    private Image background;
    private GameLevel gameLevel;

    private static final Font font = new Font("Monospaced",Font.BOLD,15);

    public GameView(GameLevel gameLevel, int width, int height) {
        super(gameLevel, width, height);
        this.gameLevel = gameLevel;
        this.background = new ImageIcon("data/back.jpg").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {
       g.drawImage(background,0,0,this);
    }
    public void setBackground(String image) {
        try {
            this.background = ImageIO.read(new File(image));
            repaint();
        }
        catch (IOException e) {
            System.out.println("Error loading background: " + e.getMessage());
        }
    }
    @Override
    protected void paintForeground(Graphics2D g) {
        int health = gameLevel.getPlayerFighter().getHealthCount();
        int coins = gameLevel.getPlayerFighter().getCoins();
        g.setColor(Color.GREEN);
        g.setFont(font);
        g.drawString("Player Health:" + health,15,20.5f);
    }
    public void updateView() {
        repaint();
    }
}

