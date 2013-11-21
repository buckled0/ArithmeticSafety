package ui;

import javax.swing.*;
import java.awt.*;

public class LeagueWindow extends JFrame {
    public static final String TITLE = "Arithmetic Football";
    public static final Dimension INITIAL_SIZE = new Dimension(850, 450);
    public static final Point INITIAL_LOCATION = new Point(150, 22);

    public LeagueWindow(){
        setTitle(TITLE);
        setSize(INITIAL_SIZE);
        setResizable(false);
        setLocation(INITIAL_LOCATION);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().add(BorderLayout.CENTER, new LeagueTable());
        getContentPane().add(BorderLayout.SOUTH, new BottomPanel());
        getContentPane().add(BorderLayout.NORTH, new TopPanel());

        setVisible(true);
    }
}
