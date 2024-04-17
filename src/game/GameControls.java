package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameControls {
    public JPanel panel1;
    private JButton backButton;
    private Game game;

    public GameControls(Game game) {
        this.game = game;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.transitionBackToMain();
            }
        });
    }
}
